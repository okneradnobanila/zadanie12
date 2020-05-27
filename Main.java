import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

class Main {
  public static int RtoA(String a){
    Map<Character, Integer> Romans = new HashMap<Character, Integer>();
    Romans.put('I', 1);
    Romans.put('V', 5);
    Romans.put('X', 10);
    Romans.put('L', 50);
    Romans.put('C', 100);
    Romans.put('D', 500);
    Romans.put('M', 1000);

    int n = 0;

    for(int i=0; i<a.length();i=i+1){
      if( i==0 || Romans.get(a.charAt(i)) <= Romans.get(a.charAt(i-1)) ){
        n += Romans.get(a.charAt(i));
      }
      else{
        n += Romans.get(a.charAt(i)) - 2*Romans.get(a.charAt(i-1));
      }
    }
    return n;
  }
  public static void main(String[] args) {
    
    Scanner in = new Scanner(System.in);
    System.out.print("Выберите действие:\n1) Перевод римского числа в арабское\n2) Проверка на полиндром\n");
    int num = in.nextInt();
    // не смогла сделать первое задание по переводу :(
    if(num==1){
      System.out.print("Введите римскую цифру: ");
      String n =  in.nextLine();
      int perev = RtoA(n);
      System.out.println("Римская цифра:" + n + " равна:" + perev);
      in.close();
    }
    if(num==2){
      System.out.print("Введите число для проверки: ");
      int ch = in.nextInt();
      if(String.valueOf(ch).equals(new StringBuilder(String.valueOf(ch)).reverse().toString())){
        System.out.println("Число палиндром");
      }
      else{
        System.out.println("Число не палиндром");
      }
    }
  }
}
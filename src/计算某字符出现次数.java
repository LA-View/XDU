import java.util.Scanner;

public class 计算某字符出现次数 {
    public static class Main{
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            String str =sc.nextLine().toUpperCase();
            String s = sc.nextLine().toUpperCase();
            System.out.print(str.length()-str.replaceAll(s,"").length());
        }
    }
}

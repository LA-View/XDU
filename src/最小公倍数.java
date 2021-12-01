import java.util.Scanner;

public class 最小公倍数 {

    /**
     * 题目描述
     * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
     * 输入描述:
     * 输入两个正整数A和B。
     * 输出描述:
     * 输出A和B的最小公倍数。
     *
     * 示例1
     * 输入
     * 5 7
     * 输出
     * 35
     */
    public static class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int int1= scanner.nextInt();
            int int2= scanner.nextInt();
            System.out.println(int1*int2/methods(int1,int2));
        }
        public static int methods(int int1,int int2){
            if(int1 == int2){
                return int2;
            }
            if(int1 > int2){
                int differ= int1-int2;
                return methods(int2,differ);
            }else{
                int differ= int2-int1;
                return methods(int1,differ);
            }
        }
    }




}

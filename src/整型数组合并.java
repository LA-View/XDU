import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class 整型数组合并 {
    /*
    将两个整型数组按照升序合并，并且过滤掉重复数组元素。
输出时相邻两数之间没有空格。
示例1
输入：
3
1 2 5
4
-1 0 3 2
复制
输出：
-101235

     */
    public class Main {
        public void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while (in.hasNextInt()) {
                TreeSet<Integer> set = new TreeSet<>();
                int a = in.nextInt();
                for (int i = 0; i < a; i++) {
                    set.add(in.nextInt());
                }
                int b = in.nextInt();
                for (int i = 0; i < b; i++) {
                    set.add(in.nextInt());
                }
                Iterator iter = set.iterator();
                while (iter.hasNext()) {
                    System.out.print(iter.next());
                }
                System.out.println();
            }
        }
    }


    public static class Main2{
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                TreeSet<Integer> ts = new TreeSet<>();
                int n1 = sc.nextInt();
                for(int i=0; i<n1; i++){
                    ts.add(sc.nextInt());
                }
                int n2 = sc.nextInt();
                for(int i=0; i<n2; i++){
                    ts.add(sc.nextInt());
                }
                for(int a:ts){
                    System.out.print(a);
                }
                System.out.println();
            }
        }
    }
}

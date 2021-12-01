import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 连续最大和 {
    /*
    描述
一个数组有 N 个元素，求连续子数组的最大和。 例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为 3
输入描述：
输入为两行。 第一行一个整数n(1 <= n <= 100000)，表示一共有n个元素 第二行为n个数，即每个元素,每个整数都在32位int范围内。以空格分隔。
输出描述：
所有连续子数组中和最大的值。
     */

    public static class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");

            int max = Integer.parseInt(line[0]);
            int Sum = Integer.parseInt(line[0]);
            int num;
            for (int i = 1; i < n; i++) {
                num = Integer.parseInt(line[i]);
                if (Sum < 0) Sum = num;
                else Sum += num;
                if (Sum > max) max = Sum;
            }
            System.out.println(max);
        }
    }
}

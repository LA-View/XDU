import java.util.*;

public class 编写程序将数字转换成英文 {

    /*
    输入：
22
100
145
1234
8088
486669
1652510
复制
输出：
twenty two
one hundred
one hundred and forty five
one thousand two hundred and thirty four
eight thousand eighty eight
four hundred and eighty six thousand six hundred and sixty nine
one million six hundred and fifty two thousand five hundred and ten
     */


    public static class Main {

        public static String[] ones = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        public static String[] tens = new String[]{"ten", "eleven", "twelve", "thirteen", "forteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        public static String[] twieties = new String[]{"zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        public static int[] range = new int[]{(int) 1e2, (int) 1e3, (int) 1e6, (int) 1e9, (int) 1e12};
        public static String[] ranges = new String[]{"hundred", "thousand", "million", "billion"};

        public static void main(String[] args) {
            // 管道流
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                // 获取数值
                int num = sc.nextInt();
                // 转换
                System.out.println(transfer(num));
            }
        }

        public static String transfer(int num) {
            // terminor
            if (num <= 9) return ones[num];
            if (num <= 19) return tens[num % 10];
            if (num <= 99) return twieties[num / 10] + (num % 10 == 0 ? "" : " " + ones[num % 10]);

            // 递归调用
            for (int i = 0; i < 4; i++) {
                if (num < range[i + 1]) {
                    return transfer(num / range[i]) + " " + ranges[i] +
                            (num % range[i] == 0 ? " " : (i != 0 ? " " : " and ") + transfer(num % range[i]));
                }
            }
            return "";
        }
    }
}

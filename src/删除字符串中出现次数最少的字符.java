import java.util.*;

public class 删除字符串中出现次数最少的字符 {

    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                String str = sc.nextLine();
                int min = 100;
                StringBuilder sb = new StringBuilder();
                int[] num = new int[str.length()];
                char[] ch = str.toCharArray();
                for (int i = 0; i < ch.length; i++) {//找到每个字符出现的次数
                    for (int j = 0; j < str.length(); j++) {
                        if (ch[i] == str.charAt(j)) {
                            num[i]++;
                        }
                    }
                }
                for (int i = 0; i < num.length; i++) {//找到出现次数最小的值
                    if (num[i] < min) {
                        min = num[i];
                    }
                }

                for (int k = 0; k < str.length(); k++) {//进行遍历，采用StringBuilder放入次数不为最小值的字符
                    if (num[k] != min) {
                        sb.append(str.charAt(k));
                    }
                }

                System.out.println(sb); //打印

            }
        }

    }
}

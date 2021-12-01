import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class 成绩排序 {
    /*
    描述
查找和排序

题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
都按先录入排列在前的规则处理。

例示：
jack      70
peter     96
Tom       70
smith     67

从高到低  成绩
peter     96
jack      70
Tom       70
smith     67

从低到高

smith     67

jack      70

Tom       70
peter     96

注：0代表从高到低，1代表从低到高

注意：本题含有多组输入数据！
数据范围：人数：，数据组数：
进阶：时间复杂度：，空间复杂度：
输入描述：
输入多行，先输入要排序的人的个数，然后分别输入他们的名字和成绩，以一个空格隔开

输出描述：
按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开

示例1
输入：
3
0
fang 90
yang 50
ning 70
复制
输出：
fang 90
ning 70
yang 50
     */;

    // 注意类名必须为 Main, 不要有任何 package xxx 信息
    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            HashMap<Integer, String> map = new HashMap<>();
            while (sc.hasNextLine()) {
                int n = Integer.parseInt(sc.nextLine());
                int flag = Integer.parseInt(sc.nextLine());//1是升序，0是降序
                int[][] score = new int[n][2];//姓名编号，成绩
                for (int i = 0; i < n; i++) {
                    String[] nameAndScore = sc.nextLine().split("\\s+");
                    score[i][0] = i;
                    score[i][1] = Integer.parseInt(nameAndScore[1]);
                    map.put(i, nameAndScore[0]);
                }
                Arrays.sort(score, (o1, o2) -> {
                    if (flag == 0) {
                        return o2[1] - o1[1];//按第二列降序排列,如果相等的话，返回0，顺序不变
                    } else {
                        return o1[1] - o2[1];//按第二列升序
                    }
                });
                for (int i = 0; i < n; i++) {
                    System.out.println(map.get(score[i][0]) + " " + score[i][1]);
                }
            }
        }
    }

}

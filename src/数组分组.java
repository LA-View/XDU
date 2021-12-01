
import java.util.*;

public class 数组分组 {/*
描述
输入int型数组，询问该数组能否分成两组，使得两组中各元素加起来的和相等，并且，所有5的倍数必须在其中一个组中，所有3的倍数在另一个组中（不包括5的倍数），不是5的倍数也不是3的倍数能放在任意一组，可以将数组分为空数组，能满足以上条件，输出true；不满足时输出false。

本题含有多组样例输入。

数据范围：每个数组大小满足  ，输入的数据大小满足
输入描述：
第一行是数据个数，第二行是输入的数据

输出描述：
返回true或者false

示例1
输入：
4
1 5 -5 1
3
3 5 8
复制
输出：
true
false
复制
说明：
第一个样例：
第一组：5 -5 1
第二组：1
第二个样例：由于3和5不能放在同一组，所以不存在一种分法。
*/

    public static class Main {

        public Main() {
        }

        private boolean dfs(List<Integer> bag, int target, int i) {
            if (target == 0) return true;
            if (i == bag.size()) return false;
            // dfs搜索，对每个元素，选择或者放弃
            return dfs(bag, target, i + 1) || dfs(bag, target - bag.get(i), i + 1);
        }

        public boolean isPartition(int[] arr) {
            List<Integer> bag = new LinkedList<>();
            for (int i : arr) {
                bag.add(i);
            }
            // sum of 5 - sum of 3
            int diff = 0;
            // sum of others
            int others = 0;
            for (int i = 0; i < bag.size(); ) {
                if (bag.get(i) % 5 == 0) {
                    diff += bag.get(i);
                    bag.remove(i);
                } else if (bag.get(i) % 3 == 0) {
                    diff -= bag.get(i);
                    bag.remove(i);
                } else {
                    others += bag.get(i++);
                }
            }
            if ((others - Math.abs(diff)) % 2 != 0) {
                return false;
            }
            // find if sub sum in bag equals target
            int target = (others - Math.abs(diff)) / 2;
            return dfs(bag, target, 0);
        }

        public static void main(String[] args) {
            Main solution = new Main();
            Scanner in = new Scanner(System.in);
            while (in.hasNextInt()) {
                int n = in.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }
                boolean res = solution.isPartition(arr);
                System.out.println(res);
            }
        }
    }
}

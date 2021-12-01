import java.util.LinkedList;
import java.util.Queue;

public class 树深度 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public class Solution {
        public int TreeDepth(TreeNode root) {
            if (root == null) return 0;
            int res = 0;
            // 队列实现bfs
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            // 遍历每一层
            while (!queue.isEmpty()) {
                // 每遍历一层,计数+1
                res++;
                // queue每次只保存当层的节点数
                int size = queue.size();
                // 遍历当前层的每一个节点, 队列中poll掉当前层节点,add其所有子节点
                for (int i = 0; i < size; i++) {
                    // 取出当前节点,并将其左右子节点放入队列
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            return res;
        }
    }


}

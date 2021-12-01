import java.util.Stack;

public class 二叉搜索树的第k个节点 {


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param proot TreeNode类
         * @param k     int整型
         * @return int整型
         */
        public int KthNode(TreeNode proot, int k) {
            if (proot == null) return -1;
            //中序遍历，第k个节点
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(proot);
            TreeNode node = proot;
            int i = 0;
            while (!stack.isEmpty()) {
                //遍历node下的所有左节点
                while (node.left != null) {
                    stack.push(node.left);
                    node = node.left;
                }
                i++;
                if (i == k) return stack.pop().val;
                TreeNode tmp = stack.pop();
                //加入右子树
                if (tmp.right != null) {
                    stack.push(tmp.right);
                    node = tmp.right;
                }
            }
            return -1;
        }
    }

}

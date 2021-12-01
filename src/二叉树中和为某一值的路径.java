import java.util.ArrayList;
import java.util.LinkedList;

public class 二叉树中和为某一值的路径 {
    /*
    1、采用深度优先搜索的方式，枚举每一条从根节点到叶子节点的路径。当我们遍历到叶子节点，且此时路径和恰为目标和时，我们就找到了一条满足条件的路径。
    2、我们也可以采用广度优先搜索的方式，遍历这棵树。当我们遍历到叶子节点，且此时路径和恰为目标和时，我们就找到了一条满足条件的路径。为了节省空间，我们使用哈希表记录树中的每一个节点的父节点。每次找到一个满足条件的节点，我们就从该节点出发不断向父节点迭代，即可还原出从根节点到当前节点的路径。

    举例说明：
    采用深度优先搜索的方式：
    二叉树：{10,5,12,4,7},   目标值：22
    根据二叉树可以枚举出所有从根节点到叶子节点的路径【10，5，4】、【10，5，7】、【10，12】
    将不同的路径节点值相加，并判断符合结果等于目标值的路径：【10，5，7】、【10，12】
     */
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        //初始化集合
        ArrayList res = new ArrayList<>();
        LinkedList path = new LinkedList<>();

        public ArrayList FindPath(TreeNode root, int target) {
            dfs(root, target);
            return res;
        }

        public void dfs(TreeNode root, int tar) {

            if (root == null) {
                return;
            }
            //将root节点放入路径集合
            path.add(root.val);
            //更新目标值，每放入一个节点，目标值应该相应减去对应节点的值，直到目标值为0
            tar -= root.val;
            //如果目标值减到了0 && 左节点为空 && 右节点为空 证明树已遍历完，此路径为目标路径
            if (tar == 0 && root.left == null && root.right == null) {
                res.add(new ArrayList(path));
            }
            // 递归左右子树
            dfs(root.left, tar);
            dfs(root.right, tar);
            //删除当前节点，在回溯过程中，此节点不在新路径上
            path.removeLast();
        }
    }
}

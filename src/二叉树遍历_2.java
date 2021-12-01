import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class 二叉树遍历_2 {//Main函数

    //二叉树节点结构
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            int[] array = new int[num];
            for (int i = 0; i < num; i++) {
                array[i] = scanner.nextInt();
            }
            TreeNode root = new TreeNode(array[0]);
            for (int i = 1; i < num; i++) {
                buildBST(root, array[i]);
            }
            DLR(root);//前序遍历
            System.out.println();
            LDR(root);//中序遍历
            System.out.println();
            LRD(root);//后序遍历
            System.out.println();
            levelOrder(root);//层次遍历
            System.out.println();
        }
    }

    //前序遍历非递归
    public static void DLR(TreeNode node) {
        if (node != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(node);
            while (!stack.isEmpty()) {
                node = stack.pop();
                System.out.print(node.val + " ");
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            }
        }
    }

    //中序遍历非递归
    public static void LDR(TreeNode node) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }

    //后序遍历非递归
    public static void LRD(TreeNode node) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = node;
        while (node != null) {
            while (node.left != null) {
                stack.push(node);
                node = node.left;
            }
            while (node != null && (node.right == null || node.right == pre)) {
                System.out.print(node.val + " ");
                pre = node;
                if (stack.isEmpty()) return;
                node = stack.pop();
            }
            stack.push(node);
            node = node.right;
        }
    }

    //层次遍历非递归
    public static void levelOrder(TreeNode node) {
        Queue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    //构建二叉排序树
    public static void buildBST(TreeNode node, int val) {
        if (node.val == val) return;
        if (val < node.val) {
            if (node.left == null) node.left = new TreeNode(val);
            else buildBST(node.left, val);
        } else {
            if (node.right == null) node.right = new TreeNode(val);
            else buildBST(node.right, val);
        }
    }
}

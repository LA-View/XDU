public class 删除链表的节点 {


    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }


    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param head ListNode类
         * @param val  int整型
         * @return ListNode类
         */
        public ListNode deleteNode(ListNode head, int val) {
            // write code here
            if (head.val == val) {
                return head.next;
            }
            ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode cur = head;
            ListNode next = null;
            while (cur != null) {
                cur = cur.next;
                pre = pre.next;
                if (cur.val == val) {
                    next = cur.next;
                    break;
                }
            }
            cur.next = null;
            pre.next = next;
            return head;
        }
    }

}

package top.damoncai.chapter_21_LinkedListPalindrome;

/**
 * 单向流链表：判断是否是回文链表
 * ABBA
 * ABCBA
 *
 * @author zhishun.cai
 * @date 2025/1/16
 */
public class LinkedListPalindrome2<T> {

    /**
     * 判断方法：
     * 1、获取中间节点
     * 2、对中间节点后面链表进行翻转
     * 3、然后比较
     *
     * 将第一步和第二步骤合并
     * @param node
     * @return
     */
    public boolean check(Node<T> node) {

        if(node == null || node.next == null) {
            return false;
        }

        Node<T> fast = node,
                slow = node,
                o1 = node,
                n1 = null;


        // 1、获取中间节点 & 翻转
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            o1.next = n1;

            n1 = o1;
            o1 = slow;

        }
        // 判断是否为基数个
        if(fast != null) {
            slow = slow.next;
        }

        while(slow != null) {
            if (!slow.getData().equals(n1.getData())) {
                return false;
            }
            slow = slow.next;
            n1 = n1.next;
        }
        return true;
    }


}

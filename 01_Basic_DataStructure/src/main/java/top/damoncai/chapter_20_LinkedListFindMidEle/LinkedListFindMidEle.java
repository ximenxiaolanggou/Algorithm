package top.damoncai.chapter_20_LinkedListFindMidEle;

/**
 *
 * 单项链表查找中间节点
 *
 * 1 2 3 4 5 null -> 3
 *
 * 1 2 3 4 5 6 null -> 4
 *
 * @author zhishun.cai
 * @date 2025/1/16
 */
public class LinkedListFindMidEle<T> {



    public T findMinEle(Node<T> node) {
        if(node == null) {
            return null;
        }

        if(node.next == null) {
            return node.data;
        }

        Node<T> slow = node;
        Node<T> fast = node;
        while(fast != null && fast.next != null) {
            // 慢指正走一步
            slow = slow.next;

            // 快指针走两步
            fast = fast.next.next;

        }
        return slow.data;
    }
}

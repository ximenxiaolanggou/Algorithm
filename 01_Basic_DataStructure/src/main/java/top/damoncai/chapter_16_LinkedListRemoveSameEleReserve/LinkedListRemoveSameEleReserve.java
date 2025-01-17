package top.damoncai.chapter_16_LinkedListRemoveSameEleReserve;

/**
 * 有序链表删除重复节点，并保留一个重复节点
 *
 * @author zhishun.cai
 * @date 2025/1/9
 */
public class LinkedListRemoveSameEleReserve<T> {

    public Node<T> removeDuplicates(Node<T> head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node leftPoint = head;
        Node rightPoint = head.next;

        while (( rightPoint = leftPoint.next) != null) {

            if (leftPoint.data == rightPoint.data) {
                // 元素相同
                leftPoint.next = rightPoint.next;

            }else {
                // 元素不相同
                leftPoint = leftPoint.next;
            }
        }
        return head;
    }


    /**
     * 递归方式
     * @param head
     * @return
     */
    public Node<T> removeDuplicatesReursion(Node<T> head) {
        if (head == null ) {
            return null;
        }

        Node<T> node = removeDuplicatesReursion(head.next);
        if(node != null && head.data == node.data) {
            // 递归返回节点值和当前节点值相同
            head.next = node.next;
            return node;
        }else {
            return head;
        }
    }
}

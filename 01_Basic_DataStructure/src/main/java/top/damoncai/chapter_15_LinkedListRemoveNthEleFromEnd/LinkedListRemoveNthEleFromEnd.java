package top.damoncai.chapter_15_LinkedListRemoveNthEleFromEnd;

/**
 * 单线链表：重后往前删除第n个元素（从 1 开始计数）
 * @author zhishun.cai
 * @date 2025/1/8
 */
public class LinkedListRemoveNthEleFromEnd<T> {


    public Node<T> handle(int removeIndex, Node<T> cur) {
        Node<T> node = new Node(-1, cur);
        removeFastSlowPointer(removeIndex, node);
        return node.next;
    }

    /**
     * 递归方式
     * @param removeIndex
     * @param cur
     * @return
     */
    public int removeReursion(int removeIndex, Node<T> cur) {
        if(cur == null) {
            return 0;
        }

        int nth = removeReursion(removeIndex, cur.next);

        if(nth == removeIndex) {
            cur.next = cur.next.next;
        }

        return ++nth;
    }

    /**
     * 快慢指针法
     * @param removeIndex
     * @param cur
     * @return
     */
    public void removeFastSlowPointer(int removeIndex, Node<T> cur) {
        Node<T> slowPointer = cur;
        Node<T> fastPointer = cur;

        // 快指针和慢指针拉开 removeIndex + 1距离，因为slowPointer需要指向需要删除节点的上一个节点
        for (int i = 0; i < removeIndex + 1; i++) {
            fastPointer = fastPointer.next;
        }

        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        slowPointer.next = slowPointer.next.next;
    }
}

package top.damoncai.chapter_14_LinkedListRemoveEle;

/**
 * 单向链表：删除指定元素
 * @author zhishun.cai
 * @date 2025/1/7
 */
public class LinkedListRemoveEle<T> {

    /**
     * 删除指定元素
     * @param head
     * @param val
     * @return
     */
    public Node<T> removeElement(Node<T> head, T val) {
        // 因为需要删除元素后再拼接，并且是单项链表所以需要定义两个索引
        // 第一个索引为当前判断的数据节点
        // 第二个索引为上一个数据节点
        // 我们正常判断的是数据节点是否需要删除，但是有个特殊情况，就是头结点。
        // 针对上面问题我们这里提供一个哨兵节点

        Node<T> sentinelNode = new Node(null, head);
        Node<T> preNode = sentinelNode;
        Node<T> curNode = head;

        while (curNode != null) {
            // 当前节点不为空

            if(curNode.data == val) {
                // 当前节点需要删除
                preNode.next = curNode.next;
                curNode = preNode.next;
            }else {
                // 当前节点不需要删除
                preNode = preNode.next;
                curNode = curNode.next;
            }
        }
        return sentinelNode.next;
    }


    /**
     * 递归删除
     * @param head
     * @param val
     * @return
     */
    public Node<T> removeElementRecursion(Node<T> head, T val) {
        // head节点为null，直接返回
        if (head == null) {
            return null;
        }

        // 递归
        Node<T> tNode = removeElementRecursion(head.next, val);

        // 再每次递归中判断当前值是否和目标值相等
        // 相等：返回上次递归的返回值（这个节点就不需要了）
        // 不相等：让当前节点的下一个值指向上次递归的返回值(这个节点的值需要保留)
        if(head.data == val) {
            return tNode;
        }else {
            head.next = tNode;
            return head;
        }
    }
}

package top.damoncai.chapter_21_LinkedListPalindrome;

/**
 * 单向流链表：判断是否是回文链表
 * A B B A
 * A B C B A
 *
 * @author zhishun.cai
 * @date 2025/1/16
 */
public class LinkedListPalindrome1<T> {

    /**
     * 判断方法：
     * 1、获取中间节点
     * 2、对中间节点后面链表进行翻转
     * 3、然后比较
     * @param node
     * @return
     */
    public boolean check(Node<T> node) {
        if(node == null || node.next == null) {
            return false;
        }
        // 1、获取中间节点
        Node<T> midNode = getMidNode(node);
        System.out.println("中间节点：" + midNode.getData());

        // 2、翻转节点
        Node<T> reverseNode = reverse(midNode);
        reverseNode.print();

        // 3、判断比较
        Node<T> header = node;
        while(reverseNode != null) {
            if (!reverseNode.getData().equals(header.getData())) {
                return false;
            }
            reverseNode = reverseNode.next;
            header = header.next;
        }
        return true;
    }

    /**
     * 翻转节点
     * @param node
     * @return
     */
    private Node<T> reverse(Node<T> node) {
        Node o1 = node;
        Node n1 = null;

        while(o1 != null) {
            Node<T> o2 = o1.next;
            o1.next = n1;

            n1 = o1;
            o1 = o2;
        }

        return n1;

    }

    /**
     * 获取中间节点
     * @param node
     * @return
     */
    public Node<T> getMidNode(Node<T> node) {
        Node<T> fast = node,
                slow = node;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

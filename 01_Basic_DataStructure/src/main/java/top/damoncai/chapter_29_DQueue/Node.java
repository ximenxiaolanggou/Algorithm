package top.damoncai.chapter_29_DQueue;

/**
 * @author zhishun.cai
 * @date 2025/2/25
 */
public class Node<E> {

    Node<E> prev;
    E value;
    Node<E> next;

    public Node(Node<E> prev, E value, Node<E> next) {
        this.prev = prev;
        this.value = value;
        this.next = next;
    }
}

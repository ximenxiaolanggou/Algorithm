package top.damoncai.chapter_13_LinkedListReverse;

import top.damoncai.chapter_03_singlylinkedlist.SinglyLinkedList;

/**
 *
 * 单项链表反转
 *  5 -> 4 -> 3
 *  3 -> 4 -> 5
 *
 * @author zhishun.cai
 * @date 2025/1/6
 */
public class Case_01_Reverse<T> {

    // 单项链表反转
    public ListNode<T> reverse(ListNode<T> list) {

        ListNode<T> ln = new ListNode();
        Node<T> header = list.header;

        while(header != null) {
            Node<T> tNode = new Node(header.data, ln.header);
            ln.header = tNode;

            header = header.next;
        }
        return ln;
    }
}

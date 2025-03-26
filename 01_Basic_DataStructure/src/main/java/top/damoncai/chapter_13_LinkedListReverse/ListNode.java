package top.damoncai.chapter_13_LinkedListReverse;

import ch.qos.logback.core.util.StringCollectionUtil;

/**
 * 单项链表
 * @author zhishun.cai
 * @date 2025/1/6
 */
public class ListNode<T> {

    private final String SPLITE = " -> ";

    public Node<T> header;

    public void print() {
        Node<T> p = header;
        StringBuffer sb = new StringBuffer("");
        while (p != null) {
            sb.append(p.data + SPLITE);
            p = p.next;
        }
        if(sb.length() > 0) {
            System.out.println(sb.substring(0, sb.length() - 4));
            return;
        }
        System.out.println(sb.toString());
    }

    public static <T> ListNode<T> of(T ...eles) {
        if(eles == null || eles.length == 0) {
            return null;
        }
        ListNode<T> listNode = new ListNode<>();
        Node<T> tNode = new Node<>(eles[0]);
        listNode.header = tNode;

        for (int i = 1; i < eles.length; i++) {
            tNode.next = new Node<>(eles[i]);
            tNode = tNode.next;
        }
        return listNode;
    }
}

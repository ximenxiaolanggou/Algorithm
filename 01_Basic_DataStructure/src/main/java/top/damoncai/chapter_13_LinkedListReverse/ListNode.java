package top.damoncai.chapter_13_LinkedListReverse;

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
}

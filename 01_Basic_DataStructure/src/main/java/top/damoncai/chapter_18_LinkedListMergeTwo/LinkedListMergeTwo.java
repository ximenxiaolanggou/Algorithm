package top.damoncai.chapter_18_LinkedListMergeTwo;

/**
 *
 * 合并两个有序链表
 *
 * @author zhishun.cai
 * @date 2025/1/10
 */
public class LinkedListMergeTwo {

    public Node<Integer> merge(Node<Integer> n1, Node<Integer> n2) {
        if(n1 == null) {
            return n2;
        }
        if(n2 == null) {
            return n1;
        }

        Node header = new Node(-1);
        Node p = header;

        while(n1 != null && n2 != null) {
            if(n1.data < n2.data) {
                p.next = n1;
                n1 = n1.next;
            }else {
                p.next = n2;
                n2 = n2.next;
            }
            p = p.next;
        }

        if(n1 != null) {
            p.next = n1;
        }
        if(n2 != null) {
            p.next = n2;
        }

        return header.next;
    }

    /**
     * 递归 方式
     * @param n1
     * @param n2
     * @return
     */
    public Node<Integer> mergeRecursion(Node<Integer> n1, Node<Integer> n2) {

        if(n1 == null) {
            return n2;
        }
        if(n2 == null) {
            return n1;
        }

        if(n1.data < n2.data) {
            n1.next = mergeRecursion(n1.next, n2);
            return n1;
        }else {
            n2.next = mergeRecursion(n1, n2.next);
            return n2;
        }
    }
}

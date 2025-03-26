package top.damoncai.chapter_19_LinkedListMergeN;

import top.damoncai.chapter_18_LinkedListMergeTwo.Node;

import org.junit.jupiter.api.Test;

/**
 * @author zhishun.cai
 * @date 2025/1/10
 */
public class LinkedListMergeNTest {

    @Test
    public void test() {
        Node<Integer> n1 = new Node<>(1);
        n1.next = new Node(3);
        n1.next.next = new Node(5);
        n1.next.next.next = new Node(7);
        n1.next.next.next.next = new Node(9);

        Node<Integer> n2 = new Node<>(1);
        n2.next = new Node(2);
        n2.next.next = new Node(4);
        n2.next.next.next = new Node(5);
        n2.next.next.next.next = new Node(8);

        Node<Integer> n3 = new Node<>(1);
        n3.next = new Node(3);
        n3.next.next = new Node(6);
        n3.next.next.next = new Node(7);
        n3.next.next.next.next = new Node(9);

        Node<Integer> n4 = new Node<>(1);
        n4.next = new Node(1);
        n4.next.next = new Node(4);
        n4.next.next.next = new Node(7);
        n4.next.next.next.next = new Node(8);


        Node<Integer>[] nodes = new Node[4];
        nodes[0] = n1;
        nodes[1] = n2;
        nodes[2] = n3;
        nodes[3] = n4;

        Node<Integer> node = new LinkedListMergeN().merge(nodes);
        if (node != null) {
            node.print();
        }

    }

}
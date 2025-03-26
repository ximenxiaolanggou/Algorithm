package top.damoncai.chapter_17_LinkedListRemoveSameEleNoReserve;

import top.damoncai.chapter_16_LinkedListRemoveSameEleReserve.Node;

import org.junit.jupiter.api.Test;

/**
 * @author zhishun.cai
 * @date 2025/1/9
 */
public class LinkedListRemoveSameEleNoReserveTest {

    @Test
    public void test() {

        Node<Integer> node = new Node(1);
        node.next = new Node(1);
        node.next.next = new Node(2);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(3);

        node.print();
        node = new LinkedListRemoveSameEleNoReserve().remove(node);

        if(node !=null) {
            node.print();
        }
    }

    @Test
    public void test2() {

        Node<Integer> node = new Node(1);
        node.next = new Node(1);
        node.next.next = new Node(2);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(3);

        node.print();
        node = new LinkedListRemoveSameEleNoReserve().remove2(node);

        if(node !=null) {
            node.print();
        }
    }

    @Test
    public void test3() {
        Node<Integer> node = new Node(1);
        node.next = new Node(1);
        node.next.next = new Node(2);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(3);

        node.print();
        node = new LinkedListRemoveSameEleNoReserve().removeDuplicatesReursion(node);

        if(node !=null) {
            node.print();
        }
    }
}
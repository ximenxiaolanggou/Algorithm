package top.damoncai.chapter_16_LinkedListRemoveSameEleReserve;

import org.junit.jupiter.api.Test;

/**
 * @author zhishun.cai
 * @date 2025/1/9
 */
public class LinkedListRemoveSameEleReserveTest {

    
    @Test
    public void test() {
        LinkedListRemoveSameEleReserve llr = new LinkedListRemoveSameEleReserve();
        
        Node<Integer> node = new Node(1);
        node.next = new Node(1);
        node.next.next = new Node(2);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(3);

        node.print();

        node = llr.removeDuplicates(node);

        if(node != null) {
            node.print();
        }
    }


    @Test
    public void test2() {
        LinkedListRemoveSameEleReserve llr = new LinkedListRemoveSameEleReserve();

        Node<Integer> node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(2);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(3);

        node.print();

        node = llr.removeDuplicatesReursion(node);

        if(node != null) {
            node.print();
        }
    }


}
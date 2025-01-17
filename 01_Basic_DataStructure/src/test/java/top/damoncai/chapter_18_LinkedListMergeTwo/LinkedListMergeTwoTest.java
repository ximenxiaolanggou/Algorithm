package top.damoncai.chapter_18_LinkedListMergeTwo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhishun.cai
 * @date 2025/1/10
 */
public class LinkedListMergeTwoTest {


    @Test
    public void test() {
        LinkedListMergeTwo merge = new LinkedListMergeTwo();

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

        Node node = merge.merge(n1, n2);
        if(node != null) {
            node.print();
        }
    }



    @Test
    public void test2() {
        LinkedListMergeTwo merge = new LinkedListMergeTwo();

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

        Node node = merge.mergeRecursion(n1, n2);
        if(node != null) {
            node.print();
        }
    }


}
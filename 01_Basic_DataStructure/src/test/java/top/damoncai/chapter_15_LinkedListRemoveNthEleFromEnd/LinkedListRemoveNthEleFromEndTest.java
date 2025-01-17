package top.damoncai.chapter_15_LinkedListRemoveNthEleFromEnd;

import org.junit.Test;


/**
 * @author zhishun.cai
 * @date 2025/1/8
 */
public class LinkedListRemoveNthEleFromEndTest {


    /**
     * 递归测试
     */
    @Test
    public void test() {
        LinkedListRemoveNthEleFromEnd<Integer> linkedList = new LinkedListRemoveNthEleFromEnd<>();

        Node<Integer> node = new Node<>(5);
        node.next = new Node(4);
        node.next.next = new Node(3);
        node.next.next.next = new Node(2);
        node.next.next.next.next = new Node(1);

        node.print();

        node = linkedList.handle(5, node);

        if(node != null) {
            node.print();
        }
    }


    /**
     * 快慢指针测试
     */
    @Test
    public void test2() {
        LinkedListRemoveNthEleFromEnd<Integer> linkedList = new LinkedListRemoveNthEleFromEnd<>();

        Node<Integer> node = new Node<>(5);
        node.next = new Node(4);
        node.next.next = new Node(3);
        node.next.next.next = new Node(2);
        node.next.next.next.next = new Node(1);

        node.print();

        node = linkedList.handle(5, node);

        if(node != null) {
            node.print();
        }
    }
}
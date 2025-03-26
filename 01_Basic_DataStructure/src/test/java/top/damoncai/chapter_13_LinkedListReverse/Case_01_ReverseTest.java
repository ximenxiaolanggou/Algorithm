package top.damoncai.chapter_13_LinkedListReverse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author zhishun.cai
 * @date 2025/1/6
 */
public class Case_01_ReverseTest {

    public static ListNode<Integer> listNode = new ListNode();

    @BeforeAll
    public static void before() {
        listNode.header = new Node(1);
        listNode.header.next = new Node(2);
        listNode.header.next.next = new Node(3);
        listNode.header.next.next.next = new Node(4);
        listNode.header.next.next.next.next = new Node(5);
    }


    @Test
    public void test_01_Reverse() {
        listNode.print();
        ListNode reverse = new Case_01_Reverse().reverse(listNode);
        reverse.print();
    }

}
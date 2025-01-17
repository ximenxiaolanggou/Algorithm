package top.damoncai.chapter_14_LinkedListRemoveEle;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhishun.cai
 * @date 2025/1/7
 */
@Slf4j
public class LinkedListRemoveEleTest {


    @Test
    public void test() {
        Node node = new Node(4);
        node.next = new Node(4);
        node.next.next = new Node(4);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(4);
        node.next.next.next.next.next = new Node(4);


        LinkedListRemoveEle<Integer> handler = new LinkedListRemoveEle<>();
        node.print();
        node = handler.removeElement(node, 4);
        if(node != null) {
            node.print();
        }
    }

    @Test
    public void test2() {
        Node node = new Node(2);
        node.next = new Node(3);
        node.next.next = new Node(4);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(4);
        node.next.next.next.next.next = new Node(4);


        LinkedListRemoveEle<Integer> handler = new LinkedListRemoveEle<>();
        node.print();
        node = handler.removeElementRecursion(node, 4);
        if(node != null) {
            node.print();
        }
    }
}
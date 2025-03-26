package top.damoncai.chapter_20_LinkedListFindMidEle;

import org.junit.jupiter.api.Test;

/**
 * @author zhishun.cai
 * @date 2025/1/16
 */
public class LinkedListFindMidEleTest {



  @Test
  public void testFindMidElement() {

    Node<Integer> n1 = new Node(1);
    n1.next = new Node(2);
    n1.next.next = new Node(3);
    n1.next.next.next = new Node(4);
    n1.next.next.next.next = new Node(5);
    n1.next.next.next.next.next = new Node(6);

    LinkedListFindMidEle<Integer> llm = new LinkedListFindMidEle();

    Integer ele = llm.findMinEle(n1);

    System.out.println(ele);
  }

}
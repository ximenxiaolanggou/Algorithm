package top.damoncai.chapter_22_LinkedListAdjustRing;

import org.junit.jupiter.api.Test;

/**
 * @author zhishun.cai
 * @date 2025/2/7
 */
public class LinkedListAdjustRingTest {


  @Test
  public void testIsRing() {
    LinkedListAdjustRing l = new LinkedListAdjustRing();

    Node<Integer> n7 = new Node<Integer>(7, null);
    Node<Integer> n6 = new Node<Integer>(6, n7);
    Node<Integer> n5 = new Node<Integer>(5, n6);
    Node<Integer> n4 = new Node<Integer>(4, n5);
    Node<Integer> n3 = new Node<Integer>(3, n4);
    Node<Integer> n2 = new Node<Integer>(2, n3);
    Node<Integer> n1 = new Node<Integer>(1, n2);

    // 构成环
    n7.next = n4;

    boolean isRing = l.checkIsRing(n1);

    System.out.println(isRing);
  }


  @Test
  public void testFindPort() {
    LinkedListAdjustRing l = new LinkedListAdjustRing();

    Node<Integer> n7 = new Node<Integer>(7, null);
    Node<Integer> n6 = new Node<Integer>(6, n7);
    Node<Integer> n5 = new Node<Integer>(5, n6);
    Node<Integer> n4 = new Node<Integer>(4, n5);
    Node<Integer> n3 = new Node<Integer>(3, n4);
    Node<Integer> n2 = new Node<Integer>(2, n3);
    Node<Integer> n1 = new Node<Integer>(1, n2);

    // 构成环
    n7.next = n1;

    Node port = l.findRingPort(n1);

    System.out.println(port.data);
  }
}
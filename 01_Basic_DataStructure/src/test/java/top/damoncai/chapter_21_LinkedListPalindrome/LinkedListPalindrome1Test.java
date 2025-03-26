package top.damoncai.chapter_21_LinkedListPalindrome;

import org.junit.jupiter.api.Test;
/**
 *
 *
 * @author zhishun.cai
 * @date 2025/1/16  
 */  
public class LinkedListPalindrome1Test {


    @Test
    public void test() {

      Node<Integer> n1 = new Node(1);
      n1.next = new Node(2);
      n1.next.next = new Node(3);
      n1.next.next.next = new Node(3);
      n1.next.next.next.next = new Node(3);
      n1.next.next.next.next.next = new Node(1);


      LinkedListPalindrome1<Integer> list = new LinkedListPalindrome1<>();
      boolean res = list.check(n1);
      System.out.println(res);

    }

}
package top.damoncai.chapter_29_DQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * @author zhishun.cai
 * @date 2025/2/25
 */
public class LinkedListDQueueTest {

  @Test
  public void test() {
    LinkedListDQueue<Integer> dQueue = new LinkedListDQueue(5);

    dQueue.offerFirst(1);
    dQueue.offerFirst(2);

    dQueue.offerLast(3);
    dQueue.offerLast(4);

    dQueue.offerFirst(5);
    dQueue.offerFirst(6);

    // 数据应该为  5 2 1 3 4
    Assertions.assertIterableEquals(List.of(5,2,1,3,4), dQueue);

    Assertions.assertEquals(dQueue.peekFirst(), 5);
    Assertions.assertEquals(dQueue.peekLast(), 4);

    Assertions.assertEquals(dQueue.pollFirst(), 5);
    Assertions.assertEquals(dQueue.pollLast(), 4);

    Assertions.assertIterableEquals(List.of(2,1,3), dQueue);

  }

}
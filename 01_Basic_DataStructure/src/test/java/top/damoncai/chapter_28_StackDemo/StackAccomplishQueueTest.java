package top.damoncai.chapter_28_StackDemo;


import org.junit.jupiter.api.Test;

/**
 * @author zhishun.cai
 * @date 2025/2/21
 */
public class StackAccomplishQueueTest {

  @Test
  public void testStack() {
    StackAccomplishQueue<Integer> queue = new StackAccomplishQueue(20);

    System.out.println(queue.peek());

    queue.offer(1);
    queue.offer(2);
    queue.offer(3);
    queue.offer(4);
    queue.offer(5);

    System.out.println(queue.peek());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
  }
}
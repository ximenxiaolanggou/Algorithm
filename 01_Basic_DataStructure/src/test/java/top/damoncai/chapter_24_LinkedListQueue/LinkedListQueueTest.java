package top.damoncai.chapter_24_LinkedListQueue;

import org.junit.jupiter.api.Test;

import java.util.Iterator;


/**
 * @author zhishun.cai
 * @date 2025/2/10
 */
public class LinkedListQueueTest {

    @Test
    public void testOffer() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>(3);

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        Iterator<Integer> iterator = queue.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println(queue.peek());
        System.out.println(queue.peek());

        System.out.println(queue.poll());
        System.out.println(queue.poll());

        iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
package top.damoncai.chapter_25_ArrayQueue;

import org.junit.Test;
import top.damoncai.chapter_24_LinkedListQueue.LinkedListQueue;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * @author zhishun.cai
 * @date 2025/2/11
 */
public class ArrayQueueTest {

    @Test
    public void test() {
        ArrayQueue<Integer> queue = new ArrayQueue<>(3);

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
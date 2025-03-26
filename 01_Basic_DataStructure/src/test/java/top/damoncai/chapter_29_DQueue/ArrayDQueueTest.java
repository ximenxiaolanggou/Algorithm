package top.damoncai.chapter_29_DQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhishun.cai
 * @date 2025/2/26
 */
class ArrayDQueueTest {


    @Test
    public void testArrayDQueue() {
        ArrayDQueue<Integer> dQueue = new ArrayDQueue<Integer>(5);

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
package top.damoncai.chapter_30_PriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author zhishun.cai
 * @date 2025/3/5
 */
class MaxHeapPriorityQueueTest {

    @Test
    public void test() {
        MaxHeapPriorityQueue<Entry> priorityQueue = new MaxHeapPriorityQueue<Entry>(5);

        priorityQueue.offer(new Entry("task1", 2));
        priorityQueue.offer(new Entry("task2", 8));
        priorityQueue.offer(new Entry("task3", 7));
        priorityQueue.offer(new Entry("task4", 7));
        priorityQueue.offer(new Entry("task5", 5));

        // 超出容量返回false
        Assertions.assertEquals(priorityQueue.offer(new Entry("task6", 10)), false);

        Assertions.assertEquals(priorityQueue.poll().getPriority(), 8);
        Assertions.assertEquals(priorityQueue.poll().getPriority(), 7);
        Assertions.assertEquals(priorityQueue.poll().getPriority(), 7);
        Assertions.assertEquals(priorityQueue.poll().getPriority(), 5);
        Assertions.assertEquals(priorityQueue.poll().getPriority(), 2);
        Assertions.assertEquals(priorityQueue.poll(), null);

    }
}
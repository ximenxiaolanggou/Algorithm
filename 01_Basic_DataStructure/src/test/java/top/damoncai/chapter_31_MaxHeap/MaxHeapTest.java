package top.damoncai.chapter_31_MaxHeap;

import org.junit.jupiter.api.Test;


/**
 * @author zhishun.cai
 * @date 2025/3/24
 */
class MaxHeapTest {


    @Test
    public void testMaxHeap() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        MaxHeap maxHeap = new MaxHeap(arr);
        maxHeap.print();
    }


    @Test
    public void testPeek() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        MaxHeap maxHeap = new MaxHeap(arr);
        maxHeap.print();
        System.out.println(maxHeap.peek());
        maxHeap.print();
    }

    @Test
    public void testPoll() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        MaxHeap maxHeap = new MaxHeap(arr);
        maxHeap.print();
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        maxHeap.print();
    }

    @Test
    public void testPollIndex() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        MaxHeap maxHeap = new MaxHeap(arr);
        maxHeap.print();
        System.out.println(maxHeap.poll(1));
        maxHeap.print();
    }

    @Test
    public void testOffer() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        MaxHeap maxHeap = new MaxHeap(arr, 10);
        maxHeap.offer(1);
        maxHeap.offer(10);
        maxHeap.print();
    }
}
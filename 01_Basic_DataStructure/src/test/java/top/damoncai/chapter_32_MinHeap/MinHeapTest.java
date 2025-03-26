package top.damoncai.chapter_32_MinHeap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhishun.cai
 * @date 2025/3/25
 */
class MinHeapTest {


    @Test
    public void testMinHeap() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        MinHeap MinHeap = new MinHeap(arr);
        MinHeap.print();
    }


    @Test
    public void testPeek() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        MinHeap MinHeap = new MinHeap(arr);
        MinHeap.print();
        System.out.println(MinHeap.peek());
        MinHeap.print();
    }

    @Test
    public void testPoll() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        MinHeap MinHeap = new MinHeap(arr);
        MinHeap.print();
        System.out.println(MinHeap.poll());
        System.out.println(MinHeap.poll());
        MinHeap.print();
    }

    @Test
    public void testPollIndex() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        MinHeap MinHeap = new MinHeap(arr);
        MinHeap.print();
        System.out.println(MinHeap.poll(1));
        MinHeap.print();
    }

    @Test
    public void testOffer() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        MinHeap MinHeap = new MinHeap(arr, 10);
        MinHeap.offer(1);
        MinHeap.offer(10);
        MinHeap.print();
    }
}
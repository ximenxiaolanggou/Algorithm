package top.damoncai.chapter_34_StreamMidNumber;

import top.damoncai.chapter_31_MaxHeap.MaxHeap;
import top.damoncai.chapter_32_MinHeap.MinHeap;

/**
 *
 * 数据流中中为数：
 *  - 如果奇数个 -> 中间数
 *  - 如果是偶数个 -> 中间两数的平均值
 * @author zhishun.cai
 * @date 2025/3/26
 */
public class StreamMidNumber {

    private MaxHeap left = new MaxHeap(100);

    private MinHeap right = new MinHeap(100);

    /**
     * 添加数
     *
     * 实现逻辑：
     *  - 先分成两个堆，左边是大顶堆，右边是小顶堆，例如 5 4 3  <--> 8 9 9
     *  - 每次添加数需要保证：
     *      - 大小堆最多相差一个数 - 添加时候判断
     *      - 左边的最大值（栈顶）需要小于等于 右边最小值（栈顶）
     *          - 在添加左边堆时候，先将其添加到右边堆，然后取出一个最小值放到左边
     *          - 
     *
     *  - 判断个数，取中间
     * @param data
     */
    public void add(int data) {
        // 1. 判断左右堆个数
        if(left.getSize() == right.getSize()) {
            // 数据需要添加到左堆
            right.offer(data);
            left.offer(right.poll());
        }else {
            // 数据需要添加到右堆
            left.offer(data);
            right.offer(left.poll());
        }
    }

    /**
     * 获取中间数
     * @return
     */
    public double midNumber() {
        // 没有数据
        if(left.getSize() == 0 && right.getSize() == 0) {
            return -1;
        }

        if(left.getSize() == right.getSize()) {
            return (left.peek() + right.peek()) / 2.0;
        }else {
            return left.peek() * 1.0;
        }
    }
}

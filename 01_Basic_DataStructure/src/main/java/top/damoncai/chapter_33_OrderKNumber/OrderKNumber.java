package top.damoncai.chapter_33_OrderKNumber;

import top.damoncai.chapter_32_MinHeap.MinHeap;

/**
 * 数组中第K大元素-Leetcode 215
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/description/
 * @author zhishun.cai
 * @date 2025/3/25
 */
public class OrderKNumber {


    /**
     * 思路：
     *  - 创建k大小的小顶堆
     *  - 先将k个数据放到小顶堆中，那么此时堆顶就是第k大的数据
     *  - 然后遍历剩余的数据，每当这个数大于堆顶（最小）的数据，就替换掉然后再保持小堆
     *  - 知道最后堆顶的数据就是第k小的数
     * @param arr
     * @param k
     * @return
     */
    public int getOrderKNumber(int arr[], int k) {
        MinHeap minHeap = new MinHeap(k);
        for (int i = 0; i < k; i++) {
            minHeap.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if(arr[i] > minHeap.peek()) {
                minHeap.replace(arr[i]);
            }
        }
        return minHeap.peek();
    }
}

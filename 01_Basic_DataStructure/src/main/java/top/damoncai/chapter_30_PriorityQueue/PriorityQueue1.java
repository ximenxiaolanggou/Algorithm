package top.damoncai.chapter_30_PriorityQueue;

import top.damoncai.chapter_24_LinkedListQueue.Queue;

/**
 *
 * 无序数组实现优先级队列
 *
 * 1、添加数据 - 向数组的尾部添加 复杂度 O(1)
 * 2、获取数据 - 找出数组中的最大值（或者最小值） 复杂度 O(n)
 *
 * @author zhishun.cai
 * @date 2025/3/4
 */
public class PriorityQueue1<E extends Priority> implements Queue<E> {

    /**
     * 数据容器
     */
    private Priority[] arr;

    /**
     * 容器大小
     */
    private int size;

    public PriorityQueue1(int capacity) {
        arr = new Priority[capacity];
    }

    @Override
    public boolean offer(E e) {
        if(isFull()) {
            return false;
        }
        arr[size++] = e;
        return true;
    }

    @Override
    public E poll() {
        if(isEmpty()) {
            return null;
        }
        int index = maxPriorityIndex();
        Priority data = arr[index];

        remove(index);

        return (E) data;
    }

    @Override
    public E peek() {
        if(isEmpty()) {
            return null;
        }
        int index = maxPriorityIndex();
        Priority data = arr[index];
        return (E) data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == arr.length;
    }

    /**
     * 移除元素
     * @param index 需要移除的元素
     */
    public void remove(int index) {
        // 判断删除的元素是后面一个元素
        if(index < size - 1) {
            // 后面数据前移
            System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        }
        // help gc
        arr[--size] = null;
    }


    /**
     * 获取最大优先级索引
     * @return
     */
    public int maxPriorityIndex() {
        int max = 0;
        for(int i = 1; i < size; i++) {
            if(arr[max].getPriority() < arr[i].getPriority()) {
                max = i;
            }
        }
        return max;
    }
}

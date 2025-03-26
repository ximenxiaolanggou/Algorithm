package top.damoncai.chapter_30_PriorityQueue;

import top.damoncai.chapter_24_LinkedListQueue.Queue;

/**
 *
 * 有序数组实现优先级队列
 *
 * 1、添加数据 - 找出需要插入的位置 O(n)
 * 2、获取数据 - 直接从数组尾部获取
 *
 * @author zhishun.cai
 * @date 2025/3/4
 */
public class PriorityQueue2<E extends Priority> implements Queue<E> {

    /**
     * 数据容器
     */
    private Priority[] arr;

    /**
     * 容器大小
     */
    private int size;

    public PriorityQueue2(int capacity) {
        arr = new Priority[capacity];
    }

    @Override
    public boolean offer(E e) {
        if(isFull()) {
            return false;
        }
        insert(e);
        size++;
        return true;
    }

    @Override
    public E poll() {
        if(isEmpty()) {
            return null;
        }
        Priority data = arr[--size];
        // help gc
        arr[size] = null;
        return (E) data;
    }

    @Override
    public E peek() {
        if(isEmpty()) {
            return null;
        }
        Priority data = arr[size - 1];
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
     * 插入数据
     * @param ele
     */
    public void insert(Priority ele) {
        int i = size - 1;
        while (i >= 0 && arr[i].getPriority() > ele.getPriority()) {
            arr[i + 1] = arr[i];
            i--;
        }
        arr[i + 1] = ele;
    }
}

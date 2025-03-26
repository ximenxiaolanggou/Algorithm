package top.damoncai.chapter_30_PriorityQueue;

import top.damoncai.chapter_24_LinkedListQueue.Queue;

/**
 * 堆优先级队列 - 大顶堆
 *
 * 堆 - 就是完全二叉树（分为大顶堆和小顶堆）
 *
 * 数组实现堆优先级队列原理：
 *  - 添加：数组尾部添加，然后上浮
 *  - 获取最大优先级：将数组尾部数据覆盖顶部数据，然后下层
 *
 *  特性：
 * 如果从索引0开始存储节点数据
 *  - 节点i的父节点为 floor((i-1)/2)，当i>0时。
 *  - 节点i的左子节点为 2i + 1，右子节点为 2i + 2，当然它们得< size
 * @author zhishun.cai
 * @date 2025/3/5
 */
public class MaxHeapPriorityQueue<E extends Priority> implements Queue<E> {


    private Priority[] array;

    private int size;

    public MaxHeapPriorityQueue(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(E e) {
        if(isFull()) {
            return false;
        }
        int childIndex = size++;
        int parentIndex = (childIndex - 1) / 2;
        // 大顶堆
        while (childIndex > 0 && e.getPriority() > array[parentIndex].getPriority()) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        array[childIndex] = e;
        return true;
    }

    @Override
    public E poll() {
        if(isEmpty()) {
            return null;
        }
        E data = (E) array[0];
        // 将尾部数据添加到顶部
        array[0] = array[size - 1];
        // 下层
        int parentIndex = 0;
        int leftChildIndex;
        while ((leftChildIndex = 2 * parentIndex + 1) < size) {
            int maxIndex = leftChildIndex;
            // 如果父节点存在两个子节点，需要比较两个子节点的优先级（获取子节点最大优先级）
            if(leftChildIndex + 1 < size && array[leftChildIndex].getPriority() < array[leftChildIndex + 1].getPriority()) {
                maxIndex = leftChildIndex + 1;
            }
            // 父节点 和 最大子节点优先级比较
            if(array[maxIndex].getPriority() > array[parentIndex].getPriority()) {
                array[parentIndex] = array[maxIndex];
                parentIndex = maxIndex;
                continue;
            }
            break;
        }
        array[parentIndex] = array[--size];
        array[size] = null;
        return data;
    }

    @Override
    public E peek() {
        if(isEmpty()) {
            return null;
        }
        return (E) array[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
}

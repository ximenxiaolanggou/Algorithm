package top.damoncai.chapter_28_StackDemo;

import top.damoncai.chapter_24_LinkedListQueue.LinkedListQueue;
import top.damoncai.chapter_24_LinkedListQueue.Queue;
import top.damoncai.chapter_25_ArrayQueue.ArrayQueue;
import top.damoncai.chapter_26_LinkedListStack.Stack;

import java.util.ArrayDeque;

/**
 *
 * 队列实现栈
 * @author zhishun.cai
 * @date 2025/2/24
 */
public class QueueAccomplishStack<E> implements Stack<E> {

    private LinkedListQueue<E> queue;


    public QueueAccomplishStack(int capacity) {
        queue = new LinkedListQueue<>(capacity);
    }

    /**
     *  head          tail
     *  1      2      3
     *
     *  需要添加一个4
     *
     *  head              tail
     *  1      2    3     4
     *  然后将1到3按顺序头部添加到尾部
     *
     *   head              tail
     *   4     1      2    3
     *
     * @param e
     * @return
     */
    @Override
    public boolean push(E e) {
        if(isFull()) {
            return false;
        }

        queue.offer(e);
        for (int i = 0; i < queue.getSize() - 1; i++) {
            queue.offer(queue.poll());
        }
        return true;
    }

    @Override
    public E pop() {
        return queue.poll();
    }

    @Override
    public E peek() {
        return queue.peek();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean isFull() {
        return queue.isFull();
    }
}

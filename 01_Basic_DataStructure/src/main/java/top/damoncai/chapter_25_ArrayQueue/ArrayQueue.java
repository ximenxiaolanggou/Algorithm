package top.damoncai.chapter_25_ArrayQueue;

import lombok.Data;
import top.damoncai.chapter_24_LinkedListQueue.Queue;

import java.util.Iterator;

/**
 *
 * 数组实现链表
 *
 * @author zhishun.cai
 * @date 2025/2/10
 */
@Data
public class ArrayQueue<E> implements Queue<E>, Iterable<E>{

    private E[] array;

    private int capacity;

    private int head = 0;

    private int tail = 0;

    public ArrayQueue(int capacity) {
        this.capacity = capacity + 1;
        array = (E[]) new Object[capacity];
    }


    @Override
    public boolean offer(E e) {
        if(isFull()) {
            return false;
        }
        array[tail] = e;
        tail = (tail + 1) % capacity;
        return true;
    }

    @Override
    public E poll() {
        if(isEmpty()) {
            return null;
        }
        E ele = array[head];
        head = (head + 1) % capacity;
        return ele;
    }

    @Override
    public E peek() {
        if(isEmpty()) {
            return null;
        }

        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return (tail + 1) % capacity == head;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int h = head;
            @Override
            public boolean hasNext() {
                return h != tail;
            }

            @Override
            public E next() {
                E ele = array[h];
                h  = (h + 1) % capacity;
                return ele;
            }
        };
    }
}

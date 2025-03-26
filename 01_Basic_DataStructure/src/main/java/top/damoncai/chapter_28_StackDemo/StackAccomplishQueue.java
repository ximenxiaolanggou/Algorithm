package top.damoncai.chapter_28_StackDemo;

import top.damoncai.chapter_24_LinkedListQueue.Queue;
import top.damoncai.chapter_27_ArrayStack.ArrayStack;

import java.lang.reflect.Array;
import java.util.Iterator;

/**
 *
 * 双端队列实现队列
 * @author zhishun.cai
 * @date 2025/2/21
 */
public class StackAccomplishQueue<E> implements Queue<E>{

    private ArrayStack<E> stack1;

    private ArrayStack<E> stack2;

    private int capacity;

    private int size = 0;

    public StackAccomplishQueue(int capacity) {
        this.capacity = capacity;
        stack1 = new ArrayStack<>(capacity);
        stack2 = new ArrayStack<>(capacity);
    }

    @Override
    public boolean offer(E e) {
        if(isFull()) {
            return false;
        }
        stack1.push(e);
        size++;
        return true;
    }

    @Override
    public E poll() {
        if(isEmpty()) {
            return null;
        }
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        size--;
        return stack2.pop();
    }

    @Override
    public E peek() {
        if(isEmpty()) {
            return null;
        }
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    @Override
    public boolean isEmpty() {
        return capacity == 0;
    }

    @Override
    public boolean isFull() {
        return capacity == size;
    }

}

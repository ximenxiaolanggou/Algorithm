package top.damoncai.chapter_27_ArrayStack;

import top.damoncai.chapter_26_LinkedListStack.Stack;

import javax.swing.text.Element;
import java.io.Serializable;
import java.util.Iterator;

/**
 * 数组实现链表
 * 0 1 2 3
 * 2 5 4 top
 * @author zhishun.cai
 * @date 2025/2/17
 */
public class ArrayStack<E> implements Stack<E>, Iterable<E> {

    /**
     * 栈
     */
    private E[] stack;

    /**
     * 栈顶指针
     */
    private int top = 0;

    /**
     * rong
     */
    private int capacity = 0;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        stack = (E[]) new Object[capacity];
    }

    @Override
    public boolean push(E e) {
        if(isFull()) {
            return false;
        }
        stack[top++] = e;
        return true;
    }

    @Override
    public E pop() {
        if(isEmpty()) {
            return null;
        }
        E ele = stack[--top];
        return ele;
    }

    @Override
    public E peek() {
        if(isEmpty()) {
            return null;
        }
        return stack[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = top;
            @Override
            public boolean hasNext() {
                return index != 0;
            }

            @Override
            public E next() {
                E e = stack[--index];
                return e;
            }
        };
    }
}

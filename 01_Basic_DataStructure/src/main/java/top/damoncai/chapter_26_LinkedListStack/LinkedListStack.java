package top.damoncai.chapter_26_LinkedListStack;

import top.damoncai.chapter_24_LinkedListQueue.LinkedListQueue;

import java.util.Iterator;

/**
 * @author zhishun.cai
 * @date 2025/2/14
 */
public class LinkedListStack<E> implements Stack<E>, Iterable<E> {

    private class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    /**
     * 链表哨兵节点
     */
    private Node<E> head = new Node<E>(null, null);

    /**
     * 栈容量
     */
    private int capacity = 0;

    /**
     * 元素
     */
    private int size = 0;

    public LinkedListStack(int capacity) {
        this.capacity = capacity;
    }


    @Override
    public boolean push(E e) {
        if(isFull()) {
            return false;
        }
        head.next = new Node<>(e, head.next);
        size++;
        return true;
    }

    @Override
    public E pop() {
        if(isEmpty()) {
            return null;
        }
        Node<E> eleNode = head.next;
        head.next = eleNode.next;
        size--;
        return eleNode.element;
    }

    @Override
    public E peek() {
        if(isEmpty()) {
            return null;
        }
        Node<E> eleNode = head.next;
        return eleNode.element;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Node<E> curr = head.next;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public E next() {
                E ele = curr.element;
                curr = curr.next;
                return ele;
            }
        };
    }

}

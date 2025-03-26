package top.damoncai.chapter_29_DQueue;

import java.util.Iterator;

/**
 * 链表实现双端队列
 * @author zhishun.cai
 * @date 2025/2/25
 */
public class LinkedListDQueue<E> implements Deque<E>, Iterable<E> {

    private int capacity = Integer.MAX_VALUE;

    private int size = 0;

    private Node<E> head;

    private Node<E> tail;

    public LinkedListDQueue(int capacity) {
        this.capacity = capacity;
        head = new Node(null, null, null);
        tail = new Node(head, null, null);
        head.next = tail;
    }

    public LinkedListDQueue() {
        head = new Node(null, null, null);
        tail = new Node(head, null, null);
        head.next = tail;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Node<E> cur = head.next;

            @Override
            public boolean hasNext() {
                return cur != tail;
            }

            @Override
            public E next() {
                E value = cur.value;
                cur = cur.next;
                return value;
            }
        };
    }

    @Override
    public boolean offerFirst(E e) {
        if(isFull()) {
            return false;
        }
        Node<E> insertNode = new Node<>(head, e, head.next);
        head.next.prev = insertNode;
        head.next = insertNode;
        size++;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if(isFull()) {
            return false;
        }
        Node<E> insertNode = new Node<>(tail.prev, e, tail);
        tail.prev.next = insertNode;
        tail.prev = insertNode;
        size++;
        return true;
    }

    @Override
    public E pollFirst() {
        if(isEmpty()) {
            return null;
        }
        Node<E> pollNode = head.next;
        head.next = head.next.next;
        pollNode.next.prev = head;
        size--;
        return pollNode.value;
    }

    @Override
    public E pollLast() {
        if(isEmpty()) {
            return null;
        }
        Node<E> pollNode = tail.prev;
        tail.prev = tail.prev.prev;
        pollNode.prev.next = tail;
        size--;
        return pollNode.value;
    }

    @Override
    public E peekFirst() {
        if(isEmpty()) {
            return null;
        }
        return head.next.value;
    }

    @Override
    public E peekLast() {
        if(isEmpty()) {
            return null;
        }
        return tail.prev.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }
}

package top.damoncai.chapter_24_LinkedListQueue;

import java.util.Iterator;

/**
 * @author zhishun.cai
 * @date 2025/2/10
 */
public class LinkedListQueue<E> implements Queue<E>, Iterable<E>{

    private class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    // 队列容量
    private Integer capacity = Integer.MAX_VALUE;

    // 队列中元素个数
    private Integer size = 0;

    private Node<E> head = new Node(null, null);
    private Node<E> tail = head;

    {
        // 形成环
        head.next = head;
    }

    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean offer(E e) {
        if(size.equals(capacity)){
            return false;
        }
        Node<E> newNode = new Node<>(e, head);
        tail.next = newNode;
        tail = newNode;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if(size.equals(0)){
            return null;
        }
        Node<E> firstNode = head.next;

        head.next = firstNode.next;
        if(head.next == head){
            tail = head;
        }
        size--;
        return firstNode.element;
    }

    @Override
    public E peek() {
        if(size.equals(0)){
            return null;
        }
        return head.next.element;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public Iterator<E> iterator() {


        return new Iterator<E>() {

            private Node<E> current = head.next;

            @Override
            public boolean hasNext() {
                return current != head;
            }

            @Override
            public E next() {
                E element = current.element;
                current = current.next;
                return element;
            }
        };
    }
}

package top.damoncai.chapter_04_bidirectionallinkedlist;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import top.damoncai.chapter_03_singlylinkedlist.SinglyLinkedList;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 双向链表
 * @author zhishun.cai
 * @date 2024/10/29
 */
public class DidirectionaLlinkedList<T> implements Iterable<T> {

    /**
     * 头结点
     */
    private Node<T> head;

    /**
     * 尾结点
     */
    private Node<T> tail;

    public DidirectionaLlinkedList() {
        head = new Node<T>();
        tail = new Node<T>();
        head.next = tail;
        tail.prev = head;
    }



    /**
     * 头部添加数据
     * @param data
     */
    public void addFirst(T data) {
        Node<T> node = new Node<>(data);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 尾部添加
     * @param data
     */
    public void addLast(T data) {
        Node<T> node = new Node(data);
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    /**
     * 根据索引获取
     * @param index
     * @return
     */
    public T get(int index) {
        int i = 0;
        Node<T> node = head.next;
        while (node != tail) {
            if(index == i++) {
                return node.data;
            }
            node = node.next;
        }
        throw new IndexOutOfBoundsException("超出索引");
    }

    /**
     * 插入
     * @param index
     * @param data
     */
    public void insert(int index, T data) {
        int i = 0;
        Node<T> node = head.next;
        while (node != tail) {
            if(index == i++) {
                Node<T> dataNode = new Node(data);
                dataNode.next = node;
                dataNode.prev = node.prev;

                node.prev.next = dataNode;
                node.prev = dataNode;
                return;
            }
            node = node.next;
        }
        throw new IndexOutOfBoundsException("超出索引");
    }

    /**
     * 移除头部
     * @return
     */
    public T removeFirst() {
        Node<T> node = head.next;
        if(node == tail) {
            return null;
        }
        T data = node.data;
        head.next = node.next;
        node.next.prev = head;

        // help gc
        node.next = null;
        node.prev = null;

        return data;
    }

    /**
     * 根据索引删除
     * @param index
     * @return
     */
    public T remove(int index) {
        int i = 0;
        Node<T> node = head.next;
        while (node != tail) {
            if(index == i++) {
                node.prev.next = node.next;
                node.next.prev = node.prev;

                // help gc
                node.next = null;
                node.prev = null;
                return node.data;
            }
            node = node.next;
        }
        throw new IndexOutOfBoundsException("超出索引");
    }

    /**
     * 遍历 - 1
     * @param consumer
     */
    public void loop(Consumer<T> consumer) {
        Node<T> node = head.next;
        while (node != tail) {
            consumer.accept(node.data);
            node = node.next;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new DidirectionaLlinkedList.NodeIterator();
    }

    /**
     * 迭代器
     */
    private class NodeIterator implements Iterator<T> {

        Node<T> node = head.next;
        @Override
        public boolean hasNext() {
            return node != tail;
        }

        @Override
        public T next() {
            node = node.next;
            return node.prev.data;
        }
    }





    @AllArgsConstructor
    @NoArgsConstructor
    class Node<T> {

        /**
         * 数据
         */
        public T data;

        /**
         * 后继节点
         */
        public Node<T> next;

        /**
         * 前继节点
         */
        public Node<T> prev;

        public Node(T data) {
            this.data = data;
        }

    }
}

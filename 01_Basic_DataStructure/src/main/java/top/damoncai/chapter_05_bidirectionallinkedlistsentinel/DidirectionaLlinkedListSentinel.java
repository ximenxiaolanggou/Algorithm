package top.damoncai.chapter_05_bidirectionallinkedlistsentinel;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 双向环形链表带哨兵，这时哨兵**既作为头，也作为尾**
 * @author zhishun.cai
 * @date 2024/10/29
 */
public class DidirectionaLlinkedListSentinel<T> implements Iterable<T> {

    private Node<T> sentinel = new Node<T>();

    public DidirectionaLlinkedListSentinel() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /**
     * 头部添加
     * @param element
     */
    public void addFirst(T element) {
        Node<T> node = new Node<T>(element);

        sentinel.next.prev = node;
        node.next = sentinel.next;

        node.prev = sentinel;
        sentinel.next = node;
    }

    /**
     * 尾部添加
     * @param element
     */
    public void addLast(T element) {
        Node<T> node = new Node<T>(element);

        node.next = sentinel;
        node.prev = sentinel.prev;

        sentinel.prev.next = node;
        sentinel.prev = node;

    }

    /**
     * 头部删除
     */
    public void removeFirst() {
        Node<T> node = sentinel.next;

        // 没有数据
        if (node == sentinel) {
            return;
        }

        sentinel.next = node.next;
        node.next.prev = sentinel;

        // help gc
        node.next = null;
        node.prev = null;
    }

    /**
     * 尾部删除
     */
    public void removeLast() {
        Node<T> node = sentinel.prev;

        // 没有数据
        if (node == sentinel) {
            return;
        }

        sentinel.prev = node.prev;
        node.prev.next = sentinel;

        // help gc
        node.next = null;
        node.prev = null;
    }

    /**
     * 根据元素删除
     * @param value
     */
    public void removeByValue(T value) {
        Node<T> node = sentinel.next;

        // 没有数据
        while (node != sentinel) {
           if(value == node.data) {
               node.prev.next = node.next;
               node.next.prev = node.prev;

               // help gc
               node.next = null;
               node.prev = null;
               return;
           }
            node = node.next;
        }
    }


    /**
     * 根据元素查找
     * @param value
     */
    public Node<T> findNodeByValue(T value) {
        Node<T> node = sentinel.next;

        // 没有数据
        while (node != sentinel) {
            if(value == node.data) {
                return node;
            }
            node = node.next;
        }
        return null;
    }


    /**
     * 循环
     * @param consumer
     */
    public void loop(Consumer<T> consumer) {
        Node<T> node = sentinel.next;
        while (node != sentinel) {
            consumer.accept(node.data);
            node = node.next;
        }
    }





    @Override
    public Iterator<T> iterator() {
        return new DidirectionaLlinkedListSentinel.NodeIterator();
    }

    /**
     * 迭代器
     */
    private class NodeIterator implements Iterator<T> {

        Node<T> node = sentinel.next;
        @Override
        public boolean hasNext() {
            return node != sentinel;
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

package top.damoncai.chapter_02_array.case_02_singlylinkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 *
 * 单项列表实现
 * @author zhishun.cai
 * @date 2024/10/24
 */
public class SinglyLinkedList<T> implements Iterable<T> {

    /**
     * 头结点
     */
    public Node<T> head;

    /**
     * 头部添加数据
     * @param data
     */
    public void addFirst(T data) {
        Node<T> node = new Node(data);
        // 这里不需要关系头结点是否为null
        node.next = head;
        head = node;
    }

    /**
     * 尾部添加
     * @param data
     */
    public void addLast(T data) {
        Node<T> node = head;
        if(head == null) {
            head = new Node(data);
            return;
        }
        // 找到尾部节点
        while(node.next != null) {
            node = node.next;
        }
        node.next = new Node(data);
    }

    /**
     * 根据索引获取
     * @param index
     * @return
     */
    public T get(int index) {
        int i = 0;
        Node<T> node = head;
        while (node != null) {
            if(i++ == index) {
                return node.data;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * 插入
     * @param index
     * @param data
     */
    public void insert(int index, T data) {
        if(0 == index) {
            addFirst(data);
            return;
        }

        int i = 1;
        Node<T> nodeData = new Node(data);
        Node<T> node = head;
        while (node != null) {
            if(index == i++ ) {
                nodeData.next = node.next;
                node.next = nodeData;
                return;
            }
            node = node.next;
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * 移除头部
     * @return
     */
    public T removeFirst() {
        if(head == null) {
            return null;
        }

        T data = head.data;
        head = head.next;
        return data;
    }

    /**
     * 根据索引删除
     * @param index
     * @return
     */
    public T remove(int index) {
        if(index == 0) {
            return removeFirst();
        }

        int i = 1;
        Node<T> node = head;
        while (node != null) {
            if(index == i++ ) {
                T data = node.next.data;
                node.next = node.next.next;
                return data;
            }
            node = node.next;
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * 遍历 - 1
     * @param consumer
     */
    public void loop(Consumer<T> consumer) {
        Node<T> node = head;
        while (node != null) {
            consumer.accept(node.data);
            node = node.next;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new NodeIterator();
    }

    /**
     * 迭代器
     */
    private class NodeIterator implements Iterator<T> {
        Node<T> node = head;
        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            T data = node.data;
            node = node.next;
            return data;
        }
    }


    /**
     * 节点对象
     * @param <T> 数据泛型
     */
    private static class Node<T> {

        public T data;

        public Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
}

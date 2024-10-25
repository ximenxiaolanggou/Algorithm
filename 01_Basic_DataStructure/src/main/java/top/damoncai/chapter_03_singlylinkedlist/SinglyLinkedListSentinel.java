package top.damoncai.chapter_03_singlylinkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 *
 * 单项列表实现 - 哨兵节点
 * @author zhishun.cai
 * @date 2024/10/24
 */
public class SinglyLinkedListSentinel<T> implements Iterable<T> {

    /**
     * 头结点
     */
    public Node<T> head = new Node<T>(null);

    /**
     * 头部添加数据
     * @param data
     */
    public void addFirst(T data) {
        Node<T> node = new Node(data);

        node.next = head.next;
        head = node;
    }

    /**
     * 尾部添加
     * @param data
     */
    public void addLast(T data) {
        Node<T> node = head;
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
        Node<T> node = head.next;
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
        int i = 0;
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
        Node<T> node = head.next;
        if(node == null) {
            return null;
        }

        head.next = node.next;
        return node.data;
    }

    /**
     * 根据索引删除
     * @param index
     * @return
     */
    public T remove(int index) {

        int i = 0;
        Node<T> node = head;
        while (node != null && node.next != null) {
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
        Node<T> node = head.next;
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
        Node<T> node = head.next;
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

package top.damoncai.chapter_29_DQueue;

import java.util.Iterator;

/**
 *
 * 数组实现双端队列
 *
 * @author zhishun.cai
 * @date 2025/2/26
 */
public class ArrayDQueue<E> implements Deque<E>, Iterable<E> {

  private int head = 0;
  private int tail = 0;
  private E[] array;

  private int capacity;

  /**
   * tail
   * head
   * 0     1     2     3
   *       tail        head
   */
  public ArrayDQueue(int capacity) {
    this.capacity = capacity;
    // 通过首位指针的方式需要让费一个元素节点（当head == tail的时候无法判断是满还是空）
    array = (E[]) new Object[capacity + 1];
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterator<E>() {

      private int current = head;

      @Override
      public boolean hasNext() {
        return current != tail;
      }

      @Override
      public E next() {
        E data = array[current];
        current = inc(current, array.length);
        return data;
      }
    };
  }

  @Override
  public boolean offerFirst(E e) {
    if(isFull()) {
      return false;
    }
    head = dec(head, array.length);
    array[head] = e;
    return true;
  }

  @Override
  public boolean offerLast(E e) {
    if(isFull()) {
      return false;
    }
    array[tail] = e;
    tail = inc(tail, array.length);
    return true;
  }

  @Override
  public E pollFirst() {
    if(isEmpty()) {
      return null;
    }
    E data = array[head];
    head = inc(head, array.length);
    return data;
  }

  @Override
  public E pollLast() {
    if(isEmpty()) {
      return null;
    }
    tail = dec(tail, array.length);
    return array[tail];
  }

  @Override
  public E peekFirst() {
    if(isEmpty()) {
      return null;
    }
    return array[head];
  }

  @Override
  public E peekLast() {
    if(isEmpty()) {
      return null;
    }
    return array[dec(tail, array.length)];
  }

  @Override
  public boolean isEmpty() {
    return head == tail;
  }

  @Override
  public boolean isFull() {
//    if (tail > head) {
//      return tail - head == array.length - 1;
//    } else if (tail < head) {
//      return head - tail == 1;
//    } else {
//      return false;
//    }
    return Math.abs(tail - head) == 1;
  }

  public static int inc(int index, int len) {
    if(index == len - 1) {
      return 0;
    }
    return index + 1;
  }

  public static int dec(int index, int len) {
    if(index == 0) {
      return len - 1;
    }
    return index - 1;
  }
}

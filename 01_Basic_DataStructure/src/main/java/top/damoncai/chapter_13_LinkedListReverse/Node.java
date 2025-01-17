package top.damoncai.chapter_13_LinkedListReverse;

/**
 * @author zhishun.cai
 * @date 2025/1/6
 */
public class Node<T> {

  public T data;

  public Node<T> next;


  public Node(T data) {
    this.data = data;
  }

  public Node(T data, Node<T> next) {
    this.data = data;
    this.next = next;
  }

  public Node() {

  }
}

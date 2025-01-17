package top.damoncai.chapter_20_LinkedListFindMidEle;

import lombok.Data;

/**
 * @author zhishun.cai
 * @date 2025/1/7
 */

@Data
public class Node<T> {

  public T data;

  public Node<T> next;


  /**
   * 打印节点信息
   */
  public void print() {
    Node<T> node = this;
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
    System.out.println("");
  }


  public Node(T data) {
    this.data = data;
  }

  public Node(T data, Node<T> next) {
    this.data = data;
    this.next = next;
  }

}

package top.damoncai.chapter_04_bidirectionallinkedlist;

import org.junit.Test;
import top.damoncai.chapter_03_singlylinkedlist.SinglyLinkedList;

import static org.junit.Assert.*;
/**
 *
 *
 * @author zhishun.cai
 * @date 2024/10/29  
 */  
public class DidirectionaLlinkedListTest {

  DidirectionaLlinkedList<Integer> list = new DidirectionaLlinkedList();

  @Test
  public void addFitstTest() {
    list.addFirst(1);
    list.addFirst(2);
    list.addFirst(3);
    list.addFirst(4);

    list.loop(item -> System.out.println(item));
  }

  @Test
  public void addLastTest() {
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);

    list.loop(item -> System.out.println(item));
  }

  @Test
  public void getTest() {
    list.addLast(0);
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);


    System.out.println(list.get(1));
    System.out.println(list.get(5));
  }

  @Test
  public void intsertTest() {
    list.addLast(0);
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);

    list.insert(1,0);


    list.loop(item -> System.out.println(item));

    list.insert(2,8);
    System.out.println("------------");
//    list.insert(5,5);

    list.loop(item -> System.out.println(item));
    list.insert(10,10);
  }

  @Test
  public void removeFistTest() {
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);

    System.out.println(list.removeFirst());
    System.out.println(list.removeFirst());
    System.out.println("loop++++++++++++++++++");
    list.loop(item -> System.out.println(item));
  }

  @Test
  public void removeIndexTest() {
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);

    System.out.println(list.remove(0));
    System.out.println(list.remove(0));
    System.out.println(list.remove(0));
    System.out.println(list.remove(0));
    System.out.println(list.remove(0));
    System.out.println("loop++++++++++++++++++");
    list.loop(item -> System.out.println(item));

    System.out.println(list.remove(5));
  }
}
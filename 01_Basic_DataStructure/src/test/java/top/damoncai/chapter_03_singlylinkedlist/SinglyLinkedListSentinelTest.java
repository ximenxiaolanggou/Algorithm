package top.damoncai.chapter_03_singlylinkedlist;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author zhishun.cai
 * @date 2024/10/25
 */
public class SinglyLinkedListSentinelTest{

    SinglyLinkedListSentinel<Integer> singlyList = new SinglyLinkedListSentinel();

    @Test
    public void addFitstTest() {
        singlyList.addFirst(1);
        singlyList.addFirst(2);
        singlyList.addFirst(3);
        singlyList.addFirst(4);

        singlyList.loop(item -> System.out.println(item));
    }

    @Test
    public void addLastTest() {
        singlyList.addLast(1);
        singlyList.addLast(2);
        singlyList.addLast(3);
        singlyList.addLast(4);

        singlyList.loop(item -> System.out.println(item));
    }

    @Test
    public void getTest() {
        singlyList.addFirst(1);
        singlyList.addFirst(2);
        singlyList.addFirst(3);
        singlyList.addFirst(4);

        System.out.println(singlyList.get(1));
        System.out.println(singlyList.get(5));
    }

    @Test
    public void intsertTest() {
        singlyList.addLast(1);
        singlyList.addLast(2);
        singlyList.addLast(3);
        singlyList.addLast(4);

        singlyList.insert(0,0);
        singlyList.insert(2,8);

        singlyList.insert(5,5);

        singlyList.loop(item -> System.out.println(item));
        singlyList.insert(10,10);
    }

    @Test
    public void removeFistTest() {
        singlyList.addLast(1);
        singlyList.addLast(2);
        singlyList.addLast(3);
        singlyList.addLast(4);

        System.out.println(singlyList.removeFirst());
        System.out.println(singlyList.removeFirst());
        System.out.println("loop++++++++++++++++++");
        singlyList.loop(item -> System.out.println(item));
    }

    @Test
    public void removeIndexTest() {
        singlyList.addLast(1);
        singlyList.addLast(2);
        singlyList.addLast(3);
        singlyList.addLast(4);

        System.out.println(singlyList.remove(1));
        System.out.println(singlyList.remove(1));
        System.out.println("loop++++++++++++++++++");
        singlyList.loop(item -> System.out.println(item));

        System.out.println(singlyList.remove(5));
    }

}
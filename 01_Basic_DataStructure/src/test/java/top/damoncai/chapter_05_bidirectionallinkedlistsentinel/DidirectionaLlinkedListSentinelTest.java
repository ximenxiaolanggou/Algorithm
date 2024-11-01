package top.damoncai.chapter_05_bidirectionallinkedlistsentinel;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * @author zhishun.cai
 * @date 2024/11/1
 */
public class DidirectionaLlinkedListSentinelTest {

    DidirectionaLlinkedListSentinel list = new DidirectionaLlinkedListSentinel();

    @Test
    public void addFirst() {
        list.addFirst(0);
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        list.loop(item -> System.out.println(item));
    }

    @Test
    public void addLast() {
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.loop(item -> System.out.println(item));
    }

    @Test
    public void removeFirst() {
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);


        list.loop(item -> System.out.println(item));
        System.out.println("=======================");
        list.removeFirst();
        list.loop(item -> System.out.println(item));
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst(); // 没有数据返回的是null
    }

    @Test
    public void removeLast() {
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);


        list.loop(item -> System.out.println(item));
        System.out.println("=======================");
        list.removeLast();
        list.loop(item -> System.out.println(item));
        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeLast(); // 没有数据返回的是null
    }

    @Test
    public void removeByValue() {

        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);


        list.loop(item -> System.out.println(item));
        System.out.println("=======================");
        list.removeByValue(2);

        list.loop(item -> System.out.println(item));
    }

    @Test
    public void findNodeByValue() {

        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);


        list.loop(item -> System.out.println(item));
        System.out.println("=======================");

        System.out.println(list.findNodeByValue(2));
    }

    @Test
    public void loop() {
        list.loop(item -> System.out.println(item));
    }

    @Test
    public void iterator() {
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
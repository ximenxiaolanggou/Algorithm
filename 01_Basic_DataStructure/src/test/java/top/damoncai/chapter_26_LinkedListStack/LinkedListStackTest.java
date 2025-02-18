package top.damoncai.chapter_26_LinkedListStack;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * @author zhishun.cai
 * @date 2025/2/14
 */
public class LinkedListStackTest {

    @Test
    public void test() {
        LinkedListStack stack = new LinkedListStack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        Iterator iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("pop：" + stack.pop());

        iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
package top.damoncai.chapter_27_ArrayStack;

import org.junit.Test;
import top.damoncai.chapter_26_LinkedListStack.LinkedListStack;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * @author zhishun.cai
 * @date 2025/2/17
 */
public class ArrayStackTest {


    @Test
    public void test() {
        ArrayStack stack = new ArrayStack<Integer>(5);

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
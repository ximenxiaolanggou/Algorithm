package top.damoncai.chapter_28_StackDemo;

import org.junit.jupiter.api.Test;
import top.damoncai.chapter_27_ArrayStack.ArrayStack;

import java.util.Iterator;


/**
 * @author zhishun.cai
 * @date 2025/2/24
 */
public class QueueAccomplishStackTest {


    @Test
    public void test() {
        QueueAccomplishStack stack = new QueueAccomplishStack<Integer>(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
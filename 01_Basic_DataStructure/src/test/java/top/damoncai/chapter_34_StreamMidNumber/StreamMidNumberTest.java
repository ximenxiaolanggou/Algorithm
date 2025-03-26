package top.damoncai.chapter_34_StreamMidNumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhishun.cai
 * @date 2025/3/26
 */
class StreamMidNumberTest {


    @Test
    public void test() {
        StreamMidNumber handler = new StreamMidNumber();
        System.out.println(handler.midNumber());

        handler.add(1);
        handler.add(6);
        handler.add(3);
        handler.add(5);
        handler.add(8);
        handler.add(7);
        System.out.println(handler.midNumber());
        handler.add(2);
        handler.add(3);
        handler.add(9);
        System.out.println(handler.midNumber());
        handler.add(10);
        handler.add(11);
        System.out.println(handler.midNumber());
    }

}
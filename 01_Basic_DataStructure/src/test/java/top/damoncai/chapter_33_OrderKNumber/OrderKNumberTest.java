package top.damoncai.chapter_33_OrderKNumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhishun.cai
 * @date 2025/3/25
 */
class OrderKNumberTest {

    @Test
    void getOrderKNumber() {
        OrderKNumber handler = new OrderKNumber();
        int[] arr1 = {3,2,1,5,6,4};
        int[] arr2 = {3,2,3,1,2,4,5,5,6};

        Assertions.assertEquals(5, handler.getOrderKNumber(arr1, 2));
        Assertions.assertEquals(4, handler.getOrderKNumber(arr2, 4));
    }
}
package top.damoncai.chapter_08_recursionDoubleSort;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author zhishun.cai
 * @date 2024/12/24
 */
public class RecursionDoubleSortTest {


    @Test
    public void testRecursionDoubleSort() {
        RecursionDoubleSort sort = new RecursionDoubleSort();
        Integer[] arr = {2,3,8,5,6,9,3,6};
        System.out.println(Arrays.toString(arr));
        sort.sort(arr, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        System.out.println("----------------v2----------------");
        Integer[] arr_V2 = {2,3,8,5,6,9,3,6};
        System.out.println(Arrays.toString(arr_V2));
        sort.sort(arr_V2, arr_V2.length - 1);
        System.out.println(Arrays.toString(arr_V2));
    }
}
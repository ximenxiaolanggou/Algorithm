package top.damoncai.chapter_09_recursionInsertionSort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author zhishun.cai
 * @date 2024/12/26
 */
public class RecursionInsertionSortTest {

    @Test
    public void testRecursionInsertionSort() {
        int[] arr = {2,3,8,5,6,9,3,6,1};
        RecursionInsertionSort sort = new RecursionInsertionSort();

        sort.sort(arr, 1);

        System.out.println(Arrays.toString(arr));
    }
}
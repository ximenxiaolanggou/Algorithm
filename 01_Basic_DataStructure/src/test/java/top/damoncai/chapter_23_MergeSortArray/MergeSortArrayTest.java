package top.damoncai.chapter_23_MergeSortArray;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author zhishun.cai
 * @date 2025/2/8
 */
public class MergeSortArrayTest {


  @Test
  public void testCommonMergeSortArray() {
    int[] a1 = {1,3,4,5};
    int[] a2 = {2,3,5,6};

    MergeSortArray handler = new MergeSortArray();

    int[] mergeArray = handler.commonMerge(a1, a2);

    System.out.println(Arrays.toString(mergeArray));
  }

  @Test
  public void testRecursionMerge() {
    int[] a1 = {1,3,4,5};
    int[] a2 = {2,3,5,6};

    MergeSortArray handler = new MergeSortArray();

    int[] mergeArray = handler.recursionMerge(a1, a2);

    System.out.println(Arrays.toString(mergeArray));
  }
}
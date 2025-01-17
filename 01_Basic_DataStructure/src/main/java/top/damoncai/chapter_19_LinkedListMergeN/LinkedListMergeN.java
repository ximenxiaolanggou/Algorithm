package top.damoncai.chapter_19_LinkedListMergeN;

import top.damoncai.chapter_18_LinkedListMergeTwo.LinkedListMergeTwo;
import top.damoncai.chapter_18_LinkedListMergeTwo.Node;

import java.util.Arrays;

/**
 *
 * 合并 N个有序链表
 * [
 *  [1,2,3,6,7],
 *  [1,3,4],
 *  [2,4,5,6],
 *  .....
 * ]
 *
 * @author zhishun.cai
 * @date 2025/1/10
 */
public class LinkedListMergeN {


    public Node<Integer> merge(Node<Integer>[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }

        if(nodes.length == 1) {
            return nodes[0];
        }

        Node<Integer> node = doMerge(nodes, 0, nodes.length - 1);
        return node;
    }

    public Node<Integer> doMerge(Node<Integer>[] nodes, int left, int right) {
        if(left == right) {
            return nodes[left];
        }

        int mid = (left + right) >> 1;

        return new LinkedListMergeTwo().merge(
                doMerge(nodes, left, mid),
                doMerge(nodes, mid + 1, right)
        );

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int mid = 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid , arr.length );

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
    }


}

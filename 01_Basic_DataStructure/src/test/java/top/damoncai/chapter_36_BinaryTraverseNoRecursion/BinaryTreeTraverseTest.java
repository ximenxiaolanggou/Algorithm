package top.damoncai.chapter_36_BinaryTraverseNoRecursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhishun.cai
 * @date 2025/4/1
 */
class BinaryTreeTraverseTest {
    static TreeNode treeNode = null;

    static {
        treeNode = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        null
                ),
                new TreeNode(3,
                        new TreeNode(5),
                        new TreeNode(6)
                )
        );
    }



    /**
     * 前序遍历 - 非递归测试
     */
    @Test
    void preTraverse() {
        BinaryTreeTraverse traverse = new BinaryTreeTraverse();
        List<Integer> collector = new ArrayList<>();
        traverse.preTraverse(treeNode, collector);
        Assertions.assertEquals(List.of(1,2,4,3,5,6), collector);
    }

    /**
     * 中序遍历 - 非递归测试
     */
    @Test
    void midTraverse() {
        BinaryTreeTraverse traverse = new BinaryTreeTraverse();
        List<Integer> collector = new ArrayList<>();
        traverse.midTraverse(treeNode, collector);
        Assertions.assertEquals(List.of(4,2,1,5,3,6), collector);
    }

    /**
     * 后序遍历 - 非递归测试
     */
    @Test
    void postTraverse() {
        BinaryTreeTraverse traverse = new BinaryTreeTraverse();
        List<Integer> collector = new ArrayList<>();
        traverse.postTraverse(treeNode, collector);
        Assertions.assertEquals(List.of(4,2,5,6,3,1), collector);
    }
}
package top.damoncai.chapter_38_BinaryTreeMaxDeep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhishun.cai
 * @date 2025/4/7
 */
class BinaryTreeMaxDeepTest {

    static TreeNode treeNode1;
    static TreeNode treeNode2;
    static TreeNode treeNode3;

    static {
        treeNode1 = new TreeNode(1);
        treeNode2 = new TreeNode(
                1,
                new TreeNode(2, null, null),
                new TreeNode(3, null, null)
        );
        treeNode3 = new TreeNode(
                1,
                new TreeNode(2, null, null),
                new TreeNode(3, null, new TreeNode(4, null, null))
        );
    }

    /**
     * 递归方式获取二叉树最大深度
     */
    @Test
    void maxDeepRecursion() {
        BinaryTreeMaxDeep binaryTreeMaxDeep = new BinaryTreeMaxDeep();
        int r1 = binaryTreeMaxDeep.maxDeepRecursion(treeNode1);
        int r2 = binaryTreeMaxDeep.maxDeepRecursion(treeNode2);
        int r3 = binaryTreeMaxDeep.maxDeepRecursion(treeNode3);

        Assertions.assertEquals(1, r1);
        Assertions.assertEquals(2, r2);
        Assertions.assertEquals(3, r3);

    }

    /**
     * 非递归方式获取二叉树最大深度
     */
    @Test
    void maxDeepNoRecursion() {

        BinaryTreeMaxDeep binaryTreeMaxDeep = new BinaryTreeMaxDeep();
        int r1 = binaryTreeMaxDeep.maxDeepNoRecursion(treeNode1);
        int r2 = binaryTreeMaxDeep.maxDeepNoRecursion(treeNode2);
        int r3 = binaryTreeMaxDeep.maxDeepNoRecursion(treeNode3);

        Assertions.assertEquals(1, r1);
        Assertions.assertEquals(2, r2);
        Assertions.assertEquals(3, r3);
    }

    /**
     * 遍历方式获取二叉树最大深度
     */
    @Test
    void maxDeepForeach() {
        BinaryTreeMaxDeep binaryTreeMaxDeep = new BinaryTreeMaxDeep();
        int r1 = binaryTreeMaxDeep.maxDeepForeach(treeNode1);
        int r2 = binaryTreeMaxDeep.maxDeepForeach(treeNode2);
        int r3 = binaryTreeMaxDeep.maxDeepForeach(treeNode3);

        Assertions.assertEquals(1, r1);
        Assertions.assertEquals(2, r2);
        Assertions.assertEquals(3, r3);
    }
}
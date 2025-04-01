package top.damoncai.chapter_37_SymmetricBinaryTree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhishun.cai
 * @date 2025/4/1
 */
class SymmetricBinaryTreeTest {


    static TreeNode treeNode = null;

    static {
        treeNode = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(4)
                ),
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(3)
                )
        );
    }


    @Test
    void isSymmetric() {
        SymmetricBinaryTree tree = new SymmetricBinaryTree();
        boolean isSymmetric = tree.isSymmetric(treeNode);
        Assertions.assertEquals(true, isSymmetric);
    }
}
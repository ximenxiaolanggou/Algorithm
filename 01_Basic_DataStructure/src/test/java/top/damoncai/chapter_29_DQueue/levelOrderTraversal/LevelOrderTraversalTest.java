package top.damoncai.chapter_29_DQueue.levelOrderTraversal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhishun.cai
 * @date 2025/3/3
 */
class LevelOrderTraversalTest {

  @Test
  public void levelOrderTraversal() {
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    TreeNode node7 = new TreeNode(7);

    TreeNode node2 = new TreeNode(2, node4, node5);
    TreeNode node3 = new TreeNode(3, node6, node7);

    TreeNode rootNode = new TreeNode(1, node2, node3);

    LevelOrderTraversal traversal = new LevelOrderTraversal();


    traversal.traversal(rootNode);
  }
}
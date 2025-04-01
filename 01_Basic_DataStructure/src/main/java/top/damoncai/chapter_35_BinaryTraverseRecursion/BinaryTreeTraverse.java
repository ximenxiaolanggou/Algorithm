package top.damoncai.chapter_35_BinaryTraverseRecursion;


import java.util.List;

/**
 * 二叉树遍历 - 递归
 *
 * @author zhishun.cai
 * @date 2025/3/31
 */
public class BinaryTreeTraverse {


    /**
     * 前序遍历
     * @param root
     * @param collector
     */
    public void preTraverse(TreeNode root, List<Integer> collector) {
        if(root == null) return;
        collector.add(root.val);
        preTraverse(root.left, collector);
        preTraverse(root.right, collector);
    }


    /**
     * 中序遍历
     * @param root
     * @param collector
     */
    public void midTraverse(TreeNode root, List<Integer> collector) {
        if(root == null) return;
        midTraverse(root.left, collector);
        collector.add(root.val);
        midTraverse(root.right, collector);
    }

    /**
     * 后续遍历
     * @param root
     * @param collector
     */
    public void postTraverse(TreeNode root, List<Integer> collector) {
        if(root == null) return;
        postTraverse(root.left, collector);
        postTraverse(root.right, collector);
        collector.add(root.val);
    }
}

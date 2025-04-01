package top.damoncai.chapter_37_SymmetricBinaryTree;

/**
 * 对称二叉树
 * @author zhishun.cai
 * @date 2025/4/1
 */
public class SymmetricBinaryTree {


    /**
     * 判断是否对称
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return doIsSymmetric(root.left, root.right);
    }

    private boolean doIsSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        if(left.val != right.val) {
            return false;
        }
        return doIsSymmetric(left.right, right.left) && doIsSymmetric(left.left, right.right);
    }
}

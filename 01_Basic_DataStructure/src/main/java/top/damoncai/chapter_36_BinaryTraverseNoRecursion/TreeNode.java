package top.damoncai.chapter_36_BinaryTraverseNoRecursion;

/**
 * 树节点
 * @author zhishun.cai
 * @date 2025/3/3
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) { val = x; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}

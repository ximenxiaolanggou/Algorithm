package top.damoncai.chapter_36_BinaryTraverseNoRecursion;


import top.damoncai.chapter_26_LinkedListStack.LinkedListStack;

import java.util.List;

/**
 * 二叉树遍历 - 非递归
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
        LinkedListStack<TreeNode> stack = new LinkedListStack(20);
        while (root != null || !stack.isEmpty()) {
            if(root != null) {
                collector.add(root.val);
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop().right;
            }
        }
    }


    /**
     * 中序遍历
     * @param root
     * @param collector
     */
    public void midTraverse(TreeNode root, List<Integer> collector) {
        LinkedListStack<TreeNode> stack = new LinkedListStack(20);
        while (root != null || !stack.isEmpty()) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            }else {
                collector.add(stack.peek().val);
                root = stack.pop().right;
            }
        }
    }

    /**
     * 后续遍历 - 非递归方式
     * 前序和中序代码逻辑都是一样，知识在收集元素位置不一样
     *
     * 但是后续遍历，相对前中序遍历，最大问题就是，如果节点出栈那么就无法找到返回的路了
     * 所以这里需要判断
     * - 如果没有右节点的可以出栈
     * - 如果有右节点不可以出栈，右节点直接入栈（需要注意的是右节点入栈前需要判断上次出栈的是不是就是右节点）
     *
     * @param root
     * @param collector
     */
    public void postTraverse(TreeNode root, List<Integer> collector) {
        LinkedListStack<TreeNode> stack = new LinkedListStack(20);
        TreeNode lasetNode = null;
        while (root != null || !stack.isEmpty()) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            }else {
                TreeNode currentNode = stack.peek();
                if(currentNode.right != null && lasetNode != currentNode.right) {
                   root = currentNode.right;
                }else{
                    lasetNode = stack.pop();
                    collector.add( lasetNode.val);
                }
            }
        }
    }
}

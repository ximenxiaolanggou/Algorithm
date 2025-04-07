package top.damoncai.chapter_38_BinaryTreeMaxDeep;

import top.damoncai.chapter_24_LinkedListQueue.LinkedListQueue;
import top.damoncai.chapter_24_LinkedListQueue.Queue;
import top.damoncai.chapter_26_LinkedListStack.LinkedListStack;

/**
 *
 * 二叉树最大深度问题
 * @author zhishun.cai
 * @date 2025/4/7
 */
public class BinaryTreeMaxDeep {


    /**
     * 递归方式获取二叉树最大深度
     */
    public int maxDeepRecursion(TreeNode root) {
        if(root == null) return 0;
        int leftMax = maxDeepRecursion(root.left);
        int rightMax = maxDeepRecursion(root.right);
        return Math.max(leftMax, rightMax) + 1;
    }

    /**
     * 非递归方式获取二叉树最大深度
     */
    public int maxDeepNoRecursion(TreeNode root) {
        int maxDeep = 0;
        LinkedListStack<TreeNode> stack = new LinkedListStack(20);
        TreeNode lasetNode = null;
        while (root != null || !stack.isEmpty()) {
            if(root != null) {
                stack.push(root);
                if(maxDeep < stack.getSize()) {
                    maxDeep = stack.getSize();
                }
                root = root.left;
            }else {
                TreeNode currentNode = stack.peek();
                if(currentNode.right != null && lasetNode != currentNode.right) {
                    root = currentNode.right;
                }else{
                    lasetNode = stack.pop();
                }
            }
        }

        return maxDeep;
    }

    /**
     * 横向遍历获取最小深度
     * @param root
     * @return
     */
    public int maxDeepForeach(TreeNode root) {
        LinkedListQueue<TreeNode> queue = new LinkedListQueue();
        queue.offer(root);
        int maxDeep = 0;
        while(!queue.isEmpty()) {
            maxDeep++;
            for(int i = 0; i < queue.getSize(); i++) {
                TreeNode currentNode = queue.poll();
                if(currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

        }

        return maxDeep;
    }
}

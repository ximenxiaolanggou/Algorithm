package top.damoncai.chapter_25_ArrayQueue.levelOrderTraversal;

import top.damoncai.chapter_24_LinkedListQueue.LinkedListQueue;

/**
 *
 * 树节点层序遍历
 * @author zhishun.cai
 * @date 2025/3/3
 */
public class LevelOrderTraversal {

    /**
     *      1
     *     / \
     *    2   3
     *   /\   /\
     *  4  5 6  7
     *
     * 1 2 3 4 5 6 7
     *
     * 树节点遍历
     * @param root
     */
    public void traversal(TreeNode root) {
        LinkedListQueue<TreeNode> queue = new LinkedListQueue<TreeNode>();
        // 添加根节点
        queue.offer(root);
        int c1 = 1;
        while (!queue.isEmpty()) {
            int c2 = 0;
            for (int i = 0; i < c1; i++) {
                TreeNode node = queue.poll();
                System.out.print(node + " ");
                if (node.left != null) {
                    queue.offer(node.left);
                    c2++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    c2++;
                }
            }
            c1 = c2;
            System.out.println();
        }
    }
}

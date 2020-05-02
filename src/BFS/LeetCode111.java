package BFS;

import utils.TreeNode;

import java.util.LinkedList;

public  class LeetCode111 {

    /**
     *
     给定一个二叉树，找出其最小深度。
     最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 1;

        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.pollFirst();
                if (treeNode.left == null && treeNode.right == null) {
                    return level;
                }
                if (treeNode.left != null) {
                    queue.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.addLast(treeNode.right);
                }
            }
            level++;
        }

        return level;
    }



}

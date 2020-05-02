package DFS;

import utils.TreeNode;

import java.util.LinkedList;

public class LeetCode129 {

    public int sumNumbers(TreeNode root) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        LinkedList<Integer> sums = new LinkedList<>();
        int sum = 0;
        if (root == null) {
            return sum;
        }
        nodes.addLast(root);
        sums.addLast(root.val);
        while (nodes.size() > 0) {
            TreeNode treeNode = nodes.pollFirst();
            int num = sums.pollFirst();
            if (treeNode.left == null && treeNode.right == null) {
                sum = sum + num;
            } else {
                if (treeNode.left != null) {
                    nodes.addLast(treeNode.left);
                    sums.addLast(num * 10 + treeNode.left.val);
                }

                if (treeNode.right != null) {
                    nodes.addLast(treeNode.right);
                    sums.addLast(num * 10 + treeNode.right.val);
                }
            }
        }
        return sum;
    }

}

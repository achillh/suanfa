package DFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LeetCode112 {


    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        LinkedList<Integer> integers = new LinkedList<>();
        treeNodes.addLast(root);
        integers.addLast(root.val);
        while (treeNodes.size() != 0) {
            TreeNode treeNode = treeNodes.pollLast();
            int num = integers.pollLast().intValue();

            if (treeNode.left == null && treeNode.right == null && num == sum) {
                return true;
            }

            if (treeNode.left != null) {
                treeNodes.addLast(treeNode.left);
                integers.addLast(num+treeNode.left.val);
            }

            if (treeNode.right != null) {
                treeNodes.addLast(treeNode.right);
                integers.addLast(num+treeNode.right.val);
            }
        }
        return false;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

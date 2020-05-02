package BFS;

import TwoPointer.LeetCode234;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class LeetCode102 {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        List<TreeNode> current = new ArrayList<>();
        current.add(root);
        List<TreeNode> next = new ArrayList<>();

        while (true) {
            if (current.size() == 0) {
                break;
            }
            List<Integer> currentInts = new ArrayList<>();
            for (TreeNode treeNode : current) {
                if (treeNode == null) {
                    break;
                }
                currentInts.add(treeNode.val);
                if (treeNode.left != null) {
                    next.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    next.add(treeNode.right);
                }
            }
            result.add(currentInts);
            current.clear();
            current.addAll(next);
            next.clear();
        }
        return result;
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        List<TreeNode> current = new ArrayList<>();
        current.add(root);
        List<TreeNode> next = new ArrayList<>();

        boolean left = true;
        while (true) {
            if (current.size() == 0) {
                break;
            }
            List<Integer> currentInts = new ArrayList<>();


            if(left){
                for (TreeNode treeNode : current) {
                    if (treeNode == null) {
                        return result;
                    }
                    currentInts.add(treeNode.val);

                    if (treeNode.left != null) {
                        next.add(treeNode.left);
                    }

                    if (treeNode.right != null) {
                        next.add(treeNode.right);
                    }

                }

                Collections.reverse(next);
                left = false;
            }else {
                for (TreeNode treeNode : current) {
                    if (treeNode == null) {
                        return result;
                    }
                    currentInts.add(treeNode.val);
                }

                Collections.reverse(current);

                for (TreeNode treeNode : current) {

                    if (treeNode.left != null) {
                        next.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        next.add(treeNode.right);
                    }

                }
            }

            result.add(currentInts);
            current.clear();
            current.addAll(next);
            next.clear();
        }
        return result;

    }


}

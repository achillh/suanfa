package tree;


import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Offer7 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        if (preorder.length == 0||inorder.length==0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, indexMap);

    }

    private TreeNode buildTree(int[] preoreder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> indexMap) {
        TreeNode root = new TreeNode(preoreder[preStart]);
        int index = indexMap.get(root.val);

        int leftLen = index - inStart;
        int rightLen = inEnd - index;

        if (inStart > inEnd) {
            return null;
        } else {
            root.left = buildTree(preoreder, preStart + 1, preStart + leftLen, inorder, inStart, inStart + leftLen - 1, indexMap);
            root.right = buildTree(preoreder, preStart + leftLen + 1, preStart + leftLen + rightLen, inorder, index + 1, index + rightLen,indexMap);
            return root;
        }
    }
}

package com.shubham.dataStructures.tree;

import com.shubham.lcFebChallenge.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromInorderPostorder {

  int postInorder;
  Map<Integer, Integer> inorderMap;

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    inorderMap = new HashMap<>();

    for (int i = 0; i < inorder.length; i++) {
      inorderMap.put(inorder[i], i);
    }

    postInorder = inorder.length - 1;
    return generateTree(postorder, 0, inorder.length - 1);
  }

  private TreeNode generateTree(int[] postOrderTraversal, int start, int end) {

    if (start > end) {
      return null;
    }

    TreeNode node = new TreeNode(postOrderTraversal[postInorder]);
    postInorder--;

    int inorderIndex = inorderMap.get(node.val);

    node.right = generateTree(postOrderTraversal, inorderIndex + 1, end);
    node.left = generateTree(postOrderTraversal, start, inorderIndex - 1);
    return node;

  }
}

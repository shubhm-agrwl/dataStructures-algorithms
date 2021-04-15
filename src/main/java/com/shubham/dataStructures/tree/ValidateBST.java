package com.shubham.dataStructures.tree;

import com.shubham.lcFebChallenge.TreeNode;

public class ValidateBST {

  public boolean isValidBST(TreeNode root) {
    return helper(root, null, null);
  }

  private boolean helper(TreeNode node, Integer minVal, Integer maxVal) {
    if (node == null) {
      return true;
    }

    // Preorder traversal: check if the current node respects the bounds
    if (minVal != null && node.val <= minVal) {
      return false;
    }

    if (maxVal != null && node.val >= maxVal) {
      return false;
    }

    // Traverse left and right children, note that current node applies to min and max bounds based on which
    // child we select
    boolean left = helper(node.left, minVal, node.val);
    boolean right = helper(node.right, node.val, maxVal);
    return left == true && right == true;
  }

}

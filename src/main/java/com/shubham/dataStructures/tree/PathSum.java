package com.shubham.dataStructures.tree;

import com.shubham.lcFebChallenge.TreeNode;

public class PathSum {

  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    targetSum = targetSum - root.val;
    if (targetSum == 0 && root.left == null && root.right == null) {
      return true;
    }
    boolean leftYes = hasPathSum(root.left, targetSum);
    boolean rightYes = hasPathSum(root.right, targetSum);

    return leftYes || rightYes;
  }
}

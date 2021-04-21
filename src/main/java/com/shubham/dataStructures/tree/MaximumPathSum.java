package com.shubham.dataStructures.tree;

import com.shubham.lcFebChallenge.TreeNode;

public class MaximumPathSum {

  int maxSum = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    helper(root); // return value is not important in this function
    return maxSum;
  }

  private int helper(TreeNode node) {
    if (node == null) {
      return 0; // null node contributes nothing to the sum
    }

    // Postorder traversal
    int leftSum = helper(node.left);
    int rightSum = helper(node.right);

    int maxChildSum = Math.max(leftSum, rightSum);

    // We now need to compute three aspects:
    // Case 1: Max path is only the current node
    maxSum = Math.max(node.val, maxSum);
    // Case 2: the path includes node and both of its children
    maxSum = Math.max(node.val + leftSum + rightSum, maxSum);
    // Case 3: Path including Node and only one of the child
    maxSum = Math.max(node.val + maxChildSum, maxSum);

    // The question here is to find max path sum, and not max subtree sum
    // hence we return only a viable path sum to the parent node
    // Depending on the value of the nodes, this can either be the node itself,
    // or sum of the node and max of its children
    return Math.max(node.val, node.val + maxChildSum);
  }
}

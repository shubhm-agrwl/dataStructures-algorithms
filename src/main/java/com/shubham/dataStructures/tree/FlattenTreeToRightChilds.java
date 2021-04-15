package com.shubham.dataStructures.tree;

import com.shubham.lcFebChallenge.TreeNode;

public class FlattenTreeToRightChilds {

  public void flatten(TreeNode root) {
    heperFlatten(root);
  }

  private TreeNode heperFlatten(TreeNode root) {

    // Base Case
    if (root == null) {
      return root;
    }

    // Store right sub tree for current node
    TreeNode rightSubTree = root.right;

    // Attach left sub tree to right side of current node and set left subtree to null for current node
    root.right = heperFlatten(root.left);
    root.left = null;

    // Interate until we reach bottom most node of right subtree
    TreeNode current = root;
    while (current.right != null) {
      current = current.right;
    }

    // attach the storeed right subtree here
    current.right = heperFlatten(rightSubTree);

    return root;
  }

}

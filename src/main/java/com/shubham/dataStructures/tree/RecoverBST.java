package com.shubham.dataStructures.tree;

import com.shubham.lcFebChallenge.TreeNode;

public class RecoverBST {

  TreeNode left = null;
  TreeNode right = null;
  TreeNode last = null;

  public void recoverTree(TreeNode root) {
    dfs(root);
    int temp = left.val;
    left.val = right.val;
    right.val = temp;
  }

  private void dfs(TreeNode root) {
    if (root == null) {
      return;
    }
    dfs(root.left);
    if (last != null && left == null && last.val > root.val) {
      left = last;
    }
    if (last != null && last.val > root.val) {
      right = root;
    }
    last = root;
    dfs(root.right);
  }
}

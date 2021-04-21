package com.shubham.dataStructures.tree;

import com.shubham.lcFebChallenge.TreeNode;

public class SumRootToLeafNums {

  public int sumNumbers(TreeNode root) {

    String n = "";

    return sum(n, root);
  }

  public static int sum(String n, TreeNode root) {
    if (root == null) {
      return 0;
    }

    n += String.valueOf(root.val);

    if (root.left == null && root.right == null) {
      return Integer.parseInt(n);
    }

    return sum(n, root.left) + sum(n, root.right);
  }

}

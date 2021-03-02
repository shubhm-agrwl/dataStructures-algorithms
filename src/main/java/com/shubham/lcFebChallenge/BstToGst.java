package com.shubham.lcFebChallenge;

public class BstToGst {

  public static void main(String[] args) {

  }

  public static TreeNode bstToGst(TreeNode root) {
    int sum = 0; // Initialize sum
    transformTreeUtil(root, sum);
    return root;
  }

  public static void transformTreeUtil(TreeNode root, int sum) {
    if (root == null) {
      return;
    }
    transformTreeUtil(root.right, sum);
    sum = sum + root.val;
    root.val = sum - root.val;
    transformTreeUtil(root.left, sum);
  }
}

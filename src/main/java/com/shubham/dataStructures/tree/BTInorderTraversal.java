package com.shubham.dataStructures.tree;

import com.shubham.lcFebChallenge.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTInorderTraversal {

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    helper(root, res);
    return res;
  }

  public void helper(TreeNode root, List<Integer> res) {
    if (root != null) {
      if (root.left != null) {
        helper(root.left, res);
      }
      res.add(root.val);
      if (root.right != null) {
        helper(root.right, res);
      }
    }
  }

  public List<Integer> inorderTraversalStack(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      res.add(curr.val);
      curr = curr.right;
    }
    return res;
  }

  public List<Integer> inorderTraversalMorris(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    TreeNode curr = root;
    TreeNode pre;
    while (curr != null) {
      if (curr.left == null) {
        res.add(curr.val);
        curr = curr.right; // move to next right node
      } else { // has a left subtree
        pre = curr.left;
        while (pre.right != null) { // find rightmost
          pre = pre.right;
        }
        pre.right = curr; // put cur after the pre node
        TreeNode temp = curr; // store cur node
        curr = curr.left; // move cur to the top of the new tree
        temp.left = null; // original cur left be null, avoid infinite loops
      }
    }
    return res;
  }
}

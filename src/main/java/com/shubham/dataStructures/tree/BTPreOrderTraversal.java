package com.shubham.dataStructures.tree;

import com.shubham.lcFebChallenge.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BTPreOrderTraversal {

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    preorderTraversal(root, list);
    return list;
  }

  public void preorderTraversal(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }

    list.add(root.val);
    preorderTraversal(root.left, list);
    preorderTraversal(root.right, list);
  }

}

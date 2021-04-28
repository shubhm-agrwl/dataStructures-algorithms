package com.shubham.dataStructures.tree;

import com.shubham.lcFebChallenge.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BTPostOrderTraversal {

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    preorderTraversal(root, list);
    return list;
  }

  public void preorderTraversal(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    preorderTraversal(root.left, list);
    preorderTraversal(root.right, list);
    list.add(root.val);

  }

}

package com.shubham.lcAprilChallenge;

import com.shubham.lcFebChallenge.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {

  public int deepestLeavesSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> qu = new LinkedList<>();
    qu.offer(root);
    int sumOfCurrLevel = 0;
    while (!qu.isEmpty()) {
      int size = qu.size();
      sumOfCurrLevel = 0;
      while (size-- > 0) {
        TreeNode head = qu.poll();
        sumOfCurrLevel += head.val;
        if (head.left != null) {
          qu.offer(head.left);
        }
        if (head.right != null) {
          qu.offer(head.right);
        }
      }
    }
    return sumOfCurrLevel;
  }

}

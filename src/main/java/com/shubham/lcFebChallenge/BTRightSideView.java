package com.shubham.lcFebChallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTRightSideView {

  public static void main(String[] args) {

  }

  // BFS
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList();
    Queue<TreeNode> q = new LinkedList();
    q.add(root);

    while (!q.isEmpty() && root != null) {
      result.add(q.peek().val);
      for (int i = q.size(); i > 0; i--) {
        root = q.poll();
        if (root.right != null) {
          q.add(root.right);
        }
        if (root.left != null) {
          q.add(root.left);
        }
      }
    }

    return result;
  }

  // DFS
  public List<Integer> rightSideView2(TreeNode root) {
    List<Integer> list = new ArrayList();
    dfs(root, 0, list);
    return list;
  }

  private void dfs(TreeNode root, int d, List<Integer> list) {
    if(root == null)
      return;
    if(list.size() == d)
      list.add(root.val);
    dfs(root.right, d + 1, list);
    dfs(root.left, d + 1, list);
  }

}

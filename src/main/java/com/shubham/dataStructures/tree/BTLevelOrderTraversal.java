package com.shubham.dataStructures.tree;

import com.shubham.lcFebChallenge.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversal {

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      ArrayList<Integer> currentLevel = new ArrayList<Integer>(levelSize);
      for (int i = 0; i < levelSize; i++) {
        TreeNode currentNode = queue.poll();
        currentLevel.add(currentNode.val);
        if (currentNode.left != null) {
          queue.offer(currentNode.left);
        }
        if (currentNode.right != null) {
          queue.offer(currentNode.right);
        }
      }
      result.add(0, currentLevel);
    }
    return result;
  }

  public List<List<Integer>> levelOrder(TreeNode root) {

    List<List<Integer>> res = new ArrayList<>();
    dfs(root, 1, res);
    return res;

  }

  public void dfs(TreeNode node, int level, List<List<Integer>> res) {
    if (node == null) {
      return;
    }

    if (res.size() < level) {
      res.add(new ArrayList<>());
    }
    List<Integer> levelElems = res.get(level - 1);
    levelElems.add(node.val);

    dfs(node.left, level + 1, res);
    dfs(node.right, level + 1, res);
  }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();

    // Base case
    if (root == null) {
      return result;
    }

    // Perform Breath First Search
    bfs(root, result, new ArrayList<Integer>());
    return result;
  }

  private void bfs(TreeNode root, List<List<Integer>> result, List<Integer> temp) {

    // Create a queue and add root node to queue
    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.offerLast(root);

    // Level
    int level = 0;

    // While we have elements in queue perform th following
    while (!queue.isEmpty()) {

      // Get the size of queue, this will tell the number of nodes in the current level of the tree
      int size = queue.size();

      // For each node in the current level of the tree add left and right child if they are not null
      for (int i = 1; i <= size; ++i) {
        TreeNode current = queue.pollFirst();
        if (current.left != null) {
          queue.offerLast(current.left);
        }

        if (current.right != null) {
          queue.offerLast(current.right);
        }

        // Add node of current level to a temporary list
        if (level % 2 == 1) { // For odd level add nodes at start
          temp.add(0, current.val);
        } else { // For even level add nodes at end
          temp.add(current.val);
        }
      }

      // add all the nodes of current level to their own list
      result.add(new ArrayList<Integer>(temp));

      // clear temporary list for next level nodes to be stored
      temp.clear();

      ++level;
    }
  }

}

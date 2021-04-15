package com.shubham.dataStructures.tree;

import com.shubham.lcFebChallenge.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class PathSum {

  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    targetSum = targetSum - root.val;
    if (targetSum == 0 && root.left == null && root.right == null) {
      return true;
    }
    boolean leftYes = hasPathSum(root.left, targetSum);
    boolean rightYes = hasPathSum(root.right, targetSum);

    return leftYes || rightYes;
  }

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> result = new ArrayList<>();
    helperPathSum(root, targetSum, result, new ArrayList<Integer>());
    return result;
  }

  private void helperPathSum(TreeNode root, int targetSum, List<List<Integer>> result,
      List<Integer> temp) {

    // Base Case
    if (root == null) {
      return;
    }

    // Leaf node found
    if (root.left == null && root.right == null) {

      // If remaining sum is 0 we found a path
      if (targetSum - root.val == 0) {
        // Add the current val to temporary list and then store the temporary list in main result
        temp.add(root.val);
        result.add(new ArrayList<Integer>(temp));
        // remove the last added node from temporary list
        temp.remove(temp.size() - 1);
      }
      return;
    }

    // add the current node val to temporary list and recursively make calls on left and right sub tree reducing the target value
    temp.add(root.val);
    helperPathSum(root.left, targetSum - root.val, result, temp);
    helperPathSum(root.right, targetSum - root.val, result, temp);
    temp.remove(temp.size() - 1);

  }
}

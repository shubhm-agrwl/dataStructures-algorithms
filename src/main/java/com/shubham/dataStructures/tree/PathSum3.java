package com.shubham.dataStructures.tree;

import com.shubham.lcFebChallenge.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class PathSum3 {

  Map<Integer, Integer> cumulativeSumMap = new HashMap<>();
  int count = 0;
  int targetSum;

  public int pathSum(TreeNode root, int sum) {
    targetSum = sum;
    preorder(root, 0);
    return count;
  }

  public void preorder(TreeNode node, int cumulativeSum) {
    if (node == null) {
      return;
    }

    cumulativeSum = cumulativeSum + node.val;
    if (cumulativeSum == targetSum) {
      count++;
    }

    int prefixSum = cumulativeSum - targetSum;

    if (cumulativeSumMap.containsKey(prefixSum)) {
      count = count + cumulativeSumMap.get(prefixSum);
    }
    cumulativeSumMap.put(cumulativeSum, cumulativeSumMap.getOrDefault(cumulativeSum, 0) + 1);

    preorder(node.left, cumulativeSum);
    preorder(node.right, cumulativeSum);

    // on backtracking, let's remove the hashmap counts so those are not considered for the other subtrees
    cumulativeSumMap.put(cumulativeSum, cumulativeSumMap.get(cumulativeSum) - 1);
  }

}

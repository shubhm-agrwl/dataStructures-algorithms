package com.shubham.dataStructures.tree;

import com.shubham.lcFebChallenge.TreeNode;

public class SortedToBST {

  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null) {
      return null;
    }
    return bst(0, nums.length - 1, nums);
  }

  public TreeNode bst(int start, int end, int[] nums) {
    if (start > end) {
      return null;
    }

    int mid = (start + end) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = bst(start, mid - 1, nums);
    root.right = bst(mid + 1, end, nums);

    return root;
  }

}

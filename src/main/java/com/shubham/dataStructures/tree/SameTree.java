package com.shubham.dataStructures.tree;

public class SameTree {

  public boolean isSameTree(Node p, Node q) {
    if (p == null && q == null) {
      return true;
    }
    // one of p and q is null
    if (q == null || p == null) {
      return false;
    }
    if (p.data != q.data) {
      return false;
    }
    return isSameTree(p.right, q.right) &&
        isSameTree(p.left, q.left);
  }

}

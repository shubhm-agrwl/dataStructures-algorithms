package com.shubham.dataStructures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaryPreorderTraversal {

  List<Integer> list;

  public List<Integer> preorder(Node root) {
    list = new ArrayList();
    Solve(root);
    return list;
  }

  public void Solve(Node root) {
    if (root == null) {
      return;
    }
//    list.add(root.val);
//    for (Node node : root.children) {
//      Solve(node);
//    }
  }

  public List<Integer> preorderStack(Node root) {
    Stack<Node> stack = new Stack();
    List<Integer> list = new ArrayList();
    if (root == null) {
      return list;
    }
    stack.push(root);
    while (!stack.isEmpty()) {
      Node node = stack.pop();
      if (node != null) {
//        list.add(node.val);
//        for (int i = node.children.size() - 1; i >= 0; i--) {
//          stack.push(node.children.get(i));
//        }
      }
    }
    return list;
  }

}

class NodeNary {

  public int val;
  public List<Node> children;

  public NodeNary() {
  }

  public NodeNary(int _val) {
    val = _val;
  }

  public NodeNary(int _val, List<Node> _children) {
    val = _val;
    children = _children;
  }
}

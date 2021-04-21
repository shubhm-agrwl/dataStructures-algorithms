package com.shubham.dataStructures.tree;

import java.util.ArrayList;
import java.util.List;

public class CloneGraph {

//  public Node dfs(NodeCloneGraph node, HashMap<Integer, NodeCloneGraph> map) {
//    if (map.containsKey(node.val)) {
//      return null;
//    }
//    NodeCloneGraph newNode = new NodeCloneGraph(node.val);
//    map.put(node.val, newNode);
//
//    for (NodeCloneGraph child : node.neighbors) {
//      if (map.containsKey(child.val)) {
//        newNode.neighbors.add(map.get(child.val));
//      } else {
//        newNode.neighbors.add(dfs(child, map));
//      }
//    }
//    return newNode;
//  }

//  public Node cloneGraph(NodeCloneGraph node) {
//    if (node == null) {
//      return null;
//    }
//    HashMap<Integer, NodeCloneGraph> map = new HashMap<>();
//    return dfs(node, map);
//  }


}

class NodeCloneGraph {

  public int val;
  public List<NodeCloneGraph> neighbors;

  public NodeCloneGraph() {
    val = 0;
    neighbors = new ArrayList<NodeCloneGraph>();
  }

  public NodeCloneGraph(int _val) {
    val = _val;
    neighbors = new ArrayList<NodeCloneGraph>();
  }

  public NodeCloneGraph(int _val, ArrayList<NodeCloneGraph> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
}
package com.shubham.dataStructures.linkedList;

public class CopyListWithRandomPointer {

  public RandomListNode copyRandomList(RandomListNode head) {

    // duplicate copy each node and stitch it to the next of original node
    RandomListNode curr = head;
    while (curr != null) {
      RandomListNode newNode = new RandomListNode(curr.val);
      newNode.next = curr.next;
      curr.next = newNode;
      curr = curr.next.next;
    }

    // attach random pointers to duplicated nodes
    curr = head;
    while (curr != null) {
      if (curr.random != null) {
        curr.next.random = curr.random.next;
      }
      curr = curr.next.next;
    }

    // sentinel/dummy node for new list
    RandomListNode sentinel = new RandomListNode(0);
    RandomListNode deepCopyListPrev = sentinel;

    // detach duplicate nodes and return as a new list
    curr = head;
    while (curr != null) {
      deepCopyListPrev.next = curr.next;      // attach to new list
      curr.next = curr.next.next; // detach

      deepCopyListPrev = deepCopyListPrev.next;
      curr = curr.next;
    }

    return sentinel.next;

  }
}

class RandomListNode {

  int val;
  RandomListNode next;
  RandomListNode random;

  public RandomListNode(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }
}

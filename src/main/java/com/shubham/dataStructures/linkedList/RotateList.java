package com.shubham.dataStructures.linkedList;

public class RotateList {

  public ListNode rotateRight(ListNode head, int k) {

    if (head == null) {
      return head;
    }
    int len = 0;
    ListNode tmp = head, tail = null;
    while (tmp != null) {
      len++;
      tail = tmp;
      tmp = tmp.next;
    }
    tail.next = head; //make a circle
    int step = len - Math.min(k, k % len);
    while (step-- > 0) {
      tail = head;
      head = head.next;
    }
    tail.next = null;
    return head;
  }

}

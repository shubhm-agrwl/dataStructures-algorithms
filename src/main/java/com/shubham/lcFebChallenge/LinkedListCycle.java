package com.shubham.lcFebChallenge;

public class LinkedListCycle {

  public static void main(String[] args) {

  }

  public boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }

    return false;
  }

  public ListNode detectCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        while (head != null) {
          if (head == fast) { //this condition will help us to fin the node at which it meets.
            return head; // return the node.
          }
          head = head.next;//moving the head node
          fast = fast.next;//moving the fast node
        }
      }
    }

    return null;
  }

}

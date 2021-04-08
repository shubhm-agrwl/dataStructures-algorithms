package com.shubham.lcAprilChallenge;

import com.shubham.dataStructures.linkedList.ListNode;

public class PalindromeLinkedList {

  public boolean isPalindrome(ListNode head) {

    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    if (fast != null) {
      slow = slow.next;
    }

    ListNode reverseSecHalf = reverseList(slow);

    while (reverseSecHalf != null && head.val == reverseSecHalf.val) {
      reverseSecHalf = reverseSecHalf.next;
      head = head.next;
    }

    return reverseSecHalf == null;
  }

  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
  }
}

package com.shubham.dataStructures.linkedList;

public class ReorderList {

  public void reorderList(ListNode head) {
    // check for base cases
    if (head == null || head.next == null) {
      return;
    }

    // reach the mid of the linked list
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // reverse the second part of the linked list
    ListNode reversedHead = reverse(slow.next);
    slow.next = null;

    // Now we have the first half and second Half
    // merge both the halves one by one
    ListNode temp = head;
    while (temp != null && reversedHead != null) {
      ListNode next = temp.next;
      temp.next = reversedHead;
      reversedHead = reversedHead.next;
      temp.next.next = next;
      temp = next;
    }
  }

  // utility function to reverse the list
  private ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode reverseHead = reverse(head.next);
    ListNode temp = head.next;
    head.next = null;
    temp.next = head;
    return reverseHead;
  }

}

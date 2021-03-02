package com.shubham.dataStructures.linkedList;

public class RemoveDuplicatesSortedList {

  public ListNode deleteDuplicates(ListNode head) {

    if (head == null) {
      return head;
    }
    ListNode pointer1 = head;
    ListNode pointer2 = pointer1;

    while ((pointer1.next != null)) {
      while (pointer1.val == pointer1.next.val) {
        pointer1.next = pointer1.next.next;
        if (pointer1.next == null) {
          break;
        }
      }
      pointer1 = pointer1.next;
      if (pointer1 == null) {
        break;
      }
    }
    return pointer2;

  }

  public ListNode deleteDuplicates2(ListNode head) {
    ListNode current = head;
    while (current != null && current.next != null) {
      if (current.next.val == current.val) {
        current.next = current.next.next;
      } else {
        current = current.next;
      }
    }
    return head;
  }

}

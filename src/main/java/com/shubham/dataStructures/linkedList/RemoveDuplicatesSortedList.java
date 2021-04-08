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
        current = current.next.next;
      } else {
        current = current.next;
      }
    }
    return head;
  }

  public ListNode deleteDuplicatesAll(ListNode head) {
    ListNode sentinel = new ListNode(0);

    // predecessor = the last node
    // before the sublist of duplicates
    ListNode pred = sentinel;

    while (head != null) {
      // if it's a beginning of duplicates sublist
      // skip all duplicates
      if (head.next != null && head.val == head.next.val) {
        // move till the end of duplicates sublist
        while (head.next != null && head.val == head.next.val) {
          head = head.next;
        }
        // skip all duplicates
        pred.next = head.next;
        // otherwise, move predecessor
      } else {
        pred = pred.next;
      }

      // move forward
      head = head.next;
    }
    return sentinel.next;
  }


}

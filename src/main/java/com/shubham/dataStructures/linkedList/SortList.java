package com.shubham.dataStructures.linkedList;

public class SortList {

  // Insertion Sort
  public ListNode insertionSortList(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode curr = head;
    ListNode p = dummy;

    while (curr != null) {
      if (curr.next != null && (curr.next.val < curr.val)) {
        while (p.next != null && p.next.val < curr.next.val) {
          p = p.next;
        }

        ListNode t = p.next;
        p.next = curr.next;

        curr.next = curr.next.next;
        p.next.next = t;
        p = dummy;
      } else {
        curr = curr.next;
      }
    }

    return dummy.next;
  }

  // Merge Sort
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode mid = getMid(head);
    ListNode left = sortList(head);
    ListNode right = sortList(mid);
    return merge(left, right);
  }

  ListNode merge(ListNode list1, ListNode list2) {
    ListNode dummyHead = new ListNode(0);
    ListNode tail = dummyHead;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        tail.next = list1;
        list1 = list1.next;
        tail = tail.next;
      } else {
        tail.next = list2;
        list2 = list2.next;
        tail = tail.next;
      }
    }
    tail.next = (list1 != null) ? list1 : list2;
    return dummyHead.next;
  }

  ListNode getMid(ListNode head) {
    ListNode midPrev = null;
    while (head != null && head.next != null) {
      midPrev = (midPrev == null) ? head : midPrev.next;
      head = head.next.next;
    }
    ListNode mid = midPrev.next;
    midPrev.next = null;
    return mid;
  }

}

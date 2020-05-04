package com.shubham.dataStructures.linkedList;

public class RemoveNthFromEnd {

  /*
   * Given a linked list, remove the n-th node from the end of list and return its head.
   * 
   * Example:
   * 
   * Given linked list: 1->2->3->4->5, and n = 2.
   * 
   * After removing the second node from the end, the linked list becomes 1->2->3->5.
   * 
   * Note:
   * 
   * Given n will always be valid.
   * 
   * Follow up:
   * 
   * Could you do this in one pass?
   * 
   */

  public static void main(String[] args) {
    ListNode first = new ListNode(1);
    ListNode second = new ListNode(2);
    ListNode third = new ListNode(3);
    ListNode four = new ListNode(4);
    ListNode five = new ListNode(5);
    ListNode curr = first;
    curr.next = second; // Link first node with the second node
    second.next = third;
    third.next = four;
    four.next = five;

    while (curr != null) {
      System.out.println(curr.val);
      curr = curr.next;
    }

    curr = first;
    curr.next = second; // Link first node with the second node
    second.next = third;
    third.next = four;
    four.next = five;

    ListNode res2Pass = removeNthFromEnd2Pass(curr, 2);

    curr = first;
    curr.next = second; // Link first node with the second node
    second.next = third;
    third.next = four;
    four.next = five;

    ListNode res1Pass = removeNthFromEnd1Pass(curr, 2);

    while (res2Pass != null) {
      System.out.println(res2Pass.val);
      res2Pass = res2Pass.next;
    }

    while (res1Pass != null) {
      System.out.println(res1Pass.val);
      res1Pass = res1Pass.next;
    }
  }

  public static void RemoveNthFromEndMain() {

  }

  private static ListNode removeNthFromEnd1Pass(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;
    ListNode second = dummy;
    // Advances first pointer so that the gap between first and second is n nodes apart
    for (int i = 1; i <= n + 1; i++) {
      first = first.next;
    }
    // Move first to the end, maintaining the gap
    while (first != null) {
      first = first.next;
      second = second.next;
    }
    second.next = second.next.next;
    return dummy.next;
  }

  private static ListNode removeNthFromEnd2Pass(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    int length = 0;
    ListNode first = head;
    while (first != null) {
      length++;
      first = first.next;
    }
    length -= n;
    first = dummy;
    while (length > 0) {
      length--;
      first = first.next;
    }
    first.next = first.next.next;
    return dummy.next;
  }

}

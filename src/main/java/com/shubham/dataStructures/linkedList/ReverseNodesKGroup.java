package com.shubham.dataStructures.linkedList;

public class ReverseNodesKGroup {

  /*
   * Given a linked list, reverse the nodes of a linked list k at a time and return its modified
   * list.
   *
   * k is a positive integer and is less than or equal to the length of the linked list. If the
   * number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
   *
   * Example:
   *
   * Given this linked list: 1->2->3->4->5
   *
   * For k = 2, you should return: 2->1->4->3->5
   *
   * For k = 3, you should return: 3->2->1->4->5
   *
   * Note:
   *
   * Only constant extra memory is allowed. You may not alter the values in the list's nodes, only
   * nodes itself may be changed.
   *
   *
   */

  public static void main(String[] args) {
    ListNode first = new ListNode(1);
    ListNode second = new ListNode(2);
    ListNode third = new ListNode(3);
    ListNode four = new ListNode(4);
    ListNode five = new ListNode(5);
    ListNode l1 = first;
    l1.next = second; // Link first node with the second node
    second.next = third;
    third.next = four;
    four.next = five;

    ListNode res = reverseKGroup(l1, 3);

    while (res != null) {
      System.out.println(res.val);
      res = res.next;
    }
  }

  private static ListNode reverseKGroup(ListNode head, int k) {
    ListNode current = head;
    ListNode next = null;
    ListNode prev = null;

    ListNode check = head;
    int checkCount = 0;

    while (checkCount < k) {
      if (check != null) {
        check = check.next;
      } else {
        return head;
      }
      checkCount++;
    }

    int count = 0;

    /* Reverse first k nodes of linked list */
    while (count < k && current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
      count++;
    }

    /*
     * next is now a pointer to (k+1)th node Recursively call for the list starting from current.
     * And make rest of the list as next of first node
     */

    if (next != null) {
      head.next = reverseKGroup(next, k);
    }

    // prev is now head of input list
    return prev;
  }

}

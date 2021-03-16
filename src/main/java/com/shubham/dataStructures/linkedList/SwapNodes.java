package com.shubham.dataStructures.linkedList;

public class SwapNodes {

  /*
   * Given a linked list, swap every two adjacent nodes and return its head.
   *
   * You may not modify the values in the list's nodes, only nodes itself may be changed.
   *
   * Example:
   *
   * Given 1->2->3->4, you should return the list as 2->1->4->3.
   *
   */

  public static void main(String[] args) {
    ListNode first = new ListNode(1);
    ListNode second = new ListNode(2);
    ListNode third = new ListNode(3);
    ListNode four = new ListNode(4);
    ListNode l1 = first;
    l1.next = second; // Link first node with the second node
    second.next = third;
    third.next = four;

    ListNode res = swapPairs(l1);

    while (res != null) {
      System.out.println(res.val);
      res = res.next;
    }
  }

  private static ListNode swapPairs(ListNode head) {

    ListNode temp = head;

    /* Traverse only till there are atleast 2 nodes left */
    while (temp != null && temp.next != null) {

      /* Swap the data */
      int k = temp.val;
      temp.val = temp.next.val;
      temp.next.val = k;
      temp = temp.next.next;
    }
    return head;
  }

  public ListNode swapNodes(ListNode head, int k) {
    k = k - 1;
    ListNode firstN = head;
    while (k > 0) {
      firstN = firstN.next;
      k--;
    }

    ListNode f = firstN;
    ListNode secondN = head;
    while (f.next != null) {
      secondN = secondN.next;
      f = f.next;
    }

    int temp = firstN.val;
    firstN.val = secondN.val;
    secondN.val = temp;

    return head;

  }

}

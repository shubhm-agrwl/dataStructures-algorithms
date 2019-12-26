package com.shubham.dataStructures.linkedList;

public class Merge2SortedLL {

  /*
   * Merge two sorted linked lists and return it as a new list. The new list should be made by
   * splicing together the nodes of the first two lists.
   * 
   * Example:
   * 
   * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
   * 
   */

  public static void Merge2SortedLLMain() {
    ListNode first = new ListNode(1);
    ListNode second = new ListNode(2);
    ListNode third = new ListNode(4);
    ListNode l1 = first;
    l1.next = second; // Link first node with the second node
    second.next = third;

    ListNode f2 = new ListNode(1);
    ListNode s2 = new ListNode(3);
    ListNode t2 = new ListNode(4);
    ListNode l2 = f2;
    l2.next = s2; // Link first node with the second node
    s2.next = t2;

    ListNode res = mergeTwoLists(l1, l2);

    while (res != null) {
      System.out.println(res.val);
      res = res.next;
    }
  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    ListNode dummyNode = new ListNode(0);
    ListNode tail = dummyNode;

    while (true) {
      if (l1 == null) {
        tail.next = l2;
        break;
      }
      if (l2 == null) {
        tail.next = l1;
        break;
      }
      if (l1.val > l2.val) {
        tail.next = l2;
        l2 = l2.next;
      } else {
        tail.next = l1;
        l1 = l1.next;
      }
      tail = tail.next;
    }
    return dummyNode.next;
  }
}

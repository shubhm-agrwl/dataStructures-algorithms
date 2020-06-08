package com.shubham.dataStructures.linkedList;

  /*
  Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

  You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

  Example 1:

  Input: 1->2->3->4->5->NULL
  Output: 1->3->5->2->4->NULL

  Example 2:

  Input: 2->1->3->5->6->4->7->NULL
  Output: 2->3->6->7->1->5->4->NULL

  Note:

      The relative order inside both the even and odd groups should remain as it was in the input.
      The first node is considered odd, the second node even and so on ...
 */

public class OddEvenLinkedList {

  public static void main(String[] args) {
    ListNode first = new ListNode(1);
    ListNode second = new ListNode(2);
    ListNode third = new ListNode(3);
    ListNode four = new ListNode(4);
    ListNode l1 = first;
    l1.next = second; // Link first node with the second node
    second.next = third;
    third.next = four;

    ListNode res = oddEvenList(l1);

    while (res != null) {
      System.out.println(res.val);
      res = res.next;
    }
  }

  private static ListNode oddEvenList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode odd = head, even = head.next, evenHead = even;
    while (even != null && even.next != null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
      even = even.next;
    }
    odd.next = evenHead;
    return head;
  }

}

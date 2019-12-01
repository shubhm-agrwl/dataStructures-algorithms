package com.shubham.dataStructuresAlgorithms;

public class AddTwoNumbersSLL {

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode p = l1;
    ListNode q = l2;
    ListNode curr = head;
    int carry = 0;

    while ((p != null) || (q != null)) {
      int x = (p != null) ? p.val : 0;
      int y = (q != null) ? q.val : 0;
      int sum = carry + x + y;
      carry = sum / 10;
      curr.next = new ListNode(sum % 10);
      curr = curr.next;
      if (p != null)
        p = p.next;
      if (q != null)
        q = q.next;
    }

    if (carry > 0) {
      curr.next = new ListNode(carry);
    }

    return head.next;
  }

  public static void addTwoNumbersMain() {
    
    /*
     * 
     * Problem 2: You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a single digit. Add
     * the two numbers and return it as a linked list.
     * 
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * 
     * Example:
     * 
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 + 465 = 807.
     */
    
    /*
     * ListNode first = new ListNode(2); ListNode second = new ListNode(4); ListNode third = new
     * ListNode(3);
     * 
     * ListNode curr = first; curr.next = second; // Link first node with the second node
     * second.next = third; // Link second node with the third node
     * 
     * ListNode first2 = new ListNode(5); ListNode second2 = new ListNode(6); ListNode third2 = new
     * ListNode(4);
     * 
     * ListNode curr2 = first2; curr2.next = second2; // Link first node with the second node
     * second2.next = third2; // Link second node with the third node
     * 
     * ListNode res = AddTwoNumbersSLL.addTwoNumbers(curr, curr2);
     * 
     * while (res != null) { System.out.print(res.val + " "); res = res.next; }
     */

  }
}

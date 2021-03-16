package com.shubham.lcMarChallenge;

public class IntersectionLinkedLists {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode pA = headA;
    ListNode pB = headB;
    while (pA != pB) {
      pA = pA == null ? headB : pA.next;
      pB = pB == null ? headA : pB.next;
    }
    return pA;
  }
}

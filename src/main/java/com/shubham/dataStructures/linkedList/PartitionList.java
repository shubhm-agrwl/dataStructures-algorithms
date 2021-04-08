package com.shubham.dataStructures.linkedList;

public class PartitionList {

  public ListNode partition(ListNode head, int x) {

    ListNode nodesAfterX = new ListNode(0);
    ListNode nodesAfterXOrig = nodesAfterX;
    ListNode orig = head;
    int flag = 0;
    while (head != null) {
      if (head.val == x) {
        flag = 1;
      }
      if (flag == 1) {
        if (head.val > x) {
          nodesAfterX.next = new ListNode(head.val);
          nodesAfterX = nodesAfterX.next;
        }
      }
      head = head.next;
    }

    ListNode secondIter = orig;
    nodesAfterXOrig = nodesAfterXOrig.next;
    ListNode res = new ListNode(0);
    ListNode ans = res;
    while (secondIter != null) {
      if (nodesAfterXOrig != null && secondIter.val >= nodesAfterXOrig.val) {
        res.next = new ListNode(nodesAfterXOrig.val);
        nodesAfterXOrig = nodesAfterXOrig.next;
      } else {
        res.next = new ListNode(secondIter.val);
        secondIter = secondIter.next;
      }
      res = res.next;
    }
    return ans.next;
  }

  public ListNode partitionWorking(ListNode head, int x) {

    ListNode beforePartition = new ListNode(0);
    ListNode before = beforePartition;
    ListNode afterPartition = new ListNode(0);
    ListNode after = afterPartition;

    while (head != null) {
      if (head.val >= x) {
        afterPartition.next = head;
        afterPartition = afterPartition.next;
      } else {
        beforePartition.next = head;
        beforePartition = beforePartition.next;
      }
      head = head.next;
    }
    afterPartition.next = null;
    beforePartition.next = after.next;
    return before.next;

  }

}

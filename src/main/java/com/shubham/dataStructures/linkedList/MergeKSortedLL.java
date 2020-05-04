package com.shubham.dataStructures.linkedList;

public class MergeKSortedLL {

  /*
   * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its
   * complexity.
   *
   * Example:
   *
   * Input: [ 1->4->5, 1->3->4, 2->6 ] Output: 1->1->2->3->4->4->5->6
   *
   *
   */

  public static void main(String[] args) {
    ListNode first = new ListNode(1);
    ListNode second = new ListNode(4);
    ListNode third = new ListNode(5);
    ListNode l1 = first;
    l1.next = second; // Link first node with the second node
    second.next = third;

    ListNode f2 = new ListNode(1);
    ListNode s2 = new ListNode(3);
    ListNode t2 = new ListNode(4);
    ListNode l2 = f2;
    l2.next = s2; // Link first node with the second node
    s2.next = t2;

    ListNode[] lists = {l1, l2};

    ListNode res = mergeKLists(lists);
    while (res != null) {
      System.out.println(res.val);
      res = res.next;
    }
  }

  private static ListNode mergeKLists(ListNode[] lists) {
    int last = lists.length - 1;
    if (last < 0) {
      return null;
    }
    while (last != 0) {
      int i = 0, j = last;

      // (i, j) forms a pair
      while (i < j) {
        // merge List i with List j and store
        // merged list in List i
        lists[i] = Merge2SortedLL.mergeTwoLists(lists[i], lists[j]);

        // consider next pair
        i++;
        j--;

        // If all pairs are merged, update last
        if (i >= j) {
          last = j;
        }
      }
    }

    return lists[0];
  }

}

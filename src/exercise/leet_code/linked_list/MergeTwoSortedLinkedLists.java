package exercise.leet_code.linked_list;

public class MergeTwoSortedLinkedLists {
    public static void main(String[] args) {

    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode merge = null;
        ListNode pm = null;
        ListNode next1 = null;
        ListNode next2 = null;

        while (true) {
            if (p1 != null) {
                next1 = p1.next;
                p1.next = null;
            }

            if (p2 != null) {
                next2 = p2.next;
                p2.next = null;
            }

            if (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
                    if (merge == null) {
                        merge = p1;
                        pm = p1;
                    }

                    pm.next = p1;  // set the new val
                    pm = p1;  // change pointer to new val
                    p1 = next1;  // iterate p1
                    p2.next = next2;  // reconnect next again
                } else {
                    if (merge == null) {
                        merge = p2;
                        pm = p2;
                    }

                    pm.next = p2;
                    pm = p2;
                    p2 = next2;
                    p1.next = next1;
                }
            } else if (p1 == null) {
                p2.next = next2;  // reconnect the next chain
                pm.next = p2;  // set the remaining linked list
                return merge;  // 1 of 2 places code will exit
            } else {
                p1.next = next1;
                pm.next = p1;
                return merge;
            }
        }
    }
}

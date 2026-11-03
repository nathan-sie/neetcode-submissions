/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeRange(lists, 0, lists.length - 1);
    }
    private ListNode mergeTwo(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (a != null && b != null) {
            // 比较 a.val 和 b.val
            // 把较小的节点接到 tail 后面
            // 移动被选中的指针
            // 移动 tail
            if (a.val < b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        if (a == null) {
            tail.next = b;
        } else {
            tail.next = a;
        }

        // 一条用完后，把另一条剩余部分直接接上

        return dummy.next;
    }
    private ListNode mergeRange(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        }

        if (left == right) {
            return lists[left];
        }

        int mid = left + (right - left) / 2;

        ListNode a = mergeRange(lists, left, mid);
        ListNode b = mergeRange(lists, mid + 1, right);

        return mergeTwo(a,b); // 用刚才写好的方法合并 a、b
    }
}

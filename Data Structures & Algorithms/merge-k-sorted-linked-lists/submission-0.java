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
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode l : lists) {
            if (l != null) {
                heap.offer(l);
            }
        }
        while (!heap.isEmpty()) {
            ListNode node = heap.poll(); // 取出当前最小节点
            tail.next = node;
            tail = tail.next;
            if(node.next != null){
                heap.offer(node.next);
            }
            // 1. 将 node 接到 tail 后面
            // 2. 让 tail 移到刚接上的节点
            // 3. 如果 node.next 不为空，将它放入堆
        }

        return dummy.next;
    }
}

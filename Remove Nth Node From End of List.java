/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p=head,q=head;
        int index = 0;
        while(index<n){
            q = q.next;
            index++;
        }
        if(q==null)
            return head.next;
        while(true){
            if(q.next==null){
                p.next = p.next.next;
                break;
            }
            else{
                p = p.next;
                q = q.next;
            }
        }
        return head;
    }
}

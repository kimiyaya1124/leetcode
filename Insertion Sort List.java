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
    public ListNode insertionSortList(ListNode head) {
        if((head == null) || (head.next==null))
            return head;
            
        ListNode p,q,h,prep,t=head;
        p = head;
        q = head.next;
        
        h = head;
        h.next = null;
        
        while(q!=null){
            p = h;
            prep = null;
            while(p!=null){
                if(p.val>q.val){
                    t = q.next;
                    if(prep==null){
                        q.next = p;
                        h = q;
                    }
                    else{
                        prep.next = q;
                        q.next = p;
                    }
                    break;
                }
                else{
                    prep = p;
                    p = p.next;
                }
            }
            if(p == null){
                t = q.next;
                prep.next = q;
                q.next = p;
            }
            q = t;
        }
        return h;
    }
}

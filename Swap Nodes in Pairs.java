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
    public ListNode swapPairs(ListNode head) {
        if( (head == null) || (head.next == null))
            return head;
        
        int period = 2,index = 1;
        
        ListNode preq = head,q=head,nextq = head.next;
        ListNode lasttail = head,thishead = head;
        while(true){
            preq = q;
            q = nextq;
            nextq = q.next;
            q.next = preq;
            index++;
            if(index==period)
                break;
        }
        ListNode h = q;
        
        index = 1;
        while(true){
            if(nextq == null){
                lasttail.next = null;
                break;
            }
            
            q = nextq;
            thishead = q;
            preq = q;
            nextq = q.next;
            while(index % period != 0){
                q = nextq;
                if(q == null)
                    break;
                index++;
                nextq = q.next;
                q.next = preq;
                preq = q;
            }
            if(q == null){
                lasttail.next = thishead;
                break;
            }
            else
                index = 1;
            
            lasttail.next = preq;
            lasttail = thishead;
        }
        return h;
    }
}

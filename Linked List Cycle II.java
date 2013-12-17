/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if( (head==null) || (head.next==null) )
            return null;
        
        ListNode pfast = head,pslow = head;
        while(true){
            pfast = pfast.next.next;
            pslow = pslow.next;
            
            if(pslow == null)
                return null;
            if( (pfast == null) || (pfast.next == null) )
                return null;
            if(pslow == pfast){
                break;
            }
        }
        
        pfast = head;
        if(pfast == pslow)
            return pslow;
            
        while(true){
            pslow = pslow.next;
            pfast = pfast.next;
            if(pslow == pfast)
                return pslow;
        }
    }
}

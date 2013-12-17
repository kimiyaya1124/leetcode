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
    public void reorderList(ListNode head) {
        if((head==null) || (head.next==null))
            return;
            
        ListNode pfast,pslow,prep,p,q;
        pfast = head;
        pslow = head;
        while( (pfast.next!=null) && (pfast.next.next!=null) ){
            pfast = pfast.next.next;
            pslow = pslow.next;
        }
        
        pfast = pslow;
        pslow = pslow.next;
        ListNode tail = pslow;
        pfast.next = null;
        
        //reverse
        if(pslow.next!=null){
            p = pslow.next;
            prep = pslow;
            while(true){
                if(p.next == null){
                    p.next = prep;
                    break;
                }
                else{
                    ListNode t = p.next;
                    p.next = prep;
                    prep = p;
                    p = t;
                }
            }
            tail = p;
            pslow.next = null;
        }
        
        pslow = head;
        pfast = tail;
        while(true){
            p = pslow.next;
            q = pfast.next;
            
            pslow.next = pfast;
            pfast.next = p;
            
            if(p==null){
                break;
            }
            else{
                if(q==null){
                    p.next = q;
                    break;
                }
                else{
                    pslow = p;
                    pfast = q;
                }
            }
        }
        
    }
}

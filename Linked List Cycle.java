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
    public boolean hasCycle(ListNode head) {
        if((head==null) || (head.next==null)){
            return false;
        }
        
        ListNode pslow = head, pfast = head;
        while(true){
            pfast = pfast.next.next;
            pslow = pslow.next;
            
            if((pfast == null) || (pfast.next==null))
                return false;
            if(pslow==null)
                return false;
            
            if(pfast==pslow)
                return true;
        }
    }
}

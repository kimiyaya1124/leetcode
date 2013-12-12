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
    public ListNode sortList(ListNode head) {
        ListNode p = head;
        if(p==null)
            return p;
        else if(p.next == null)
            return p;
            
        ListNode pfast = head,pslow = head;
        while ( (pfast.next!=null) && (pfast.next.next!=null) ){
            pfast = pfast.next.next;
            pslow = pslow.next;
        }
        pfast = pslow;
        pslow = pslow.next;
        pfast.next = null;
        pfast = sortList(head);
        pslow = sortList(pslow);
        return merge(pfast,pslow);
    }
    
    public ListNode merge(ListNode h1, ListNode h2){
        if(h1==null) return h2;
        if(h2==null) return h1;
        
        ListNode res,p;
        if(h1.val < h2.val){
            res = h1;
            h1 = h1.next;
        }
        else{
            res = h2;
            h2 = h2.next;
        }
        p = res;
        
        while((h1!=null) && (h2!=null)){
            if(h1.val < h2.val){
                p.next = h1;
                h1 = h1.next;
            }
            else{
                p.next = h2;
                h2 = h2.next;
            }
            p = p.next;
        }
        if(h1!=null)
            p.next = h1;
        else if(h2!=null)
            p.next = h2;
        return res;
    }
}

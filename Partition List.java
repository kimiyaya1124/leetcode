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
    public ListNode partition(ListNode head, int x) {
        if((head==null) || (head.next==null))
            return head;
        
        ListNode h1 = null,t1 = null, h2 = null, t2 = null, p = head;
        while(p!=null){
            if(p.val < x){
                if(h1==null){
                    h1 = p;
                    t1 = p;
                }
                else{
                    t1.next = p;
                    t1 = t1.next;
                }
                p = p.next;
            }
            else{
                if(h2==null){
                    h2 = p;
                    t2 = p;
                }
                else{
                    t2.next = p;
                    t2 = t2.next;
                }
                p = p.next;
            }
        }
        if(t1==null){
            t2.next = null;
            return h2;
        }
        else{
            t1.next = h2;
            if(t2!=null)
                t2.next = null;
            return h1;
        }
    }
}

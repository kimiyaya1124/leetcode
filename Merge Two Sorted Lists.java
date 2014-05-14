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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        
        ListNode h = new ListNode(1);
        ListNode head = h;
        while((l1!=null) && (l2!=null)){
            if(l1.val<l2.val){
                h.next = l1;
                l1 = l1.next;
            }
            else{
                h.next = l2;
                l2 = l2.next;
            }
            h = h.next;
        }
        if(l1==null)
            h.next = l2;
        else
            h.next = l1;
            
        return head.next;
    }
}

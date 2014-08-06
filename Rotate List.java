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
    public ListNode rotateRight(ListNode head, int n) {
        if(head==null)
            return null;
        int l = getLen(head);
        n = n%l;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode tail = dummy;
        for(int i = 0; i < n; i++){
            head = head.next;
        }
        while(head.next!=null){
            tail = tail.next;
            head = head.next;
        }
        head.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;
        return dummy.next;
    }
    
    public int getLen(ListNode head){
        int res = 0;
        ListNode p = head;
        while(p!=null){
            res++;
            p = p.next;
        }
        return res;
    }
}

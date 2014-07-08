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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if((head==null) || (head.next==null))
            return head;
        if(m==n)
            return head;
        
        ListNode p = head,t = head,h = head;
        int index = 1;
        while(index < m){
            t = p;
            p = p.next;
            index++;
        }
        ListNode q = p;
        ListNode prep = p;
        p = p.next;
        ListNode nextp = p.next;
        index++;
        while(index <= n){
            p.next = prep;
            prep = p;
            p = nextp;
            if(nextp!=null){
                nextp = nextp.next;
            }
            else{
                break;
            }
            index++;
        }
        if(m==1){
            h = prep;
            t.next = p;
        }
        else{
            t.next = prep;
            q.next = p;
        }
        return h;
    }
}

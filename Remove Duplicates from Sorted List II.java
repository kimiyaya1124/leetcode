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
    public ListNode deleteDuplicates(ListNode head) {
        if( (head==null) || (head.next==null))
            return head;
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode pre = h;
        int count = 1;
        while(head!=null){
            ListNode next = head.next;
            if(next==null){
                if(count>1){
                    pre.next = next;
                }
                break;
            }
            else{
                if(next.val == head.val)
                    count++;
                else{
                    if(count>1){
                        pre.next = next;
                        count=1;
                    }
                    else{
                        pre = head;
                    }
                }
            }
            head = head.next;
        }
        return h.next;
    }
}

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head==null) 
            return head;
            
        RandomListNode q = head;
        if (head.next == null){
            q = new RandomListNode(head.label);
            q.next = null;
            if(head.random == null)
                q.random = null;
            else
                q.random = q;
            return q;
        }
            
        RandomListNode h = head,p = head,prevp=head;
        while(true){
            prevp = p;
            p = p.next;
            
            q = new RandomListNode(prevp.label);
            q.next = p;
            prevp.next = q;
            
            if(p == null)
                break;
        }
        
        prevp = h;
        p = prevp.next;
        while(true){
            if(prevp.random==null)
                p.random = null;
            else
                p.random = prevp.random.next;
            
            prevp = prevp.next.next;
            if(prevp == null)
                break;
            p = prevp.next;
        }
        
        prevp = h;
        p = prevp.next;
        h = p;
        while(true){
            prevp.next = p.next;
            p.next = prevp.next.next;
            
            prevp = prevp.next;
            p = p.next;
            if(p.next == null){
                prevp.next = null;
                break;
            }
        }
        
        return h;
    }
}

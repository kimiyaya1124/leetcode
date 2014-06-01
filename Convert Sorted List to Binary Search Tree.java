/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null){
            TreeNode tn = new TreeNode(head.val);
            return tn;
        }
        ListNode p = head;
        int len = 0;
        while(p!=null){
            p = p.next;
            len++;
        }
        TreeNode tn = bst(head,len);
        return tn;
    }
    
    public TreeNode bst(ListNode head,int len){
        if(len<=0)
            return null;
        ListNode p = head;
        int i = 0;
        while(i<len/2){
            p = p.next;
            i++;
        }
        TreeNode lt = bst(head,i);
        TreeNode rt = bst(p.next,len-i-1);
        TreeNode tn = new TreeNode(p.val);
        tn.left = lt;
        tn.right = rt;
        return tn;
    }
}

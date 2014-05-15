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
    public TreeNode sortedArrayToBST(int[] num) {
        if(num.length==0)
            return null;
        
        int h = 0, t = num.length-1,mid = (h+t)/2;
        TreeNode root = new TreeNode(num[mid]);
        if(mid-h>0){
            int[] lefttree = new int[mid-h];
            System.arraycopy(num,0,lefttree,0,mid-h);
            TreeNode leftroot = sortedArrayToBST(lefttree);
            root.left = leftroot;
        }
        else
            root.left = null;
        if(t-mid>0){
            int[] righttree = new int[t-mid];
            System.arraycopy(num,mid+1,righttree,0,t-mid);
            TreeNode rightroot = sortedArrayToBST(righttree);
            root.right = rightroot;
        }
        else
            root.right = null;
            
        return root;
    }
}

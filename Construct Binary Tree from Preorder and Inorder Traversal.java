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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length<=0)
            return null;
        TreeNode root = buildTree2(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        return root;
    }
    
    public TreeNode buildTree2(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend){
        if(prestart>preend)
            return null;
        if(instart > inend)
            return null;
        TreeNode root = new TreeNode(preorder[prestart]);
        int split = 0;
        for(int i = instart; i <= inend; i++){
            if(inorder[i]==root.val){
                split = i;
                break;
            }
        }
        root.left = buildTree2(preorder, prestart+1, prestart+split-instart, inorder, instart, split-1);
        root.right = buildTree2(preorder, prestart+split-instart+1,preend, inorder, split+1,inend);
        return root;
    }
}

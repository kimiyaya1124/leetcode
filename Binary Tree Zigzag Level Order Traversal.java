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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> outerarr = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return outerarr;
            
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int lastlevel = 1;
        int thislevel = 0;
        int nextlevel = 0;
        int level = 0;
        q.offer(root);
        while(!q.isEmpty()){
             level++;
             ArrayList<Integer> innerarr = new ArrayList<Integer>();
             while(thislevel < lastlevel){
                 TreeNode t = q.poll();
                 if(t.left!=null){
                    q.offer(t.left);
                    nextlevel++;
                }
                if(t.right!=null){
                    q.offer(t.right);
                    nextlevel++;
                }
                thislevel++;
                if(level%2==1){
                    innerarr.add(t.val);
                }
                else{
                    innerarr.add(0,t.val);
                }
            }
            outerarr.add(innerarr);
            lastlevel = nextlevel;
            thislevel = 0;
            nextlevel = 0;
        }
        return outerarr;
    }
}

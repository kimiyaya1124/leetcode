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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> outerArr = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return outerArr;
            
        int level = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int lastlevel = 1;
        int thislevel = 0;
        int nextlevel = 0;
        q.offer(root);
        while(!q.isEmpty()){
            ArrayList<Integer> innerArr = new ArrayList<Integer>();
            while(thislevel < lastlevel){
                TreeNode tmpr = q.poll();
                thislevel++;
                innerArr.add(tmpr.val);
                if(tmpr.left!=null){
                    q.offer(tmpr.left);
                    nextlevel++;
                }
                if(tmpr.right!=null){
                    q.offer(tmpr.right);
                    nextlevel++;
                }
            }
            outerArr.add(outerArr.size(),innerArr);
            lastlevel = nextlevel;
            nextlevel = 0;
            thislevel = 0;
        }
        return outerArr;
    }
}

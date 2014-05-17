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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> outerArr = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return outerArr;
        
        int lastlevel = 1,index = 0,nextlevel = 0;
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        q1.offer(root);
        while(!q1.isEmpty()){
            ArrayList<Integer> innerArr = new ArrayList<Integer>();
            while(!q1.isEmpty() && (index < lastlevel)){
                TreeNode tmpr = q1.poll();
                innerArr.add(new Integer(tmpr.val));
                if(tmpr.left!=null){
                    q1.offer(tmpr.left);
                    nextlevel++;
                }
                if(tmpr.right!=null){
                    q1.offer(tmpr.right);
                    nextlevel++;
                }
                index++;
            }
            outerArr.add(0,innerArr);
            lastlevel = nextlevel;
            nextlevel = 0;
            index = 0;
        }
        return outerArr;
    }
}

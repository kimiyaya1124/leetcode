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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root==null)
            return res;
        if((root.left==null) && (root.right==null)){
            if(root.val == sum){
                ArrayList<Integer> innerArr = new ArrayList<Integer>();
                innerArr.add(root.val);
                res.add(innerArr);
            }
            else
                return res;
        }
        ArrayList<ArrayList<Integer>> leftres = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> rightres = new ArrayList<ArrayList<Integer>>();
        if(root.left!=null)
            leftres = pathSum(root.left,sum-root.val);
        if(root.right!=null)
            rightres = pathSum(root.right,sum-root.val);
        for(int i = 0; i < leftres.size();i++){
            ArrayList<Integer> innerArr = leftres.get(i);
            innerArr.add(0,root.val);
            res.add(innerArr);
        }
        for(int i = 0; i < rightres.size();i++){
            ArrayList<Integer> innerArr = rightres.get(i);
            innerArr.add(0,root.val);
            res.add(innerArr);
        }
        return res;
    }
}

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(candidates.length==0)
            return res;
        
        Arrays.sort(candidates);
        combsum(candidates,target,0,res,new ArrayList<Integer>());
        return res;
    }
    
    public void combsum(int[] candidates,int target,int start,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> curArr){
        if(target<0)
            return;
        if(target==0){
            ArrayList<Integer> innerArr = new ArrayList<Integer>(curArr);
            res.add(innerArr);
            return;
        }
        for(int i = start;i<candidates.length;i++){
            if((i>0)&&(candidates[i]==candidates[i-1])){
                continue;
            }
            curArr.add(candidates[i]);
            combsum(candidates,target-candidates[i],i,res,curArr);
            curArr.remove(curArr.size()-1);
        }
    }
}

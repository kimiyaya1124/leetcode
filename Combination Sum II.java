public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> outerArr = new ArrayList<ArrayList<Integer>>();
        if(num.length==0)
            return outerArr;
            
        Arrays.sort(num);
        combsum(num,target,0,outerArr,new ArrayList<Integer>());
        return outerArr;
    }
    
    public void combsum(int[] num, int target, int start, ArrayList<ArrayList<Integer>> outerArr, ArrayList<Integer> curArr){
        if(target < 0)
            return;
        if(target==0){
            ArrayList<Integer> innerArr = new ArrayList<Integer>(curArr);
            outerArr.add(innerArr);
            return;
        }
        for(int i = start; i < num.length;i++){
            if(i>start && num[i]==num[i-1]) continue; 
            curArr.add(num[i]);
            combsum(num,target-num[i],i+1,outerArr,curArr);
            curArr.remove(curArr.size()-1);
        }
    }
}

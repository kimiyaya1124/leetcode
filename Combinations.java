public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(); 
        if(n < k)
            return res;
        if(k == 1){
            for(int i = 1; i <= n; i++){
                ArrayList<Integer> innerArr = new ArrayList<Integer>();
                innerArr.add(i);
                res.add(innerArr);
            }
            return res;
        }
        else{
            ArrayList<ArrayList<Integer>> res1 = combine(n-1,k-1);
            res = combine(n-1,k);
            ArrayList<Integer> innerArr = new ArrayList<Integer>();
            for(int i = 0; i < res1.size();i++){
                innerArr = res1.get(i);
                innerArr.add(n);
                res.add(innerArr);
            }
        }
        return res;
    }
}

public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(new Integer(0));
        for(int i=0;i<n;i++){
            Integer h = 1<<i;
            int curlen = res.size();
            for(int j = curlen-1;j>=0;j--){
                Integer l = res.get(j);
                res.add(l+h);
            }
        }
        return res;
    }
}

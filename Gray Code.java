public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        int len = 1<<n;
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0;i<len;i++){
            int r = i ^ (i>>1);
            res.add(r);
        }
        return res;
    }
}

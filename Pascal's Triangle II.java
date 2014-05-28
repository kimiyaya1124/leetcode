public class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(rowIndex <= 1){
            for(int i = 0; i <= rowIndex;i++)
                res.add(1);
            return res;
        }
        res.add(1);
        res.add(1);
        int last = 0, cur = 0;
        for(int i = 2; i <= rowIndex; i++){
            last = 1;
            for(int j = 1; j < i; j++){
                cur = res.get(j);
                res.set(j,last+cur);
                last = cur;
            }
            res.add(1);
        }
        return res;
    }
}

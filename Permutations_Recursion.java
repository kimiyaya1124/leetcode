public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> outers = new ArrayList<Integer> ();
        if(num.length==0)
            return res;
        if(num.length==1){
            outers.add(num[0]);
            res.add(outers);
            return res;
        }
        
        ArrayList<Integer> inners = new ArrayList<Integer> ();
        ArrayList<Integer> inners2 = new ArrayList<Integer> ();
        int[] num2 = new int[num.length-1];
        ArrayList<ArrayList<Integer>> res2 = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < num.length;i++){
            inners.add(new Integer(num[i]));
        }
        for(int i = 0;i < num.length;i++){
            int tmpi = inners.get(i);
            inners.remove(i);
            for(int j = 0; j < inners.size();j++)
                num2[j] = inners.get(j);
            res2 = permute(num2);
            inners.add(i,tmpi);
            for(int j = 0; j < res2.size();j++){
                ArrayList<Integer> tmp = res2.get(j);
                tmp.add(0,tmpi);
                res.add(tmp);
            }
        }
        return res;   
    }
}

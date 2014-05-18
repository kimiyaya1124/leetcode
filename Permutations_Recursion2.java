public class Solution {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> inners = new ArrayList<Integer>();
    
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        if(num.length==0)
            return res;
            
        ArrayList<Integer> outers = int2Array(num);
        permute2(outers);
        return res;
    }
    
    public void permute2(ArrayList<Integer> num){
        if(num.size()==1){
            int index = inners.size();
            inners.add(index,num.get(0));
            res.add(copyArray(inners));
            inners.remove(index);
        }
        
        for(int i = 0; i < num.size();i++){
            int index = inners.size();
            int tmpi = num.get(i);
            inners.add(tmpi);
            num.remove(i);
            permute2(num);
            num.add(i,tmpi);
            inners.remove(index);
        }
    }
    
    public ArrayList<Integer> copyArray(ArrayList<Integer> num){
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0;i < num.size();i++)
            res.add(num.get(i));
        return res;
    }
    
    public ArrayList<Integer> int2Array(int[] num){
        ArrayList<Integer> res = new ArrayList<Integer> ();
        for(int i = 0; i < num.length;i++){
            res.add(new Integer(num[i]));
        }
        return res;
    }
    
    public int[] array2Int(ArrayList<Integer> num){
        int[] res = new int[num.size()];
        for(int i = 0; i < num.size();i++)
            res[i] = num.get(i);
        return res;
    }
}

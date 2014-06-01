public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0)
            return 0;
        List<Integer> arr = triangle.get(0);
        if(triangle.size()==1){
            return arr.get(0);
        }
        int level = triangle.size();
        int i,j,k;
        int[] info = new int[level];
        for(i = level-1;i>=0;i--){
            arr = triangle.get(i);
            for(j = 0;j < arr.size();j++){
                if(i==level-1)
                    info[j] = arr.get(j);
                else{
                    info[j] = arr.get(j)+Math.min(info[j],info[j+1]);
                }
            }
        }
        return info[0];
    }
}

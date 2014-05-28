public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> outerArr = new ArrayList<ArrayList<Integer>>();
        if(S.length==0)
            return outerArr;
        
        Arrays.sort(S);
        int i=0,j=0;
        ArrayList<Integer> innerArr = new ArrayList<Integer>();
        outerArr.add(innerArr);
        for(i = 0; i < S.length;i++){
            int innerLen = outerArr.size();
            for(j = 0; j < innerLen; j++){
                ArrayList<Integer> innerArr2 = new ArrayList<Integer>(outerArr.get(j));
                innerArr2.add(S[i]);
                outerArr.add(innerArr2);
            }
        }
        return outerArr;
    }
}

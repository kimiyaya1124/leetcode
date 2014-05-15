public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> outerArr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> lastArr = new ArrayList<Integer>();
        for(int i = 1;i <= numRows; i++){
            ArrayList<Integer> innerArr = new ArrayList<Integer>();
            innerArr.add(new Integer(1));
            for(int j = 1;j < i-1;j++){
                innerArr.add(lastArr.get(j-1)+lastArr.get(j));
            }
            if(i > 1)
                innerArr.add(new Integer(1));
            lastArr = innerArr;
            outerArr.add(innerArr);
        }
        return outerArr;
    }
}

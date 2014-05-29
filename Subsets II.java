public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        int i,j,last=0,len=0;
        ArrayList<ArrayList<Integer>> outerArr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> innerArr = new ArrayList<Integer>();
        if(num.length==0)
            return outerArr;
        outerArr.add(new ArrayList<Integer>());
        innerArr.add(num[0]);
        outerArr.add(innerArr);
        last = 1;
        for(i = 1; i < num.length;i++){
            len = outerArr.size();
            if(num[i]!=num[i-1]){
                for(j = 0; j < len;j++){
                    ArrayList<Integer> innerArr2 = new ArrayList<Integer>(outerArr.get(j));
                    innerArr2.add(num[i]);
                    outerArr.add(innerArr2);
                }
                last = 1;
            }
            else{
                last++;
                for(j = 0; j < len;j++){
                    ArrayList<Integer> innerArr2 = outerArr.get(j);
                    if(!innerArr2.contains(num[i])){
                        innerArr2 = new ArrayList<Integer>(outerArr.get(j));
                        for(int k = 0; k < last;k++)
                            innerArr2.add(num[i]);
                        outerArr.add(innerArr2);
                    }
                }
            }
        }
        return outerArr;
    }
}

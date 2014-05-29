public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if(s.length()<=0)
            return res;
        
        boolean[][] ispalin = new boolean[s.length()][s.length()];
        ArrayList<String> innerArr = new ArrayList<String>();
        getpartition(s,0,res,innerArr,ispalin);
        return res;
    }
    
    public void getpartition(String s, int start, ArrayList<ArrayList<String>> res,ArrayList<String> curArr,boolean[][] ispalin){
        if((start==s.length()) && (curArr.size()>0)){
            res.add(new ArrayList<String>(curArr));
            return;
        }
        for(int i = start;i<s.length();i++){
            if(start==i)
                ispalin[start][i]=true;
            else if(s.charAt(i)==s.charAt(start)){
                if(i-start==1)
                    ispalin[start][i]=true;
                else{
                    if(ispalin[start+1][i-1])
                        ispalin[start][i]=true;
                }
            }
            if(ispalin[start][i]){
                curArr.add(s.substring(start,i+1));
                getpartition(s,i+1,res,curArr,ispalin);
                curArr.remove(curArr.size()-1);
            }
        }
    }
}

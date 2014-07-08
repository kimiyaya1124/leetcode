public class Solution {
    int upper;
    
    public ArrayList<String[]> solveNQueens(int n) {
        upper = (1<<n) - 1;
        ArrayList<String[]> outerArr = new ArrayList<String[]>();
        ArrayList<String> strs = new ArrayList<String>();
        NQueens(n,0,0,0,outerArr,strs);
        return outerArr;
    }
    
    public void NQueens(int n, int row, int ld, int rd, ArrayList<String[]> outerArr,ArrayList<String> strs){
        int pos,p;
        if(row < upper){
            pos = upper & (~(row | ld | rd));
            while(pos!=0){
                p = pos & (-pos);
                String s = "";
                for(int i = 0; i < n; i++){
                    if((p & (1<<i))==0)
                        s += ".";
                    else
                        s += "Q";
                }
                strs.add(s);
                pos = pos - p;
                NQueens(n,row+p,(ld+p)<<1,(rd+p)>>1,outerArr,strs);
                strs.remove(strs.size()-1);
            }
        }
        else{
            String[] innerArr = new String[strs.size()];
            for(int i = 0; i < strs.size();i++)
                innerArr[i] = new String(strs.get(i));
            outerArr.add(innerArr);
        }
    }
}

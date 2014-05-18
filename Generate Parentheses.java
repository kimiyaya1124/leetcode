public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String> ();
        if(n == 0) 
            return res;
        if(n == 1){
            res.add("()");
            return res;
        }
        
        String r = "";
        ArrayList<String> inners = new ArrayList<String>();
        ArrayList<String> outers = new ArrayList<String>();
        outers = generateParenthesis(n-1);
        for(int i = 0;i < outers.size();i++){
            r = "()"+outers.get(i);
            res.add(r);
        }
        for(int i = 1;i<n;i++){
            inners = generateParenthesis(i);
            outers = generateParenthesis(n-1-i);
            for(int j = 0;j < inners.size();j++){
                r = "("+inners.get(j)+")";
                if(outers.size()==0)
                    res.add(r);
                else
                    for(int k = 0;k < outers.size();k++)
                        res.add(r+outers.get(k));
            }
        }
        
        return res;
    }
}

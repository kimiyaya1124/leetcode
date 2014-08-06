public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(L==null || L.length<=0)
            return res;
        int n = L.length, m = L[0].length();
        if(m<=0 || S.length()<n*m)
            return res;
        HashMap<String, Integer> Lmap = new HashMap<String, Integer>();
        for(int i = 0; i < L.length; i++){
            if(Lmap.containsKey(L[i])){
                Lmap.put(L[i],Lmap.get(L[i])+1);
            }
            else{
                Lmap.put(L[i],1);
            }
        }
        
        HashMap<String, Integer> FoundMap = new HashMap<String, Integer>();
        for(int i = 0; i <= S.length()-n*m;i++){
            FoundMap.clear();
            int j;
            for(j = 0; j < n; j++){
                int k = i+j*m;
                String tmpstr = S.substring(k,k+m);
                if(!Lmap.containsKey(tmpstr))
                    break;
                if(!FoundMap.containsKey(tmpstr)){
                    FoundMap.put(tmpstr,1);
                }
                else{
                    FoundMap.put(tmpstr,FoundMap.get(tmpstr)+1);
                }
                if(FoundMap.get(tmpstr)>Lmap.get(tmpstr))
                    break;
            }
            if(j>=n)
                res.add(i);
        }
        return res;
        
    }
}

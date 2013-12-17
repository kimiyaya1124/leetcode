public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> solutions = new ArrayList<String>();
        if(s.length()==0)
            return solutions;
        if(dict.isEmpty())
            return solutions;
            
        int[][] isexist = new int[s.length()][s.length()+1];
        Integer l,i,k;
        
        for(l = 1;l <= s.length();l++){
            for(i = 0;i < s.length();i++){
                if(i+l<=s.length()){
                    String tmp = s.substring(i,i+l);
                    if(dict.contains(tmp)){
                        isexist[i][l] = 2;
                        continue;
                    }
                
                    for(k = 1;k < l;k++){
                        if( (isexist[i][k]>0) && (isexist[i+k][l-k]>0) ){
                            isexist[i][l] = 1;
                            break;
                        }
                    }
                }
            }
        }
        
        if(isexist[0][s.length()]>0){
            solutions = mergeString(s,isexist,0,s.length());
        }
        return solutions;
    }
    
    public ArrayList<String> mergeString(String s, int[][] isexist, int start, int length){
        ArrayList<String> strs = new ArrayList<String>();
        int i,k;
        for(k = 1;k<length;k++){
            if( (isexist[start][k]==2) && (isexist[start+k][length-k]>0) ){
                String str1 = s.substring(start,start+k);
                ArrayList<String> str2 = mergeString(s,isexist,start+k,length-k);
                for(i = 0;i < str2.size();i++){
                    strs.add(str1+" "+str2.get(i));
                }
            }
        }
        if(isexist[start][length]==2){
            strs.add(s.substring(start,start+length));
        }
        return strs;
    }
}

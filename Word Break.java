import java.util.*;

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s.length()==0)
            return true;
            
        boolean[][] ifexist = new boolean[s.length()][s.length()+1];
        
        Integer i,l,k;
        
        for(l = 1;l <= s.length();l++){
            for(i = 0;i < s.length(); i++){
                if(i+l <= s.length()){
                    String tmp = s.substring(i,i+l);
                    if(dict.contains(tmp)){
                        ifexist[i][l] = true;
                        continue;
                    }
                    
                    for(k = 1;k < l;k++){
                        if(ifexist[i][k] && ifexist[i+k][l-k]){
                            ifexist[i][l] = true;
                            break;
                        }
                    }
                }
            }
        }
        
        return ifexist[0][s.length()];
    }
}

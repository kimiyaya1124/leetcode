public class Solution {
    public String minWindow(String S, String T) {
        if(S==null || S.length()<=0)
            return S;
        if(T==null || T.length()<=0)
            return "";
        
        HashMap<Character,Integer> tmap = new HashMap<Character,Integer>();
        for(int i = 0; i < T.length(); i++){
            char c = T.charAt(i);
            if(tmap.containsKey(c)){
                tmap.put(c,tmap.get(c)+1);
            }
            else{
                tmap.put(c,1);
            }
        }
        
        HashMap<Character,Integer> windowMap = new HashMap<Character,Integer>();
        String windowStr = null;
        int tCount = 0, leftBound = 0;
        for(int i = 0; i < S.length();i++){
            char c = S.charAt(i);
            if(!tmap.containsKey(c))
                continue;
            if(windowMap.containsKey(c)){
                windowMap.put(c,windowMap.get(c)+1);
            }
            else{
                windowMap.put(c,1);
            }
            if(windowMap.get(c)<=tmap.get(c))
                tCount++;
            if(tCount==T.length()){
                while(leftBound<i){
                    char c2 = S.charAt(leftBound);
                    if(!tmap.containsKey(c2)){
                        leftBound++;
                        continue;
                    }
                    if(windowMap.get(c2) > tmap.get(c2)){
                        windowMap.put(c2,windowMap.get(c2)-1);
                        leftBound++;
                        continue;
                    }
                    break;
                }
                if(windowStr==null || i-leftBound+1<windowStr.length()){
                    windowStr = S.substring(leftBound,i+1);
                }
            }
        }
        return windowStr==null?"":windowStr;
    }
}

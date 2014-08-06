public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> res = new ArrayList<String>();
        if(words==null || words.length<=0)
            return res;
        int curLen = 0, lastI = 0;
        for(int i = 0; i <= words.length;i++){
            if(i == words.length || (curLen+words[i].length()+i-lastI>L)){
                String tmpS = "";
                int spaceCount = L-curLen;
                int spaceSpot = i-lastI-1;
                if(spaceSpot==0 || i==words.length){
                    for(int j = lastI; j < i; j++){
                        tmpS += words[j];
                        if(j!=i-1){
                            tmpS = appendSpace(tmpS,1);
                        }
                    }
                    tmpS = appendSpace(tmpS,L-tmpS.length());
                }
                else{
                    int spaceEach = spaceCount/spaceSpot;
                    int spaceExtra = spaceCount%spaceSpot;
                    for(int j = lastI; j < i; j++){
                        tmpS += words[j];
                        if(j!=i-1){
                            tmpS = appendSpace(tmpS,spaceEach+(j-lastI<spaceExtra?1:0));
                        }
                    }
                }
                res.add(tmpS);
                lastI = i;
                curLen = 0;
            }
            if(i < words.length){
                curLen += words[i].length();
            }
        }
        return res;
    }
    
    public String appendSpace(String str, int n){
        for(int i = 0; i < n; i++){
            str += " ";
        }
        return str;
    }
}

public class Solution {
    public int lengthOfLastWord(String s) {
        int i;
        int lastlen=0, curlen = 0;
        int wordbegin=0;
        for(i = 0; i < s.length();i++){
            char c = s.charAt(i);
            if((c!=' ') && (wordbegin==0)){
                wordbegin=1;
            }
            if((c==' ') && (wordbegin==1)){
                wordbegin=0;
                lastlen = curlen;
                curlen = 0;
            }
            if(wordbegin==1)
                curlen++;
        }
        if(curlen>0)
            return curlen;
        else
            return lastlen;
    }
}

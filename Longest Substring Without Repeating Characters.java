public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=0)
            return 0;
        int charNum = 256;
        int[] rec = new int[charNum];
        for(int i = 0; i < charNum;i++)
            rec[i] = -1;
        int maxlen = 1;
        int start = 0;
        rec[s.charAt(0)] = 0;
        int end = 1;
        
        for(int i = end; i < s.length();i++){
            if(rec[s.charAt(i)]>=start){
                maxlen = Math.max(maxlen, i-start);
                start = rec[s.charAt(i)]+1;
            }
            if(i == s.length()-1){
            	maxlen = Math.max(maxlen, i-start+1);
            }
            rec[s.charAt(i)] = i;
        }
        return maxlen;
    }
}

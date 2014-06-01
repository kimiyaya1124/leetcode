public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        if(strs.length<=0)
            return res;
        int len = 0,i;
        while(len<strs[0].length()){
            char s = strs[0].charAt(len);
            for(i = 0; i < strs.length;i++){
                if((len>=strs[i].length()) || (s!=strs[i].charAt(len)))
                    break;
            }
            if(i < strs.length)
                break;
            else{
                res += strs[0].substring(len,len+1);
                len++;
            }
        }
        return res;
    }
}

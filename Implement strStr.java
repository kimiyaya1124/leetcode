public class Solution {
    public String strStr(String haystack, String needle) {
        if(haystack==null || needle==null)
            return null;
        if(needle.length()<=0 || haystack.equals(needle)){
            if(haystack.length()<=0)
                return "";
            else
                return haystack.substring(0);
        }
        int i,j;
        for(i = 0; i < haystack.length()-needle.length();i++){
            for(j = 0; j < needle.length();j++){
                if(haystack.charAt(i+j)!=needle.charAt(j))
                    break;
            }
            if(j>=needle.length()){
                return haystack.substring(i);
            }
        }
        return null;
    }
}

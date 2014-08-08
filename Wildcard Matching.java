public class Solution {
    public boolean isMatch(String s, String p) {
        if(s==null || p==null){
            return false;
        }
        if(p.length()<=0)
            return s.length()==0;
        int nostar = 0;
        for(int i = 0; i < p.length();i++){
            if(p.charAt(i)!='*')
                nostar++;
        }
        if(nostar>s.length())
            return false;
            
        boolean[] isTrue = new boolean[s.length()+1];
        isTrue[0] = true;
        for(int i = 0; i < p.length();i++){
            if(p.charAt(i)!='*'){
                for(int j = s.length();j>0;j--){
                    isTrue[j] = isTrue[j-1] && (p.charAt(i)=='?' || p.charAt(i)==s.charAt(j-1));
                }
            }
            else{
                int j = 0;
                while(j<=s.length() && !isTrue[j])
                    j++;
                for(;j<=s.length();j++)
                    isTrue[j] = true;
            }
            isTrue[0] = isTrue[0] && (p.charAt(i)=='*');
        }
        return isTrue[s.length()];
    }
}

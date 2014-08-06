public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3==null)
            return false;
        if(s1==null || s1.length()<=0){
            if(s2!=null && s2.equals(s3))
                return true;
            else
                return false;
        }
        if(s2==null || s2.length()<=0){
            if(s1!=null && s1.equals(s3))
                return true;
            else
                return false;
        }
        if(s3.length()!=s1.length()+s2.length())
            return false;
        boolean[][] isMatched = new boolean[s1.length()+1][s2.length()+1];
        for(int i = 1; i <= s1.length();i++){
            isMatched[i][0] = s1.charAt(i-1)==s3.charAt(i-1);
            if(!isMatched[i][0])
                break;
        }
        for(int i = 1; i <= s2.length(); i++){
            isMatched[0][i] = s2.charAt(i-1)==s3.charAt(i-1);
            if(!isMatched[0][i])
                break;
        }
        for(int i = 1; i <= s1.length();i++){
            for(int j = 1; j <= s2.length(); j++){
                boolean gets1 = (s1.charAt(i-1)==s3.charAt(i+j-1)) && (isMatched[i-1][j]);
                boolean gets2 = (s2.charAt(j-1)==s3.charAt(i+j-1)) && (isMatched[i][j-1]);
                isMatched[i][j] = gets1 || gets2;
            }
        }
        return isMatched[s1.length()][s2.length()];
    }
}

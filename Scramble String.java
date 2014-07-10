public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length())
            return false;
        if((s1.length()<=0) || (s2.length()<=0))
            return false;
            
        int len = s1.length();
        boolean[][][] dp = new boolean[len][len][len];
        int i,j,k,m;
        for(i = 0; i < len; i++){
            for(j = 0; j < len; j++){
                dp[0][i][j] = (s1.charAt(i)==s2.charAt(j));
            }
        }
        
        for(k = 2; k <= len; k++){
            for(i = 0; i <= len-k; i++){
                for(j = 0; j <= len-k; j++){
                    boolean isscr = false;
                    for(m = 1; m < k;m++){
                        isscr = (dp[m-1][i][j] && dp[k-m-1][i+m][j+m]) || (dp[m-1][i][j+k-m] && dp[k-m-1][i+m][j]);
                        if(isscr)
                            break;
                    }
                    dp[k-1][i][j] = isscr;
                }
            }
        }
        return dp[len-1][0][0];
    }
}

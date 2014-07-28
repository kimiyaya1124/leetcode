public class Solution {
    public int minCut(String s) {
        if(s==null || s.length()<=0)
            return 0;
        int[] cut = new int[s.length()+1];
        boolean[][] isPalindrome = getIsPalindrome(s);
        
        cut[0] = 0;
        for(int i = 1; i <= s.length();i++){
            cut[i] = Integer.MAX_VALUE;
            for(int j = 1; j <= i; j++){
                if(isPalindrome[i-j][i-1] && cut[i-j]!=Integer.MAX_VALUE){
                    cut[i] = Math.min(cut[i],cut[i-j]+1);
                }
            }
        }
        return cut[s.length()]-1;
    }
    
    public boolean[][] getIsPalindrome(String s){
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length();i++)
            isPalindrome[i][i] = true;
        for(int i = 0; i < s.length()-1;i++)
            isPalindrome[i][i+1] = (s.charAt(i)==s.charAt(i+1));
        for(int l = 2; l < s.length();l++){
            for(int start = 0; start+l < s.length();start++){
                isPalindrome[start][start+l] = isPalindrome[start+1][start+l-1] && (s.charAt(start)==s.charAt(start+l));
            }
        }
        return isPalindrome;
    }
}

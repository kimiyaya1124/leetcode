public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length()==0){
            return word2.length();
        }
        if(word2.length()==0){
            return word1.length();
        }
        int[][] minD = new int[word1.length()+1][word2.length()+1];
        int i,j;
        for(i = 0; i <= word1.length(); i++){
            for(j = 0; j <= word2.length(); j++){
                if(i == 0){
                    minD[i][j] = j;
                    continue;
                }
                if(j == 0){
                    minD[i][j] = i;
                    continue;
                }
                if((i == 0) && (j==0))
                    minD[i][j] = Integer.MAX_VALUE;
                int d0 = Integer.MAX_VALUE;
                if((i>0) && (j>0) && (word1.charAt(i-1)==word2.charAt(j-1)))
                    d0 = minD[i-1][j-1];
                int d1 = minD[i-1][j-1]+1;
                int d2 = minD[i-1][j]+1;
                int d3 = minD[i][j-1]+1;
                int d = Math.min(d0,d1);
                d = Math.min(d,d2);
                minD[i][j] = Math.min(d,d3);
            }
        }
        return minD[word1.length()][word2.length()];
    }
}

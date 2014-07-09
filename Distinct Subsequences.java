public class Solution {
    public int numDistinct(String S, String T) {
        if(S.length()<=0)
            return 0;
        if(T.length()>S.length())
            return 0;
        int[][] mD = new int[S.length()+1][T.length()+1];
        int i,j;
        for(i = 0; i <= S.length();i++){
            for(j = 0; j <= T.length();j++){
                if( (i == 0) || (j>i) ){
                    mD[i][j] = 0;
                    continue;
                }
                if(j==0){
                    mD[i][j]=1;
                    continue;
                }
                mD[0][0] = 1;
                if(S.charAt(i-1)==T.charAt(j-1)){
                    mD[i][j] = mD[i-1][j-1]+mD[i-1][j];
                }else{
                    mD[i][j] = mD[i-1][j];
                }
            }
        }
        return mD[S.length()][T.length()];
    }
}

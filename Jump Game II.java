public class Solution {
    public int jump(int[] A) {
        if(A.length<=1)
            return 0;
        
        int maxlen = 0;
        int step = 0;
        int stepd = 0;
        int i;
        for(i = 0; i < A.length;i++){
            if(i > stepd){
                stepd = maxlen;
                step++;
            }
            maxlen = Math.max(maxlen,i+A[i]);
        }
        return step;
    }
}

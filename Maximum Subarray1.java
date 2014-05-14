public class Solution {
    public int maxSubArray(int[] A) {
        if(A.length==0)
            return 0;
        int maxs = Integer.MIN_VALUE;
        int lastmaxs = 0;
        int i;
        for(i = 0;i < A.length;i++){
            if(lastmaxs<0)
                lastmaxs = A[i];
            else
                lastmaxs += A[i];
            if(lastmaxs>maxs)
                maxs = lastmaxs;
        }
        return maxs;
    }
}

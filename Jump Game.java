public class Solution {
    public boolean canJump(int[] A) {
        if(A.length<=0)
            return false;
        if(A.length==1)
            return true;
        int maxlen = A[0];
        if(maxlen>=A.length-1)
            return true;
        if(maxlen<=0)
            return false;
        boolean res = false;
        for(int i = 1; i < A.length-1;i++){
            if((maxlen>=i) && (i+A[i]>=A.length-1)){
                res = true;
                break;
            }
            if((maxlen<=i) && (A[i]==0)){
                res = false;
                break;
            }
            if((maxlen>=i) && (i+A[i]>maxlen))
                maxlen = i+A[i];
        }
        return res;
    }
}

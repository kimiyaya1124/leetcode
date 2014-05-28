public class Solution {
    public int trap(int[] A) {
        if(A.length<=2)
            return 0;
        int[] leftMost = new int[A.length];
        int[] rightMost = new int[A.length];
        int i;
        leftMost[0] = 0;
        for(i = 1; i < A.length; i++){
            leftMost[i] = Math.max(A[i-1],leftMost[i-1]);
        }
        rightMost[A.length-1] = 0;
        int sumTrap = 0;
        for(i = A.length-2;i>=0;i--){
            rightMost[i] = Math.max(A[i+1],rightMost[i+1]);
            if(Math.min(leftMost[i],rightMost[i])>A[i])
                sumTrap += Math.min(leftMost[i],rightMost[i])-A[i];
        }
        return sumTrap;
    }
}

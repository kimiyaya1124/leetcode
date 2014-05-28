public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length<=1)
            return A.length;
        int insertIndex = 1;
        int times = 1;
        for(int i = 1; i < A.length;i++){
            if(A[i]==A[i-1])
                times++;
            else
                times = 1;
            if(times <= 2){
                A[insertIndex] = A[i];
                insertIndex++;
            }
        }
        return insertIndex;
    }
}

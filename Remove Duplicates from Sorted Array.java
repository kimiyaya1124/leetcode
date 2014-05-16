public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length==0)
            return 0;
        int index = 0,i,cur = A[0];
        for(i = 1; i < A.length;i++){
            if(A[i]!=cur){
                index++;
                A[index] = A[i];
                cur = A[index];
            }
        }
        return index+1;
    }
}

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int i = m-1,j = n-1,index = m+n-1;
        while( (i>=0) && (j>=0) ){
            if(A[i]>=B[j]){
                A[index] = A[i];
                i--;
            }
            else{
                A[index] = B[j];
                j--;
            }
            index--;
        }
        if(j>=0){
            for(int k = 0;k <= j;k++)
                A[k] = B[k];
        }
    }
}

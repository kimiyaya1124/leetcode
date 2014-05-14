public class Solution {
    public int removeElement(int[] A, int elem) {
        if(A.length == 0)
            return 0;
        
        int p,q;
        for(p=0,q=0;q<A.length;q++){
            if(A[q]!=elem){
                A[p] = A[q];
                p++;
            }
        }
        return p;
    }
}

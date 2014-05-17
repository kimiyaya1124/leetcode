public class Solution {
    public void sortColors(int[] A) {
        if((A.length==0) || (A.length==1))
            return;
        
        int h = 0, t = A.length-1;
        int index = h;
        while(index <= t){
            if(A[index] == 2){
                A[index] = A[t];
                A[t] = 2;
                t--;
            }
            else if(A[index] == 0){
                if(index > h){
                    A[index] = A[h];
                    A[h] = 0;
                }
                index++;
                h++;
            }
            else
                index++;
        }
    }
}

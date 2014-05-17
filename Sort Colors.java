public class Solution {
    public void sortColors(int[] A) {
        if((A.length==0) || (A.length==1))
            return;
        
        int h = 0, t = A.length-1;
        while((h < A.length) && (A[h] == 0)){
            h++;
        }
        while((t>=0) && (A[t] == 2)){
            t--;
        }
        if((h >= A.length) || (t < 0) || (h>t))
            return;
            
        int index = h;
        while(index <= t){
            if(A[index] == 2){
                A[index] = A[t];
                A[t] = 2;
                t--;
            }
            else if(A[index] == 0){
                if(index == h){
                    index++;
                }
                else{
                    A[index] = A[h];
                    A[h] = 0;
                }
                h++;
            }
            else
                index++;
        }
    }
}

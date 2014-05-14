public class Solution {
    public int removeElement(int[] A, int elem) {
        if(A.length == 0)
            return 0;
        
        int h = 0, t = A.length-1;
        for(h = 0; h <= t; h++){
            if(A[h]==elem){
                while(t>=h){
                    if(A[t]==elem)
                        t--;
                    else
                        break;
                }
                if(t<h)
                    break;
                else{
                    A[h] = A[t];
                    A[t] = elem;
                    t--;
                }
            }
        }
        return t+1;
    }
}

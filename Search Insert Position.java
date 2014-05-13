public class Solution {
    public int searchInsert(int[] A, int target) {
        if(target>A[A.length-1])
            return A.length;
        if(target < A[0])
            return 0;
            
        int h = 0, t = A.length-1,index;
        int res=h;
        
        while(h<=t){
            index = (h+t)/2;
            if(target < A[index])
            {
                t = index-1;
                res = index;
            }
            else if (target > A[index])
            {
                h = index+1;
                res = index+1;
            }
            else{
                res = index;
                break;
            }
        }
        
        return res;
    }
}

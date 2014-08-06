public class Solution {
    public int sqrt(int x) {
        long high,low,mid;
        high = x;
        low = 0;
        while(high>=low){
            mid = low+(high-low)/2;
            if(x<mid*mid){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return (int) high;
    }
}

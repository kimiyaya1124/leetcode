public class Solution {
    private static final int maxDiv10 = Integer.MAX_VALUE / 10;
    private static final int minDiv10 = Integer.MIN_VALUE / 10;
    public int reverse(int x) {
        if(x == Integer.MAX_VALUE){
            return 0;
        }
        if(x == Integer.MIN_VALUE){
            return 0;
        }
        int n = 0;
        int tx = x;
        while(tx != 0){
            if(n > maxDiv10 || n < minDiv10){
                return 0;
            }
            n = n * 10 + tx % 10;
            tx = tx/10;
        }
        return (int) n;
    }
}

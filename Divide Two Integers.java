public class Solution {
    public int divide(int dividend, int divisor) {
        boolean negative = (dividend>0 && divisor<0) || (dividend<0 && divisor>0);
        if(dividend==Integer.MIN_VALUE && divisor==Integer.MIN_VALUE)
            return 1;
        if(divisor==Integer.MIN_VALUE){
            return 0;
        }
        int res = 0;
        if(dividend==Integer.MIN_VALUE){
            res = 1;
            dividend += Math.abs(divisor);
        }
        long a = Math.abs(dividend);
        long b = Math.abs(divisor);
        while(a>=b){
            int shift = 0;
            while((b<<shift)<=a){
                shift++;
            }
            res += 1<<(shift-1);
            a = a-(b<<(shift-1));
        }
        return negative?-res:res;
    }
}

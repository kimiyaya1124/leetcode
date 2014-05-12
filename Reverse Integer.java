public class Solution {
    public int reverse(int x) {
        int n = 0;
        int tx = x;
        while(tx != 0){
            n = n * 10 + tx % 10;
            tx = tx/10;
        }
        return n;
    }
}

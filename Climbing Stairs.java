public class Solution {
    public int climbStairs(int n) {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
            
        int an=1,bn=2,cn=an+bn;
        for(int i=3;i<=n;i++){
            cn = an+bn;
            an = bn;
            bn = cn;
        }
        return cn;
    }
}

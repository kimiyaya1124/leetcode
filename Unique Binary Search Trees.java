public class Solution {
    public int numTrees(int n) {
        if(n == 0)
            return 1;
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
            
        int i = 0;
        int number = 0;
        for(i = 0;i<=(n-1)/2;i++){
            if(i==n-1-i)
                number += numTrees(i)*numTrees(n-1-i);
            else
                number += numTrees(i)*numTrees(n-1-i)*2;
        }
        return number;
    }
}

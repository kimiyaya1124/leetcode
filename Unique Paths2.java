public class Solution {
    public int uniquePaths(int m, int n) {
        if((m == 1) || (n == 1))
            return 1;
        if((m < 1) || (n < 1) )
            return 0;
        
        int[] paths = new int[n];
        paths[0] = 1;
        for(int i = 0; i < m;i++){
            for(int j = 1; j < n; j++){
                paths[j] = paths[j]+paths[j-1];
            }
        }
        return paths[n-1];
    }
}

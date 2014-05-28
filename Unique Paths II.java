public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length<=0)
            return 0;
        if(obstacleGrid[0].length<=0)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int i,j;
        int[] res = new int[n];
        if((obstacleGrid[0][0]==1) || (obstacleGrid[m-1][n-1]==1))
            return 0;
        res[0] = 1;
        for(i = 0; i < m;i++){
            if((obstacleGrid[i][0]==0) && (res[0]==1))
                res[0] = 1;
            else
                res[0] = 0;
            for(j = 1; j < n;j++){
                if(obstacleGrid[i][j]==1)
                    res[j] = 0;
                else
                    res[j] = res[j-1]+res[j];
            }
        }
        return res[n-1];
    }
}

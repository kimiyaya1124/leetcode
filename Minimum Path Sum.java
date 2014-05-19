public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] pathsums = new int[n];
        int firstpathsum = 0;
        pathsums[0] = grid[0][0];
        for(int i = 1; i < n; i++){
            pathsums[i] = pathsums[i-1]+grid[0][i];
        }
        for(int i = 1; i < m;i++){
            pathsums[0] += grid[i][0];
            for(int j = 1; j < n; j++){
                pathsums[j] = Math.min(pathsums[j-1]+grid[i][j],pathsums[j]+grid[i][j]);
            }
        }
        return pathsums[n-1];
    }
}

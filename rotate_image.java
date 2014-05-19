public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int i,j;
        for(i = 0; i < n-1; i++){
            for(j = 0; j <= Math.min(i,(n-2-i)); j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
            }
        }
    }
}

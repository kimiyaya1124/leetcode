public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if(n == 0)
            return res;
        int curv = 0;
        int rowIndex = 0, colIndex = 0;
        int mode = 0;
        while(true){
            curv++;
            res[rowIndex][colIndex] = curv;
            if(curv >= n*n)
                break;
            int level = mode / 4;
            if(mode%4 == 0){
                if(colIndex < n-1-level)
                    colIndex++;
                else{
                    mode++;
                    rowIndex++;
                }
            }
            else if(mode%4 == 1){
                if(rowIndex < n-1-level)
                    rowIndex++;
                else{
                    mode++;
                    colIndex--;
                }
            }
            else if(mode%4 == 2){
                if(colIndex > level)
                    colIndex--;
                else{
                    mode++;
                    rowIndex--;
                }
            }
            else if(mode%4 == 3){
                if(rowIndex > level+1)
                    rowIndex--;
                else{
                    mode++;
                    colIndex++;
                }
            }
        }
        return res;
    }
}

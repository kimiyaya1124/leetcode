public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0)
            return;
        if(matrix[0].length==0)
            return;
        int isColZero = 0, isRowZero = 0;
        for(int i = 0; i < matrix[0].length;i++){
            if(matrix[0][i] == 0){
                isRowZero = 1;
                break;
            }
        }
        for(int i = 0; i < matrix.length;i++){
            if(matrix[i][0] == 0){
                isColZero = 1;
                break;
            }    
        }
        for(int i = 1; i < matrix.length;i++){
            for(int j = 1; j < matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < matrix[0].length;i++){
            if(matrix[0][i]==0){
                for(int j = 1; j < matrix.length;j++)
                    matrix[j][i] = 0;
            }
        }
        for(int i = 1; i < matrix.length;i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j < matrix[i].length;j++)
                    matrix[i][j] = 0;
            }
        }
        if(isRowZero==1){
            for(int i = 0; i < matrix[0].length;i++)
                matrix[0][i] = 0;
        }
        if(isColZero==1){
            for(int i = 0; i < matrix.length;i++)
                matrix[i][0] = 0;
        }
    }
}

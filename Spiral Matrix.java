public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(matrix==null || matrix.length<=0 || matrix[0].length<=0)
            return res;
        int row = matrix.length;
        int col = matrix[0].length;
        int count = 0;
        while(count*2<row && count*2<col){
            for(int i = count; i < col-count;i++){
                res.add(matrix[count][i]);
            }
            for(int i = count+1; i < row-count;i++){
                res.add(matrix[i][col-count-1]);
            }
            if(row - 2 * count == 1 || col - 2 * count == 1)
                break;
            for(int i = col-count-2; i >= count;i--){
                res.add(matrix[row-count-1][i]);
            }
            for(int i = row-count-2;i >= count+1;i--){
                res.add(matrix[i][count]);
            }
            count++;
        }
        return res;
    }
}

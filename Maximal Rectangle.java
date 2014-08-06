public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length<=0 || matrix[0].length<=0)
            return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] height2D = new int[row][col];
        int maxArea = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j]=='0')
                    height2D[i][j] = 0;
                else{
                    height2D[i][j] = i==0?1:height2D[i-1][j]+1;
                }
            }
        }
        
        for(int i = 0; i < row; i++){
            maxArea = Math.max(maxArea,listRectangle(height2D[i]));
        }
        return maxArea;
    }
    
    public int listRectangle(int[] height){
        if(height.length<=0)
            return 0;
        Stack<Integer> sta = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= height.length;i++){
            int curval = i==height.length?-1:height[i];
            while(!sta.isEmpty() && (curval < height[sta.peek()])){
                int h = height[sta.pop()];
                int w = sta.isEmpty()?i:i-sta.peek()-1;
                maxArea = Math.max(maxArea,h*w);
            }
            sta.push(i);
        }
        return maxArea;
    }
}

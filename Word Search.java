public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length<=0 || board[0].length<=0)
            return false;
        if(word.length()<=0)
            return true;
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j]==word.charAt(0)){
                    boolean left = helper(board,i,j,word,0);
                    if(left)
                        return true;
                }
            }
        }
        return false;
    }
    
    public boolean helper(char[][] board, int row, int col, String word, int start){
        if(start==word.length()){
            return true;
        }
        if(row >= board.length || col >= board[0].length || row < 0 || col < 0 || board[row][col]!=word.charAt(start)){
            return false;
        }
        
        board[row][col] = '#';
        boolean res = helper(board,row+1,col,word,start+1) || helper(board, row-1,col,word,start+1) || helper(board,row,col+1,word, start+1) || helper(board,row,col-1,word,start+1);
        board[row][col] = word.charAt(start);
        return res;
    }
}

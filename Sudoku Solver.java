public class Solution {
    public void solveSudoku(char[][] board) {
        if(board==null || board.length <= 0 || board[0].length <=0)
            return;
        solve(board);
    }
    
    public boolean solve(char[][] board){
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[0].length;j++){
                if(board[i][j]!='.'){
                    continue;
                }
                for(int k = 1; k <= 9; k++){
                    board[i][j] = (char) (k+'0');
                    if(isValid(board,i,j) && solve(board)){
                        return true;
                    }
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board, int x, int y){
        Set<Character> isContained = new HashSet<Character>();
        int rows = board.length;
        int cols = board[0].length;
        for(int i = 0; i < cols; i++){
            if(isContained.contains(board[x][i])){
                return false;
            }
            if(board[x][i]<='9' && board[x][i]>='0')
                isContained.add(board[x][i]);
        }
        
        isContained.clear();
        for(int i = 0; i < rows; i++){
            if(isContained.contains(board[i][y])){
                return false;
            }
            if(board[i][y]<='9' && board[i][y]>='0')
                isContained.add(board[i][y]);
        }
        
        isContained.clear();
        for(int i = 0; i < 3;i++){
            for(int j = 0; j < 3; j++){
                int a = x/3*3+i;
                int b = y/3*3+j;
                if(isContained.contains(board[a][b]))
                    return false;
                if(board[a][b] <= '9' && board[a][b] >= '0')
                    isContained.add(board[a][b]);
            }
        }
        
        return true;
    }
}

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int dec = 9;
        if(board.length!=dec)
            return false;
        if(board[0].length!=dec)
            return false;
            
        for(int i = 0; i < 9;i++){
            int[] rowc = new int[dec];
            int[] colc = new int[dec];
            for(int j = 0; j < 9; j++){
                if(board[i][j]!='.'){
                    if(rowc[board[i][j]-49]==1)
                        return false;
                    else
                        rowc[board[i][j]-49]++;
                }
                if(board[j][i]!='.'){
                    if(colc[board[j][i]-49]==1)
                        return false;
                    else
                        colc[board[j][i]-49]++;
                }
            }
        }
        
        for(int i = 0;i < 3;i++){
            for(int j = 0; j < 3; j++){
                int[] squarc = new int[dec];
                for(int m=0;m<3;m++){
                    for(int n=0; n<3; n++){
                        if(board[i*3+m][j*3+n]!='.'){
                            if(squarc[board[i*3+m][j*3+n]-49]==1)
                                return false;
                            else
                                squarc[board[i*3+m][j*3+n]-49]++;
                        }
                    }
                }
            }
        }
        return true;
        
    }
}

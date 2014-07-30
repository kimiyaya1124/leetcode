public class Solution {
    Queue<Integer> q = new LinkedList<Integer>();
    int row = 0, col = 0;
    
    public void solve(char[][] board) {
        if(board.length<=0 || board[0].length<=0)
            return;
        row = board.length;
        col = board[0].length;
        int i,j;
        for(i = 0; i < row; i++){
            enqueue(i,0,board);
            enqueue(i,col-1,board);
        }
        for(i = 0; i < col;i++){
            enqueue(0,i,board);
            enqueue(row-1,i,board);
        }
        
        while(!q.isEmpty()){
            int index = q.poll();
            int tmprow = index/col;
            int tmpcol = index%col;
            if(board[tmprow][tmpcol]=='O'){
                board[tmprow][tmpcol] = 'N';
            }
            enqueue(tmprow+1,tmpcol,board);
            enqueue(tmprow-1,tmpcol,board);
            enqueue(tmprow,tmpcol+1,board);
            enqueue(tmprow,tmpcol-1,board);
        }
        
        for(i = 0; i < row; i++){
            for(j = 0; j < col; j++){
                if(board[i][j] == 'O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='N'){
                    board[i][j] = 'O';
                }
            }
        }
        
    }
    
    public void enqueue(int x, int y, char[][] board){
        if(x>=0 && y>=0 && x<row && y<col && board[x][y]=='O')
            q.offer(x*col+y);
    }
}

public class Solution {
    int sum;
    int upper;
    
    public int totalNQueens(int n) {
        sum = 0;
        upper = (1<<n) - 1;
        NQueens(0,0,0);
        return sum;
    }
    
    public void NQueens(int row,int ld, int rd){
        int pos,p;
        if(row < upper){
            pos = upper & (~(row | ld | rd));
            while(pos!=0){
                p = pos & (-pos);
                pos = pos - p;
                NQueens(row+p,(ld+p)<<1,(rd+p)>>1);
            }
        }
        else
            sum++;
    }
}

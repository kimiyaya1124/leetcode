public class Solution {
    public int candy(int[] ratings) {
        if(ratings.length<=0)
            return 0;
        if(ratings.length==1)
            return 1;
        
        int N = 0,up = 0,step=0,i;
        boolean ifup = true, ifdown = false,ifequal = false;
        int cur = 1;
        N += cur;
        
        for(i = 0;i < ratings.length-1;i++){
            if(ratings[i+1] > ratings[i]){
                if(ifdown || ifequal){
                    if(ifdown)
                        N = calDown(N,step,cur);
                    cur = 1;
                    ifdown = false;
                    ifequal = false;
                    ifup = true;
                }
                cur = cur + 1;
                N += cur;
            }
            else if(ratings[i+1] == ratings[i]){
                if(ifdown){
                    N = calDown(N,step,cur);
                    ifdown = false;
                }
                if(ifup)
                    ifup = false;
                ifequal = true;
                cur = 1;
                N += cur;
            }
            else {
                if(ifup || ifequal){
                    step = 0;
                    ifup = false;
                    ifequal = false;
                    ifdown = true;
                }
                
                step++;
                cur--;
                N+=cur;
                
                if(i == ratings.length-2){
                    N = calDown(N,step,cur);
                }
            }
        }
        
        return N;
    }
    
    public int calDown(int N,int step,int cur){
        if(cur > 1)
            return N-step*(cur-1);
        else if(cur < 1)
            return N+(step+1)*(1-cur);
        else 
            return N;
    }
}

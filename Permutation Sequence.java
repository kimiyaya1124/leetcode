public class Solution {
    public String getPermutation(int n, int k) {
        String res = "";
        String nums = "123456789";
        boolean[] used = new boolean[n];
        
        int factor = 1;
        for(int i = 1; i <= n; i++)
            factor *= i;
        k--;
        for(int i = 0; i < n; i++){
            factor /= n-i;
            int digit = k / factor;
            k = k % factor;
            for(int j = 0; j < n; j++){
                if(used[j]==false){
                    if(digit==0){
                        used[j] = true;
                        res += nums.substring(j,j+1);
                        break;
                    }
                    else{
                        digit--;
                    }
                }
            }
        }
        return res;
    }
}

public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length==0)
            return digits;
        boolean isadd = true;
        for(int i = 0; i < digits.length;i++)
            if(digits[i]!=9){
                isadd = false;
                break;
            }
        if(isadd){
            int[] res = new int[digits.length+1];
            res[0] = 1;
            for(int i = 1; i < res.length;i++)
                res[i] = 0;
            return res;
        }
        else{
            int[] res = new int[digits.length];
            int curdigit = 0,iscarry=0;
            for(int i = digits.length-1;i >=0;i--){
                if(i == digits.length-1){
                    curdigit = digits[i]+1;
                }
                else{
                    curdigit = digits[i] + iscarry;
                    iscarry = 0;
                }
                if(curdigit>9){
                    iscarry = 1;
                    res[i] = 0;
                }
                else
                    res[i] = curdigit;
            }
            return res;
        }
    }
}

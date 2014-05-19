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
            int curdigit = 0,iscarry=1;
            for(int i = digits.length-1;i >=0;i--){
                curdigit = digits[i] + iscarry;
                iscarry = curdigit / 10;
                res[i] = curdigit % 10;
            }
            return res;
        }
    }
}

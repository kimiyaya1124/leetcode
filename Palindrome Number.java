public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int newx = x;
        int highl = 1;
        int dec = 10;
        while(true){
            if(newx / highl >= 10)
                highl *= dec;
            else
                break;
        }
        int lowl = dec;
        boolean res = true;
        while(true){
            int h = newx / highl;
            int l = newx % lowl;
            if(h != l){
                res = false;
                break;
            }
            newx = (newx - h*highl - l)/dec;
            highl = highl/dec/dec;
            if(highl <= lowl)
                break;
        }
        return res;
    }
}

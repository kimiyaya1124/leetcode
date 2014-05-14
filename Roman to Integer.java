public class Solution {
    public int romanToInt(String s) {
        String uppers = s.toUpperCase();
        int total = romanCharToInt(s.charAt(0));
        for(int i = 1;i < s.length();i++){
            int pre = romanCharToInt(s.charAt(i-1));
            int cur = romanCharToInt(s.charAt(i));
            if(cur<=pre)
                total += cur;
            else{
                total = total-2*pre+cur;
            }
        }
        return total;
    }
    
    public int romanCharToInt(char c){
        int res = 0;
        switch(c){
            case 'I':
                res=1;
                break;
            case 'V':
                res=5;
                break;
            case 'X':
                res=10;
                break;
            case 'L':
                res=50;
                break;
            case 'C':
                res=100;
                break;
            case 'D':
                res=500;
                break;
            case 'M':
                res=1000;
                break;
            default:
                res=-1;
                break;
        }
        if(res==-1)
            System.err.println("wrong char input\n");
        return res;
    }
}

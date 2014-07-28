public class Solution {
    public boolean isNumber(String s) {
        int len = s.length();
        int front = 0, end = len-1;
        while((front<len) && (Character.isWhitespace(s.charAt(front))))
            front++;
        if(front>len-1)
            return false;
        while((end>=front) && (Character.isWhitespace(s.charAt(end))))
            end--;
        if((s.charAt(front)=='+') || (s.charAt(front)=='-'))
            front++;
        boolean num = false, dot = false, exp = false;
        while(front<=end){
            char c = s.charAt(front);
            if(Character.isDigit(c)){
                num = true;
            }
            else if(c=='.'){
                if(dot)
                    return false;
                if(exp)
                    return false;
                dot = true;
            }
            else if(c=='e'){
                if(!num)
                    return false;
                if(exp)
                    return false;
                exp = true;
                num = false;
            }
            else if((c=='+') || (c=='-')){
                if(s.charAt(front-1)!='e')
                    return false;
            }
            else{
                return false;
            }
            front++;
        }
        return num;
    }
}

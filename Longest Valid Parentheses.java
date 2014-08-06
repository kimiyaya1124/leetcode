public class Solution {
    public int longestValidParentheses(String s) {
        if(s==null || s.length()<=0)
            return 0;
        Stack<Integer> sta = new Stack<Integer>();
        int maxLen = 0;
        int last = -1;
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i)=='('){
                sta.push(i);
            }
            else{
                if(sta.isEmpty()){
                    last = i;
                }
                else{
                    sta.pop();
                    if(sta.isEmpty()){
                        maxLen = Math.max(maxLen,i-last);
                    }
                    else{
                        maxLen = Math.max(maxLen,i-sta.peek());
                    }
                }
            }
        }
        return maxLen;
    }
}

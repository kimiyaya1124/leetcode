public class Solution {
    public boolean isValid(String s) {
        if(s.length()==0)
            return true;
        if(s.length()%2==1)
            return false;
        
        Stack<Character> st = new Stack<Character>();
        boolean res = true;
        for(int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            if(c=='(' || c=='[' || c=='{')
                st.add(c);
            else{
                if(st.empty()){
                    res = false;
                    break;
                }
                char c2 = st.pop();
                if((c2=='(') && (c!=')')){
                    res = false;
                    break;
                }
                if((c2=='[') && (c!=']')){
                    res = false;
                    break;
                }
                if((c2=='{') && (c!='}')){
                    res = false;
                    break;
                }
            }
        }
        if(!st.empty())
            res = false;
        return res;
    }
}

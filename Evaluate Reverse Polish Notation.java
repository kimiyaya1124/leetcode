public class Solution {
    int defaultVal = -10000;
    public int evalRPN(String[] tokens) {
        Stack<Integer> tokentree = new Stack<Integer> ();
        
        int i;
        Integer t,t1,t2;
        for(i=0;i<tokens.length;i++){
            if(!isOperator(tokens[i])){
                t = tryParseInt(tokens[i]);
                if(t==defaultVal)
                    return defaultVal;
                else
                    tokentree.push(t);
            }
            else{
                if(tokentree.size()>=2){
                    t1 = tokentree.pop();
                    t2 = tokentree.pop();
                    if(tokens[i].equals("+")){
                        tokentree.push(t1+t2);
                    }
                    else if (tokens[i].equals("-")){
                        tokentree.push(t2-t1);
                    }
                    else if (tokens[i].equals("*")){
                        tokentree.push(t1*t2);
                    }
                    else{
                        if(t1==0)
                            return defaultVal;
                        t = t2/t1;
                        tokentree.push(t);
                    }
                }
                else
                    return defaultVal;
            }
        }
        
        if(tokentree.size()==1){
            t = tokentree.pop();
            return t.intValue();
        }
        else
            return defaultVal;
    }
    
    public boolean isOperator(String token){
        if((token.equals("+")) || (token.equals("-")) || (token.equals("*")) || (token.equals("/")))
            return true;
        else
            return false;
    }
    
    public Integer tryParseInt(String token){
        try{
            return Integer.valueOf(token);
        } catch (NumberFormatException e){
            return defaultVal;
        }
    }
}

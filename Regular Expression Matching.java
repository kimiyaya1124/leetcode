public class Solution {
    public boolean isMatch(String s, String p) {
        int i,j;
        if(s.length()<=0)
            return checkEmpty(p);
        if(p.length()<=0)
            return false;
            
        char a = s.charAt(0);
        char b = p.charAt(0);
        char b2 = '0';
        if(p.length()>1)
            b2 = p.charAt(1);
        if(b2=='*'){
            if(compare(a,b)){
                return isMatch(s.substring(1),p) || isMatch(s,p.substring(2));
            }
            else{
                return isMatch(s,p.substring(2));
            }
        }
        else{
            if(compare(a,b)){
                return isMatch(s.substring(1),p.substring(1));
            }
            else{
                return false;
            }
        }
        
    }
    
    public boolean checkEmpty(String p){
        if(p.length()%2!=0)
            return false;
        for(int i = 1; i < p.length();i+=2){
            if(p.charAt(i)!='*')
                return false;
        }
        return true;
    }
    
     public boolean compare(char a, char b){
        return b == '.' || a == b;
    }
}

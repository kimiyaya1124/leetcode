public class Solution {
    public boolean isPalindrome(String s) {
        if((s==null) || (s.length()<=1))
            return true;
            
        int head = 0;
        int tail = s.length()-1;
        while(head < tail){
            while(head<s.length() && !isValid(s.charAt(head)))
                head++;
            if(head>=s.length())
                return true;
            while((tail>=0) && !isValid(s.charAt(tail))){
                tail--;
            }
            if(Character.toLowerCase(s.charAt(head))!=Character.toLowerCase(s.charAt(tail)))
                break;
            else{
                head++;
                tail--;
            }
        }
        return tail<=head;
    }
    
    boolean isValid(char c){
        return Character.isLetter(c) || Character.isDigit(c);
    }
}

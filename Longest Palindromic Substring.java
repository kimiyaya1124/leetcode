public class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<=0)
            return "";
        int max = 0;
        String res = "";
        for(int i = 1; i <= 2*s.length()-1;i++){
            int count = 1;
            while(i-count>=0 && i+count<=2*s.length() && get(s,i+count)==get(s,i-count)){
                count++;
            }
            count--;
            if(count>max){
                res = s.substring((i-count)/2,(i+count)/2);
                max = count;
            }
        }
        return res;
    }
    
    public char get(String s, int index){
        if(index%2==0)
            return '#';
        else
            return s.charAt(index/2);
        
    }
}

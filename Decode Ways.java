public class Solution {
    public int numDecodings(String s) {
        if(s==null || s.length()<=0)
            return 0;
        int[] num = new int[s.length()+1];
        num[0] = 1;
        num[1] = s.charAt(0)=='0'?0:1;
        for(int i = 2; i <= s.length(); i++){
            if(s.charAt(i-1)!='0')
                num[i] = num[i-1];
            if(s.charAt(i-2)!='0'){
                int num2 = (s.charAt(i-2)-'0')*10+s.charAt(i-1)-'0';
                if(num2>=10 && num2 <= 26)
                    num[i] += num[i-2];
            }
        }
        return num[s.length()];
    }
}

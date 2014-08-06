public class Solution {
    public String multiply(String num1, String num2) {
        if(num1==null || num2==null)
            return null;
            
        int len1 = num1.length(), len2 = num2.length();
        int len3 = len1+len2;
        int[] num3 = new int[len3];
        int i,j,carry,digit=10;
        
        for(i = len1-1;i>=0; i--){
            carry = 0;
            for(j = len2-1;j>=0;j--){
                int a = carry+num3[i+j+1]+Character.getNumericValue(num1.charAt(i))*Character.getNumericValue(num2.charAt(j));
                carry = a / digit;
                num3[i+j+1] = a % digit;
            }
            num3[i+j+1] = carry;
        }
        
        String S = "";
        i = 0;
        while(i < len3-1 && num3[i]==0){
            i++;
        }
        while(i < len3){
            S += Integer.toString(num3[i]);
            i++;
        }
        return S;
    }
}

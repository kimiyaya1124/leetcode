public class Solution {
    public String addBinary(String a, String b) {
        int la = a.length()-1;
        int lb = b.length()-1;
        int carry = 0;
        String res = "";
        while((la>=0) && (lb>=0)){
            int tmp = (a.charAt(la)-'0'+b.charAt(lb)-'0')+carry;
            carry = tmp/2;
            tmp = tmp%2;
            res = Integer.toString(tmp)+res;
            la--;
            lb--;
        }
        while(la>=0){
            int tmp = (a.charAt(la)-'0')+carry;
            carry = tmp/2;
            tmp = tmp%2;
            res = Integer.toString(tmp)+res;
            la--;
        }
        while(lb>=0){
            int tmp = (b.charAt(lb)-'0')+carry;
            carry = tmp/2;
            tmp = tmp%2;
            res = Integer.toString(tmp)+res;
            lb--;
        }
        if(carry>0){
            res = Integer.toString(carry)+res;
        }
        return res;
    }
}

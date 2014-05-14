public class Solution {
    public String intToRoman(int num) {
        String r[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int val[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        
        int i = 0;
        String res = "";
        int valn = num;
        while( (i<r.length) && (valn>0) ){
            while(valn >= val[i]){
                res = res + r[i];
                valn -= val[i];
            }
            i++;
        }
        return res;
    }
}

public class Solution {
    public String convert(String s, int nRows) {
        if(s.length()<=2)
            return s;
        if(nRows <= 1)
            return s;
        int step = (nRows-1)*2;
        int i,k;
        String res = "";
        for(i = 0; i < nRows;i++){
            if(i == 0){
                for(k = 0; k < s.length();){
                    res += s.substring(k,k+1);
                    k += step;
                }
            }else if(i == nRows-1){
                for(k = nRows-1; k < s.length();){
                    res += s.substring(k,k+1);
                    k += step;
                }
            }
            else{
                for(k = 0; k <= s.length()/step;k++){
                    int index = k*step+i;
                    if(index < s.length())
                        res += s.substring(index,index+1);
                    index = k*step+step-i;
                    if(index < s.length())
                        res += s.substring(index,index+1);
                    
                }
            }
        }
        return res;
    }
}

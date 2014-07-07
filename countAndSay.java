public class Solution {
    public String countAndSay(int n) {
        if(n<=0)
            return "";
        if(n==1)
            return "1";
        String laststr = "1";
        String thisstr = "";
        for(int i = 2; i <= n; i++){
            thisstr = "";
            int index = 0;
            int count = 1;
            String tmps = laststr.substring(0,1);
            index++;
            while(index <= laststr.length()){
                if(index < laststr.length()){
                    String tmps2 = laststr.substring(index,index+1);
                    if(tmps.equals(tmps2))
                        count++;
                    else{
                        thisstr = thisstr+Integer.toString(count)+tmps;
                        count = 1;
                        tmps = tmps2;
                    }
                }else{
                    thisstr = thisstr+Integer.toString(count)+tmps;
                }
                index++;
            }
            laststr = thisstr;
        }
        return thisstr;
    }
}

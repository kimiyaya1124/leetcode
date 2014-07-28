public class Solution {
    public String reverseWords(String s) {
        if(s==null || s.length()<=0)
            return s;
        
        String[] array = s.split(" ");
        String res = "";
        for(int i = array.length-1;i>=0;i--){
            if(!array[i].equals("")){
                res += array[i]+" ";
            }
        }
        if(res.length()<=0)
            return res;
        else{
            return res.substring(0,res.length()-1);
        }
    }
}

public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<String>();
        if(s.length()<4 || s.length()>12)
            return res;
        
        helper(res,list,s,0);
        return res;
    }
    
    public void helper(ArrayList<String> res, ArrayList<String> list, String s, int start){
        if(list.size()==4){
            if(s.length()==start){
                String tmpres = "";
                for(int i = 0; i < list.size()-1; i++){
                    String tmp = list.get(i);
                    tmpres += tmp+".";
                }
                tmpres += list.get(list.size()-1);
                res.add(tmpres);
                return;
            }
            else
                return;
        }
        for(int i = start; i < s.length() && i < start+3; i++){
            String tmp = s.substring(start,i+1);
            if(isValid(tmp)){
                list.add(tmp);
                helper(res,list,s,i+1);
                list.remove(list.size()-1);
            }
        }
    }
    
    public boolean isValid(String s){
        if(s.charAt(0)=='0')
            return s.equals("0");
        int num = Integer.valueOf(s);
        return num > 0 && num <= 255;
    }
}

public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        String[] charact = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        ArrayList<String> innerarr = new ArrayList<String>();
        String s = "";
        comb(innerarr,digits,charact,s);
        return innerarr;
    }
    
    public void comb(ArrayList<String> innerarr, String digits, String[] charact, String s){
        if(digits.length()<=0){
            String news = new String(s);
            innerarr.add(news);
            return;
        }
        
        String chara = charact[digits.charAt(0)-'0'];
        for(int i = 0; i < chara.length();i++){
            s += chara.substring(i,i+1);
            comb(innerarr,digits.substring(1),charact,s);
            s = s.substring(0,s.length()-1);
        }
    }
}

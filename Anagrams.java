public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> res = new ArrayList<String>();
        if(strs.length<=0)
            return res;
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>(); 
        for(int i = 0; i < strs.length;i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String tmpstr = new String(chars);
            if(map.containsKey(tmpstr)){
                map.get(tmpstr).add(strs[i]);
            }
            else{
                ArrayList<String> innerlist = new ArrayList<String>();
                innerlist.add(strs[i]);
                map.put(tmpstr,innerlist);
            }
        }
        Iterator iter = map.values().iterator(); 
        while(iter.hasNext()){
            ArrayList<String> item = (ArrayList<String>)iter.next(); 
            if(item.size()>1)
                res.addAll(item);
        }
        return res;
    }
}

public class Solution {
    public String simplifyPath(String path) {
        String res = "/";
        if(path==null || path.length()<=0)
            return res;
        String[] strs = path.split("/+");
        ArrayList<String> paths = new ArrayList<String>();
        for(String str:strs){
            if(str.equals("..")){
                if(paths.size()>0)
                    paths.remove(paths.size()-1);
            }
            else if(!str.equals(".") && !str.equals("")){
                paths.add(str);
            }
        }
        for(int i = 0; i < paths.size();i++){
            res += paths.get(i)+"/";
        }
        if(res.length()>1)
            res = res.substring(0,res.length()-1);
        return res;
    }
}

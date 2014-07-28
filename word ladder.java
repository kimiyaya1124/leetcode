public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if(dict==null || dict.size()==0)
            return 0;
        
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        dict.remove(start);
        int length = 1;
        
        while(!q.isEmpty()){
            int count = q.size();
            for(int i = 0; i < count; i++){
                String curstr = q.poll();
                for(char c = 'a'; c <= 'z'; c++){
                    for(int j = 0; j < curstr.length();j++){
                        if(c==curstr.charAt(j)){
                            continue;
                        }
                        String tmp = replace(curstr,j,c);
                        if(tmp.equals(end))
                            return length+1;
                        if(dict.contains(tmp)){
                            q.offer(tmp);
                            dict.remove(tmp);
                        }
                    }
                }
            }
            length++;
        }
        return 0;
    }
    
    public String replace(String str,int index, char c){
        char[] cs = str.toCharArray();
        cs[index] = c;
        return new String(cs);
    }
}

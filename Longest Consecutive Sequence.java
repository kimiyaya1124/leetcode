public class Solution {
    public int longestConsecutive(int[] num) {
        if(num.length<2)
            return num.length;
        Set<Integer> set = new HashSet<Integer>(); 
        for(int i:num){  
            set.add(i);  
        }
        int maxlen = 0;
        int curlen = 0;
        for(int i = 0; i < num.length;i++){
            if(set.contains(num[i])){
                int next = num[i]+1;
                curlen = 1;
                while(set.contains(next)){
                    curlen++;
                    set.remove(next);
                    next++;
                }
                next = num[i]-1;
                while(set.contains(next)){
                    curlen++;
                    set.remove(next);
                    next--;
                }
                if(curlen>maxlen)
                    maxlen = curlen;
                set.remove(num[i]);
            }
        }
        return maxlen;
    }
}

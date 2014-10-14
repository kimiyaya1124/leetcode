class Node{
    int len = 0;
    String val = "";
    LinkedList<Node> prev;
    
    public Node(String s , int l){
        val = s;
        len = l;
    }
    
    public void add(Node t){
        if(prev == null){
            prev = new LinkedList<Node>();
        }
        prev.add(t);
    }
    
}

public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, Set<String> dict) {
        ArrayList<ArrayList<String>> outerArr = new ArrayList<ArrayList<String>>();
        if(dict == null || dict.size() <= 0){
            return outerArr;
        }
        
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        HashMap<String , Node> dictHash = new HashMap<String , Node>();
        Node startNode = new Node(start , 0);
        dictHash.put(start , startNode);
        int curLen = 0;
        boolean isstop = false;
        while(!q.isEmpty() && !isstop){
            int lq = q.size();
            curLen++;
            for(int i = 0; i < lq; i++){
                String curStr = q.poll();
                for(int j = 0; j < curStr.length(); j++){
                    for(char c = 'a'; c <= 'z'; c++){
                        String tmpStr = replace(curStr , j , c);
                        if(tmpStr.equals(end)){
                            isstop = true;
                        }
                        if(dict.contains(tmpStr) || tmpStr == end){
                            Node preNode = dictHash.get(curStr);
                            if(!dictHash.containsKey(tmpStr)){
                                Node tmpNode = new Node(tmpStr, preNode.len + 1);
                                tmpNode.add(preNode);
                                dictHash.put(tmpStr, tmpNode);
                                q.offer(tmpStr);
                            }
                            else{
                                Node tmpNode = dictHash.get(tmpStr);
                                if(tmpNode.len == curLen){
                                    tmpNode.add(preNode);
                                }
                            }
                        }
                    }
                }
            }
        }
        
        ArrayList<String> innerArr = new ArrayList<String>();
        innerArr.add(end);
        if(isstop){
            helper(end, start, dictHash, innerArr, outerArr);
        }
        return outerArr;
    }
    
    public void helper(String str, String start, HashMap<String , Node> hm, ArrayList<String> innerArr, ArrayList<ArrayList<String>> outerArr){
        if(str == start){
            outerArr.add(new ArrayList<String>(innerArr));
            return;
        }
        
        Node tmpNode = hm.get(str);
        for(int i = 0; i < tmpNode.prev.size(); i++){
            innerArr.add(0 , tmpNode.prev.get(i).val);
            helper(tmpNode.prev.get(i).val , start , hm , innerArr , outerArr);
            innerArr.remove(0);
        }
    }
    
    public String replace(String str, int i, char c){
        char[] tmpc = str.toCharArray();
        tmpc[i] = c;
        return new String(tmpc);
    }

}

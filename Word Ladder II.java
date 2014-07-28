class Node{
    String str = "";
    int len = 0;
    LinkedList<Node> prev;
    
    Node(String s, int n){
        str = s;
        len = n;
    }
    
    void addPrev(Node pNode){
        if(prev==null)
            prev = new LinkedList<Node>();
        prev.add(pNode);
    }
}

public class Solution {
    ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        if(dict==null || dict.size()==0)
            return res;
        Queue<Node> q = new LinkedList<Node>();
        HashMap<String,Node> map = new HashMap<String, Node>();
        Node startN = new Node(start,0);
        Node endN = null;
        Node node = null;
        boolean isstop = false;
        q.offer(startN);
        while(!q.isEmpty() && !isstop){
            int count = q.size();
            for(int i = 0; i < count;i++){
                node = q.poll();
                for(int j = 0; j < node.str.length();j++){
                    for(char c = 'a';c<='z';c++){
                        String tmp = replace(node.str,j,c);
                        if(dict.contains(tmp)){
                            Node v = map.get(tmp);
                            if(v==null){
                                Node tmpNode = new Node(tmp,node.len+1);
                                tmpNode.addPrev(node);
                                q.add(tmpNode);
                                map.put(tmp,tmpNode);
                                if(tmp.equals(end)){
                                    endN = tmpNode;
                                    isstop = true;
                                }
                            }
                            else{
                                if(v.len == node.len+1)
                                    v.addPrev(node);
                            }
                        }
                    }
                }
            }
        }
        if(endN!=null){
            ArrayList<String> cur = new ArrayList<String>();
            cur.add(end);
            findPath(endN,cur,start);
        }
        return res;
    }
    
    public String replace(String str,int index, char c){
        char[] cs = str.toCharArray();
        cs[index] = c;
        return new String(cs);
    }
    
    public void findPath(Node node, ArrayList<String> cur,String start){
        if(node.str.equals(start)){
            ArrayList<String> tmp = new ArrayList<String>(cur);
            res.add(tmp);
            return;
        }
        for(Node n:node.prev){
            cur.add(0,n.str);
            findPath(n, cur, start);
            cur.remove(0);
        }
    }
}

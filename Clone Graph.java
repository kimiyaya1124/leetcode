/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null)
            return node;
        
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        nodes.add(node);
        map.put(node,new UndirectedGraphNode(node.label));
        int start = 0;
        while(start<nodes.size()){
            UndirectedGraphNode tmpNode = nodes.get(start);
            start++;
            for(int i = 0; i < tmpNode.neighbors.size();i++){
                UndirectedGraphNode neighbor = tmpNode.neighbors.get(i);
                if(!map.containsKey(neighbor)){
                    map.put(neighbor,new UndirectedGraphNode(neighbor.label));
                    nodes.add(neighbor);
                }
            }
        }
        
        for(int i = 0; i < nodes.size();i++){
            UndirectedGraphNode tmpNode = map.get(nodes.get(i));
            for(int j = 0; j < nodes.get(i).neighbors.size();j++){
                tmpNode.neighbors.add(map.get(nodes.get(i).neighbors.get(j)));
            }
        }
        
        return map.get(node);
    }
}

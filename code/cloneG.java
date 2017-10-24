/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {

private HashMap<Integer,UndirectedGraphNode> map = new HashMap<>();
    //map key int with undirectedGraphNode
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node); 
    }
    private UndirectedGraphNode clone (UndirectedGraphNode node)
    {
        if (node ==null) return null;
        if (map.containsKey(node.label))
        {
        return map.get(node.label);//if key already exist
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label,clone);
        for (UndirectedGraphNode neighbor : node.neighbors)
        {
            clone.neighbors.add(clone(neighbor));//recusively add all the neighbor's neighbors'
        }
        return clone;
    }
}
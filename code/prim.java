public class LazyPrim
{
 Edge[] pred = new Edge[G.V()];
 public LazyPrim(WeightedGraph G)
 {
 boolean[] marked = new boolean[G.V()];
 double[] dist = new double[G.V()];
 for (int v = 0; v < G.V(); v++)
 dist[v] = Double.POSITIVE_INFINITY;
 MinPQplus<Double, Integer> pq;
 pq = new MinPQplus<Double, Integer>();
 dist[s] = 0.0;
 pq.put(dist[s], s);
 while (!pq.isEmpty())
 {
 int v = pq.delMin();
 if (marked[v]) continue;
 marked(v) = true;
 for (Edge e : G.adj(v))
 {
 int w = e.other(v);
 if (!marked[w] && (dist[w] > e.weight() ))
 {
 dist[w] = e.weight();
 pred[w] = e;
 pq.insert(dist[w], w);
 }
 }
 }
 }
}

public class LazyDijkstra
{
 double[] dist = new double[G.V()];
 Edge[] pred = new Edge[G.V()];
 public LazyDijkstra(WeightedDigraph G, int s)
 {
 boolean[] marked = new boolean[G.V()];
 for (int v = 0; v < G.V(); v++)
 dist[v] = Double.POSITIVE_INFINITY;
 MinPQplus<Double, Integer> pq;
 pq = new MinPQplus<Double, Integer>();
 dist[s] = 0.0;
 pq.put(dist[s], s);
 while (!pq.isEmpty())
 {
 int v = pq.delMin();
 if (marked[v]) continue;
 marked(v) = true;
 for (Edge e : G.adj(v))
 {
 int w = e.to();
 if (dist[w] > dist[v] + e.weight())
 {
 dist[w] = dist[v] + e.weight();
 pred[w] = e;
 pq.insert(dist[w], w);
 }
 }
 }
 }
}
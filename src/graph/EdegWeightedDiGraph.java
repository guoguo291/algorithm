package graph;

import lineartable.Queue;

/**
 * @Author:guoj
 * @Time: 2021/10/14
 * @Description: 加权有向图
 */
public class EdegWeightedDiGraph {
    //顶点数目
    private int V;
    //边的数目
    private int E;
    //邻接表
    private Queue<DirectedEdge>[] adj;
    public EdegWeightedDiGraph(int V) {
        this.V=V;
        this.E=0;
        //初始化邻接表
        adj=new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i]=new Queue<DirectedEdge>();
        }
    }

    /**
     * 获取顶点数目
     * @return
     */
    public int getV(){
        return V;
    }
    /**
     * 获取边数目
     * @return
     */
    public int getE(){
        return E;
    }

    /**
     * 添加边
     * @param edge
     */
    public void addEdge(DirectedEdge edge){
        //需要让edge这个边同时出现在这个边的两个顶点的邻接表中
        int v = edge.from();
        adj[v].enqueue(edge);
        //边的数量+1
        E++;
    }

    /**
     * 获取和顶点v关联的所有边，v指出的边
     * @param v
     * @return
     */
    public Queue<DirectedEdge> adj(int v){
        return adj[v];
    }

    /**
     * 获取加权有向图的所有边
     * @return
     */
    public Queue<DirectedEdge> edges() {
        //创建一个队列保存所有的边
        Queue<DirectedEdge> edges = new Queue<>();
        //遍历所有的顶点,找到该顶点的邻接表，表中存储的是该顶点关联的边
        for (int i = 0; i < V; i++) {
            for (DirectedEdge edge : adj(i)) {
                    edges.enqueue(edge);
            }
        }
        return edges;
    }
}

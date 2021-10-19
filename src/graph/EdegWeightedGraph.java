package graph;

import lineartable.Queue;

/**
 * @Author:guoj
 * @Time: 2021/10/13
 * @Description: 加权无向图
 */
public class EdegWeightedGraph {
    //顶点数目
    private int V;
    //边的数目
    private int E;
    //邻接表
    private Queue<Edge>[] adj;
    public EdegWeightedGraph(int V) {
        this.V=V;
        this.E=0;
        //初始化邻接表
        adj=new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i]=new Queue<Edge>();
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
    public void addEdge(Edge edge){
        //需要让edge这个边同时出现在这个边的两个顶点的邻接表中
        int v = edge.either();
        int w = edge.other(v);
        adj[v].enqueue(edge);
        adj[w].enqueue(edge);
        //边的数量+1
        E++;
    }

    /**
     * 获取和顶点v关联的所有边
     * @param v
     * @return
     */
    public Queue<Edge> adj(int v){
        return adj[v];
    }

    /**
     * 获取加权无向图的所有边
     * @return
     */
    public Queue<Edge> edges() {
        //创建一个队列保存所有的边
        Queue<Edge> edges = new Queue<>();
        //遍历所有的顶点,找到该顶点的邻接表，表中存储的是该顶点关联的边
        for (int i = 0; i < V; i++) {
            for (Edge edge : adj(i)) {
                //因为无向图，同一条边会出现在它关联的两个顶点的邻接表中，所以要排除一个
                int other = edge.other(i);
                //当当前顶点小于边关联的另外一个顶点时，才加入的队列中，排除重复的情况
                if (i<other){
                    edges.enqueue(edge);
                }
            }

        }
        return edges;
    }
}

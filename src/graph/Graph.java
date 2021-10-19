package graph;


import lineartable.Queue;

/**
 * @Author:guoj
 * @Time: 2021/10/11
 * @Description: 无向图 以邻接表的数据结构来存储 空间复杂度低于邻接矩阵（O(n^2)）
 */
public class Graph {
    //顶点数目
    private int V;
    //边的数目
    private int E;
    //各顶点对应存储边的队列
    private Queue<Integer>[] adj;

    public Graph(int v) {
        this.V = v;
        this.E = 0;
        adj=new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i]=new Queue<Integer>();
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
     * 向图中增加一条边
     * @param v
     * @param w
     */
    public void addEdge(int v,int w){
        //无向图 v和w的邻接表中需要添加彼此
        adj[v].enqueue(w);
        adj[w].enqueue(v);
        E++;
    }

    /**
     * 获取和v相连的所有顶点
     * @param v
     * @return
     */
    public  Queue<Integer> adj(int v){
        return adj[v];
    }
}

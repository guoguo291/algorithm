package graph;


import lineartable.Queue;

/**
 * @Author:guoj
 * @Time: 2021/10/11
 * @Description: 有向图 以邻接表的数据结构来存储
 */
public class Digraph {
    //顶点数目
    private int V;
    //边的数目
    private int E;
    //各顶点对应存储边的队列
    private Queue<Integer>[] adj;

    public Digraph(int v) {
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
     * 向图中增加一条边v指向w
     * @param v
     * @param w
     */
    public void addEdge(int v,int w){
        //有向图 v的邻接表中增加w
        adj[v].enqueue(w);
        E++;
    }

    /**
     * 获取由v指出的边所连接的所有顶点
     * @param v
     * @return
     */
    public  Queue<Integer> adj(int v){
        return adj[v];
    }

    /**
     * 获取当前图的反向图
     * @return
     */
    private Digraph reverse(){
        Digraph reverse=new Digraph(V);
        //遍历所有的顶点
        for (int i = 0; i < V; i++) {
            //获取由顶点i指出的所有边
            for (Integer w : adj[i]) {
                //将w指向i
                reverse.addEdge(w,i);
            }
        }
        return reverse;
    }
}

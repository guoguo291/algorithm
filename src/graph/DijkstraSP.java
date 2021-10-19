package graph;

import heap.IndexMinPriorityQueue;
import lineartable.Queue;

/**
 * @Author:guoj
 * @Time:2021/10/15
 * @Description:
 */
public class DijkstraSP {
    //索引代表顶点，值表示从顶点s到当前顶点的最短路径上的最后一条边
    private DirectedEdge[] edgeTo;
    //索引代表顶点，值表示从顶点s到当前顶点的最短路径总权重
    private double[] distTo;
    //存放树中顶点与非树中顶点的有效横切边
    private IndexMinPriorityQueue<Double> pq;

    public DijkstraSP(EdegWeightedDiGraph G,int s) {
        //初始化edgeTo
        this.edgeTo=new DirectedEdge[G.getV()];
        //初始化distTo,先默认存储一个最大值
        this.distTo=new double[G.getV()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i]=Double.POSITIVE_INFINITY;
        }
        this.pq=new IndexMinPriorityQueue<>(G.getV());
        //将s作为起点
        distTo[s]=0.0;
        pq.insert(s,0.0);
        while (!pq.isEmpty()){
            relax(G, pq.delMin());
        }
    }

    /**
     * 松弛G图中的顶点v
     * @param G
     * @param v
     */
    private void relax(EdegWeightedDiGraph G,int v){
        //遍历顶点v的邻接表
        for (DirectedEdge edge : G.adj(v)) {
            int w = edge.to();
            //松弛v顶点，判断起点s到w的最短路径中是否包含v
            if (distTo[v]+edge.getWeight()<distTo[w]){
                //更新数据
                distTo[w]=distTo[v]+edge.getWeight();
                edgeTo[w]=edge;
                //判断pq中是否包含w
                if (pq.contains(w)) {
                    pq.changeItem(w, edge.getWeight());
                } else {
                    pq.insert(w, edge.getWeight());
                }
            }
        }
    }

    /**
     * 获取起点s到顶点v的最短路径的总权重
     * @param v
     * @return
     */
    public double distTo(int v){
        return distTo[v];
    }

    /**
     * 顶点s到v是否存在路径
     * @param v
     * @return
     */
    public boolean hasPathTo(int v){
        return distTo[v]<Double.POSITIVE_INFINITY;
    }

    /**
     * 返回起点s到顶点v的最小路径的边
     * @param v
     * @return
     */
    public Queue<DirectedEdge> pathTo(int v){
        Queue<DirectedEdge> edges = new Queue<>();
        while (true){
            DirectedEdge edge = edgeTo[v];
            if (edge==null){
                break;
            }
            edges.enqueue(edge);
            v=edge.from();
        }
        return edges;
    }
}

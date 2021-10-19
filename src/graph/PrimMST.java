package graph;

import heap.IndexMinPriorityQueue;
import lineartable.Queue;

/**
 * @Author:guoj
 * @Time: 2021/10/13
 * @Description: 最小生成树Prim算法
 */
public class PrimMST {
    //索引代表顶点，值表示当前顶点和最小生成树之间的最短边
    private Edge[] edgeTo;
    //索引代表顶点，值表示当前顶点和最小生成树之间的最短边的权重
    private Double[] distTo;
    //索引代表顶点，值表示是否已经在最小生成树中
    private boolean[] marked;
    //存放树中顶点和非树中顶点之间的有效横切边,非树中顶点为索引
    private IndexMinPriorityQueue<Double> pq;
    //根据加权无向图，创建最小生成树计算对象
    public PrimMST(EdegWeightedGraph G) {
        this.edgeTo=new Edge[G.getV()];
        this.distTo=new Double[G.getV()];
        for (int i = 0; i < distTo.length; i++) {
            //默认让distTo中的值为最大值
            distTo[i]=Double.POSITIVE_INFINITY;
        }
        this.marked=new boolean[G.getV()];
        this.pq=new IndexMinPriorityQueue<>(G.getV());
        //默认让0先进入树中,树中只有一个顶点所以没有和其他顶点相连的边，所以权重是0.0
        distTo[0]=0.0;
        pq.insert(0,0.0);
        //遍历索引最小优先队列，拿到最小横切边对应的顶点，把该顶点加入到最小生成树中
        while (!pq.isEmpty()){
            visit(G,pq.delMin());
        }
    }

    /**
     * 将顶点v添加到最小生成树中，并且更新数据
     * @param G
     * @param v
     */
    public void visit(EdegWeightedGraph G,int v){
        System.out.println("添加顶点"+v);
        //把顶点v添加到最小生成树中
        marked[v]=true;
        //更新数据
        for (Edge edge : G.adj(v)) {
            //获取边的另外一个顶点
            int w = edge.other(v);
            //判断另外一个顶点w是不是已经在树中了,不在树中才做处理
            if (marked[w]){
                continue;
            }
            //如果当前边的权重小于已经存在的w到树中的边的权重，则更新distTo和edgeTo
            if (edge.getWeight()<distTo[w]){
                edgeTo[w]=edge;
                distTo[w]=edge.getWeight();
                //判断pq中是否已经存在该顶点到树中的横切边
                if (pq.contains(w)){
                    pq.changeItem(w, edge.getWeight());
                }else {
                    pq.insert(w, edge.getWeight());
                }
            }
        }
    }

    /**
     * 获取最小生成树的所有边
     * @return
     */
    public Queue<Edge> edges(){
        //创建队列对象
        Queue<Edge> allEdges = new Queue<>();
        //遍历edgeto数组,不为null加入队列
        for (int i = 0; i < edgeTo.length; i++) {
            if (edgeTo[i]!=null){
                allEdges.enqueue(edgeTo[i]);
            }
        }
        return allEdges;
    }
}

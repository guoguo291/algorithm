package graph;

import heap.MinPriorityQueue;
import lineartable.Queue;
import tree.UF_Tree_Weighted;

/**
 * @Author:guoj
 * @Time: 2021/10/14
 * @Description: Kruskal算法  先找到所有边中权重最小的边，判断边的两个顶点是否在同一棵树中，不在的话合并到一起，继续遍历合并，直到生成最小生成树
 */
public class KruskalMST {
    //保存最小生成树的所有边
    private Queue<Edge> mst;
    //并查集，索引代表顶点，可以用来合并两个顶点到同一个树中，也可以判断两个顶点是否在同一个树中
    private UF_Tree_Weighted uf;
    //存储图中的所有边，使用最小优先队列，对边按照权重进行排序
    private MinPriorityQueue<Edge> pq;
    //根据一副加权无向图，计算最小生成树对象
    public KruskalMST(EdegWeightedGraph G){
        this.mst=new Queue<>();
        this.uf=new UF_Tree_Weighted(G.getV());
        this.pq=new MinPriorityQueue<>(G.getE());
        //把图中所有的边存储到pq中
        for (Edge edge : G.edges()) {
            pq.insert(edge);
        }
        //遍历找到最小权重的边
        while (!pq.isEmpty()&&mst.size()< G.getV()-1){
            //找到最小权重的边
            Edge minEdge = pq.delMin();
            int v = minEdge.either();
            int w = minEdge.other(v);
            if (uf.connected(v,w)){
                //两个顶点已经在同一颗树中直接返回
                continue;
            }
            //将两个顶点合并到一棵树中
            uf.union(v,w);
            //把边加入mst中
            mst.enqueue(minEdge);
        }
    }

    /**
     * 获取最小生成树中所有的边
     * @return
     */
    public Queue<Edge> edges(){
        return mst;
    }
}

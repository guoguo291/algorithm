package graph;

import lineartable.Queue;

/**
 * @Author:guoj
 * @Time: 2021/10/11
 * @Description: 广度优先搜索
 */
public class BreadthFirstSearch {
    //索引代表顶点，值代表是否被搜索过
    private boolean[] marked;
    //记录有多少个顶点与s相通
    private int count;
    //临时队列保存待搜索的顶点
    private Queue<Integer> waitSearch;
    //构建深度有限搜索
    public BreadthFirstSearch(Graph G, int s) {
        //初始化marked数组
        this.marked = new boolean[G.getV()];
        //初始化跟顶点s相通的顶点
        this.count = 0;
        this.waitSearch=new Queue<Integer>();
        bfs(G,s);
    }

    /**
     * 找出图G中与顶点V相通的顶点
     *
     * @param G
     * @param v
     */
    private void bfs(Graph G, int v) {
        //把v标识为已搜索
        marked[v] = true;
        //将v放入待搜索队列
        waitSearch.enqueue(v);
        //当待搜索队列不为空的时候，遍历队列
        while (!waitSearch.isEmpty()){
            Integer wait = waitSearch.dequeue();
            //遍历wait顶点的邻接表
            for (Integer w : G.adj(wait)) {
                //如果没有被搜索过，递归搜索
                if (!marked(w)){
                    bfs(G,w);
                }
            }
        }
        //相通顶点数量+1
        count++;
    }

    /**
     * 判断顶点w与顶点s是否相通
     * @param w
     * @return
     */
    public boolean marked(int w){
        return marked[w];
    }

    /**
     * 获取与顶点S相通的顶点数
     * @return
     */
    public int count(){
        return count;
    }
}

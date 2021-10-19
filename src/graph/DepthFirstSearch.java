package graph;

/**
 * @Author:guoj
 * @Time: 2021/10/11
 * @Description: 深度优先搜索
 */
public class DepthFirstSearch {
    //索引代表顶点，值代表是否被搜索过
    private boolean[] marked;
    //记录有多少个顶点与s相通
    private int count;

    //构建深度优先搜索
    public DepthFirstSearch(Graph G, int s) {
        //初始化marked数组
        this.marked = new boolean[G.getV()];
        //初始化跟顶点s相通的顶点
        this.count = 0;
        dfs(G,s);
    }

    /**
     * 找出图G中与顶点V相通的顶点
     *
     * @param G
     * @param v
     */
    private void dfs(Graph G, int v) {
        //把v标识为已搜索
        marked[v] = true;
        //遍历搜索与v相连接的顶点
        for (Integer w : G.adj(v)) {
            //判断当前顶点是否已经搜索过,没有被搜索过的话就递归进行深度优先搜索
            if (!marked[w]) {
                dfs(G, w);
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

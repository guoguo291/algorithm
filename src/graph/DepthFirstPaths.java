package graph;

import stack.Stack;

/**
 * @Author:guoj
 * @Time: 2021/10/11
 * @Description: 深度优先搜索 路径查找
 */
public class DepthFirstPaths {
    //索引代表顶点，值代表是否被搜索过
    private boolean[] marked;
    //起点S
    private int s;
    //索引代表顶点 值代表从s到达当前顶点路径上的最后一个顶点
    private int[] edgeTo;
    //构建深度优先搜索
    public DepthFirstPaths(Graph G, int s) {
        //初始化marked数组
        this.marked = new boolean[G.getV()];
        //初始化跟顶点s相通的顶点
        this.s = s;
        //初始化edgeTo
        this.edgeTo=new int[G.getV()];
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
                //记录顶点路径 到达w的路径上的最后一个顶点是v
                edgeTo[w]=v;
                dfs(G, w);
            }
        }
    }

    /**
     * 找出顶点s到v的路径（即该路径经过的顶点）
     * @param v
     * @return
     */
    public Stack<Integer> pathTo(int v){
        if (!hasPaths(v)){
            return null;
        }
        Stack<Integer> path=new Stack();
        //通过循环从v开始往前找，找到与起点相同时停止
        for (int w = v; w!=s ; w=edgeTo[w]) {
            path.push(w);
        }
        //将起点放入栈中
        path.push(s);
        return path;
    }
    /**
     * 判断顶点w与顶点s是否存在路径
     * @param w
     * @return
     */
    public boolean hasPaths(int w){
        return marked[w];
    }

}

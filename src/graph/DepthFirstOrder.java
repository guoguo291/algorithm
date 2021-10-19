package graph;

import stack.Stack;

/**
 * @Author:guoj
 * @Time: 2021/10/12
 * @Description: 基于深度优先的顶点排序
 */
public class DepthFirstOrder {
    private boolean marked[];
    //使用栈存储顶点序列
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph G) {
        this.marked=new boolean[G.getV()];
        this.reversePost=new Stack<>();
        //遍历图中每一个顶点，让每一个顶点作为入口,完成一次深度优先搜索
        for (int i = 0; i < G.getV(); i++) {
            if (!marked[i]){
                dfs(G,i);
            }
        }
    }

    /**
     * 基于深度优先搜索，从顶点v开始
     * @param G
     * @param v
     */
    private void dfs(Digraph G,int v){
        //标记当前顶点为搜索过的
        marked[v]=true;
        //循环搜索顶点v的邻接表
        for (Integer w : G.adj(v)) {
            if (!marked[w]){
                dfs(G,w);
            }
        }
        //搜索结束后将顶点v入栈加入序列
        reversePost.push(v);
    }

    /**
     * 返回有序的序列
     * @return
     */
    public Stack<Integer> reversePost(){
        return reversePost;
    }
}

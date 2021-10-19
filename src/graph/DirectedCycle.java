package graph;

import javax.xml.bind.annotation.W3CDomHandler;
import java.awt.font.TextHitInfo;

/**
 * @Author:guoj
 * @Time: 2021/10/12
 * @Description: 检测图中是否有有向环的对象
 */
public class DirectedCycle {
    //是否有环
    private boolean hasCycle;
    //是否被检测过
    private boolean[] marked;
    //顶点是否已经在检测队列中,索引是顶点，对应值标识是否存在队列中
    private boolean[] onstack;

    public DirectedCycle(Digraph G) {
        this.hasCycle = false;
        this.marked=new boolean[G.getV()];
        this.onstack=new boolean[G.getV()];
        //遍历每一个顶点，检测是否有环
        for (int i = 0; i < G.getV(); i++) {
            //没有被搜索过，则遍历检测
            if (!marked[i]){
                dfs(G,i);
            }
        }
    }
    //基于深度优先搜索检测图中是否有环
    private void dfs(Digraph G,int v){
        //标识当前顶点v为已搜索
        marked[v]=true;
        //把当前顶点入栈
        onstack[v]=true;
        //搜索 遍历v顶点的邻接表
        for (Integer w : G.adj(v)) {
            //当前顶点没有被搜索过则继续进行深度搜索
            if (!marked[w]){
                dfs(G, w);
            }
            //当前顶点已经搜索过了，那么检测当前顶点是否在栈中
            if (onstack[w]){
                hasCycle=true;
                return;
            }
        }
        //让当前顶点出栈
        onstack[v]=false;
    }
    public boolean hasCycle(){
        return hasCycle;
    }
}

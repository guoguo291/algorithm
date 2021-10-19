package graph;

import stack.Stack;

/**
 * @Author:guoj
 * @Time: 2021/10/12
 * @Description: 拓扑排序
 */
public class TopoLogical {
    //顶点的拓扑序列
    private Stack<Integer> order;
    public TopoLogical(Digraph G){
        DirectedCycle directedCycle=new DirectedCycle(G);
        //检测是否有环,没有环则对图进行深度优先排序
        if (!directedCycle.hasCycle()){
            DepthFirstOrder depthFirstOrder=new DepthFirstOrder(G);
            order=depthFirstOrder.reversePost();
        }
    }
    public boolean hasCycle(){
        return order==null;
    }
    public Stack<Integer> getOrder(){
        return order;
    }
}

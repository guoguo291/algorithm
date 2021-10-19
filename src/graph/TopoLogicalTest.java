package graph;

import stack.Stack;

/**
 * @Author:guoj
 * @Time:2021/10/12
 * @Description:
 */
public class TopoLogicalTest {
    public static void main(String[] args) {
        //构建有向图
        Digraph digraph = new Digraph(6);
        digraph.addEdge(0,2);
        digraph.addEdge(0,3);
        digraph.addEdge(2,4);
        digraph.addEdge(3,4);
        digraph.addEdge(4,5);
        digraph.addEdge(1,3);
        TopoLogical topoLogical = new TopoLogical(digraph);
        boolean hasCycle = topoLogical.hasCycle();
        Stack<Integer> order = topoLogical.getOrder();
        System.out.println("是否有环："+hasCycle);
        for (Integer integer : order) {
            System.out.print("->"+integer);
        }
    }
}

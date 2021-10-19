package graph;

/**
 * @Author:guoj
 * @Time:2021/10/11
 * @Description:
 */
public class GraphTest {
    public static void main(String[] args) {
        Graph g=new Graph(13);
        g.addEdge(0,5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,6);
        g.addEdge(5,3);
        g.addEdge(5,4);
        g.addEdge(3,4);
        g.addEdge(4,6);

        g.addEdge(7,8);

        g.addEdge(9,11);
        g.addEdge(9,12);
        g.addEdge(9,10);
        g.addEdge(11,12);

//        DepthFirstSearch search=new DepthFirstSearch(g,0);
        BreadthFirstSearch search=new BreadthFirstSearch(g,0);
        System.out.println("与0相通的顶点数目："+search.count());
        System.out.println("4与0是否相通："+search.marked(4));
        System.out.println("11与0是否相通："+search.marked(11));


    }
}

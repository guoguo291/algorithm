package graph;

import lineartable.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author:guoj
 * @Time:2021/10/14
 * @Description:
 */
public class MSTTest {
    public static void main(String[] args) throws IOException {
        //准备加权无向图
        BufferedReader br = new BufferedReader(new InputStreamReader(MSTTest.class.getClassLoader().getResourceAsStream("primmst.txt")));
        //读第一行总边数 8
        int totalNum = Integer.parseInt(br.readLine());
        //读第一行边的数目 16
        int edgeNum = Integer.parseInt(br.readLine());
        //构建图对象
        EdegWeightedGraph G = new EdegWeightedGraph(totalNum);
        //循环读取已经存在的16条边
        for (int i = 0; i < edgeNum; i++) {
            String line = br.readLine();//4 5 0.35
            String[] strs = line.split(" ");
            int p = Integer.parseInt(strs[0]);
            int q = Integer.parseInt(strs[1]);
            double weight = Double.parseDouble(strs[2]);
            //构建加权无向边
            Edge edge=new Edge(p,q,weight);
            G.addEdge(edge);
        }
        System.out.println("图中所有的边数目："+G.getE());
        //计算加权无向图中的最小生成树
//        PrimMST mst = new PrimMST(G);
        KruskalMST mst = new KruskalMST(G);
        Queue<Edge> edges = mst.edges();
        for (Edge edge : edges) {
            int v=edge.either();
            int w=edge.other(v);
            double weight = edge.getWeight();
            System.out.println(v+"--"+w+","+weight);
        }
    }
}

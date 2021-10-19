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
public class DijkstraTest {
    public static void main(String[] args) throws IOException {
        //准备加权无向图
        BufferedReader br = new BufferedReader(new InputStreamReader(DijkstraTest.class.getClassLoader().getResourceAsStream("min_road_path.txt")));
        //读第一行总边数 8
        int totalNum = Integer.parseInt(br.readLine());
        //读第一行边的数目 15
        int edgeNum = Integer.parseInt(br.readLine());
        //构建图对象
        EdegWeightedDiGraph G = new EdegWeightedDiGraph(totalNum);
        //循环读取已经存在的15条边
        for (int i = 0; i < edgeNum; i++) {
            String line = br.readLine();//4 5 0.35
            String[] strs = line.split(" ");
            int p = Integer.parseInt(strs[0]);
            int q = Integer.parseInt(strs[1]);
            double weight = Double.parseDouble(strs[2]);
            //构建加权无向边
            DirectedEdge edge=new DirectedEdge(p,q,weight);
            G.addEdge(edge);
        }
        //计算加权有向图中的最短路径生成树
        DijkstraSP mst = new DijkstraSP(G,0);
        Queue<DirectedEdge> edges = mst.pathTo(6);
        for (DirectedEdge edge : edges) {
            int v=edge.from();
            int w=edge.to();
            double weight = edge.getWeight();
            System.out.println(v+"->"+w+","+weight);
        }
    }
}

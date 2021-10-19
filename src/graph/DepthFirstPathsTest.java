package graph;

import stack.Stack;
import tree.UF_Tree_Weighted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author:guoj
 * @Time: 2021/10/11
 * @Description:
 */
public class DepthFirstPathsTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(DepthFirstPathsTest.class.getClassLoader().getResourceAsStream("depthFirstPaths.txt")));
        //读第一行总边数
        int totalNum = Integer.parseInt(br.readLine());
        //读第一行边的数目 8
        int roadNum = Integer.parseInt(br.readLine());
        //构建图对象
        Graph G = new Graph(totalNum);
        //循环读取已经存在的8条边
        for (int i = 0; i < roadNum; i++) {
            String line = br.readLine();
            String[] strs = line.split(" ");
            int p = Integer.parseInt(strs[0]);
            int q = Integer.parseInt(strs[1]);
            //链接两个顶点
            G.addEdge(p,q);
        }
        //构建路径搜索对象,起点是0
        DepthFirstPaths depthFirstPaths = new DepthFirstPaths(G, 0);
        System.out.println("0到顶点4存在路径："+depthFirstPaths.hasPaths(4));
        Stack<Integer> path = depthFirstPaths.pathTo(4);
        //遍历栈对象
        for (Integer w : path) {
            System.out.print(w+"-");
        }
    }
}

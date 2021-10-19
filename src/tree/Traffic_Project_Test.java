package tree;

import com.sun.istack.internal.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Author:guoj
 * @Time: 2021/10/9
 * @Description: 村村通工程
 */
public class Traffic_Project_Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(Traffic_Project_Test.class.getClassLoader().getResourceAsStream("traffic_project.txt")));
        //读第一行总村数
        int totalNum = Integer.parseInt(br.readLine());
        //读第一行已经通路的分组数目 7
        int roadNum = Integer.parseInt(br.readLine());
        //构建查找对象
        UF_Tree_Weighted uf = new UF_Tree_Weighted(totalNum);
        //循环读取已经存在的七条路
        for (int i = 0; i < roadNum; i++) {
            String line = br.readLine();
            String[] strs = line.split(" ");
            int p = Integer.parseInt(strs[0]);
            int q = Integer.parseInt(strs[1]);
            //调用并查集的union让两城市相通
            uf.union(p,q);
        }
        //获取当前并查集中的分组数-1 得到需要修建道路的数目
        System.out.println("还需要修建路的数目："+(uf.count()-1));
    }
}

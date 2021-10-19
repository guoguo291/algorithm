package tree;

import java.util.Scanner;

/**
 * @Author:guoj
 * @Time:2021/10/9
 * @Description:
 */
public class UFTest {
    public static void main(String[] args) {
        //创建并查集对象
//        UF uf = new UF(5);
//        UF_Tree uf = new UF_Tree(5);
        UF_Tree_Weighted uf = new UF_Tree_Weighted(5);
        System.out.println("默认情况，并查集中有："+uf.count()+"个分组");
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入第一个要合并的元素：");
            int p=scanner.nextInt();
            if (p>=5){
                System.out.println("请输入大于等于0小于5的数据");
                continue;
            }
            System.out.println("请输入第二个要合并的元素：");
            int q=scanner.nextInt();
            if (q>=5){
                System.out.println("请输入大于等于0小于5的数据");
                continue;
            }
            //判断两个元素是否已经在同一分组中
            if (uf.connected(p,q)){
                System.out.println(p+"和"+q+"已经在同一分组中了");
                continue;
            }
            uf.union(p,q);
            System.out.println(p+"和"+q+"已经合并了，当前分组数为："+uf.count());
        }
    }
}

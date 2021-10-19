package tree;

/**
 * @Author:guoj
 * @Time: 2021/10/9
 * @Description: 并查集优化 路径压缩
 */
public class UF_Tree_Weighted {
    //记录并查集中的数据分组数目
    private int count;
    //记录节点元素与该元素所在分组的标识
    private int[] eleAndGroup;
    //记录分组中元素个数
    private int[] sz;
    //初始化并查集
    public UF_Tree_Weighted(int N){
        //初始化count
        this.count=N;
        //初始化eleAndGroup
        eleAndGroup=new int[N];
        //初始化eleAndGroup中的元素,索引作为值，值是对应父结点的值
        for (int i = 0; i < N; i++) {
            eleAndGroup[i]=i;
        }
        //初始化sz 默认都为1
        sz=new int[N];
        for (int i = 0; i < N; i++) {
            sz[i]=1;
        }
    }

    /**
     * 获取并查集中的数据分组数目
     * @return
     */
    public int count(){
        return count;
    }

    /**
     * 元素P所在分组的标识符
     * @param p
     * @return
     */
    private int find(int p){
        while (true){
            if (p==eleAndGroup[p]){
                return p;
            }
            p=eleAndGroup[p];
        }
    }

    /**
     * 判断并查集中元素p和q是否在同一分组中
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p,int q){
        return find(p)==find(q);
    }

    /**
     * 把p和q所在的分组合并,要合并所有的分组时间复杂度为O(N)
     * @param p
     * @param q
     */
    public void union(int p,int q){
        //如果同一组直接返回
        if (connected(p,q)){
            return;
        }
        //不在同一组
        //找到p的分组标识
        int pGroup = find(p);
        //找到q的分组标识
        int qGroup = find(q);
        //合并p和q所在分组,将节点少的合并到节点多的分组（树）上
        if (sz[pGroup]<sz[qGroup]){
            //将p合并到q上
            eleAndGroup[pGroup]=qGroup;
            sz[qGroup]+=sz[pGroup];
        }else {
            //将q合并到p上
            eleAndGroup[qGroup]=pGroup;
            sz[pGroup]+=sz[qGroup];
        }
        //分组个数减1
        this.count--;
    }
}

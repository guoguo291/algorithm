package heap;

/**
 * @Author:guoj
 * @Time:2021/9/28
 * @Description: 最小索引优先队列
 */
public class IndexMinPriorityQueue<T extends Comparable<T>>{
    private int N;
    private T[] items;
    private int[] pq;//存放items中值对应的索引，pq是按照items的值的大小有序排列的，是堆调整后的顺序
    private int[] qp;//是pq的逆序，键为pq的值，值为pq对应的键，相当于pq队列交换键和值
    public IndexMinPriorityQueue(int capacity){
        this.N=0;
        //由于废弃了0索引位置，所以数组大小=实际容量+1
        items= (T[]) new Comparable[capacity+1];
        pq= new int[capacity + 1];
        qp= new int[capacity + 1];
        //默认情况下队列中没有任何数据
        for (int i = 0; i < qp.length; i++) {
            qp[i]= (-1);
        }
    }
    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N==0;
    }
    /**
     * 判断索引i处的值是否小于索引j处的值
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i,int j){
        //比较索引i 和j处的值  pq中i和j存的是索引，应该找到索引对应的值来比较
        return items[pq[i]].compareTo(items[pq[j]])<0;
    }

    /**
     * 返回最小元素关联的索引
     * @return
     */
    public  int minIndex(){
        return pq[1];
    }

    /**
     * 交换索引i和j处的值，这里只调整pq中的值，items中的值是不变的，要用来映射查找元素
     * @param i
     * @param j
     */
    private void   exch(int i,int j){
        //交换pq中两个索引对应的值
        int tempi=pq[i];
        pq[i]=pq[j];
        pq[j]=tempi;
        //更新qp中两个索引位置的值
        qp[pq[i]]=i;
        qp[pq[j]]=j;
    }

    /**
     * 判断key对应的元素是否存在
     * @param key
     * @return
     */
    public boolean contains(int key){

      return qp[key]!=-1;
    }

    /**
     * 往队列中插入元素并关联索引i
     * @param i
     * @param t
     */
     public void insert(int i,T t){
         //如果i已经被关联则不允许插入
         if (contains(i)){
             return;
         }
         items[i]=t;
         //元素个数加1
         N++;
         //将i存储到pq中
         pq[N]=i;
         //将N存储与qp中
         qp[i]=N;
         //通过上浮完成堆调整 调整的pq中的最后一个元素
         swim(N);
     }

    /**
     * 删除堆中最小的元素，并返回元素对应的索引  即items[]中对应的索引
     * @return
     */
    public int delMin(){
        int minDataIndex=pq[1];
        //交换pq中最小和最大索引处的值
        exch(1,N);
        //删除item中对应位置的值
        items[pq[N]]=null;
        //删除qp中对应的值为-1
        qp[pq[N]]=-1;
        //删除pq最大索引处的值
        pq[N]=-1;
        N--;
        //通过下沉重新调整顺序
        sink(1);
        return minDataIndex;
    }

    /**删除索引i对应的元素
     * @param i
     */
    public void delete(int i){
        //找到pq中i对应的索引
        int pqindex = qp[i];
        //交换pq中的索引与最后的索引位置
        exch(pqindex,N);
        //删除items中的内容
        items[pq[N]]=null;
        //删除qp中的内容
        qp[pq[N]]=-1;
        //删除pq中的内容
        pq[N]=-1;
        N--;
        //堆调整，下沉
        sink(pqindex);
//        swim(pqindex);
    }
    public void changeItem(int i,T t){
        //修改items对应索引的值
        items[i]=t;
        //调整pq列中的堆顺序
        //先找到pq中i对应的索引k
        int k=qp[i];
        //调整堆的顺序
        sink(k);
        swim(k);

    }

    /**
     * 上浮元素，放到合适的位置，小的元素往上放
     * @param k
     */
    private void swim(int k) {
        //循环比较k与父结点的大小，父结点大于当前k节点则交换位置
        while (k>1){//k=1时已经没有父结点，跳出循环
            if (less(k,k/2)){  //k的父结点为k/2
                //小于父结点交换位置
                exch(k,k/2);
                //变换k的值
                k=k/2;
            }else {
                return;
            }
        }
    }
    /**
     * 下沉算法，通过下沉找到结点合适的位置，小的往上放
     * @param k
     */
    private void sink(int k) {
        //循环遍历与左右子节点中的较大值比较，判断是否来交换位置
        while(2*k<=N){//有一个左子节点，才循环比较
            //获取子节点中的较小值
            int min;//记录较小结点
            if (2*k+1<=N){
                if (less(2*k,2*k+1)){
                    min=2*k;
                }else {
                    min=2*k+1;
                }
            }else{//没有右子节点
                min=2*k;
            }
           //比较当前节点与较小子结点
            if (less(k,min)){//如果当前节点的值小于较小结点的值，直接结束循环
                break;
            }
            //min位置的元素值大，交换元素位置
            exch(k,min);
            //变换k的值
            k=min;
        }
    }
}

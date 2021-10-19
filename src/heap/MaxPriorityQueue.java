package heap;

/**
 * @Author:guoj
 * @Time:2021/9/26
 * @Description: 最大优先队列，传统队列是先进先出的结构，最大优先队列有优先级，可以取出优先级最大的值
 */
public class MaxPriorityQueue<T extends Comparable<T>>{
    private int N;
    private T[] items;
    public MaxPriorityQueue(int capacity){
        this.N=0;
        //由于废弃了0索引位置，所以数组大小=实际容量+1
        items= (T[]) new Comparable[capacity+1];
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
        return items[i].compareTo(items[j])<0;
    }

    /**
     * 交换索引i和j处的值
     * @param i
     * @param j
     */
    private void exch(int i,int j){
        T temp = items[i];
        items[i]=items[j];
        items[j]=temp;
    }
     public void insert(T t){
        items[++N]=t;
        swim(N);
     }

    /**
     * 上浮元素，放到合适的位置
     * @param k
     */
    private void swim(int k) {
        //循环比较k与父结点的大小，父结点小于当前k节点则交换位置
        while (k>1){//k=1时已经没有父结点，跳出循环
            if (less(k/2,k)){  //k的父结点为k/2
                //交换位置
                exch(k,k/2);
                //变换k的值
                k=k/2;
            }else {
                return;
            }

        }
    }

    /**
     * 删除堆中最大的元素，直接交换堆中最大元素与最后一个元素的位置，然后首个节点再下沉交换位置
     * @return
     */
    public T delMax(){
        T max = items[1];
        //交换索引1和最大索引处的元素，让最后一个元素当作临时根结点
        exch(1,N);
        //将最后一个结点删除，元素数减少1
        items[N--]=null;
        //通过下沉重新调整顺序
        sink(1);
        return max;
    }

    /**
     * 下沉算法，通过下沉找到结点合适的位置
     * @param k
     */
    private void sink(int k) {
        //循环遍历与左右子节点中的较大值比较，判断是否来交换位置
        while(2*k<=N){//有一个左子节点，才循环比较
            //获取子节点中的较大值
            int max;//记录较大结点
            if (2*k+1<=N){
                if (less(2*k,2*k+1)){
                    max=2*k+1;
                }else {
                    max=2*k;
                }
            }else{//没有右子节点
                max=2*k;
            }
           //比较当前节点与较大子结点
            if (!less(k,max)){//如果当前节点的值大于较大结点的值，直接结束循环
                break;
            }
            //max位置的元素值大，交换元素位置
            exch(k,max);
            //变换k的值
            k=max;
        }
    }
}

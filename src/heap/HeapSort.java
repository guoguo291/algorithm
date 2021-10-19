package heap;

import java.util.Arrays;

/**
 * @Author:guoj
 * @Time:2021/9/26
 * @Description: 堆排序
 */
public class HeapSort{

    /**
     * 判断索引i处的值是否小于索引j处的值
     * @param i
     * @param j
     * @return
     */
    private static boolean less(Comparable[] heap, int i, int j){
        return heap[i].compareTo(heap[j])<0;
    }

    /**
     * 交换索引i和j处的值
     * @param i
     * @param j
     */
    private static void exch(Comparable[] heap, int i, int j){
        Comparable temp = heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }
    //根据原数组创建堆
    private static void createHeap(Comparable[] source, Comparable[] heap){
        //拷贝数组生成一个无序的堆
        System.arraycopy(source,0,heap,1,source.length);
        //将堆做下沉排序，从长度的一半处，从右往左扫描
        for (int i=source.length/2;i>0;i--){
            sink(heap,i,heap.length-1);
        }
    }

    /**
     * 对source中元素进行排序
     * @param source
     */
    public static void sort(Comparable[] source){
        Comparable[] heap=new Comparable[source.length+1];
        //构建堆
        createHeap(source,heap);
        //记录堆中最后一个元素位置
        int N=heap.length-1;
        //循环交换第一个与最后一个元素，进行下沉
        while (N!=1){
            exch(heap,1,N);
            //交换后N减小 原先的最后一个元素已经最大，不参与下沉
            N--;
            sink(heap,1,N);
        }
        //将堆中排序后的数组复制到原数组中
        System.arraycopy(heap,1,source,0,source.length);
    }

    /**
     * 在堆中 target处的元素做下沉，范围是0-range
     * @param heap
     * @param target
     * @param range
     */
    private static void sink(Comparable[] heap, int target, int range) {
        while(2*target<=range){
            int max;
            //找出target的子节点中的较大值的索引
            if (2*target+1<=range){
                if (less(heap,2*target,2*target+1)){
                    max=2*target+1;
                }else {
                    max=2*target;
                }
            }else {
                //只有左子节点
                max=2*target;
            }
            //比较较大子节点与当前子节点的值，当前子节点大，直接结束
            if (!less(heap,target,max)){
                break;
            }
            //子节点中的值大,交换target与子节点
            exch(heap,target,max);
            //变换target的值
            target=max;
        }
    }
}

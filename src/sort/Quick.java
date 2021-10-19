package sort;

/**
 * @Author:guoj
 * @Time:2021/9/13
 * @Description: 快速排序，找到分界值分成两个组，比分界值大的放到右子组，小的放到左子组，时间复杂度平均及最优情况O(nlogn)，最差O(n^2)
 */
public class Quick {
    public static void sort(Comparable[] datas){

        sort(datas,0,datas.length-1);
    }
    private static void sort(Comparable[] datas,int lo,int hi){
        if (lo>=hi){
            return;
        }
        //对数组找到分界点进行分组,返回分界值索引
        int partition=partition(datas, lo, hi);
        //对左子组进行排序
        sort(datas, lo, partition-1);
        //对右子组进行排序
        sort(datas, partition+1, hi);
    }
    //返回数组的分界点
    private static int partition(Comparable[] datas,int lo,int hi){
        //确定分界值
        Comparable partition=datas[lo];
        //定义左右指针
        int left=lo;
        int right=hi+1;
        while (left<right){
            //右指针向左移动找到比分界值小的元素位置停止
            while (less(partition,datas[--right])){
                //超出边界时也停止
                if (right==lo){
                    break;
                }
            }
            //左指针向左移动找到比分界值大的元素位置停止
            while (less(datas[++left],partition)){
                if (left==hi){
                    break;
                }
            }
            if (left>=right){
                break;
            }else {
                exchange(datas,left,right);
            }
        }
        //交换分界值
        exchange(datas,lo,right);
        return right;
    }
    /**
     * 比较a的值是否小于b
     */
    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b)<0;
    }
    private static void exchange(Comparable[] datas,int i,int j){
        Comparable temp=datas[i];
        datas[i]=datas[j];
        datas[j]=temp;
    }
}

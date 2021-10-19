package sort;

/**
 * @Author:guoj
 * @Time:2021/9/12
 * @Description: 归并排序,时间复杂度O(nlogn)
 */
public class Merge {
    //辅助数组
    private static Comparable[] assist;
    public static void sort(Comparable[] datas){

        sort(datas,0,datas.length-1);
    }
    private static void sort(Comparable[] datas,int lo,int hi){
        if (lo>=hi){
            return;
        }
        //将数组datas的lo到hi索引的数组再分成两组
        int mid=(lo+hi)/2;
        //分别对两组数据排序
        sort(datas,lo,mid);
        sort(datas,mid+1,hi);
        //将两组排完顺序的数组进行归并
        merge(datas,lo,mid,hi);
    }

    /**
     * 数组datas中的两个子数组lo到mid，mid+1到hi，合并两个子数组成为一个有序的大数组
     * @param datas
     * @param lo
     * @param mid
     * @param hi
     */
    private static void merge(Comparable[] datas,int lo,int mid,int hi){
        //初始化辅助数组
        assist=new Comparable[datas.length];
        //定义三个指针
        int p1=lo;
        int p2=mid+1;
        int i=lo;
        //遍历，移动p1和p2指针，找出p1与p2指针对应索引处的数据进行比较，把小的放到辅助数组的索引i处
        while (p1<=mid && p2<=hi){
            if (less(datas[p1],datas[p2])){
                assist[i++]=datas[p1++];
            }else {
                assist[i++]=datas[p2++];
            }
        }
        //遍历，如果P1指针没有走完，顺序移动P1,把对应数据放到辅助数组的对应索引处
        while (p1<=mid){
            assist[i++]=datas[p1++];
        }
        //遍历，如果P2指针没有走完，顺序移动P2,把对应数据放到辅助数组的对应索引处
        while (p2<=hi){
            assist[i++]=datas[p2++];
        }
        //拷贝辅助数组中的元素到原数组
        for (int j = lo; j <= hi; j++) {
            datas[j]=assist[j];
        }
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

package sort;

/**
 * @Author:guoj
 * @Time:2021/9/10
 * @Description: 选择排序 时间复杂度O(N^2)
 */
public class Selection {
    public static void sort(Comparable[] datas){
        for (int i = 0; i <datas.length-1; i++) {
            int minIndex=i;
            for (int j = i+1; j < datas.length; j++) {
                if (greater(datas[i],datas[j])){
                    //将索引更改为小的值的索引
                    minIndex=j;
                }
            }
            //交换当前索引与最小索引初的值
            exchange(datas,i,minIndex);
        }
    }

    /**
     * 比较a的值是否大于b
     */
    private static boolean greater(Comparable a, Comparable b){
        return a.compareTo(b)>0;
    }
    private static void exchange(Comparable[] datas,int i,int j){
        Comparable temp=datas[i];
        datas[i]=datas[j];
        datas[j]=temp;
    }
}

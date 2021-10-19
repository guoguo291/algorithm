package sort;

/**
 * @Author:guoj
 * @Time:2021/9/10
 * @Description: 插入排序,时间复杂度O(N^2)
 */
public class Insertion {
    public static void sort(Comparable[] datas){
        for (int i = 1; i <datas.length; i++) {
            for (int j = i; j >0; j--) {
                //比较j-1和j处的值,j-1处的值大就交换顺序，继续向前比较，否则已经有序，跳出循环
                if (greater(datas[j-1],datas[j])){
                    exchange(datas,j-1,j);
                }else {
                    //有序部分就不再比较了
                    break;
                }
            }
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

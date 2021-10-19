package sort;
/**
 * @Author:guoj
 * @Time:2021/9/10
 * @Description: 冒泡排序，时间复杂度O(N^2)
 */
public class Bubble {
    public static void sort(Comparable[] datas){
        for (int i = datas.length-1; i >0; i--) {
            for (int j = 0; j < i; j++) {
                if (greater(datas[j],datas[j+1])){
                    exchange(datas,j,j+1);
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

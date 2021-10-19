package sort;

/**
 * @Author:guoj
 * @Time:2021/9/10
 * @Description: 希尔排序，时间复杂度是排序的稳定性影响O(n^（1.3—2）)
 */
public class Shell {
    public static void sort(Comparable[] datas){
        //1.根据数组的长度确定增量h
        int h=1;
        while(h<datas.length/2){
            h=2*h+1;
        }
        //2.进行分组排序，索引0到0+h为一组，1到1+h为一组以此类推
        while (h>=1){
            //2.1找到待插入数据 索引为h
            for (int i = h; i < datas.length; i++) {
                //2.2把待插入的元素插入到有序数列中，假如总长度5，h为2，则索引0,2,4为一组
                for (int j = i; j >=h ; j-=h) {
                     if (greater(datas[j-h],datas[j])){
                         exchange(datas,j,j-h);
                     }else {
                         break;
                     }
                }
            }
            //减小h的值
            h=h/2;
        }
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

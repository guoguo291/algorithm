package sort;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        Integer[] datas={1,5,6,4,3,2,7,8};
//        Bubble.sort(datas);
//        Selection.sort(datas);
//        Insertion.sort(datas);
//        Shell.sort(datas);
//        Merge.sort(datas);
        Quick.sort(datas);
        System.out.println(Arrays.toString(datas));
    }
}

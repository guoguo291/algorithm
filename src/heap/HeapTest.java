package heap;

import java.util.Arrays;

/**
 * @Author:guoj
 * @Time:2021/9/26
 * @Description:
 */
public class HeapTest {
    public static void main(String[] args) {
        Heap<String> heap = new Heap<>(10);
        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        heap.insert("E");
        heap.insert("F");
        heap.insert("G");
        System.out.println("元素个数："+heap.size());
        String result;
        while((result=heap.delMax())!=null){
            System.out.print(result+" ");
        }
        System.out.println();
        String[] strs={"B","A","C","E","F","D","G","H"};
        HeapSort.sort(strs);
        System.out.println(Arrays.toString(strs));
        //测试最大优先对列
//        MaxPriorityQueue<String> queue = new MaxPriorityQueue<>(10);
        MinPriorityQueue<String> queue = new MinPriorityQueue<>(10);
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("G");
        queue.insert("E");
        queue.insert("F");
        System.out.println("优先队列元素个数："+queue.size());
        String value;
        while(!queue.isEmpty()){
//            value= queue.delMax();
            value= queue.delMin();
            System.out.print(value+" ");
        }
    }
}

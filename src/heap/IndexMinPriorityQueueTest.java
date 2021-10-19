package heap;

/**
 * @Author:guoj
 * @Time:2021/9/28
 * @Description:
 */
public class IndexMinPriorityQueueTest {
    public static void main(String[] args) {
        IndexMinPriorityQueue<String> queue = new IndexMinPriorityQueue<>(10);
        queue.insert(0,"C");
        queue.insert(1,"A");
        queue.insert(2,"F");

        System.out.println("最小元素对应的索引："+queue.minIndex());
        System.out.println("删除的最小元素索引："+queue.delMin());
        System.out.println("队列元素数："+queue.size());
        System.out.println("队列中索引1处是否有值："+queue.contains(1));
        queue.insert(1,"D");
        System.out.println("最小元素对应的索引："+queue.minIndex());
        queue.delete(0);
        System.out.println("最小元素对应的索引："+queue.minIndex());
        System.out.println("队列是否为空："+queue.isEmpty());


    }
}

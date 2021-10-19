package lineartable;

/**
 * @Author:guoj
 * @Time:2021/9/18
 * @Description:
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue=new Queue<>();
        System.out.println("是否为空："+queue.isEmpty());
        queue.enqueue("aa");
        queue.enqueue("bb");
        queue.enqueue("cc");
        queue.enqueue("dd");
        for (String str:queue) {
            System.out.println("队列元素："+str);
        }
        System.out.println("size:"+queue.size());
        System.out.println("是否为空："+queue.isEmpty());
        System.out.println("--------------");
        System.out.println("删除元素："+queue.dequeue());
        System.out.println("元素个数："+queue.size());
        queue.enqueue("ee");
        System.out.println("添加元素后个数："+queue.size());
        for (String s:queue) {
            System.out.println("元素："+s);
        }
    }
}

package lineartable;

/**
 * @Author:guoj
 * @Time:2021/9/14
 * @Description:
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> linkedlist = new LinkedList<>();
//        DualLinkedList<String> linkedlist = new DualLinkedList<>();
        System.out.println("isempty:"+linkedlist.isEmpty());
        linkedlist.insert("000");
        linkedlist.insert("111");
        linkedlist.insert("222");
        linkedlist.insert("333");
        linkedlist.insert("444");
        for (Object t : linkedlist) {
            System.out.println(t);
        }
        System.out.println("------------------");
        linkedlist.reverse();
        for (Object t : linkedlist) {
            System.out.println(t);
        }
//        System.out.println("FIRST:"+linkedlist.getFirst());
//        System.out.println("LAST:"+linkedlist.getLast());
        System.out.println("------------------");
        System.out.println("isempty:"+linkedlist.isEmpty());
        System.out.println("length:"+linkedlist.length());
        System.out.println("index 1:"+linkedlist.get(1));
        System.out.println("222 index:"+linkedlist.indexOf("222"));
        System.out.println("insert vvv into index 2:");
        linkedlist.insert(2,"vvv");
        System.out.println("2 index:"+linkedlist.get(2));
        System.out.println("3 index:"+linkedlist.get(3));
        System.out.println("5 index:"+linkedlist.get(5));
        System.out.println("index 2 removed:"+linkedlist.remove(2));
        System.out.println("index 2 :"+linkedlist.get(2));
    }
}

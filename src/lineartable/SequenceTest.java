package lineartable;

/**
 * @Author:guoj
 * @Time:2021/9/13
 * @Description:
 */
public class SequenceTest {
    public static void main(String[] args) {
        SequenceList<String> sequenceList = new SequenceList<>(10);
        System.out.println("isempty:"+sequenceList.isEmpty());
        sequenceList.insert("000");
        sequenceList.insert("111");
        sequenceList.insert("222");
        sequenceList.insert("333");
        sequenceList.insert("444");
        for (Object t : sequenceList) {
            System.out.println(t);
        }
        System.out.println("--------------------");
        System.out.println("isempty:"+sequenceList.isEmpty());
        System.out.println("length:"+sequenceList.length());
        System.out.println("index 1:"+sequenceList.get(1));
        System.out.println("222 index:"+sequenceList.indexOf("222"));
        System.out.println("insert vvv into index 2:");
        sequenceList.insert(2,"vvv");
        System.out.println("2 index:"+sequenceList.get(2));
        System.out.println("3 index:"+sequenceList.get(3));
        System.out.println("5 index:"+sequenceList.get(5));
        System.out.println("index 2 removed:"+sequenceList.remove(2));
        System.out.println("index 2 :"+sequenceList.get(2));
    }
}

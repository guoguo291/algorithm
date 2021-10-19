package lineartable;

/**
 * @Author:guoj
 * @Time:2021/9/18
 * @Description:
 */
public class SymbolTableTest {
    public static void main(String[] args) {
//        SymbolTable<Integer,String> table=new SymbolTable<>();
        OrderSymbolTable<Integer,String> table=new OrderSymbolTable<>();
        table.put(3,"c");
        table.put(1,"a");
        table.put(5,"e");
        table.put(2,"b");
        System.out.println("是否为空："+table.isEmpty());
        System.out.println("元素个数："+table.size());
        table.put(4,"d");
        table.put(2,"ff");
        System.out.println("2对应的元素："+table.get(2));
        table.delete(3);
        System.out.println("移除3后的个数："+table.size());
    }
}

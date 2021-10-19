package lineartable;

/**
 * @Author:guoj
 * @Time:2021/9/18
 * @Description: 符号表  键值对 键唯一
 */
public class SymbolTable<K,V> {
    private class Node<K,V>{
        private K key;
        private V value;
        private Node next;
        public Node(K key,V value,Node next){
            this.key=key;
            this.value=value;
            this.next=next;
        }
    }
    private Node head;
    private int N;
    public SymbolTable(){
        //初始化头结点和元素个数
        this.head=new Node(null,null,null);
        this.N=0;
    }
    //判断当前表是否为空表
    public boolean isEmpty(){
        return N==0;
    }
    //返回符号表的长度
    public int size(){
        return N;
    }
    //获取指定key对应的元素
    public V get(K key){
        Node n=this.head;
        while (n.next!=null){
            n=n.next;
            if (n.key.equals(key)){
                return (V) n.value;
            }
        }
        return null;
    }
    //添加元素
    public void put(K key,V value){
        //找当前表中是否有相同的key有的话替换对应的值
        Node n=this.head;
        while (n.next!=null){
            n=n.next;
            if (n!=null&&n.key.equals(key)){
                n.value=value;
                return;
            }
        }
        //没有对应的key，新建node添加到表中
        Node oldeFirst=head.next;
        Node newNode=new Node(key,value,oldeFirst);
        head.next=newNode;
        //元素数增加
        N++;
    }
    public void delete(K key){
        Node n=head;
        while (n.next!=null){
            if (n.next.key.equals(key)){
                n.next=n.next.next;
                N--;
                return;
            }
            n=n.next;
        }
    }
}

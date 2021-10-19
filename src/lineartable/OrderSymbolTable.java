package lineartable;

/**
 * @Author:guoj
 * @Time:2021/9/18
 * @Description: 有序符号表  键值对 键唯一
 */
public class OrderSymbolTable<K extends Comparable,V> {
    private class Node<K extends Comparable,V>{
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
    public OrderSymbolTable(){
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
        //找当前表中比当前key大的key，记录找到的节点与前一节点
        Node pre=this.head;
        Node curr=pre.next;
        while (curr!=null&&key.compareTo(curr.key)>0){
            pre=curr;
            curr=curr.next;
        }
        //如果存在相同的key，替换值
        if (curr!=null&&curr.key.equals(key)){
            curr.value=value;
            return;
        }
        Node newNode=new Node(key,value,null);
        pre.next=newNode;
        newNode.next=curr;
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

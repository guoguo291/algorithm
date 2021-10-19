package lineartable;

import java.util.Iterator;

/**
 * @Author:guoj
 * @Time:2021/9/14
 * @Description:
 */
public class DualLinkedList<T> implements Iterable{
    private class Node<T>{
        Node pre;
        Node next;
        T item;
        public Node(Node pre,Node next,T item){
            this.pre=pre;
            this.next=next;
            this.item=item;
        }
    }
    private Node head;
    private Node last;
    //链表长度
    private int N;
    public DualLinkedList(){
        this.head=new Node(null,null,null);
        this.last=null;
        this.N=0;
    }
    public void clear(){
        this.head.next=null ;
        this.last=null;
        this.N=0;
    }
    //判断当前表是否为空表
    public boolean isEmpty(){
        return N==0;
    }
    //返回顺序表的长度
    public int length(){
        return N;
    }
    //获取指定位置的元素
    public T get(int index){
        Node node=head;
        for (int i = 0; i <= index; i++) {
            node=node.next;
        }
        return (T) node.item;
    }
    //获取指定位置的元素
    public T getFirst(){
        if (isEmpty()){
            return null;
        }
        return (T) head.next.item;
    }
    //获取指定位置的元素
    public T getLast(){
        if (isEmpty()){
            return null;
        }
        return (T) last.item;
    }
    //添加元素
    public void insert(T t){
        //链表为空
        if (isEmpty()){
            //创建新节点
            Node newNode=new Node(head,null,t);
            //头结点连接新节点
            head.next=newNode;
            //让新节点成为尾节点
            last=newNode;
        }else{
        //链表不为空
            Node oldLast=last;
            //创建新节点
            Node newNode=new Node(oldLast,null,t);
            //尾结点连接新节点
            oldLast.next=newNode;
            //让新节点成为尾节点
            last=newNode;
        }
        N++;
    }
    //向指定位置插入元素
    public void insert(int index,T value){
        if (index>=N){
            return;
        }
        Node pre=head;
        //找到指定位置的前一个节点和当前节点
        for (int i = 0; i < index; i++) {
            pre=pre.next;
        }
        Node curr=pre.next;
        //创建新节点
        Node newNode=new Node(null,null,value);
        //将前一个节点与新节点连接
        pre.next=newNode;
        newNode.pre=pre;
        //将新节点与当前的节点连接
        newNode.next=curr;
        curr.pre=newNode;
    }
    //移除指定位置元素并返回
    public T remove(int index){
        if (index>=N){
            return null;
        }
        //找到i位置节点及前置节点
        Node pre=head;
        for (int i = 0; i < index; i++) {
            pre=pre.next;
        }
        Node curr=pre.next;
        Node next=curr.next;
        //连接i节点的前一个节点与i节点的后一个节点
        pre.next=next;
        next.pre=pre;
        N--;
        return (T) curr.item;
    }
    //查找元素t第一次出现的位置
    public int indexOf(T t){
        Node n=head;
        for (int i = 0; (n=n.next)!=null; i++) {
            if (n.item.equals(t)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator iterator() {
        return new DuaIterator();
    }
    private class DuaIterator implements Iterator{
        private Node n;
        public DuaIterator(){
            this.n=head;
        }
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n=n.next;
            return n.item;
        }
    }
}

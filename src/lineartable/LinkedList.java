package lineartable;

import java.util.Iterator;

/**
 * @Author:guoj
 * @Time:2021/9/13
 * @Description:
 */
public class LinkedList<T> implements Iterable{

    private class Node{
        //记录数据
        T item;
        //下个节点
        Node next;
        public Node(T item,Node next){
            this.item=item;
            this.next=next;
        }
    }
    //记录当前链表中的元素个数
    private Node head;
    private int N;
    public LinkedList(){
        //初始化头结点和元素个数
        this.head=new Node(null,null);
        this.N=0;
    }
    public void clear(){
        this.head.next=null;
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
        Node n=this.head;
        for (int i = 0; i <=  index; i++) {
            n=n.next;
        }
        return n.item;
    }
    //添加元素
    public void insert(T t){
        //找到最后的节点
        Node n=this.head;
        while (n.next!=null){
            n=n.next;
        }
        //创建新节点保存数据t
        Node newNode=new Node(t,null);
        //将最后的节点next指向新节点
        n.next=newNode;
        //元素数增加
        N++;
    }
    //向指定位置插入元素
    public void insert(int index,T value){
        if (index>=N){
            return;
        }
        //找到插入位置的前一个节点
        Node pre=this.head;
        for (int i = 0; i < index; i++) {
            pre=pre.next;
        }
        Node curr=pre.next;
        //将新节点的next指向原节点
        Node newNode=new Node(value,curr);
        //将原节点的的前一个元素指向新节点
        pre.next=newNode;
        //增加元素数据
        N++;
    }
    //移除指定位置元素并返回
    public T remove(int index){
        if (index>=N){
            return null;
        }
        //找到位置的前一个节点
        Node pre=head;
        for (int i = 0; i < index; i++) {
            pre=pre.next;
        }
        //找到插入位置的节点
        Node curr=pre.next;
        //找到插入位置的下一个节点
        Node next=curr.next;
        //将前置的节点的下一个节点指向原插入位置的后置节点
        pre.next=next;
        //减小元素个数
        N--;
        //将移除的元素返回
        return curr.item;
    }
    //查找元素t第一次出现的位置
    public int indexOf(T t){
        Node n=head;
        for (int i = 0;(n=n.next)!=null; i++) {
            if (n.item.equals(t)){
                return i;
            }
        }
        return -1;
    }
    public void reverse(){
        if (isEmpty()){
            return;
        }
        reverse(head.next);
    }
    //反转指定节点,并把反转后的节点返回
    public Node reverse(Node curr){
        //如果当前节点的next为空表示当前为最后一个节点，将头结点指向该节点完成反转
        if (curr.next==null){
            head.next=curr;
            return curr;
        }
        //递归反转下一节点，反转后的下一个节点变为当前curr节点的前置节点
        Node pre = reverse(curr.next);
        pre.next=curr;
        //当前节点反转后的下一个节点置为空
        curr.next=null;
        return curr;
    }

    @Override
    public Iterator iterator() {
        return new LIterator();
    }
    private class LIterator implements Iterator{
        private Node n;
        public LIterator(){
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

package lineartable;

import com.sun.scenario.effect.impl.prism.PrImage;

import java.util.Iterator;

/**
 * @Author:guoj
 * @Time:2021/9/18
 * @Description: 队列 先进先出
 */
public class Queue<T> implements Iterable<T>{

    private class Node{
        //记录数据
        T item;
        //下个节点
        Node next;
        public Node(T item, Node next){
            this.item=item;
            this.next=next;
        }
    }
    private Node head;
    private Node last;
    //记录当前链表中的元素个数
    private int N;
    public Queue(){
        head=new Node(null,last);
        last=null;
        N=0;
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
    public int size(){
        return N;
    }
    public T dequeue(){
        if (isEmpty()){
            return null;
        }
        Node oldFirst=head.next;
        head.next=oldFirst.next;
        N--;
        //如果出栈后元素变为0，则重置last=null
        if (isEmpty()){
            last=null;
        }
        return oldFirst.item;

    }
    public void enqueue(T t){
        if (last==null){
            last=new Node(t,null);
            head.next=last;
        }else {
            Node oldLast=last;
            last=new Node(t,null);
            oldLast.next=last;
        }
        N++;
    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator<>();
    }
    private class QIterator<T> implements Iterator<T>{
        Node n;
        public QIterator(){
            this.n=head;
        }
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public T next() {
            n=n.next;
            return (T) n.item;
        }
    }
}

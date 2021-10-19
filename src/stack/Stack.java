package stack;

import lineartable.LinkedList;

import java.util.Iterator;

/**
 * @Author:guoj
 * @Time:2021/9/16
 * @Description:
 */
public class Stack<T> implements Iterable<T>{

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
    //记录当前链表中的元素个数
    private Node head;
    private int N;
    public Stack(){
        //初始化头结点和元素个数
        this.head=new Node(null,null);
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
    //压栈
    public void push(T t){
        Node n=new Node(t,null);
        //判断头结点后是否数据
        if (head.next==null){
            head.next=n;
        }else {
            Node old=head.next;
            head.next=n;
            n.next=old;
        }
        N++;
    }
    public T pop(){
        Node oldFirst=head.next;
        if (oldFirst!=null){
            Node oldTwo=oldFirst.next;
            head.next=oldTwo;
            N--;
            return oldFirst.item;
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator<T>();
    }
    private class SIterator<T> implements Iterator<T>{
        Node n;
        public SIterator(){
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

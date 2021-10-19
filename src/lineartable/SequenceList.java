package lineartable;

import java.util.Iterator;

/**
 * @Author:guoj
 * @Time:2021/9/13
 * @Description: 顺序表，物理位置连续，数组保存, get的时间复杂度O(1),插入删除的时间复杂度O(N)
 */
public class SequenceList<T> implements Iterable {
    //存储元素的数组
    T[] eles;
    //记录当前顺序表中的元素个数
    private int N;
    //构造方法
    public SequenceList(int capacity){
        //初始化数组
        this.eles= (T[]) new Object[capacity];
        this.N=0;

    }
    public void clear(){
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
        //没有元素或清空的话返回null
        if (N>0){
            return eles[index];
        }
        return null;
    }
    //添加元素
    public void insert(T value){
        if (N> eles.length){
            resize(2* eles.length);
        }
        eles[N++]=value;
    }
    //向指定位置插入元素
    public void insert(int index,T value){
        //扩容
        if (N> eles.length){
            resize(2* eles.length);
        }
        //将index索引之后的元素往后移动一个位置
        for (int i = N; i >=index ; i--) {
            eles[i]=eles[i-1];
        }
        //将插入的元素拷贝到指定索引位置
        eles[index]=value;
        N++;
    }
    //移除指定位置元素并返回
    public T remove(int index){
        //记录index处的元素
        T current=eles[index];
        //将index后的元素向前移动一个位置
        for (int i = index; i <N-1 ; i++) {
            eles[index]=eles[index+1];
        }
        N--;
        if (N< eles.length/4){
            resize(eles.length/2);
        }
        //将移除的元素返回
      return current;
    }
    //查找元素t第一次出现的位置
    public int indexOf(T t){
        for (int i = 0; i < N; i++) {
            if (eles[i].equals(t)){
                return i;
            }
        }
        return -1;
    }
    private void resize(int newSize){
        //定义临时数组保存原数组数据
        T[] temp=eles;
        //将索引指向新数组
        eles= (T[]) new Object[newSize];
        //将原数组数据拷贝到新数组
        for (int i = 0; i < N; i++) {
            eles[i]=temp[i];
        }
    }

    @Override
    public Iterator iterator() {
        return new Siterator();
    }
    private class Siterator implements Iterator{
        private int cusor;
        public Siterator(){
            this.cusor=0;
        }
        @Override
        public boolean hasNext() {
            return cusor<N;
        }

        @Override
        public Object next() {
            return eles[cusor++];
        }
    }
}

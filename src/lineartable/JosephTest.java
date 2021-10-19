package lineartable;

/**
 * @Author:guoj
 * @Time:2021/9/15
 * @Description:
 */
public class JosephTest {
    private static class Node<T>{
        T item;
        Node next;
        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        //初始化41个节点
        //记录头结点
        Node<Integer> first=null;
        //构造链
        Node<Integer> pre=null;
        for (int i = 1; i <= 41; i++) {
            if (i==1){
                first=new Node<>(i,null);
                pre=first;
                continue;
            }
            //增加新节点
            Node<Integer> newNode=new Node<>(i,null);
            pre.next=newNode;
            //将指针移到新节点
            pre=newNode;
            if (i==41){
                pre.next=first;
            }
        }
        //模拟报数
        //记录前一个节点和当前节点
        Node<Integer> curr=first;
        Node<Integer> before=null;
        int count=0;
        while (curr!=curr.next){
            count++;
            if (count==3){
                System.out.print(curr.item+",");
                //移除当前节点
                before.next=curr.next;
                curr=curr.next;
                count=0;
            }else{
                before=curr;
                curr=curr.next;
            }
        }
        System.out.println("最后剩的："+curr.item);
    }
}

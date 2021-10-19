package lineartable;

/**
 * @Author:guoj
 * @Time:2021/9/14
 * @Description:
 */
public class FastSlowTest {
    private static class Node<T>{
        T item;
        Node next;
        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        //创建结点
        Node<String> first = new Node<String>("aa", null);
        Node<String> second = new Node<String>("bb", null);
        Node<String> third = new Node<String>("cc", null);
        Node<String> fourth = new Node<String>("dd", null);
        Node<String> fifth = new Node<String>("ee", null);
        Node<String> sixth = new Node<String>("ff", null);
        Node<String> seventh = new Node<String>("gg", null);


        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
//        sixth.next = third;
        sixth.next = seventh;
        seventh.next = first;

//        String mid = getMid(first);
//        System.out.println("中间值：" + mid);
        System.out.println("单链表是否有环：" + hasCircle(first));
        System.out.println("单链表环的入口：" + getEntrance(first).item);
    }
    //获取中间值
    public static String getMid(Node<String> first){
        //定义两个指针
        Node<String> fast = first;
        Node<String> slow = first;

        while(fast != null && fast.next != null){
           if (fast.next.next!=null){
               //链表长度为奇数
               fast=fast.next.next;
               slow=slow.next;
           }else {
               //链表长度为偶数,此时慢指针指向中间的两个节点中的前一个
               fast=fast.next;
               return slow.item+" 与 "+slow.next.item;
           }
        }
        return slow != null ? slow.item : null;
    }
    //判断是否有环
    public static boolean hasCircle(Node<String> first){
        //定义两个指针
        Node<String> fast = first;
        Node<String> slow = first;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast!=null&&fast.equals(slow)){
                return true;
            }
        }
        return false;
    }

    /**
     * 获取有环链表环的入口
     * @param first
     * @return 快慢指针相遇时定义临时指针指向首节点，临时指针与慢指针相遇的地方为入口
     */
    public static Node getEntrance(Node<String> first){
        //定义快慢指针
        Node<String> fast=first;
        Node<String> slow=first;
        Node<String> temp=null;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast!=null&&fast.equals(slow)&&temp==null){
                temp=first;
                //判断是否相等相等则为入口
                if (slow.equals(temp)){
                    break;
                }
                continue;
            }
            //当快慢指针相遇，temp不为null时，temp才开始移动
            if (temp!=null){
                temp=temp.next;
                if (slow.equals(temp)){
                    break;
                }
            }

        }
        return temp;
    }
}

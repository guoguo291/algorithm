package tree;

import lineartable.Queue;

/**
 * @Author:guoj
 * @Time:2021/9/26
 * @Description: 折纸问题，纸片对折 下折痕为down,上折痕为up，可以对应树的结构，左子树为down，右子树为up，中序遍历打印出折痕
 */
public class PageForderTest {
    private static class Node<T>{
        private T item;
        private Node left;
        private Node right;
        public Node(T item, Node left, Node right){
            this.item=item;
            this.left=left;
            this.right=right;
        }
    }
    public static void main(String[] args) {
        Node tree = createTree(3);
        printTree(tree);
    }
    //根据折的次数构建树

    public static Node createTree(int n){
        Node root=null;
        for (int i = 0; i < n; i++) {
            //当前是第一次对折
            if (i==0){
                root=new Node("down",null,null);
                continue;
            }
            //当前不是第一次对折
            //通过层序遍历的思想，查找叶子节点，为叶子节点添加子节点
            Queue<Node> nodes = new Queue<>();
            nodes.enqueue(root);
            while (!nodes.isEmpty()){
                Node<String> node = nodes.dequeue();
                if (node.left!=null){
                    nodes.enqueue(node.left);
                }
                if (node.right!=null){
                    nodes.enqueue(node.right);
                }
                //为叶子节点，为该节点添加子节点
                if (node.left==null&&node.right==null){
                    node.left=new Node("down",null,null);
                    node.right=new Node("up",null,null);
                }
            }
        }
        return root;
    }

    /**
     * 使用中序遍历打印节点数据
     * @param x
     */
    public static void printTree(Node x){
        if (x==null){
            return;
        }
        //打印左子树
        if (x.left!=null){
            printTree(x.left);
        }
        //打印当前节点
        System.out.print(x.item+" ");
        //打印右子树
        if (x.right!=null){
            printTree(x.right);
        }
    }
}

package tree;

import lineartable.Queue;
import lineartable.SymbolTable;

import java.awt.image.Kernel;
import java.security.Key;

/**
 * @Author:guoj
 * @Time:2021/9/22
 * @Description:
 * 结点的度：结点含有字数的个数   树的度：树中的结点度的最大值 树的高度：节点的最大层次
 * 满二叉树：每一层的结点都达到醉倒值
 * 完全二叉树：叶只能出现在最下层和次下层
 * 前序遍历：先遍历根结点，然后左子树，最后右子树
 * 中序遍历：先遍历左子树，然后根结点，最后右子树
 * 后序遍历：先遍历左子树，然后右子树，最后根结点
 */
public class BinaryTree<K extends Comparable<K>,V> {
    private class Node{
        private K k;
        private V v;
        private Node left;
        private Node right;
        public Node(K k, V v, Node left,Node right){
            this.k=k;
            this.v=v;
            this.left=left;
            this.right=right;
        }
    }
    private Node root;
    private int N;
    public int size(){
        return N;
    }
    //向数中添加数据
    public void put(K key,V value){
        root=put(root,key,value);
    }
    //向指定数添加数据，并返回新的树
    private Node put(Node x,K key,V value){
        if (x==null){
            N++;
            return new Node(key,value,null,null);
        }
        //x子树不为空，比较键的大小
        int cmp = key.compareTo(x.k);
        if (cmp>0){
            //继续找右子树,并把新树返回
            x.right=put(x.right,key,value);
        }else if(cmp<0){
            //找左子树
            x.left=put(x.left,key,value);
        }else {
            //key值相等，替换结点的值
            x.v=value;
        }
        return x;
    }
    //从整个树中查找
    public V get(K key){
        return get(root,key);
    }
    //查找指定结点
    private V get(Node x,K key){
        if (x==null){
            return null;
        }
        //x子树不为空，比较键的大小
        int cmp = key.compareTo(x.k);
        if (cmp>0){
            //继续找右子树,并把新树返回
            return get(x.right,key);
        }else if(cmp<0){
            //找左子树
            return get(x.left,key);
        }else {
            //key值相等，zhao到值
            return x.v;
        }
    }
    //从整个树中删除key
    public void delete(K key){
        delete(root,key);
    }
    //删除指定树中对应key的值，返回删除后的树
    private Node delete(Node x,K key){
        if (x==null){
            return null;
        }
        //x子树不为空，比较键的大小
        int cmp = key.compareTo(x.k);
        if (cmp>0){
            //继续找右子树,并把删除值后的新树返回
            x.right=delete(x.right,key);
        }else if(cmp<0){
            //找左子树
            x.left=delete(x.left,key);
        }else {
            //key值相等，找到值，需要删除x结点，完成删除动作
            N--;
            //返回右子树中的最小结点
            //如果没有右子树，直接返回左子树
            if (x.right==null){
                return x.left;
            }
            if (x.left==null){
                return x.right;
            }
            //有左右子树，则遍历右子树，找到最小结点
            Node minNode=x.right;
            while(minNode.left!=null){
                minNode=minNode.left;
            }
            //让最小的节点替换删除的节点
            Node lastNode=x.right;
            while(lastNode.left!=null){
                if (lastNode.left.left!=null){
                    lastNode=lastNode.left;
                }else {
                    lastNode.left=null;
                };
            }
            //让x的左子树成为minNode的左子树
            minNode.left=x.left;
            //让x的右子树成为minNode的右子树
            minNode.right=x.right;
            //让x的父结点指向minNode
            x=minNode;
        }
        return x;
    }

    /**
     * 查找整个树中最小的key
     * @return
     */
    private K min(){
        return  min(root).k;
    }

    /**
     * 查找指定树中最小的key
     * @param x
     * @return
     */
    private Node min(Node x){
        if (x==null){
            return null;
        }
        if (x.left==null){
            return x;
        }else {
            return min(x.left);
        }
    }
    /**
     * 查找整个树中最大的key
     * @return
     */
    private K max(){
        return  max(root).k;
    }

    /**
     * 查找指定树中最小的key
     * @param x
     * @return
     */
    private Node max(Node x){
        if (x==null){
            return null;
        }
        if (x.right==null){
            return x;
        }else {
            return max(x.right);
        }
    }

    /**
     * 前序遍历，将整个树所有的键放到队列中
     * @return
     */
    public Queue<K> preErgodic(){
        Queue<K> queue = new Queue();
        preErgodic(root,queue);
        return queue;
    }
    /**
     * 前序遍历，将指定结点树所有的键放到队列中
     * @return
     */
    private void  preErgodic(Node x,Queue<K> queue){
        if (x==null){
            return;
        }
        //将x结点key添加到队列中
        queue.enqueue(x.k);
        //递归遍历左子树
        if (x.left!=null){
            preErgodic(x.left,queue);
        }
        //递归遍历右子树
        if (x.right!=null){
            preErgodic(x.right,queue);
        }
    }

    /**
     * 中序遍历，将整个树所有的键放到队列中
     * @return
     */
    public Queue<K> midErgodic(){
        Queue<K> queue = new Queue();
        midErgodic(root,queue);
        return queue;
    }
    /**
     * 中序遍历，将指定结点树所有的键放到队列中
     * @return
     */
    private void  midErgodic(Node x,Queue<K> queue){
        if (x==null){
            return;
        }

        //递归遍历左子树，把key放到队列中
        if (x.left!=null){
            midErgodic(x.left,queue);
        }
        //将x结点key添加到队列中
        queue.enqueue(x.k);
        //递归遍历右子树，把key放到队列中
        if (x.right!=null){
            midErgodic(x.right,queue);
        }
    }
    /**
     * 后序遍历，将整个树所有的键放到队列中
     * @return
     */
    public Queue<K> afterErgodic(){
        Queue<K> queue = new Queue();
        afterErgodic(root,queue);
        return queue;
    }
    /**
     * 后序遍历，将指定结点树所有的键放到队列中
     * @return
     */
    private void  afterErgodic(Node x,Queue<K> queue){
        if (x==null){
            return;
        }

        //递归遍历左子树，把key放到队列中
        if (x.left!=null){
            afterErgodic(x.left,queue);
        }
        //递归遍历右子树，把key放到队列中
        if (x.right!=null){
            afterErgodic(x.right,queue);
        }
        //将x结点key添加到队列中
        queue.enqueue(x.k);

    }
    /**
     * 层序遍历，将指定结点树所有的键放到队列中
     * @return
     */
    public Queue  layerErgodic(){
        //定义两个队列一个存放key，一个存放待遍历的节点
        Queue<String> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();
        nodes.enqueue(root);
        while (!nodes.isEmpty()){
            Node node=nodes.dequeue();
            keys.enqueue((String) node.k);
            if (node.left!=null){
                nodes.enqueue(node.left);
            }
            if (node.right!=null){
                nodes.enqueue(node.right);
            }
        }
        return keys;
    }
    public int maxDepth(){
        return maxDepth(root);
    }

    private int maxDepth(Node node) {
        if (node==null){
            return 0;
        }
        int max=0;
        int maxL=0;
        int maxR=0;
        //先求左子树最大深度
        maxL=maxDepth(node.left);
        //求右子树最大深度
        maxR=maxDepth(node.right);
        //比较左右子树
        max=maxL>maxR?maxL+1:maxR+1;
        return max;
    }
}

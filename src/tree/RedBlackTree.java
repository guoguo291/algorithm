package tree;

/**
 * @Author:guoj
 * @Time: 2021/10/8
 * @Description:
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {
    //根节点
    private Node root;
    //树中元素个数
    private int N;
    //红色链接
    private static final boolean RED = true;
    //黑色链接
    private static final boolean BLACK = false;

    public RedBlackTree() {
        this.root = root;
    }

    private class Node {
        public Key key;
        private Value value;
        //左子结点
        public Node left;
        public Node right;
        //由父节点指向它的链接颜色
        public boolean color;

        public Node(Key key, Value value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }

    public int size() {
        return N;
    }

    /**
     * 判断当前节点的父指向链接是否为红色链接
     */
    public boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    /**
     * 左旋
     * @param h
     * @return 左旋后新的节点
     */
    private Node rotateLeft(Node h) {
        //h节点的右结点记录为节点x
        Node x = h.right;
        //让x节点的左子结点成为h的右子节点
        h.right = x.left;
        //让h成为x的左子节点
        x.left = h;
        //让x的颜色=h的颜色
        x.color = h.color;
        //让h的颜色变成红色
        h.color = RED;
        return x;
    }

    /**
     * 右旋
     *
     * @param h
     * @return
     */
    private Node rotateRight(Node h) {
        //h节点的左子结点记录为节点x
        Node x = h.left;
        //让x节点的右子结点成为h的左子节点
        h.left = x.right;
        //让h成为x的右子节点
        x.right = h;
        //让x的颜色=h的颜色
        x.color = h.color;
        //让h的颜色变成红色
        h.color = RED;
        return x;
    }

    /**
     * 颜色反转
     */
    private void flipColor(Node h) {
        h.left.color = BLACK;
        h.right.color = BLACK;
        h.color = RED;
    }

    /**
     * 向整个树添加节点
     *
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        root=put(root, key, value);
        //根节点的颜色总是黑色，防止颜色反转变为红色
        root.color = BLACK;
    }

    /**
     * 向指定结点添加节点,将添加节点后的新的树返回
     *
     * @param h
     * @param key
     * @param value
     */
    private Node put(Node h, Key key, Value value) {
        if (h == null) {
            //如果当前节点为空,直接返回一个红色的新节点
            N++;
            return new Node(key, value, null, null, RED);
        }
        //当前节点不为空，则进行key的比较
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            //插入的key小于h的key往左继续查找
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            //插入的key大于h的key往右继续查找
            h.right = put(h.right, key, value);
        } else {
            //key相同替换值
            h.value = value;
        }
        //判断是否需要进行左旋,当前节点的左子节点为黑色，右子节点为红色需要左旋
        if (!isRed(h.left) && isRed(h.right)) {
            h=rotateLeft(h);
        }
        //判断是否需要进行右旋，当前节点的左子节点为红色，左子节点的左子结点为红色需要左旋
        if (isRed(h.left) && isRed(h.left.left)) {
            h=rotateRight(h);
        }
        //判断是否需要颜色反转，当前节点的左子节点为红色，右子节点为红色需要颜色翻转
        if (isRed(h.left) && isRed(h.right)) {
            flipColor(h);
        }

        return h;
    }

    /**
     * 从整个树中查找值
     * @param key
     * @return
     */
    public Value get(Key key){
        return get(root,key);
    }

    /**
     * 从指定树中查找值
     * @param h
     * @param key
     * @return
     */
    private Value get(Node h,Key key){
        if (h==null){
            return null;
        }
        int cmp=key.compareTo(h.key);
        if (cmp<0){
            //继续向左查找
            return get(h.left,key);
        }else if (cmp>0){
            //向右查找
            return get(h.right,key);
        }else {
            return h.value;
        }
    }
}

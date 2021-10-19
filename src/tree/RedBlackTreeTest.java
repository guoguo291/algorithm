package tree;

/**
 * @Author:guoj
 * @Time:2021/10/8
 * @Description:
 */
public class RedBlackTreeTest {
    public static void main(String[] args) {
        RedBlackTree<String,String> redBlackTree = new RedBlackTree();
        redBlackTree.put("1","一休");
        redBlackTree.put("2","二蛋");
        redBlackTree.put("3","三毛");
        System.out.println("1:"+ redBlackTree.get("1"));
        System.out.println("2:"+ redBlackTree.get("2"));
        System.out.println("3:"+ redBlackTree.get("3"));
        System.out.println("N="+ redBlackTree.size());
    }
}

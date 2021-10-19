package tree;

import lineartable.Queue;

/**
 * @Author:guoj
 * @Time:2021/9/22
 * @Description:
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        /*BinaryTree<Integer,String > binaryTree=new BinaryTree();
        binaryTree.put(1,"11");
        binaryTree.put(2,"22");
        binaryTree.put(3,"33");
        System.out.println("元素个数："+binaryTree.size());
        System.out.println("key为3的值："+binaryTree.get(3));
        binaryTree.delete(3);
        System.out.println("删除后的元素个数："+binaryTree.size());
        System.out.println("key为3的值："+binaryTree.get(3));*/
        BinaryTree<String,String > binaryTree=new BinaryTree();
        binaryTree.put("E","5");
        binaryTree.put("B","2");
        binaryTree.put("G","7");
        binaryTree.put("A","1");
        binaryTree.put("D","4");
        binaryTree.put("F","6");
        binaryTree.put("H","8");
        binaryTree.put("C","3");
//        Queue<String> keys = binaryTree.preErgodic();
//        Queue<String> keys = binaryTree.midErgodic();
//        Queue<String> keys = binaryTree.afterErgodic();
        Queue<String> keys = binaryTree.layerErgodic();
        System.out.println("size:"+keys.size());
        for (String key:keys) {
            System.out.println("key:"+key+"  value:"+binaryTree.get(key));
        }
        System.out.println("最大层数："+binaryTree.maxDepth());
    }

}

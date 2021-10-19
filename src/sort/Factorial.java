package sort;

/**
 * @Author:guoj
 * @Time:2021/9/10
 * @Description:
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println("3的阶乘:"+factorial(3));
    }

    /**
     * @param n 阶乘
     * @return 计算N的阶乘
     */
    private static long factorial(int n){
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
}

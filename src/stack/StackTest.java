package stack;

/**
 * @Author:guoj
 * @Time:2021/9/16
 * @Description:
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack=new Stack<>();
        stack.push("aa");
        stack.push("bb");
        stack.push("cc");
        stack.push("dd");
        for (String item : stack) {
            System.out.println(item);
        }
        System.out.println("-----------------------------");
        System.out.println("弹出的元素为："+stack.pop());
        System.out.println("剩余元素个数："+stack.size());
        System.out.println("-----------------------------");
        System.out.println("(hi()) 的括号数是否匹配:"+isMatch("(hi())"));
    }

    /**
     * 字符串括号是否匹配
     * @param str
     * @return
     */
    public static boolean isMatch(String str){
        //遍历字符串将左括号压栈，遍历到右括号弹栈
        Stack<String> stack=new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            String ch=str.charAt(i)+"";
            if ("(".equals(ch)){
                stack.push(ch);
            }else if (")".equals(ch)){
                String pop = stack.pop();
                if (pop==null){
                    return false;
                }
            }
        }
        if (stack.size()==0){
            return true;
        }
        return false;
    }
}

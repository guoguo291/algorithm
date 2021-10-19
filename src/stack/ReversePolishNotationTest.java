package stack;

/**
 * @Author:guoj
 * @Time:2021/9/17
 * @Description: 逆波兰表达式计算  后缀表达式子
 */
public class ReversePolishNotationTest {
    public static void main(String[] args) {
        //中缀表达式2+(3+5)*2  对应逆波兰表达式235+2*+
        char[] notaion="235+2*+".toCharArray();
        System.out.println("235+2*+计算结果为："+caculate(notaion));
    }
    public static int caculate(char[] chars){
        //遍历数组 将操作数入栈，如果是操作符则将两个操作数弹栈计算后将结果压入栈中
        Stack<String> stack=new Stack<>();
        int result=0;
        int a,b;
        for (int i = 0; i < chars.length; i++) {
            String curr=chars[i]+"";
            switch (curr){
                case "+":
                     a =Integer.parseInt(stack.pop());
                     b =Integer.parseInt(stack.pop());
                    result=b+a;
                    stack.push(result+"");
                    break;
                case "-":
                    a =Integer.parseInt(stack.pop());
                    b =Integer.parseInt(stack.pop());
                    result=b-a;//这里要注意计算顺序
                    stack.push(result+"");
                    break;
                case "*":
                    a =Integer.parseInt(stack.pop());
                    b =Integer.parseInt(stack.pop());
                    result=b*a;
                    stack.push(result+"");
                    break;
                case "/":
                    a =Integer.parseInt(stack.pop());
                    b =Integer.parseInt(stack.pop());
                    result=b/a;
                    stack.push(result+"");
                    break;
                default:
                    //非操作数的话压入栈
                    stack.push(curr);
                    break;
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

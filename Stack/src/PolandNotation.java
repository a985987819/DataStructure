import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author laoduan
 * @create 2020-04-17-16:42
 */
public class PolandNotation {

    public static void main(String[] args) {


//        String suffixExpression = "30 4 + 5 * 6 -";
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        List<String> rpnList = getListString(suffixExpression);
        System.out.println("rpnList="+rpnList);

        int res = calulate(rpnList);
        System.out.println("计算的结果是"+res);
    }

    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for(String ele:split){
            list.add(ele);
        }
        return list;

    }

    public static int calulate(List<String> ls){
        Stack<String> stack = new Stack<String>();
        for (String item:ls){
            if(item.matches("\\d+")){
                stack.push(item);
            }else
            {
                //不是数，pop出两个数，运算
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(item.equals("+")){
                    res=num1+num2;
                }else if(item.equals("-")){
                    res = num1-num2;
                }else if(item.equals("*")){
                    res = num1*num2;
                }else if(item.equals("/")){
                    res = num1/num2;
                }else {
                    throw new RuntimeException("运算符有误");
                }
                //把res入栈
                stack.push(""+res);
            }
        }
        //最后留在stack的就是结果
        return Integer.parseInt(stack.pop());
    }
}

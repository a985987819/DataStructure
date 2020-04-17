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
//        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
//        List<String> rpnList = getListString(suffixExpression);
//        System.out.println("rpnList="+rpnList);
//
//        int res = calulate(rpnList);
//        System.out.println("计算的结果是"+res);
//
//

        String expression = "1+((2+3)*4)-5";
        List<String>infixExpressionList = toinfixExpressionList(expression);
        System.out.println(infixExpressionList);

        List<String> parseSuffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式对应的List"+parseSuffixExpressionList);

        System.out.printf("expression=%d",calulate(parseSuffixExpressionList));

    }



    //方法:将得到的中缀表达式对应的List=》后缀表达式对应的List
    public static List<String> parseSuffixExpressionList(List<String> ls){
        //定义两个栈
        Stack<String>s1 = new Stack<String>();//符号栈
        //s2在整个转换过程中没有pop操作
        //所以直接用List
        List<String> s2 = new ArrayList<String>();

        //遍历ls
        for(String item:ls){
            //如果是一个数，入s2
            if(item.matches("\\d+")){
                s2.add(item);
            }
            else if(item.equals("(")){
                s1.push(item);
            }
            else if(item.equals(")")){
                //如果是)，就一直弹出，直到(
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();//将(弹出s1       消除（）
            }else {
                //当item的优先级小于等于s1栈顶运算符,将s1栈顶的运算符弹出并加入s2
                while (s1.size()!=0&&Operation.getValue(s1.peek())>=Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                //将item压入栈中
                s1.push(item);
            }
        }
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;//因为是存放到list,因此正常输出就是逆波兰
    }

    //将中缀表达式转成list
    public static List<String> toinfixExpressionList(String s){
        List<String> ls = new ArrayList<String>();
        int i = 0;
        String str;
        char c;
        do{
            //如果是非数字，加入到ls
            if ((c=s.charAt(i))<48||(c=s.charAt(i))>57){
                ls.add(""+c);
                i++;
            }else {//如果是个数，要考虑多位数
                str = "";//先置空
                while (i<s.length()&&(c=s.charAt(i))>=48&&(c=s.charAt(i))<=57){
                    str+=c;
                    i++;
                }
                ls.add(str);
            }
        }while (i<s.length());
        return ls;
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



//Operation   可以返回一个运算符对应的优先级
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;


    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
                default:
                    System.out.println("不存在该运算符");
                    break;
        }
        return result;
    }
}
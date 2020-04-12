/**
 * @author laoduan
 * @create 2020-04-11-17:58
 */
public class Calculator {
    public static void main(String[] args) {

        String expressinon = "3+2*6-2";

        Arraystack2 numStack = new Arraystack2(10);
        Arraystack2 operStack = new Arraystack2(10);


        int index=0;//用于扫描
        int num1=0;
        int num2=0;
        int oper=0;
        int res=0;
        char ch = ' ';//将每次扫描得到的char保存到ch

        while (true){
            ch = expressinon.substring(index,index+1).charAt(0);

            if(operStack.isOper(ch)){
                if(!operStack.isEmpty()){
                    //不空则判断优先级
                    //如果优先级小于或等于栈中的操作符，就从数栈pop两个数
                    //从符合惨pop一个符合进行运算，将得到的结果入数栈，将当前操作符入符栈
                    if(operStack.priority(ch)<=operStack.priority(operStack.peek())){
                        num1=numStack.pop();
                        num2=numStack.pop();
                        oper=operStack.pop();
                        res=numStack.cal(num1,num2,oper);
                        //把运算的结果入数栈
                        numStack.push(res);
                        //当前的操作入符号栈
                        operStack.push(ch);
                    }
                    else {
                        //当前的操作符优先级大于栈中的操作符，直接入符号栈
                        operStack.push(ch);
                    }
                }else{
                    //栈空则入栈
                    operStack.push(ch);
                }
            }
            else {
                numStack.push(ch-48);//ASCII表里面'1'正好比1大48
            }
            index++;
            if(index>=expressinon.length()){
                break;
            }
        }

        while (true){
            if(operStack.isEmpty()){
                break;
            }
            num1=numStack.pop();
            num2=numStack.pop();
            oper=operStack.pop();
            res=numStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        int Finres = numStack.pop();
        System.out.printf("表达式%s=%d",expressinon,Finres);
    }
}


//

class Arraystack2{
    private int maxSize;//栈的大小
    private int[] stack;//数组
    private int top = -1;


    public Arraystack2(int maxSize){
        this.maxSize=maxSize;
        stack=new int [this.maxSize];
    }

    //增加方法，返回栈顶的值，但不是pop
    public int peek(){
        return stack[top];
    }

    //栈满
    public boolean isFull(){
        return top==maxSize-1;
    }
    //栈空
    public boolean isEmpty(){
        return top==-1;
    }
    //入栈
    public void push(int value){
        if(isFull()){
            System.out.println("栈满，不能入栈");
            return;
        }
        top++;
        stack[top]=value;
    }
    //出栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        top--;
        return stack[top+1];
    }
    //遍历栈
    public void list(){
        if (isEmpty()){
            System.out.println("栈空，不能遍历");
        }
        for (int i=top;i>-1;i--){
            System.out.printf("stacl[%d]=%d\n",i,stack[i]);
        }
    }


    //返回运算符的优先级，用数字表示
    //数字越大优先级越高
    public int priority(int oper){
        if(oper=='*'||oper=='/'){
            return 1;
        }else if(oper=='+'||oper=='-'){
            return 0;
        }else{
            return -1;//假定目前表达式只有+  -  *  /
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }
    //计算方法
    public int cal(int num1,int num2,int oper){
        int res = 0;//res用于存放计算ed结果
        switch (oper){
            case'+':
                res = num1+num2;
                break;
            case'-':
                res = num2-num1;
                break;
            case'*':
                res = num1*num2;
                break;
            case'/':
                res = num2+num1;
                break;
                default:
                    break;
        }
        return res;
    }

}











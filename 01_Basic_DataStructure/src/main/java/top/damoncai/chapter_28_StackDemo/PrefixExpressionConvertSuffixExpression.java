package top.damoncai.chapter_28_StackDemo;

import top.damoncai.chapter_27_ArrayStack.ArrayStack;

/**
 *
 * 前缀表达式转后缀表达式
 * @author zhishun.cai
 * @date 2025/2/20
 */
public class PrefixExpressionConvertSuffixExpression {

    /*
       思路
       1. 遇到数字, 拼串
       2. 遇到 + - * /
           - 优先级高于栈顶运算符 入栈
           - 否则将栈中高级或平级运算符出栈拼串, 本运算符入栈
       3. 遍历完成, 栈中剩余运算符出栈拼串
           - 先出栈,意味着优先运算
       4. 带 ()
           - 左括号直接入栈
           - 右括号要将栈中直至左括号为止的运算符出栈拼串

       |   |
       |   |
       |   |
       _____

       a+b
       a+b-c
       a+b*c
       a*b+c
       (a+b)*c

    */
    public String convert(String expre) {
        ArrayStack<Character> stack = new ArrayStack(expre.length());
        StringBuilder sb = new StringBuilder("");

        // 遍历每一个元素
        for (int i = 0; i < expre.length(); i++) {
            Character ele = expre.charAt(i);
            switch (ele) {
                case  '+', '-','*', '/'-> {
                    // 操作符
                    while (!stack.isEmpty() && getPriority(ele) <= getPriority(stack.peek())) {
                        sb.append(stack.pop());
                    }
                    stack.push(ele);
                }
                case '(' -> {
                    stack.push(ele);
                }
                case ')' -> {
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                }

                default -> {
                    // 操作数
                    sb.append(ele);
                }
            }

        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }


        return sb.toString();
    }


    /**
     * 获取优先级
     * @param c
     * @return
     */
    public int getPriority(Character c) {
        return switch (c) {
            case '(' -> 0;
            case '+', '-' -> 1;
            case '*', '/' -> 2;


            default -> throw new IllegalArgumentException("非法参数：" + c);
        };
    }

}

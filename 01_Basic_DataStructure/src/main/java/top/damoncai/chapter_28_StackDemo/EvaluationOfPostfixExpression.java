package top.damoncai.chapter_28_StackDemo;

import top.damoncai.chapter_27_ArrayStack.ArrayStack;

/**
 *
 * 后缀表达式求值-Leetcode 120
 *
 * 后缀表达式也称为逆波兰表达式，即运算符写在后面
 *
 * * 从左向右进行计算
 * * 不必考虑运算符优先级，即不用包含括号
 *
 * 示例
 *
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 即：(2 + 1) * 3
 *
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 即：4 + (13 / 5)
 *
 * 题目假设
 *  - 数字都视为整数
 *  - 数字和运算符个数给定正确，不会有除零发生
 *
 * @author zhishun.cai
 * @date 2025/2/19
 */
public class EvaluationOfPostfixExpression {

    /**
     * 计算
     * @param expression
     * @return
     */
    public int calculate(String[] expression) {
        ArrayStack<Integer> stack = new ArrayStack(expression.length);

        for (String ele : expression) {
            if(ele.equals("+") || ele.equals("-") || ele.equals("*") || ele.equals("/")) {
                // 操作符
                int e1 = stack.pop();
                int e2 = stack.pop();
                int res = operation(e2, e1, ele);
                stack.push(res);
            }else {
                // 操作数
                stack.push(Integer.parseInt(ele));
            }
        }
        return stack.pop();
    }

    /**
     *
     * @param e1 操作数 1
     * @param e2 操作数 2
     * @param operator 操作符
     * @return
     */
    public int operation(int e1, int e2, String operator) {
        return switch (operator) {
            case "+" -> e1 + e2;
            case "-" -> e1 - e2;
            case "*" -> e1 * e2;
            case "/" -> e1 / e2;
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }
}

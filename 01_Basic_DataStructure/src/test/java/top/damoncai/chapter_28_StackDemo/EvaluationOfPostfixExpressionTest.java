package top.damoncai.chapter_28_StackDemo;

import org.junit.jupiter.api.Test;

/**
 * @author zhishun.cai
 * @date 2025/2/19
 */
public class EvaluationOfPostfixExpressionTest {

    @Test
    public void test() {
        EvaluationOfPostfixExpression eope = new EvaluationOfPostfixExpression();

        String[] operation = {"2", "1", "+", "3", "*"};

        int calculated = eope.calculate(operation);
        System.out.println(calculated);
    }
}
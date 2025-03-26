package top.damoncai.chapter_28_StackDemo;

import org.junit.jupiter.api.Test;

/**
 * @author zhishun.cai
 * @date 2025/2/20
 */
public class PrefixExpressionConvertSuffixExpressionTest {



  @Test
  public void test() {
    String expr1 = "a+b";
    String expr2 = "a+b-c";
    String expr3 = "a*b+c";
    String expr4 = "a+b*c";
    String expr5 = "a+b*c-d";
    String expr6 = "(a+b)*c";
    String expr7 = "(a+b*c-d)*e";
    String expr8 = "a*(b+c)";
    PrefixExpressionConvertSuffixExpression pecse = new PrefixExpressionConvertSuffixExpression();

    System.out.println(pecse.convert(expr1));
    System.out.println(pecse.convert(expr2));
    System.out.println(pecse.convert(expr3));
    System.out.println(pecse.convert(expr4));
    System.out.println(pecse.convert(expr5));
    System.out.println(pecse.convert(expr6));
    System.out.println(pecse.convert(expr7));
    System.out.println(pecse.convert(expr8));

  }
}
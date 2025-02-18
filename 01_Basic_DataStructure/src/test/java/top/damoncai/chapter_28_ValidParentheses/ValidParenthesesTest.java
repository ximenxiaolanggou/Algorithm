package top.damoncai.chapter_28_ValidParentheses;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhishun.cai
 * @date 2025/2/18
 */
public class ValidParenthesesTest {

  @Test
  public void test() {
    ValidParentheses validParentheses = new ValidParentheses();
    String str1 = "()";
    String str2 = "()[]{}";
    String str3 = "([])";
    String str4 = "(]";
    String str5 = ")]";

    System.out.println(validParentheses.isValid(str1));
    System.out.println(validParentheses.isValid(str2));
    System.out.println(validParentheses.isValid(str3));
    System.out.println(validParentheses.isValid(str4));
    System.out.println(validParentheses.isValid(str5));

    System.out.println("=============================");
    System.out.println(validParentheses.isValid_V2(str1));
    System.out.println(validParentheses.isValid_V2(str2));
    System.out.println(validParentheses.isValid_V2(str3));
    System.out.println(validParentheses.isValid_V2(str4));
    System.out.println(validParentheses.isValid_V2(str5));
  }
}
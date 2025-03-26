package top.damoncai.chapter_28_StackDemo;

import top.damoncai.chapter_27_ArrayStack.ArrayStack;

/**
 *
 * 给定一个只包括 ‘(’，’)’，’{’，’}’，’[’，’]’ 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 1.左括号必须用相同类型的右括号闭合
 * 2.左括号必须以正确的顺序闭合
 * 3.每个右括号都有一个对应的相同类型的左括号
 *
 * @author zhishun.cai
 * @date 2025/2/18
 */
public class ValidParentheses {

  /**
   * 是否有效
   * @param s 需要验证的字符串
   * @return
   */
  public boolean isValid(String s) {
    if(s == null || s.length() == 0) {
      return false;
    }

    ArrayStack<Character> stack = new ArrayStack<>(s.length());
    for(int i = 0; i < s.length(); i++) {
      Character c = s.charAt(i);
      if(c == '(' || c == '{' || c == '[') {
        // 左边括号 - 直接入栈
        stack.push(c);
      } else {
        // 右边括号 - 校验出站
        Character stackTopChar = stack.peek();
        // 栈空 - 直接false
        if(stackTopChar == null) {
          return false;
        }

        // 判断三种情况
        switch(c) {
          case ')' -> {
            if(stackTopChar != '(') {
              return false;
            }
          }
          case '}' -> {
            if(stackTopChar != '{') {
              return false;
            }
          }
          case ']' -> {
            if(stackTopChar != '[') {
              return false;
            }
          }
        }
        stack.pop();
      }
    }
    return stack.isEmpty();
  }

  /**
   * 是否有效
   * @param s 需要验证的字符串
   * @return
   */
  public boolean isValid_V2(String s) {
    if(s == null || s.length() == 0) {
      return false;
    }

    ArrayStack<Character> stack = new ArrayStack<>(s.length());
    for(int i = 0; i < s.length(); i++) {
      Character c = s.charAt(i);
      // 这里直接存放对应的反符号
      if(c =='(') {
        stack.push(')');
      }else if(c =='{') {
        stack.push('}');
      }else if(c =='[') {
        stack.push(']');
      }else {
        // 右边括号 - 校验出站
        // 栈空 - 直接false
        if(stack.peek() == null || !stack.peek().equals(c)) {
          return false;
        }
        stack.pop();
      }
    }
    return stack.isEmpty(); // 3971
  }
}

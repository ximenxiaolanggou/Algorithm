package top.damoncai.chapter_10_recursionfibonaccisequence;

import org.junit.jupiter.api.Test;

/**
 * @author zhishun.cai
 * @date 2024/12/27
 */
public class RecursionFibonacciSequenceTest {

  @Test
  public void testRecursionFibonacciSequence() {
    RecursionFibonacciSequence handler = new RecursionFibonacciSequence();
    int res = handler.handle(12);
    System.out.println(res);
  }
}
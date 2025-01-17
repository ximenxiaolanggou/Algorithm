package top.damoncai.chapter_11_recursionfibonaccisequencerabbit;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhishun.cai
 * @date 2024/12/30
 */
public class RecursionFibonacciSequenceRabbitTest {

  @Test
  public void testRecursionFibonacciSequence() {
    RecursionFibonacciSequenceRabbit handler = new RecursionFibonacciSequenceRabbit();
    int pairs = handler.handle(6);
    System.out.println(pairs);
  }
}
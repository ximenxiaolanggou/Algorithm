package top.damoncai.chapter_12_recursionfibonaccisequencefrog;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhishun.cai
 * @date 2024/12/30
 */
public class RecursionFibonacciSequenceFrogTest {

  @Test
  public void testRecursionFibonacciSequenceFrog() {
    RecursionFibonacciSequenceFrog handler = new RecursionFibonacciSequenceFrog();
    int way = handler.handle(10);
    System.out.println(way);
  }
}
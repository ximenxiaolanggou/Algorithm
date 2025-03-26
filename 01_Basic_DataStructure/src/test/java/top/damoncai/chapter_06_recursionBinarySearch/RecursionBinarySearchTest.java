package top.damoncai.chapter_06_recursionBinarySearch;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;
/**
 *
 *
 * @author zhishun.cai
 * @date 2024/11/14  
 */

@Slf4j
public class RecursionBinarySearchTest {

  @Test
  public void testRecursionBinarySearch() {
    RecursionBinarySearch tool = new RecursionBinarySearch();
    Person p1 = new Person("张三", 11);
    Person p2 = new Person("李四", 13);
    Person p3 = new Person("王五", 15);
    Person p4 = new Person("赵三", 17);
    Person p5 = new Person("李茜", 18);
    Person p6 = new Person("大张伟", 19);

    Person[] persons = {p1, p2, p3, p4, p5, p6};

    Arrays.sort(persons);

    int index = tool.binarySearch(persons, p3, 0, 6);

    log.info("index = {}", index);
  }
}
package top.damoncai.chapter_06_recursionBinarySearch;

import java.lang.Comparable;
import java.util.Arrays;

/**
 *
 *
 * @author zhishun.cai
 * @date 2024/11/14  
 */
public class Person implements Comparable<Person> {
  public String username;
  public Integer age;

  public Person(String username, Integer age) {
    this.username = username;
    this.age = age;
  }

  @Override
  public int compareTo(Person o) {
    return Integer.compare(this.age, o.age);
  }
}

package top.damoncai.chapter_10_recursionfibonaccisequence;

/**
 * 斐波那契数列问题
 * @author zhishun.cai
 * @date 2024/12/27
 */
public class RecursionFibonacciSequence {

    public int handle(int index) {

        if(index == 0 || index == 1) {
            return index;
        }

        int stepOne = handle(index - 1);
        int steTwo = handle(index - 2);

        return stepOne + steTwo;

    }
}

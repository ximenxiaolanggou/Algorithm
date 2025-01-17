package top.damoncai.chapter_12_recursionfibonaccisequencefrog;

/**
 * 斐波那契数列 - 青蛙跳台阶
 * @author zhishun.cai
 * @date 2024/12/30
 */
public class RecursionFibonacciSequenceFrog {

    /**
     * 第n次方式 = 第n-1方式 + 第n-2方式
     * @param num
     * @return
     */
    public int handle(int num) {
        if(num == 1 || num == 2) {
            return num;
        }
        return handle(num - 1) + handle(num - 2);
    }
}

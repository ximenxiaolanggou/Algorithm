package top.damoncai.chapter_11_recursionfibonaccisequencerabbit;

/**
 * 斐波那契 - 兔子问题
 * @author zhishun.cai
 * @date 2024/12/30
 */
public class RecursionFibonacciSequenceRabbit {


    /**
     * 每月兔子数 = 上个月兔子数 + 上个月成熟的兔子（上上个月兔子数）
     * @param num
     * @return
     */
    public int handle(int num) {
        if(num == 1 || num == 2) {
            return 1;
        }
        return handle(num - 1) + handle(num - 2);
    }
}

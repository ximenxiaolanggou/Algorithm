package top.damoncai.chapter_07_recursionPrintString;

/**
 *
 * 递归的方式打印字符串
 * @author zhishun.cai
 * @date 2024/12/24
 */
public class RecursionPrintString {

    public void recursionPrintString(String str) {
        if(str == null || str.length() == 0) {
            return;
        }
        doPrint(str, 0);
    }

    public void doPrint(String str, int index) {
        // 当递归次数超出字符长度，退出
        if(str.length() == index) {
            return;
        }
        doPrint(str, index + 1);
        System.out.print(str.charAt(index));
    }
}

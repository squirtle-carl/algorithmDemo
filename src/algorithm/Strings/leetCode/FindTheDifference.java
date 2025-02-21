package algorithm.Strings.leetCode;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe 找不同
 * @date 2025/02/21
 */
public class FindTheDifference {
    /**
     * 给定两个字符串 s 和 t ，它们只包含小写字母。
     * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
     * 请找出在 t 中被添加的字母。
     * 示例 1：
     * 输入：s = "abcd", t = "abcde"
     * 输出："e"
     * 解释：'e' 是那个被添加的字母。
     * 示例 2：
     * 输入：s = "", t = "y"
     * 输出："y"
     * 提示：
     * 0 <= s.length <= 1000
     * t.length == s.length + 1
     * s 和 t 只包含小写字母
     */

    /**
     * 思路1：将字符串s转换为字符，遍历字符，将字符从t中删除，最后剩下的字符就是添加的字符
     */
    public static char findTheDifference(String s, String t) {
        if(s == null || s.isEmpty()){
            return t.charAt(0);
        }
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            t = t.replaceFirst(String.valueOf(c), "");
        }
        return t.charAt(0);
    }

    /**
     * 思路2：使用计算的方式，因为字符是可以计算的，所以，先将s和t计算出结果后，由t-s得出最后的字符
     */
    public static char findTheDifference2(String s, String t) {
        if(s == null){
            return 0;
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        if(s.isEmpty()){
            return tc[tc.length - 1];
        }
        int sums = 0;
        int sumt = 0;
        for (int i = 0; i < sc.length; i++) {
            sums += sc[i];
            sumt += tc[i];
        }
        sumt += tc[tc.length - 1];
        return (char) (sumt-sums);
    }
    public static void main(String[] args) {
        System.out.println(findTheDifference2("abcd", "abcde"));
    }
}

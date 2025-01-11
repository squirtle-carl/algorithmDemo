package algorithm.Strings.leetCode;

/**
 * @author 爱编程的杰尼龟
 * @version 1.0.0
 * @doc 找出字符串中第一个匹配项的下标
 * @date 2025/01/11
 */
public class FindFirstIndex {
    /**
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
     * 示例 1：
     * 输入：haystack = "sadbutsad", needle = "sad"
     * 输出：0
     * 解释："sad" 在下标 0 和 6 处匹配。
     * 第一个匹配项的下标是 0 ，所以返回 0 。
     * 示例 2：
     * 输入：haystack = "leetcode", needle = "leeto"
     * 输出：-1
     * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
     * 提示：
     * 1 <= haystack.length, needle.length <= 104
     * haystack 和 needle 仅由小写英文字符组成
     */
    public static int strStr(String haystack, String needle){
        // 1. 排除异常数据
        if(needle.length() == 0 || haystack.length() == 0){
            return -1;
        }
        // 2. 遍历 haystack 字符串，逐个遍历时，到最后一个匹配元素的下标应该是 haystack.length() - needle.length()
        for (int i = 0; i < haystack.length()-needle.length()+1; i++) {
            // 3. 逐个字符比较，如果相同，则返回当前下标
            String substring = haystack.substring(i, i + needle.length());
            if(substring.equals(needle)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
        System.out.println(strStr("mississippi", "issip"));
    }
}

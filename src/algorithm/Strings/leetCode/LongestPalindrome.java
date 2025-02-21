package algorithm.Strings.leetCode;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe 最长回文
 * @date 2025/02/21
 */
public class LongestPalindrome {
    /**
     * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的 回文串 的长度。
     * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
     * 示例 1:
     * 输入:s = "abccccdd"
     * 输出:7
     * 解释:
     * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     * 示例 2:
     * 输入:s = "a"
     * 输出:1
     * 解释：可以构造的最长回文串是"a"，它的长度是 1。
     * 提示:
     * 1 <= s.length <= 2000
     * s 只由小写 和/或 大写英文字母组成
     */
    // 思路：使用一个长度为128的数组记录每个字符出现的次数，然后统计奇数个字符的数量，记录奇数个数的字符，用字符总长度-奇数字符个数，最后剩下的就是回文字符串。
    public static int longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int[] charCount = new int[128];
        for (char c : s.toCharArray()) {
            charCount[c]++;
        }
        int oddCount = 0;
        for (int count : charCount) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }
        return s.length() - oddCount + (oddCount > 0 ? 1 : 0);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
}

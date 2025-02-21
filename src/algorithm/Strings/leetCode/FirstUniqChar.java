package algorithm.Strings.leetCode;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe 第一个不重复字符
 * @date 2025/02/14
 */
public class FirstUniqChar {
    /**
     * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
     * 示例 1：
     * 输入: s = "leetcode"
     * 输出: 0
     * 示例 2:
     * 输入: s = "loveleetcode"
     * 输出: 2
     * 示例 3:
     * 输入: s = "aabb"
     * 输出: -1
     * 提示:
     * 1 <= s.length <= 105
     * s 只包含小写字母
     */
    public static int uniqCharFirst(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(uniqCharFirst("acaadcad"));
    }
}

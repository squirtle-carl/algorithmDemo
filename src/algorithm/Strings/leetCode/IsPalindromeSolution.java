package algorithm.Strings.leetCode;

public class IsPalindromeSolution {
    /**
     * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
     * 字母和数字都属于字母数字字符。
     * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
     */
    public static boolean isPalindrome(String s) {
        //将字符串转换为小写，并移除所有非字母数字字符
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        if(s.length() == 0){
            return true;
        }
        //回文的特点是正着读和反着读都一样，那么反转字符串，如果相等则是回文，不相等则是非回文
        return s.contentEquals(new StringBuilder(s).reverse());
    }
    public static void main(String[] args) {
        String s = "ab";
        System.out.println(isPalindrome(s));
    }
}

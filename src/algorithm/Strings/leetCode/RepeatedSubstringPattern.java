package algorithm.Strings.leetCode;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe 重复的子字符串
 * @date 2025/02/21
 */
public class RepeatedSubstringPattern {
    /**
     * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
     * 示例 1:
     * 输入: s = "abab"
     * 输出: true
     * 解释: 可由子串 "ab" 重复两次构成。
     * 示例 2:
     * 输入: s = "aba"
     * 输出: false
     * 示例 3:
     * 输入: s = "abcabcabcabc"
     * 输出: true
     * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
     * 提示：
     * 1 <= s.length <= 10^4
     * s 由小写英文字母组成
     */
    public static boolean repeatedSubstringPattern(String s) {
        if(s.isEmpty()){
            return false;
        }
        char[] charArray = s.toCharArray();
        String sub = String.valueOf(charArray[0]);
        String result = "";
        for (int i = 1; i < charArray.length; i++){
            result = "";
            //如果字符串不能被子序列整除，则继续加
            if(charArray.length%sub.length() != 0){
                sub += charArray[i];
            }else{
                for (int j = 0; j<charArray.length/sub.length() ;j++){
                    result += sub;
                }
                if(s.equals(result)){
                    return true;
                }else{
                    sub += charArray[i];
                }
            }
        }
        return false;
    }

    public static boolean repeatedSubstringPattern2(String s) {
        if(s.length()==0) {
            return false;
        }
        int len = s.length();
        //给原串加空格（哨兵），使下标从1开始，这样j从0开始就不用初始化

        char[] chars = s.toCharArray();
        int[] next = new int[len]; //next的0\1位置都是0，不用再初始化
        int j=0;
        next[0]=0;
        //构造next数组
        for(int i=1;i<len;i++){
            while(j>0 && chars[j]!=chars[i]) {//如果j大于0 并且 第j位不等于第i位
                j=next[j-1];
            }
            if(chars[i]==chars[j]) {
                j++;
            }
            next[i]=j;
        }
        if(next[len-1]>0 && len%(len-next[len-1])==0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        String  s = "abcabc";
//        String sub = "abc";
//
//        System.out.println(s.substring(0,sub.length()).contains(s));
        long startTime = System.currentTimeMillis();
        System.out.println(repeatedSubstringPattern2("abab"));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}

package algorithm.Strings.leetCode;

/**
 * @author caihuaxin
 * @version 1.0.0
 * @describe 最长公共前缀
 * @date 2024/01/05
 */
public class LongestCommonPrefix {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * 示例 1：
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 示例 2：
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     * 提示：
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] 仅由小写英文字母组成
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        //默认以第一个字符串作为公共前缀
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
            // 求出当前字符串和公共前缀谁更短
            int minLength = Math.min(prefix.length(), strs[i].length());
            //设定一个索引从0开始，如果当前缀的字符与当前字符串的字符相同，则索引加1
            int index = 0;
            while (index < minLength && prefix.charAt(index) == strs[i].charAt(index)){
                index++;
            }
            //直接截取该字符串比对相等的部分，作为下一次循环的前缀
            prefix = strs[i].substring(0, index);
            //如果为空，则无需继续比对，直接跳出循环即可
            if(prefix.isEmpty()){
                break;
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}

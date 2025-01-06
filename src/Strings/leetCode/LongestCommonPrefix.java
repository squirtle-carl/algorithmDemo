package Strings.leetCode;

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
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
            int minLength = Math.min(prefix.length(), strs[i].length());
            int index = 0;
            while (index < minLength && prefix.charAt(index) == strs[i].charAt(index)){
                index++;
            }
            prefix = strs[i].substring(0, index);
            if(prefix.isEmpty()){
                break;
            }
        }

        return prefix;
    }
}

package algorithm.Strings.leetCode;

import java.util.Stack;

/**
 * @author caihuaxin
 * @version 1.0.0
 * @describe 有效的括号
 * @date 2024/01/06
 */
public class IsValid {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * 示例 1:
     * 输入: "()"
     * 输出: true
     * 示例 2:
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     * 输入: "(]"
     * 输出: false
     * 提示：
     * 1 <= s.length <= 10^4
     * s 仅由括号 '()[]{}' 组成
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));//是左括号就push进栈
            } else {
                if (stack.isEmpty()) {//如果一个左括号都没有，肯定不是有效的括号
                    return false;
                }
                char c = stack.pop();//如果当前字符不是左括号，那就要将栈顶元素弹出
                if ((c == '(' && s.charAt(i) == ')') || (c == '[' && s.charAt(i) == ']') || (c == '{' && s.charAt(i) == '}')) {
                    continue;//如果当前字符是左括号，并且栈顶元素是右括号，就继续下一个匹配
                } else {
                    return false;
                }
            }
        }
        //直到栈中元素清空，则说明全部匹配完成，否则非有效括号
        if (stack.isEmpty()) {
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        System.out.println(isValid.isValid("([)]"));
    }
}

package algorithm.Strings.leetCode;

import java.sql.PreparedStatement;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe excel标题转数字
 * @date 2025/01/16
 */
public class ExcelTitleToNum {
    /**
     * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
     * 例如：
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * ...
     * 示例 1:
     * 输入: columnTitle = "A"
     * 输出: 1
     * 示例 2:
     * 输入: columnTitle = "AB"
     * 输出: 28
     * 示例 3:
     * 输入: columnTitle = "ZY"
     * 输出: 701
     * 提示：
     * 1 <= columnTitle.length <= 7
     * columnTitle 仅由大写英文组成
     * columnTitle 在范围 ["A", "FXSHRXW"] 内
     */

    public static int titleToNumber(String columnTitle){
        int sum=0;
        for (int i = 0; i < columnTitle.length(); i++) {
            int k = columnTitle.charAt(i)-'A'+1;
            sum = sum * 26 + k;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println((titleToNumber("AZ")));
    }
}

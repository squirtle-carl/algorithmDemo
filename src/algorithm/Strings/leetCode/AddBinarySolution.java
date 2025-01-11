package algorithm.Strings.leetCode;

/**
 * @author 爱编程的杰尼龟
 * @version 1.0.0
 * @doc 二进制求和
 * @date 2025/01/11
 */
public class AddBinarySolution {
    /**
     * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
     */
    public static String addBinary(String a, String b) {
        if(a.length() < b.length()){
            int diffLength = b.length() - a.length();
            StringBuilder aBuilder = new StringBuilder(a);
            for (int i = 0; i < diffLength; i++) {
                aBuilder.insert(0, "0");
            }
            a = aBuilder.toString();
        }else{
            int diffLength = a.length() - b.length();
            StringBuilder bBuilder = new StringBuilder(b);
            for (int i = 0; i < diffLength; i++) {
                bBuilder.insert(0, "0");
            }
            b = bBuilder.toString();
        }
        int carry = 0;//当前位置
        int sum = 0; //进位值
        StringBuilder result = new StringBuilder();
        for (int i = a.length() - 1; i >= 0 ; i--) {
            if(a.charAt(i) == '1' && b.charAt(i) == '1' && sum == 0) {
                sum = 1;
                carry = 0;
            }else if (a.charAt(i) == '1' && b.charAt(i) == '1' && sum == 1) {
                sum = 1;
                carry = 1;
            }else if(a.charAt(i) == '0' && b.charAt(i) == '0' && sum == 0){
                sum = 0;
                carry = 0;
            }else if(a.charAt(i) == '0' && b.charAt(i) == '0' && sum == 1){
                sum = 0;
                carry = 1;
            }else if((a.charAt(i) == '1' && b.charAt(i) == '0')
                    || (a.charAt(i) == '0' && b.charAt(i) == '1') && sum == 0){
                sum = 0;
                carry = 1;
            }else if((a.charAt(i) == '1' && b.charAt(i) == '0')
                    || (a.charAt(i) == '0' && b.charAt(i) == '1') && sum == 1){
                sum = 1;
                carry = 0;
            }else{
                sum = 0;
                carry = 1;
            }
            result.insert(0, carry);
        }
        if(sum == 1){
            result.insert(0, sum);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String a = "1111";
        String b = "1111";
        System.out.println(addBinary(a, b));
    }
}

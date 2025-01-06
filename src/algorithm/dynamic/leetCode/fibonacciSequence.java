package algorithm.dynamic.leetCode;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe 斐波那契数列
 * @date 2025/01/06
 */
public class fibonacciSequence {
    public static void main(String[] args) {
        int i = fibonacci(6);
        System.out.println(i);
    }

    private static int fibonacci(int n) {
        if(n<2){
            return n;
        }
        if(n>30){
            return -1;
        }
        int [] dp=new int[3];
        dp[2]=1;
        for(int i=2;i<=n;i++){
            int sum = dp[1]+dp[2];
            dp[1]=dp[2];
            dp[2]=sum;
        }
        return dp[2];
    }
}

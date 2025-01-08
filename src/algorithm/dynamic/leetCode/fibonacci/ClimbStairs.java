package algorithm.dynamic.leetCode.fibonacci;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * 提示：
 * 1 <= n <= 45
 */
public class ClimbStairs {
    public static void main(String[] args) {
        int i = climbStair(20);
        System.out.println(i);
    }
    public static int climbStair(int n) {
        if(n<=1){
            return n;
        }
        if(n>46){
            return -1;
        }
        // f(n)=f(n-1)+f(n-2)
        int [] dp = new int[3];
        //初始化第一阶的次数和第二阶的次数
        dp[1]=1;//f(n-2)
        dp[2]=2;//f(n-1)
        //已知第一阶和第二阶的方法数，从第三阶开始，循环计算f(n)
        for (int i = 3; i <= n; i++) {
            int sum = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = sum;
        }
        return dp[2];
    }
}

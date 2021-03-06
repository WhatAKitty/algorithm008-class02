/**
 * Implement pow(x, n), which calculates x raised to the power n (x^n).
 *
 * Example 1:
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 *
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
 *
 * @author WhatAKitty
 * @date 2020/05/17
 * @since 1.0.0
 **/
public class PowXn {

    /**
     * 审题：
     * 1. x的幂等结果计算
     * 2. -100.0 < x < 100.0
     * 3. n为32位有符号整数，在[−2^31, 2^31 − 1]之间
     * 可能解决方案：
     * 1. 分治
     */
    /**
     * 分治思路：
     * 1. 结束条件：分治次数大于 n 的绝对数值
     * 2. 处理
     *      * n > 0
     *      * n < 0
     *      * n == 0
     */
    public double myPow(double x, int n) {
        return 1;
    }

}

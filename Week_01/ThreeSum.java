import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author WhatAKitty
 * @date 2020/04/19
 * @since 1.0.0
 **/
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        final List<List<Integer>> result = new ArrayList<>();
        for (int k = 0; k < nums.length; k++) {
            int i = k + 1, j = nums.length - 1;
            if (nums[k] > 0 || k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }

            while (i < j) {
                int lo = nums[i];
                int hi = nums[j];

                int s = lo + hi + nums[k];
                if (s < 0) {
                    do {
                        i++;
                    } while (i < j && nums[i] == nums[i - 1]);
                } else if (s > 0) {
                    do {
                        j--;
                    } while (i < j && nums[j] == nums[j + 1]);
                } else {
                    result.add(Arrays.asList(nums[k], lo, hi));
                    do {
                        i++;
                    } while (i < j && nums[i] == nums[i - 1]);
                    do {
                        j--;
                    } while (i < j && nums[j] == nums[j + 1]);
                }
            }
        }
        return result;
    }

}

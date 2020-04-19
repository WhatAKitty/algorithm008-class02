import java.util.List;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WhatAKitty
 * @date 2020/04/19
 * @since 1.0.0
 **/
public class ThreeSumTest {

    @Test
    public void test() {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> result = threeSum.threeSum(new int[] {-2,0,1,1,2});

        System.out.println(result);
    }

    @Test
    public void test_zero() {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> result = threeSum.threeSum(new int[] {0, 0, 0});

        System.out.println(result);
    }

}
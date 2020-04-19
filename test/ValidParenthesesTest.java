import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WhatAKitty
 * @date 2020/04/19
 * @since 1.0.0
 **/
public class ValidParenthesesTest {

    @Test
    public void test() {
        ValidParentheses validParentheses = new ValidParentheses();
        validParentheses.isValid("{[]}");
    }

}
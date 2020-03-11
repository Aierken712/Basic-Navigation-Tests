package com.cbt.utilities;

public class StringUtility {

    /**
     * Check if to strings are same. If print TEST PASSED! message.
     * Otherwise, print TEST FAILED message
     * @param expected
     * @param actual
     */
    public static void verifyEquals(String expected, String actual){
        if(expected.equals(actual)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        System.out.println(expected);
        System.out.println(actual);

    }

}

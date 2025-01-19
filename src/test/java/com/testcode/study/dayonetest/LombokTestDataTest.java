package com.testcode.study.dayonetest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LombokTestDataTest {

    @Test
    public void testDataTest(){
        TestData testData = new TestData();
        testData.setName("sujung");

        Assertions.assertEquals("sujung", testData.getName());
    }
}

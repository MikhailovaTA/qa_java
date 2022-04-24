package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionWithParametrizedTests {
    private final String sex;
    private final boolean expected;

    public LionWithParametrizedTests(String sex, boolean expected){
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getLionSex() {
        return new Object[][] {
            { "Самка", false},
            { "Самец", true},
        };
    }

    @Test
    public void shouldNotHaveMane() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline, sex);
        boolean actualResult = lion.doesHaveMane();
        Assert.assertEquals(expected, actualResult);
    }

}
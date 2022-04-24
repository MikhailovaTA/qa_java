package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class FelineTests {

    @Spy
    Feline feline;

    @Test
    public void shouldGetKittens(){
        int expectedKittens = 1;
        int actualKittens = feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
        Assert.assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void shouldGetKittensCount(){
        int expectedKittensCount = 5;
        int actualKittensCount = feline.getKittens(5);
        Assert.assertEquals(expectedKittensCount, actualKittensCount);
    }

    @Test
    public void shouldGetFoodList() throws Exception{
        List<String> expectedFoods = Arrays.asList("Животные");
        Mockito.when(feline.getFood("Хищник")).thenReturn(Arrays.asList("Животные"));
        List<String> actualFoods = feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
        Assert.assertEquals(expectedFoods, actualFoods);
    }

    @Test
    public void shouldGetFamily(){
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        Assert.assertEquals(expectedFamily, actualFamily);
    }
}

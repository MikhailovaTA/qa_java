package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionWithMockTests {

    @Mock
    Feline feline;

    @Test
    public void shouldHaveException(){
        Feline feline = new Feline();
        Throwable thrown = Assert.assertThrows(Exception.class, () -> {
            new Lion(feline, "Sамец");
        });
        String expected = "Используйте допустимые значения пола животного - самей или самка";
        assertEquals(expected, thrown.getMessage());
    }

    @Test
    public void shouldGetCountKittens() throws Exception{
        Lion lion = new Lion(feline, "Самец");
        int expectedKittens = 1;
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualKittens = lion.getKittens();
        Assert.assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void shouldGetFoodList() throws Exception{
        Lion lion = new Lion(feline, "Самка");
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> actualFood = lion.getFood();
        Assert.assertEquals(expectedFood, actualFood);
    }
}

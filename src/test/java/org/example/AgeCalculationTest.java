package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AgeCalculationTest {
    AgeCalculation ageCalculation = new AgeCalculation();

@Test
public void testIsBathMonth(){


    int expected =11;
    int actual = ageCalculation.isBathMonth(11);

    assertEquals(expected, actual);

}

    @Test
    public void testIsBathMonth1(){
        assertThrows(IllegalArgumentException.class, () -> ageCalculation.isBathMonth(-5));

    }

    @Test
    public void testIsBathDay(){


        int expected =23;
        int actual = ageCalculation.isBathDay(23);

        assertEquals(expected, actual);

    }

    @Test
    public void testIsBathDay1(){
        assertThrows(IllegalArgumentException.class, () -> ageCalculation.isBathDay(-5));

    }

    @Test
    public void testIsBathYear(){
        int expected =23;
        int actual = ageCalculation.isBathDay(23);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsBathYear1(){
        assertThrows(IllegalArgumentException.class, () -> ageCalculation.isBathYear(-5));

    }


//    @Test
//    public void testIsAgeCalculation() throws IOException {
//        int expected =23;
//        int actual = ageCalculation.isAgeCalculation(2,2,2000);
//
//        assertEquals(expected, actual);
//
//    }
    }

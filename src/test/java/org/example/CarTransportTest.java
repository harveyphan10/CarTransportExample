package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTransportTest {

    private CarTransport carTransportUnderTest;

    @BeforeEach
    void setUp() {
        carTransportUnderTest = new CarTransport();
    }

    @Test
    public void testAllCarsNeeded() {
        int[] seats = {2, 3, 4, 5};
        int[] people = {2, 3, 4, 5};
        assertEquals(4, carTransportUnderTest.numberOfCar(seats, people));
    }

    @Test
    public void testOnlyOneCar() {
        int[] seats = {10, 5, 3};
        int[] people = {1, 2, 3};
        assertEquals(1, carTransportUnderTest.numberOfCar(seats, people));
    }

    @Test
    public void testEfficientPacking() {
        int[] seats = {5, 5, 5, 5};
        int[] people = {2, 3, 3, 2};
        assertEquals(2, carTransportUnderTest.numberOfCar(seats, people));
    }

    @Test
    public void testLargeGroups() {
        int[] seats = {10, 10, 10, 10};
        int[] people = {8, 9, 8, 9};
        assertEquals(4, carTransportUnderTest.numberOfCar(seats, people));
    }

    @Test
    public void testMaxCapacityUsage() {
        int[] seats = {7, 7, 7};
        int[] people = {3, 4, 5};
        assertEquals(2, carTransportUnderTest.numberOfCar(seats, people));
    }

    @Test
    public void testDifferentArrayLengths() {
        int[] seats = {1, 2, 3};
        int[] people = {1, 2};
        assertThrows(IllegalArgumentException.class, () ->
                carTransportUnderTest.numberOfCar(seats, people));
    }

    @Test
    public void testInsufficientSeats() {
        int[] seats = {1, 2, 3};
        int[] people = {1, 3, 2};
        assertThrows(IllegalArgumentException.class, () ->
                carTransportUnderTest.numberOfCar(seats, people));
    }

    @Test
    public void testEmptyArrays() {
        int[] seats = {};
        int[] people = {};
        assertEquals(0, carTransportUnderTest.numberOfCar(seats, people));
    }

    @Test
    public void testSingleElement() {
        int[] seats = {5};
        int[] people = {3};
        assertEquals(1, carTransportUnderTest.numberOfCar(seats, people));
    }

    // Edge case where exactly full capacity is used
    @Test
    public void testExactCapacity() {
        int[] seats = {5, 5, 5};
        int[] people = {2, 3, 5};
        assertEquals(2, carTransportUnderTest.numberOfCar(seats, people));
    }
}

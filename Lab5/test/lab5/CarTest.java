package lab5;

import org.junit.Test;
import static org.junit.Assert.*;

public class CarTest {

    public CarTest() {
    }

    @Test
    public void testConstructor() {
        // AAA convention

        // Arrange - setting up variables for testing
        String expectedMake = "Ford";
        String expectedModel = "Transit";
        double expectedKilometersPerLiter = 4.8;
        double expectedCapacityInLiters = 100;
        double expectedLitersInTank = expectedCapacityInLiters;
        String expectedStringValue = "Ford Transit";

        // Act - calling the code we are testing - and get actual values
        Car car = new Car(expectedMake, expectedModel,
                expectedKilometersPerLiter, expectedCapacityInLiters);
        String actualMake = car.getMake();
        String actualModel = car.getModel();
        double actualKilometersPerLiter = car.getKilometersPerLiter();
        double actualCapacityInLiters = car.getTankCapacityInLiters();
        double actualLitersInTank = car.getLitersInTank();
        String actualStringValue = car.toString();

        // Assert - checking if we got what we expected
        assertEquals(expectedMake, actualMake);
        assertEquals(expectedModel, actualModel);
        assertEquals(expectedKilometersPerLiter, actualKilometersPerLiter, .000001);
        assertEquals(expectedCapacityInLiters, actualCapacityInLiters, .000001);
        assertEquals(expectedLitersInTank, actualLitersInTank, .000001);
        assertEquals(expectedStringValue, actualStringValue);

    }

    @Test
    public void testAddGasReturnsTrue() {
        // Arrange
        double expectedKilometersPerLiter = 10;
        double expectedCapacityInLiters = 100;
        Car car = new Car("", "", expectedKilometersPerLiter, expectedCapacityInLiters);
        car.drive(expectedKilometersPerLiter * expectedCapacityInLiters);
        double expectedLitersInTank = 1;

        // Act
        boolean actualResult = car.addGas(expectedLitersInTank);
        double actualLitersInTank = car.getLitersInTank();

        // Asert
        assertTrue(actualResult);
        assertEquals(expectedLitersInTank, actualLitersInTank, .000001);
    }

    @Test
    public void testAddGasReturnsFalse() {
        // Arrange
        double expectedKilometersPerLiter = 10;
        double expectedCapacityInLiters = 100;
        Car car = new Car("", "", expectedKilometersPerLiter, expectedCapacityInLiters);

        // Act
        boolean actualResult = car.addGas(1);

        // Asert
        assertFalse(actualResult);
    }

    @Test
    public void testDriveReturnsTrue() {
        // Arrange
        double expectedKilometersPerLiter = 10;
        double expectedCapacityInLiters = 100;
        Car car = new Car("", "", expectedKilometersPerLiter, expectedCapacityInLiters);
        double expectedLitersInTank = expectedCapacityInLiters - 1;
        
        // Act
        boolean actualResult = car.drive(10);
        double actualLitersInTank = car.getLitersInTank();

        // Asert
        assertTrue(actualResult);
        assertEquals(expectedLitersInTank, actualLitersInTank, .000001);
    }

    @Test
    public void testDriveReturnsFalse() {
        // Arrange
        double expectedKilometersPerLiter = 10;
        double expectedCapacityInLiters = 100;
        Car car = new Car("", "", expectedKilometersPerLiter, expectedCapacityInLiters);
        double expectedLitersInTank = 0;
        
        // Act
        boolean actualResult = car.drive(expectedKilometersPerLiter * expectedCapacityInLiters + 1);
        double actualLitersInTank = car.getLitersInTank();

        // Asert
        assertFalse(actualResult);
        assertEquals(expectedLitersInTank, actualLitersInTank, .000001);

    }

}

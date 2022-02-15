package lab6;

import org.junit.Test;
import static org.junit.Assert.*;

public class ItemTest {
    
    public ItemTest() {
    }

    @Test
    public void testPurchaseReturnsTrue() {
                // arrange
        int expectedQuantity = 42;
        Item item = new Item("", 50, 0);
        
        // act
        boolean actualResult = item.purchase(8);
        int actualQuantity = item.getQuantity();
        
        // assert
        assertTrue(actualResult);
        assertEquals(expectedQuantity, actualQuantity);
    }
    
    @Test
    public void testPurchaseReturnsFalse() {
        // arrange
        int expectedQuantity = 42;
        Item item = new Item("", expectedQuantity, 0);
        
        // act
        boolean actualResult = item.purchase(expectedQuantity + 1);
        int actualQuantity = item.getQuantity();
        
        // assert
        assertFalse(actualResult);
        assertEquals(expectedQuantity, actualQuantity);
        
    }

    @Test
    public void testConstructor() {
        // Arrange
        String expectedName = "coffee";
        int expectedQuantity = 42;
        double expectedPrice = .99;
        String expectedToString = "coffee $0.99";
        
        // Act
        Item item = new Item(expectedName, expectedQuantity, expectedPrice);
        String actualName = item.getName();
        int actualQuantity = item.getQuantity();
        double actualPrice = item.getPrice();
        String actualToString = item.toString();
        
        // Assert
        assertEquals(expectedName, actualName);
        assertEquals(expectedQuantity, actualQuantity);
        assertEquals(expectedPrice, actualPrice, .000001);
        assertEquals(expectedToString, actualToString);
        
    }

    
    
}

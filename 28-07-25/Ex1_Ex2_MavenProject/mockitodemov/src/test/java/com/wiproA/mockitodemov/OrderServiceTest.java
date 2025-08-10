package com.wiproA.mockitodemov;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class OrderServiceTest {
	@Test
    public void testPlaceOrder() {
        // Create a mock object
        OrderService mockOrderService = mock(OrderService.class);

        // Define behavior
        when(mockOrderService.placeOrder("ORD-01")).thenReturn("successful");

        // Call the method
        String result = mockOrderService.placeOrder("ORD-01");

        // Assert result
        assertEquals("successful", result);

        // Verify that method was called
        verify(mockOrderService).placeOrder("ORD-01");
    }
}

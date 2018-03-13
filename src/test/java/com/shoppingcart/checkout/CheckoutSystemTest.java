package com.shoppingcart.checkout;


import static org.hamcrest.CoreMatchers.is;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple CheckoutSystem.
 */
public class CheckoutSystemTest {

	private CheckoutSystem checkoutSystem;

	@Before
	public void setUp() {
		checkoutSystem = new CheckoutSystem();
	}

	@Test
	public void shouldReturnItemListforShoppingCartWithoutOffer() throws Exception {
		assertThat("1 Apple", checkoutSystem.itemsList(asList("Apple"), false), is("£0.60"));
		assertThat("2 Apple", checkoutSystem.itemsList(asList("Apple", "Apple"), false), is("£1.20"));
		assertThat("2 Apple 1 Orange", checkoutSystem.itemsList(asList("Apple", "Apple", "Orange"), false), is("£1.45"));
	}

	

}
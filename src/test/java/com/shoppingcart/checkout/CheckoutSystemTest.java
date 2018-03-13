package com.shoppingcart.checkout;


import static org.hamcrest.CoreMatchers.is;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.shoppingcart.checkout.CheckoutSystem;
import com.shoppingcart.checkout.OffersServiceImpl;

/**
 * Unit test for simple CheckoutSystem.
 */
public class CheckoutSystemTest {

	private CheckoutSystem checkoutSystem;

	@Before
	public void setUp() {
		checkoutSystem = new CheckoutSystem(new OffersServiceImpl());
	}

	@Test
	public void shouldReturnItemListforShoppingCartWithoutOffer() throws Exception {
		assertThat("1 Apple", checkoutSystem.itemsList(asList("Apple"), false), is("£0.60"));
		assertThat("2 Apple", checkoutSystem.itemsList(asList("Apple", "Apple"), false), is("£1.20"));
		assertThat("2 Apple 1 Orange", checkoutSystem.itemsList(asList("Apple", "Apple", "Orange"), false), is("£1.45"));
	}

	@Test
	public void shouldReturnItemListforShoppingCartWithBuyOneGetOneFreeAppleOffer() throws Exception {
		assertThat("Number of apples : 1", checkoutSystem.itemsList(asList("Apple"),true), is("£0.60"));
		assertThat("Number of apples : 2", checkoutSystem.itemsList(asList("Apple", "Apple"),true), is("£0.60"));
		assertThat("Number of apples : 3", checkoutSystem.itemsList(asList("Apple", "Apple", "Apple"),true), is("£1.20"));
	}

	@Test
	public void shouldReturnItemListforShoppingCartWithThreeForTwoOrangeOffer() throws Exception {
		assertThat("Number of orange : 1", checkoutSystem.itemsList(asList("Orange"),true), is("£0.25"));
		assertThat("Number of orange : 2", checkoutSystem.itemsList(asList("Orange", "Orange"),true), is("£0.50"));
		assertThat("Number of orange : 3", checkoutSystem.itemsList(asList("Orange", "Orange", "Orange"),true), is("£0.50"));
		assertThat("Number of orange : 4", checkoutSystem.itemsList(asList("Orange", "Orange", "Orange", "Orange"),true),
				is("£0.75"));
	}

	@Test
	public void shouldReturnItemListforShoppingCartWithComboOffer() throws Exception {
		assertThat("Number of apple: 2, Orange: 1", checkoutSystem.itemsList(asList("Apple", "Apple", "Orange"),true), is("£0.85"));
		assertThat("Number of apple: 2, Orange: 3",
				checkoutSystem.itemsList(asList("Apple", "Apple", "Orange", "Orange", "Orange"),true), is("£1.10"));
	}

}
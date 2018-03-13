package com.shoppingcart.checkout;

import static java.util.Collections.frequency;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * CheckoutSystem Class for all checkout for items added in shopping cart
 *
 */
public class CheckoutSystem 
{
	private static final int APPLE_COST = 60;
    private static final int ORANGE_COST = 25;
    
    private static final String APPLE = "Apple";
    private static final String ORANGE = "Orange";
    
    String itemsList(List<String> shopCart, Boolean offerApplicable) {

        int total = 0;

        int noOfApples = frequency(shopCart, APPLE);
        total += noOfApples*APPLE_COST;

        int noOfOranges = frequency(shopCart, ORANGE);
        total += noOfOranges*ORANGE_COST;

        return NumberFormat.getCurrencyInstance(Locale.UK).format(new BigDecimal(total * .01));
    }
    
    
}

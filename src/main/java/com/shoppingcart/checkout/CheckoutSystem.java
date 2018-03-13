package com.shoppingcart.checkout;

import static java.util.Collections.frequency;
import static java.util.Collections.nCopies;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import com.shoppingcart.checkout.OffersServiceImpl;

/**
 * CheckoutSystem Class for all checkout for items added in shopping cart
 *
 */
public class CheckoutSystem {


    private static final int APPLE_COST = 60;
    private static final int ORANGE_COST = 25;
    
    private static final String APPLE = "Apple";
    private static final String ORANGE = "Orange";
    
    private OffersServiceImpl offersServiceImpl;

    public CheckoutSystem(OffersServiceImpl offersServiceImpl) {
        this.offersServiceImpl = offersServiceImpl;
    }

    String itemsList(List<String> shopCart, Boolean offerApplicable) {

        int total = 0;

        int noOfApples = frequency(shopCart, APPLE);
        if(offerApplicable)
        total += offersServiceImpl.apply(nCopies(noOfApples, APPLE_COST).toArray(new Integer[noOfApples]), APPLE);
        else
        total += noOfApples*APPLE_COST;

        int noOfOranges = frequency(shopCart, ORANGE);
        if(offerApplicable)        
        total += offersServiceImpl.apply(nCopies(noOfOranges, ORANGE_COST).toArray(new Integer[noOfOranges]), ORANGE);
        else
        total += noOfOranges*ORANGE_COST;

        return NumberFormat.getCurrencyInstance(Locale.UK).format(new BigDecimal(total * .01));
    }


}
package com.shoppingcart.checkout;

/**
 * OffersServiceImpl Class for applying all applicable offers on items added in shopping cart
 *
 */
public class OffersServiceImpl implements OffersService {

	public int apply(Integer[] itemsCost, String item) {

		if (item.equalsIgnoreCase("apple")) {
			return appleOffer(itemsCost);
		} else if (item.equalsIgnoreCase("orange")) {
			return orangeOffer(itemsCost);
		} else {
			throw new IllegalArgumentException(item + " Item is not listed");
		}
	}
	
    public int appleOffer(Integer[] itemsCost) {

   	 int numberOfItems = itemsCost.length;
        
        if(numberOfItems==0){
            return 0;
        }

        return (numberOfItems /2)* itemsCost[0] + (numberOfItems %2)* itemsCost[0];
   }
  
   public int orangeOffer(Integer[] itemsCost) {

       int numberOfItems = itemsCost.length;

       if(numberOfItems==0){
           return 0;
       }

       return (numberOfItems /3)*2* itemsCost[0] +(numberOfItems %3)* itemsCost[0];
   }	
	
	

}
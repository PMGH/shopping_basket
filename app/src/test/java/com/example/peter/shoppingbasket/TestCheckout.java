package com.example.peter.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Peter on 25/11/2017.
 */

public class TestCheckout {

    private Item item1;
    private Item item2;
    private Item item3;
    private Item item4;
    private Item item5;
    private Customer customer1;
    private Customer customer2;
    private Checkout checkout;


    @Before
    public void before(){
        item1 = new Item("Gildan White T-Shirt", "Medium Gildan White T-Shirt", 12.00, true);
        item2 = new Item("Technical Tool Toko Edge Tuner", "Toko technical edge tuner with angle settings between 85 and 90 degrees.", 42.50, false);
        item3 = new Item("Amazon Echo Dot", "Amazon Echo Dot is a hands-free, voice-controlled device that uses Alexa to play music, control smart home devices, provide information, read the news, set alarms and more.", 49.99, false);
        item4 = new Item("Amazon Fire Stick", "Fire TV Stick with Alexa Voice Remote | Streaming Media Player.", 39.99, false);
        item5 = new Item("Oral-B Smart Series 6500", "Braun Oral-B Smart Series 6500 CrossAction Electric Rechargeable Toothbrush with Bluetooth Connectivity and Smart Series.", 55.49, true);

        customer1 = new Customer("Peter McCready");
        customer2 = new Customer("Alan Whyte");

        customer2.addToBasket(item1);
    }

    @Test
    public void testCheckoutStartsZero(){
        // customer1 has empty shopping basket
        checkout = new Checkout(customer1);

        assertEquals(0, checkout.getTotal(), 0.01);
    }

    @Test
    public void testCanCalculateInitialTotal(){
        // customer2 has items in shopping basket
        checkout = new Checkout(customer2);

        checkout.calculateInitialTotal();

        assertEquals(12.00, checkout.getTotal(), 0.01);
    }

    // Buy One Get One Free Discount Tests

    @Test
    public void testCanApplyBuyOneGetOneFreeDiscount__2_BOGOFItems(){
        // buy-one-get-one-free discounts on items
        // add another item to customer2's basket that is a BOGOF item
        customer2.addToBasket(item1);
        checkout = new Checkout(customer2);

        checkout.calculateInitialTotal();
        checkout.applyBuyOneGetOneFreeDiscount();

        assertEquals(12.00, checkout.getTotal(), 0.01);
    }

    @Test
    public void testCanApplyBuyOneGetOneFreeDiscount__5_BOGOFItems(){
        // add another item to customer2's basket that is a BOGOF item
        // 5 items in basket, should only charge for 3 as 2 are free
        customer2.addToBasket(item1);
        customer2.addToBasket(item1);
        customer2.addToBasket(item1);
        customer2.addToBasket(item1);
        checkout = new Checkout(customer2);

        checkout.calculateInitialTotal();
        checkout.applyBuyOneGetOneFreeDiscount();

        assertEquals(36.00, checkout.getTotal(), 0.01);
    }

    @Test
    public void testCanApplyBuyOneGetOneFreeDiscount__BOGOFItems_AndNonBOGOFItems(){
        // add another 6 BOGOF items (item1 abd item5) to customer2's basket and 4 non-BOGOF items
        // 5 items in basket, should only charge for 3 as 2 are free
        customer2.addToBasket(item1);
        customer2.addToBasket(item1);
        customer2.addToBasket(item1);
        customer2.addToBasket(item1);
        customer2.addToBasket(item2);
        customer2.addToBasket(item3);
        customer2.addToBasket(item4);
        customer2.addToBasket(item5);
        customer2.addToBasket(item5);
        checkout = new Checkout(customer2);

        checkout.calculateInitialTotal();
        checkout.applyBuyOneGetOneFreeDiscount();

        assertEquals(223.97, checkout.getTotal(), 0.01);
    }

    // Greater Than 20 Discount Tests

    @Test
    public void testCanApplyGreaterThanTwentyDiscount(){
        // 10% off on totals greater than £20 (after BOGOF discount is applied)
        customer2.addToBasket(item1);
        customer2.addToBasket(item1);
        customer2.addToBasket(item1);
        customer2.addToBasket(item1);
        customer2.addToBasket(item2);
        customer2.addToBasket(item3);
        customer2.addToBasket(item4);
        customer2.addToBasket(item5);
        customer2.addToBasket(item5);
        checkout = new Checkout(customer2);

        checkout.calculateInitialTotal();
        checkout.applyBuyOneGetOneFreeDiscount();
        // remove 10% of 223.97 (22.397, rounded to 22.40)
        checkout.applyGreaterThanTwentyDiscount();

        assertEquals(201.57, checkout.getTotal(), 0.01);
    }

    // Loyalty Discount Tests

    @Test
    public void testcannotApplyLoyaltyDiscount__noLoyaltyCard(){
        // 10% off on totals greater than £20 (after BOGOF discount is applied)
        customer2.addToBasket(item1);
        customer2.addToBasket(item1);
        customer2.addToBasket(item1);
        customer2.addToBasket(item1);
        customer2.addToBasket(item2);
        customer2.addToBasket(item3);
        customer2.addToBasket(item4);
        customer2.addToBasket(item5);
        customer2.addToBasket(item5);
        checkout = new Checkout(customer2);

        checkout.calculateInitialTotal();
        checkout.applyBuyOneGetOneFreeDiscount();
        // remove 10% of 223.97 (22.397, rounded to 22.40)
        checkout.applyGreaterThanTwentyDiscount();
        // remove 2% of 201.57 (4.0314, rounded to 4.03)
        checkout.applyLoyaltyDiscount();

        assertEquals(201.57, checkout.getTotal(), 0.01);
    }

    @Test
    public void testcanApplyLoyaltyDiscount__hasLoyaltyCard(){
        // 10% off on totals greater than £20 (after BOGOF discount is applied)
        customer2.addToBasket(item1);
        customer2.addToBasket(item1);
        customer2.addToBasket(item1);
        customer2.addToBasket(item1);
        customer2.addToBasket(item2);
        customer2.addToBasket(item3);
        customer2.addToBasket(item4);
        customer2.addToBasket(item5);
        customer2.addToBasket(item5);
        // give loyalty card to customer
        customer2.setLoyaltyCard(true);
        checkout = new Checkout(customer2);

        checkout.calculateInitialTotal();
        checkout.applyBuyOneGetOneFreeDiscount();
        // remove 10% of 223.97 (22.397, rounded to 22.40)
        checkout.applyGreaterThanTwentyDiscount();
        // remove 2% of 201.57 (4.0314, rounded to 4.03)
        checkout.applyLoyaltyDiscount();

        assertEquals(197.54, checkout.getTotal(), 0.01);
    }

}

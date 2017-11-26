package com.example.peter.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Peter on 22/11/2017.
 */

public class TestCustomer {

    private Customer customer;
    private Item item1;

    @Before
    public void before(){
        customer = new Customer("Peter");
        item1 = new Item("Amazon Echo Dot", "Amazon Echo Dot is a hands-free, voice-controlled device that uses Alexa to play music, control smart home devices, provide information, read the news, set alarms and more.", 49.99, false);
    }


    @Test
    public void testStartsWithoutLoyaltyCard(){
        assertEquals(false, customer.hasLoyaltyCard());
    }

    @Test
    public void testCanSetLoyaltyCard(){
        customer.setLoyaltyCard(true);

        assertEquals(true, customer.hasLoyaltyCard());
    }

    @Test
    public void testCustomerStartsWithEmptyBasket(){
        assertEquals(0, customer.getShoppingBasket().getSize());
    }

    @Test
    public void testCustomerCanAddToBasket(){
        customer.addToBasket(item1);

        assertEquals(1, customer.getShoppingBasket().getSize());
    }

    @Test
    public void testCustomerCanRemoveFromBasket(){
        customer.addToBasket(item1);
        customer.removeFromBasket(item1);

        assertEquals(0, customer.getShoppingBasket().getSize());
    }

    @Test
    public void testCustomerCanEmptyBasket(){
        customer.addToBasket(item1);
        customer.addToBasket(item1);
        customer.addToBasket(item1);

        assertEquals(3, customer.getShoppingBasket().getSize());

        customer.emptyBasket();

        assertEquals(0, customer.getShoppingBasket().getSize());
    }


}

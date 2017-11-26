package com.example.peter.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Peter on 22/11/2017.
 */

public class TestShoppingBasket {

    private ShoppingBasket shoppingBasket;
    private Item item1;
    private Item item2;

    @Before
    public void before(){
        shoppingBasket = new ShoppingBasket();

        item1 = new Item("Amazon Echo Dot", "Amazon Echo Dot is a hands-free, voice-controlled device that uses Alexa to play music, control smart home devices, provide information, read the news, set alarms and more.", 49.99, false);
        item2 = new Item("Technical Tool Toko Edge Tuner", "Toko technical edge tuner with angle settings between 85 and 90 degrees.", 42.50, false);
    }

    @Test
    public void testShoppingBasketStartsEmpty(){
        assertEquals(0, shoppingBasket.getSize());
    }

    @Test
    public void testCanAddToShoppingBasket(){
        shoppingBasket.add(item1);
        shoppingBasket.add(item2);
        assertEquals(2, shoppingBasket.getSize());
    }

    @Test
    public void testCanRemoveFromShoppingBasket(){
        assertEquals(0, shoppingBasket.getSize());

        shoppingBasket.add(item1);
        shoppingBasket.add(item2);

        assertEquals(2, shoppingBasket.getSize());

        shoppingBasket.remove(item2);

        assertEquals(1, shoppingBasket.getSize());
    }

    @Test
    public void testCanEmptyShoppingBasket(){
        assertEquals(0, shoppingBasket.getSize());

        shoppingBasket.add(item1);
        shoppingBasket.add(item2);

        assertEquals(2, shoppingBasket.getSize());

        shoppingBasket.empty();

        assertEquals(0, shoppingBasket.getSize());
    }
}

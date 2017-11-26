package com.example.peter.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Peter on 22/11/2017.
 */

public class TestItem {

    private Item item1;

    @Before
    public void before(){
        item1 = new Item("Amazon Echo Dot", "Amazon Echo Dot is a hands-free, voice-controlled device that uses Alexa to play music, control smart home devices, provide information, read the news, set alarms and more.", 49.99, false);
    }

    @Test
    public void testStartsNotBOGOF(){
        assertEquals(false, item1.isBogof());
    }

    @Test
    public void testCanSetBOGOF(){
        item1.setBogof(true);

        assertEquals(true, item1.isBogof());
    }

}

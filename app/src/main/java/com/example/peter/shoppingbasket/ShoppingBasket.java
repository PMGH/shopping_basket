package com.example.peter.shoppingbasket;

import java.util.ArrayList;

/**
 * Created by Peter on 25/11/2017.
 */

class ShoppingBasket {

//    Single Responsibility - Stores items
//    Open/Closed - Open for extension, Closed for modification (private/encapsulated instance variable)
//    Liskov Substitution - N/A no inheritance
//    Interface Segregation - N/A no interfaces
//    Dependency Inversion - N/A no abstract class

    private ArrayList<Item> items;

    // constructor

    ShoppingBasket() {
        this.items = new ArrayList<>();
    }

    // getters

    ArrayList<Item> getItems() {
        return items;
    }

    int getSize(){
        return items.size();
    }

    // setters


    // other behaviour

    void add(Item item) {
        items.add(item);
    }

    void remove(Item item) {
        items.remove(item);
    }

    void empty(){
        items.clear();
    }
}

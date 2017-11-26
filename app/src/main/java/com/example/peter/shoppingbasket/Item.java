package com.example.peter.shoppingbasket;

/**
 * Created by Peter on 22/11/2017.
 */

class Item {

//    Single Responsibility - Construct items that can be added to a customer's shoppingBasket
//    Open/Closed - Open for extension, Closed for modification (private/encapsulated instance variables)
//    Liskov Substitution - N/A no inheritance
//    Interface Segregation - N/A no interfaces (could use a Buyable interface implemented by multiple Item subclasses)
//    Dependency Inversion - N/A no abstract class (Item could be abstract and use subclasses (e.g. Book, DVD, CD, Game etc))

    private String name;
    private String description;
    private double price;
    private boolean bogof;

    // constructor

    Item(String name, String description, double price, boolean bogof) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.bogof = bogof;
    }

    // getters

    String getName() {
        return name;
    }

    String getDescription() {
        return description;
    }

    double getPrice() {
        return price;
    }

    boolean isBogof() {
        return bogof;
    }

    // setters

    void setBogof(boolean bogof) {
        this.bogof = bogof;
    }

}

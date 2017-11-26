package com.example.peter.shoppingbasket;

/**
 * Created by Peter on 22/11/2017.
 */

class Customer {

//    Single Responsibility - Constructs customers
//    Open/Closed - Open for extension, Closed for modification (private/encapsulated instance variables)
//    Liskov Substitution - N/A no inheritance
//    Interface Segregation - N/A no interfaces
//    Dependency Inversion - N/A no abstract class

    private String name;
    private ShoppingBasket shoppingBasket;
    private boolean loyaltyCard;

    // constructor

    Customer(String name) {
        this.name = name;
        this.shoppingBasket = new ShoppingBasket();
        this.loyaltyCard = false;
    }

    // getters

    boolean hasLoyaltyCard() {
        return loyaltyCard;
    }

    ShoppingBasket getShoppingBasket() {
        return shoppingBasket;
    }

    // setters

    void setLoyaltyCard(boolean loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
    }

    // other behaviour

    void addToBasket(Item item){
        shoppingBasket.add(item);
    }

    void removeFromBasket(Item item){
        shoppingBasket.remove(item);
    }

    void emptyBasket(){
        shoppingBasket.empty();
    }
}

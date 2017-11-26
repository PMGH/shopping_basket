package com.example.peter.shoppingbasket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Peter on 25/11/2017.
 */

class Checkout {

//    Single Responsibility - Calculates basket total price
//    Open/Closed - Open for extension, Closed for modification (private/encapsulated instance variables)
//    Liskov Substitution - N/A no inheritance
//    Interface Segregation - N/A no interfaces
//    Dependency Inversion - N/A no abstract class (Item could be abstract and use subclasses (e.g. Book, DVD, CD, Game etc))

    private Customer customer;
    private ArrayList<Item> items;
    private double total;

    // constructor

    Checkout(Customer customer) {
        this.customer = customer;
        this.items = customer.getShoppingBasket().getItems();
        this.total = 0;
    }

    // getters

    double getTotal() {
        return total;
    }

    // setters


    // other behaviour

    void calculateInitialTotal(){
        for (Item item : items){
            total += item.getPrice();
        }
    }

    void applyBuyOneGetOneFreeDiscount(){
        // buy-one-get-one-free discounts on items

        double refundAmount = 0;

        // hashmap of items
        HashMap<Item, Integer> occurrences = new HashMap<>();

        for (Item item : items){
            if (item.isBogof()){
                // count occurrences of the current item
                if (occurrences.containsKey(item)){
                    // if item already in HashMap then increment item count
                    int value = occurrences.get(item) + 1;
                    occurrences.put(item, value);
                } else {
                    // add item to hash map and set count to 1
                    occurrences.put(item, 1);
                }
            }
        }

        for (Item item : occurrences.keySet()){
            double itemPrice = item.getPrice();
            // increment refundAmount, get item count and divide by 2 (BOGOF) then multiply by itemPrice
            // divide by 2 as integer arithmetic (division) truncates
            refundAmount +=  (occurrences.get(item) / 2) * itemPrice;
        }

        total -= refundAmount;
    }

    void applyGreaterThanTwentyDiscount(){
        // 10% off on totals greater than £20 (after previous discount is applied)

        if (total > 20.00){
            double discount = total * 0.1;
            // rounds to nearest neighbour or up when equidistant (2.5 rounds to 3)
            double roundedDiscount = new BigDecimal(discount).setScale(2, RoundingMode.HALF_UP).doubleValue();

            total -= roundedDiscount;
        }
    }

    void applyLoyaltyDiscount(){
        // 2% off on total for customers with loyalty cards (after all other discounts are applied)

        if (customer.hasLoyaltyCard()){
            double discount = total * 0.02;
            // rounds to nearest neighbour or up when equidistant (e.g. 2.5 rounds to 3)
            double roundedDiscount = new BigDecimal(discount).setScale(2, RoundingMode.HALF_UP).doubleValue();

            total -= roundedDiscount;
        }
    }

}

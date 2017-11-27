# **Shopping Basket**    

## Project:    

This mini-project was a weekend code test that involved using OOP to model a Shopping Basket.     

### *Specification:*    

**Shopping Basket Code Test**

You have been asked to model a shopping basket.

You must be able to:

* add items to the shopping basket,
* remove items from the shopping basket,
* empty the shopping basket.     

*Additionally, you must be able to calculate the total value of the shopping basket. This should account for:*

* buy-one-get-one-free discounts on items,
* 10% off on totals greater than £20 (after previous discount is applied),
* 2% off on total for customers with loyalty cards (after all other discounts are applied).
* You must be able to validate that the code works through passing tests.

*What we will be looking for:*
* Evidence of 'solid' coding techniques and test driven development.    

### *Planning:*    

Planning involved reviewing the specification to ensure it was clear what I was trying to achieve then thinking about the classes I would require (and their responsibilities), the relationships they would have between them, the properties and functions they would need and how they might interact. I had initially planned that the Shopping Basket would calculate the discounts before reviewing the SOLID principles and deciding that this violated the Single Responsibility Principle. As such, I created a Checkout class to handle the discount and total calculations.     

### *Code Overview:*    

I created the Shopping Basket and associated classes using **Object Oriented Programming**, using **Test Driven Development** (JUnit) and **Java in Android Studio**.      

## Getting Started    

These instructions aim to get a copy of the project up and running on your local machine for development and testing purposes.    

### Prerequisites    

* Android Studio installed on your machine.    

### Clone    

The project can be cloned and opened (from version control) using the GitHub option on Android Studio.     

The game can be cloned with SSH using:  
[git@github.com:PMGH/shopping_basket.git](git@github.com:PMGH/shopping_basket.git)    

## Built With:  
* Test Driven Development (JUnit)  
* Android Studio  
* Java    

## Authors  
* Peter McCready - Initial work    

package com.company.creatures.animal;

import com.company.creatures.Human;

public abstract class Animal implements sellable, Edible, Feedable {
    final public String species;
    public String name;
    protected Double weight;

    public static final Double DEFAULT_DOG_WEIGHT = 5.0;
    public static final Double DEFAULT_MOUSE_WEIGHT = 0.1;
    public static final Double DEFAULT_LION_WEIGHT = 123.0;
    public static final Double DEFAULT_FOOD_WEIGHT = 1.0;

    public Animal(String species)
    {
        this.species = species;
        switch(species) {
            case "dog":
                this.weight = DEFAULT_DOG_WEIGHT;
                break;
            case "mouse":
                this.weight = DEFAULT_MOUSE_WEIGHT;
                break;
            case "lion":
                this.weight = DEFAULT_LION_WEIGHT;
                break;
        }
    }
    @Override
    public void feed()
    {
        feed(DEFAULT_FOOD_WEIGHT);
    }
    @Override
    public void feed(Double foodWeight) {
        if(weight>0.0){
            weight++;
            System.out.println("Thanks for food! Actual weight:" +weight+"kg");
        }else System.out.println("You can't feed dead animal.");
    }

    public void walk(){
        if(weight>0.0){
            weight--;
            System.out.println("Thanks for walk! Actual weight:"+weight+"kg");
        }else System.out.println("You walking with dead animal...");
    }
    public String toString() {
        return species + " " + name + " " + weight;
    }



    public void sell(Human buyer, Human seller, double price){
        if (seller.pet != null && buyer.cash >= price){
            buyer.cash = buyer.cash - price;
            seller.cash = seller.cash + price;
            seller.pet = null;
            buyer.pet = this;
            System.out.println(seller.firstName+ " " + " sprzedał " + buyer.firstName +" "+ this.name + " za kwote "+ price);
        }else System.out.println("Nie masz wystarczająco gotówki albo sprzedający nie posiada tego co sprzedaje.");


    }
}

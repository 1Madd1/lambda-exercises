package org.example;

import java.util.ArrayList;
import java.util.List;

public class IceCreamMachine {
    public String[] ingredients;
    public String[] toppings;

    public static class IceCream {
        public String ingredient;
        public String topping;

        public IceCream(String ingredient, String topping) {
            this.ingredient = ingredient;
            this.topping = topping;
        }
    }

    public IceCreamMachine(String[] ingredeints, String[] toppings) {
        this.ingredients = ingredeints;
        this.toppings = toppings;
    }

    public List<IceCream> scoops() {
        List<IceCream> scoops = new ArrayList<IceCream>();
        for (String ingredient : ingredients) {
            for (String topping : toppings) {
                scoops.add(new IceCream(ingredient, topping));
            }
        }
        return scoops;
    }
}

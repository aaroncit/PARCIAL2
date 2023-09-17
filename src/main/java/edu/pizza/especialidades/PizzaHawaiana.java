package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaHawaiana extends Pizza {
    public PizzaHawaiana() {
        super("Hawaiana", 10.0, new Topping("Jamón", 2.0), new Topping("Piña", 1.5), new Topping("Queso", 1.0));
    }
}



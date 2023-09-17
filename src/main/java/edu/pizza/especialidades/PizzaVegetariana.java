package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaVegetariana extends Pizza {
    public PizzaVegetariana() {
        super("Vegetariana", 11.0, new Topping("Pimientos", 2.0), new Topping("Cebolla", 1.5), new Topping("Aceitunas", 1.0), new Topping("Queso", 1.0));
    }
}



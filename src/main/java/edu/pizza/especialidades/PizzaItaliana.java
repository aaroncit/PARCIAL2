package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaItaliana extends Pizza {
    public PizzaItaliana() {
        super("Italiana", 10.0, new Topping("Salami", 2.0), new Topping("Aceitunas", 1.0), new Topping("Tomate", 1.5), new Topping("Queso", 1.0));
    }
}








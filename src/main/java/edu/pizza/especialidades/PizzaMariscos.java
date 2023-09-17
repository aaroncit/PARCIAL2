package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaMariscos extends Pizza {
    public PizzaMariscos() {
        super("Mariscos", 12.0, new Topping("Camarones", 3.0), new Topping("Pulpo", 4.0), new Topping("Mejillones", 2.5), new Topping("Salsa de Tomate", 1.5));
    }
}

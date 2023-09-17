package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaMexicana extends Pizza {
    public PizzaMexicana() {
        super("Mexicana", 11.0, new Topping("Carne de Res", 3.0), new Topping("Chiles Jalapeños", 2.0), new Topping("Frijoles", 1.5), new Topping("Queso", 1.0));
    }
}
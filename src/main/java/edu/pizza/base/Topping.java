package edu.pizza.base;

import java.util.ArrayList;

public class Topping {
    private String nombre; // Nombre del topping
    private ArrayList<String> ingredientes = new ArrayList<>(); // Ingredientes del topping
    private double price;

    // Constructor que acepta el nombre y el precio del topping
    public Topping(String nombre, double precio) {
        this.nombre = nombre;
        this.price = precio;
    }

    // Constructor que acepta solo el nombre del topping
    public Topping(String nombre) {
        this.nombre = nombre;
    }

    // Método para agregar un ingrediente al topping
    public void agregarIngrediente(String ingrediente) {
        this.ingredientes.add(ingrediente);
    }

    // Método para obtener el precio del topping
    public double getPrice() {
        return price;
    }

    // Método para obtener el nombre del topping
    public String getNombre() {
        return nombre;
    }

    // Método para establecer el nombre del topping
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método para obtener la lista de ingredientes del topping
    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    // Método para establecer la lista de ingredientes del topping
    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        return "Topping{" +
                "nombre='" + nombre + '\'' +
                ", ingredientes=" + ingredientes +
                '}';
    }
}

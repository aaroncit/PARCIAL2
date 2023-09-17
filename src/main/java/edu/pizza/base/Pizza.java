package edu.pizza.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pizza {
    private String name;
    private double price;
    private List<Topping> toppings = new ArrayList<>();
    private List<String> preparationStatus = new ArrayList<>(); // Lista de estado de preparación
    private String selectedSize; // Tamaño de la pizza seleccionado

    // Constructor que acepta el nombre, el precio y los toppings
    public Pizza(String name, double price, Topping... toppings) {
        this.name = name;
        this.price = price;

        // Agregar los toppings proporcionados al objeto Pizza
        Collections.addAll(this.toppings, toppings);

        // Agregar ingredientes por defecto
        agregarIngredientesPorDefecto();
    }

    // Método para agregar un topping adicional
    public void addTopping(Topping topping) {
        this.toppings.add(topping);
        updatePrice(); // Actualizar el precio cuando se agrega un ingrediente
    }

    // Método para eliminar un topping por índice
    public void removeTopping(int index) {
        if (index >= 0 && index < toppings.size()) {
            this.toppings.remove(index);
            updatePrice(); // Actualizar el precio cuando se quita un ingrediente
        }
    }

    // Obtener una lista de toppings (inmutable)
    public List<Topping> getToppings() {
        return Collections.unmodifiableList(toppings);
    }

    // Obtener el nombre de la pizza
    public String getName() {
        return name;
    }

    // Obtener el precio de la pizza
    public double getPrice() {
        return price;
    }

    // Método para preparar la pizza
    public void prepare() {
        preparationStatus.clear(); // Limpiar la lista de estado de preparación
        preparationStatus.add("Iniciando preparación de la pizza " + name);
        preparationStatus.add("Tamaño: " + selectedSize);
        preparationStatus.add("Agregando ingredientes...");

        // Agregar ingredientes uno por uno
        for (Topping topping : toppings) {
            preparationStatus.add("Agregando " + topping.getNombre());
            // Introducir un retraso de 1 segundo (simulado)
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        preparationStatus.add("La pizza está lista. ¡Disfrútala!");
        preparationStatus.add("Precio total: Q" + price);
    }

    // Método para agregar ingredientes por defecto
    private void agregarIngredientesPorDefecto() {
        // Agregar ingredientes por defecto aquí
    }

    // Método para actualizar el precio de la pizza
    private void updatePrice() {
        // Calcular el precio total con ingredientes
        double percentage = calculateSizePricePercentage(selectedSize);
        // Precio base de la pizza (ajusta según tu necesidad)
        double basePrice = 85.0;
        price = basePrice + (basePrice * percentage / 100);

        // Actualizar el estado de preparación con el nuevo precio
        preparationStatus.remove(preparationStatus.size() - 1); // Eliminar el precio anterior
        preparationStatus.add("Precio total: Q" + price);
    }

    // Método para calcular el porcentaje de precio según el tamaño seleccionado
    private double calculateSizePricePercentage(String size) {
        // Define los porcentajes de precio para cada tamaño (ajusta según tus necesidades)
        switch (size) {
            case "Pequeña":
                return 10.0;
            case "Mediana":
                return 20.0;
            case "Grande":
                return 30.0;
            default:
                return 0.0; // Tamaño no reconocido
        }
    }

    // Método para seleccionar el tamaño de la pizza
    public void setSize(String size) {
        selectedSize = size;
        updatePrice(); // Actualizar el precio cuando se selecciona un tamaño
    }

    // Método para obtener el estado de preparación de la pizza
    public List<String> getPreparationStatus() {
        return Collections.unmodifiableList(preparationStatus);
    }

    // Validación antes de preparar la pizza
    public boolean canPrepare() {
        return !name.isEmpty() && !toppings.isEmpty() && selectedSize != null;
    }
}






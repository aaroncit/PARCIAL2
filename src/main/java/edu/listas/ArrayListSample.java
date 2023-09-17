package edu.listas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListSample {
    public static void main(String[] args) {
        ArrayListSample sample = new ArrayListSample();
        sample.explicacion1();
        sample.listaValores();
        sample.ejemploListaTareas();
    }

    public void explicacion1() {
        List<String> taskList = new ArrayList<>();
        taskList.add("Hacer compras");
        taskList.add("Sacar al perro");
        taskList.add("Hacer la cama");
        taskList.add("Lavar los platos");

        // Obtener el primer elemento de taskList
        String firstTask = taskList.get(0);
        System.out.println("Primer tarea (índice 0): " + firstTask);

        // Eliminar el primer elemento de taskList
        taskList.remove(0);

        System.out.println("Nueva primera tarea (índice 0): " + taskList.get(0));
        System.out.println("Lista del resto de las tareas:");
        // Iterar sobre la lista
        for (String task : taskList) {
            System.out.println(task);
        }
    }

    public void listaValores() {
        // Obtener números desde el teclado
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un número");
        int numero = scanner.nextInt();

        List<Integer> numeros = new ArrayList<>();
        numeros.add(numero);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);

        int suma = 0;
        for (Integer numero1 : numeros) {
            suma = suma + numero1;
        }

        System.out.println("La suma de los números es: " + suma);
    }

    public void ejemploListaTareas() {
        List<ClsTaskList> tareas = new ArrayList<>();

        ClsTaskList task = new ClsTaskList("Hacer compras", "Comprar leche, huevos, pan, cereal, fruta", false);
        tareas.add(task);

        task = new ClsTaskList("Sacar al perro", "Sacar al perro al parque", false);
        tareas.add(task);

        task = new ClsTaskList("Hacer la cama", "Cambiar las sábanas y acomodar las almohadas", false);
        tareas.add(task);

        task = new ClsTaskList("Lavar los platos", "Lavar los platos y guardarlos", false);
        tareas.add(task);

        // Modificar el estado de la tarea 1
        tareas.get(1).setDone(true);

        // Mostrar solo las tareas completadas
        System.out.println("Lista de tareas completadas:");
        for (ClsTaskList tarea : tareas) {
            if (tarea.isDone()) {
                System.out.println("Tarea: " + tarea.getTaskName());
                System.out.println("Descripción: " + tarea.getTaskDescription());
            }
        }
    }
}



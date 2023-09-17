package edu.pizza;

import edu.formulario.frmPizza;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception e) {
                e.printStackTrace();
            }

            JFrame frame = new JFrame("PIZZA PLANET");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Crea una instancia del formulario frmPizza
            frmPizza pizzaForm = new frmPizza();

            // Configura la ventana principal
            frame.getContentPane().add(pizzaForm.getjPanelPrincipal());

            // Establecer un tamaño inicial (por ejemplo, 800x600 píxeles)
            frame.setPreferredSize(new Dimension(800, 600));

            frame.pack();
            frame.setVisible(true);
        });
    }
}


package edu.formulario;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class frmPizza {
    private JPanel jPanelPrincipal;
    private JButton btnVerIngredientes;
    private JComboBox<String> comboBoxEspecialidades;
    private JTextField txtPizzaName;
    private JRadioButton smallSize;
    private JRadioButton mediumSize;
    private JRadioButton largeSize;
    private DefaultListModel<String> ingredientListModel;
    private JTextArea preparationTextArea;
    private Map<String, String> specialPizzaIngredients;
    private Map<String, Double> sizePricePercentage;
    private Map<String, Double> ingredientPrices;
    private JList<String> preparationList;
    private DefaultListModel<String> preparationListModel;
    private JLabel lblTotal;
    private JButton btnPrepararPizza;
    private JButton btnRemoveIngredient;
    private JButton btnAddIngredient;
    private String selectedPizzaSize;
    private List<String> preparationStatus = new ArrayList<>();

    public JPanel getjPanelPrincipal() {
        return jPanelPrincipal;
    }

    public frmPizza() {
        initComponents();
        loadEspecialidades();
        loadSizePrices();
        loadIngredientPrices();

        btnVerIngredientes.addActionListener(e -> showIngredientes());
        btnAddIngredient.addActionListener(e -> addIngredient());
        btnRemoveIngredient.addActionListener(e -> removeIngredient());

        smallSize.addActionListener(e -> updateTotalPrice());
        mediumSize.addActionListener(e -> updateTotalPrice());
        largeSize.addActionListener(e -> updateTotalPrice());

        btnPrepararPizza.addActionListener(e -> preparePizza());
    }

    private void initComponents() {
        jPanelPrincipal = new JPanel(new BorderLayout());
        jPanelPrincipal.setBackground(new Color(255, 223, 186)); // Fondo con color más cálido

        JPanel northPanel = new JPanel(new FlowLayout());
        northPanel.setBackground(new Color(255, 193, 121)); // Encabezado con color diferente

        comboBoxEspecialidades = new JComboBox<>();
        btnVerIngredientes = new JButton("Ver Ingredientes");
        txtPizzaName = new JTextField(20);
        smallSize = new JRadioButton("Pequeña");
        mediumSize = new JRadioButton("Mediana");
        largeSize = new JRadioButton("Grande");
        btnPrepararPizza = new JButton("Preparar Pizza");
        btnPrepararPizza.setBackground(new Color(255, 89, 94)); // Color de fondo del botón resaltado
        btnPrepararPizza.setForeground(Color.WHITE); // Texto en color blanco para contraste
        lblTotal = new JLabel("Total:");

        northPanel.add(new JLabel("Nombre Pizza:"));
        northPanel.add(txtPizzaName);
        northPanel.add(new JLabel("Especialidad:"));
        northPanel.add(comboBoxEspecialidades);
        northPanel.add(btnVerIngredientes);
        northPanel.add(new JLabel("Tamaño Pizza:"));
        northPanel.add(createPizzaSizeRadioButtons());
        northPanel.add(new JLabel("Ingredientes:"));
        northPanel.add(createIngredientButtons());
        northPanel.add(btnPrepararPizza); // Mueve el botón "Preparar Pizza" aquí

        jPanelPrincipal.add(northPanel, BorderLayout.NORTH);

        // Inicializar ingredientListModel
        ingredientListModel = new DefaultListModel<>();

        preparationListModel = new DefaultListModel<>();
        preparationList = new JList<>(preparationListModel);
        JScrollPane preparationScrollPane = new JScrollPane(preparationList);
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(preparationScrollPane, BorderLayout.CENTER);
        jPanelPrincipal.add(centerPanel, BorderLayout.CENTER);
        jPanelPrincipal.add(lblTotal, BorderLayout.SOUTH);

        preparationTextArea = new JTextArea(10, 30);
        preparationTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(preparationTextArea);
        centerPanel.add(scrollPane, BorderLayout.SOUTH);
    }

    private JComponent createPizzaSizeRadioButtons() {
        ButtonGroup group = new ButtonGroup();

        smallSize = new JRadioButton("Pequeña");
        mediumSize = new JRadioButton("Mediana");
        largeSize = new JRadioButton("Grande");

        group.add(smallSize);
        group.add(mediumSize);
        group.add(largeSize);

        JPanel sizePanel = new JPanel();
        sizePanel.add(smallSize);
        sizePanel.add(mediumSize);
        sizePanel.add(largeSize);

        return sizePanel;
    }

    private JComponent createIngredientButtons() {
        JPanel ingredientPanel = new JPanel(new FlowLayout());
        btnAddIngredient = new JButton("Agregar Ingrediente");
        btnRemoveIngredient = new JButton("Quitar Ingrediente");
        ingredientPanel.add(btnAddIngredient);
        ingredientPanel.add(btnRemoveIngredient);
        return ingredientPanel;
    }

    private void loadEspecialidades() {
        comboBoxEspecialidades.addItem("Hawaiana");
        comboBoxEspecialidades.addItem("Mariscos");
        comboBoxEspecialidades.addItem("Vegetariana");
        comboBoxEspecialidades.addItem("Italiana");
        comboBoxEspecialidades.addItem("Mexicana");

        specialPizzaIngredients = new HashMap<>();
        specialPizzaIngredients.put("Hawaiana", "Piña, Jamón, Queso");
        specialPizzaIngredients.put("Mariscos", "Camarones, Mejillones, Calamares");
        specialPizzaIngredients.put("Vegetariana", "Tomate, Pimiento, Cebolla");
        specialPizzaIngredients.put("Italiana", "Tomate, Mozzarella, Albahaca");
        specialPizzaIngredients.put("Mexicana", "Carne Molida, Jalapeños, Cebolla");
    }

    private void loadSizePrices() {
        sizePricePercentage = new HashMap<>();
        sizePricePercentage.put("Pequeña", 10.0);
        sizePricePercentage.put("Mediana", 20.0);
        sizePricePercentage.put("Grande", 30.0);
    }

    private void loadIngredientPrices() {
        ingredientPrices = new HashMap<>();
        ingredientPrices.put("Queso", 5.0);
        ingredientPrices.put("Peperonni", 3.0);
        ingredientPrices.put("Salsa", 4.5);
        ingredientPrices.put("Cebolla", 1.5);
    }

    private void showIngredientes() {
        String selectedEspecialidad = (String) comboBoxEspecialidades.getSelectedItem();
        if (specialPizzaIngredients.containsKey(selectedEspecialidad)) {
            String ingredients = specialPizzaIngredients.get(selectedEspecialidad);
            JOptionPane.showMessageDialog(jPanelPrincipal, "Ingredientes de " + selectedEspecialidad + ": " + ingredients,
                    "Ingredientes de la Pizza", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(jPanelPrincipal, "No se encontraron ingredientes para " + selectedEspecialidad,
                    "Ingredientes no disponibles", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void addIngredient() {
        String ingredient = (String) JOptionPane.showInputDialog(
                jPanelPrincipal,
                "Ingrese el nombre del ingrediente:",
                "Agregar Ingrediente",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                ""
        );

        if (ingredient != null && !ingredient.isEmpty()) {
            ingredientListModel.addElement(ingredient);
            updateTotalPrice();
        }
    }

    private void removeIngredient() {
        int selectedIndex = preparationList.getSelectedIndex();
        if (selectedIndex != -1) {
            ingredientListModel.remove(selectedIndex);
            updateTotalPrice();
        }
    }

    private double calculateTotalPrice() {
        if (selectedPizzaSize != null && sizePricePercentage.containsKey(selectedPizzaSize)) {
            double percentage = sizePricePercentage.get(selectedPizzaSize);
            double basePrice = 88.0;
            return basePrice + (basePrice * percentage / 100);
        } else {
            return 0.0;
        }
    }

    private double calculateTotalIngredients() {
        double total = 0.0;
        for (int i = 0; i < ingredientListModel.size(); i++) {
            String ingredientStr = ingredientListModel.get(i);
            total += getIngredientPrice(ingredientStr);
        }
        return total;
    }

    private double getIngredientPrice(String ingredientName) {
        if (ingredientPrices.containsKey(ingredientName)) {
            return ingredientPrices.get(ingredientName);
        } else {
            return 0.0;
        }
    }

    private void preparePizza() {
        String pizzaName = txtPizzaName.getText().trim();
        String selectedEspecialidad = (String) comboBoxEspecialidades.getSelectedItem();
        selectedPizzaSize = getSelectedPizzaSize();

        if (pizzaName.isEmpty() || selectedEspecialidad == null || selectedPizzaSize == null) {
            JOptionPane.showMessageDialog(jPanelPrincipal, "Debe ingresar nombre, especialidad y tamaño para preparar la pizza.",
                    "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        preparationTextArea.setText(""); // Limpiar el JTextArea
        addPreparationStatus("Iniciando preparación de la pizza " + pizzaName + " (" + selectedEspecialidad + ")");
        addPreparationStatus("Tamaño: " + selectedPizzaSize);
        addPreparationStatus("Agregando ingredientes...");

        // Simular el proceso de preparación
        for (int i = 0; i < ingredientListModel.size(); i++) {
            String ingredient = ingredientListModel.get(i);
            addPreparationStatus("Agregando " + ingredient);
            try {
                Thread.sleep(1000); // Simular una demora de 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        double total = calculateTotalPrice() + calculateTotalIngredients();
        addPreparationStatus("La pizza está lista. ¡Disfrútala!");
        addPreparationStatus("Precio total: Q" + total);

        // Mostrar un mensaje emergente con el precio total
        JOptionPane.showMessageDialog(jPanelPrincipal, "La pizza está lista. ¡Disfrútala!\nPrecio total: Q" + total,
                "Pizza Lista", JOptionPane.INFORMATION_MESSAGE);
    }

    private String getSelectedPizzaSize() {
        if (smallSize.isSelected()) {
            return "Pequeña";
        } else if (mediumSize.isSelected()) {
            return "Mediana";
        } else if (largeSize.isSelected()) {
            return "Grande";
        } else {
            return null;
        }
    }

    private void addPreparationStatus(String status) {
        preparationStatus.add(status);
        updatePreparationList();
    }

    private void updatePreparationList() {
        preparationListModel.clear();
        for (String status : preparationStatus) {
            preparationListModel.addElement(status);
            preparationTextArea.append(status + "\n");
        }
    }

    private void updateTotalPrice() {
        double total = calculateTotalPrice() + calculateTotalIngredients();
        lblTotal.setText("Total: Q" + total);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception e) {
                e.printStackTrace();
            }

            JFrame frame = new JFrame("Pizza App");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new frmPizza().getjPanelPrincipal());
            frame.pack();
            frame.setVisible(true);
        });
    }
}
















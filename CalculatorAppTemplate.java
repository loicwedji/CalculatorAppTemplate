import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;

public class CalculatorAppTemplate extends JFrame {

    // GUI components
    private JTextField inputField1;
    private JTextField inputField2;
    private JLabel previousEquationLabel;
    private JLabel currentEquationLabel;
    private JLabel resultLabel;

    // Memory/history
    private ArrayList<String> equationHistory;
    private int historyIndex;

    public CalculatorAppTemplate() {
        equationHistory = new ArrayList<>();
        historyIndex = -1;

        setTitle("Group Calculator Project - Template");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeGUI();
    }

    private void initializeGUI() {
        setLayout(new BorderLayout(10, 10));

        // Display panel
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new GridLayout(3, 1));

        previousEquationLabel = new JLabel("Previous: ");
        previousEquationLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        previousEquationLabel.setForeground(Color.GRAY);

        currentEquationLabel = new JLabel("Current: ");
        currentEquationLabel.setFont(new Font("Arial", Font.BOLD, 18));

        resultLabel = new JLabel("Result: ");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));

        displayPanel.add(previousEquationLabel);
        displayPanel.add(currentEquationLabel);
        displayPanel.add(resultLabel);

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.add(new JLabel("Input 1:"));
        inputField1 = new JTextField();
        inputPanel.add(inputField1);

        inputPanel.add(new JLabel("Input 2:"));
        inputField2 = new JTextField();
        inputPanel.add(inputField2);

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(4, 3, 10, 10));

        JButton addButton = new JButton("Add");
        JButton subtractButton = new JButton("Subtract");
        JButton multiplyButton = new JButton("Multiply");
        JButton divideButton = new JButton("Divide");
        JButton powerButton = new JButton("Power");
        JButton modButton = new JButton("Mod");
        JButton sqrtButton = new JButton("Sqrt");
        JButton factorialButton = new JButton("Factorial");
        JButton averageButton = new JButton("Average");
        JButton clearButton = new JButton("Clear");
        JButton backButton = new JButton("Back");

        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(powerButton);
        buttonPanel.add(modButton);
        buttonPanel.add(sqrtButton);
        buttonPanel.add(factorialButton);
        buttonPanel.add(averageButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(backButton);

        // Add action listeners
        addButton.addActionListener(e -> handleBinaryOperation(" + "));
        subtractButton.addActionListener(e -> handleBinaryOperation(" - "));
        multiplyButton.addActionListener(e -> handleBinaryOperation(" * "));
        divideButton.addActionListener(e -> handleBinaryOperation(" / "));
        powerButton.addActionListener(e -> handleBinaryOperation(" ^ "));
        modButton.addActionListener(e -> handleBinaryOperation(" % "));
        averageButton.addActionListener(e -> handleBinaryOperation(" avg "));
        sqrtButton.addActionListener(e -> handleUnaryOperation("sqrt"));
        factorialButton.addActionListener(e -> handleUnaryOperation("fact"));
        clearButton.addActionListener(e -> clearFields());
        backButton.addActionListener(this::handleBackButton);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.add(displayPanel, BorderLayout.NORTH);
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);
    }

    // -----------------------------
    // Event Handlers
    // -----------------------------

    private void handleBinaryOperation(String operator) {
        try {
            double num1 = Double.parseDouble(inputField1.getText());
            double num2 = Double.parseDouble(inputField2.getText());

            double result = 0;
            String equation = num1 + operator + num2;

            switch (operator.trim()) {
                case "+":
                    result = add(num1, num2);
                    break;
                case "-":
                    result = subtract(num1, num2);
                    break;
                case "*":
                    result = multiply(num1, num2);
                    break;
                case "/":
                    result = divide(num1, num2);
                    break;
                case "^":
                    result = power(num1, num2);
                    break;
                case "%":
                    result = modulus(num1, num2);
                    break;
                case "avg":
                    result = average(num1, num2);
                    break;
                default:
                    resultLabel.setText("Result: Unsupported operation");
                    return;
            }

            updateMemory(equation, result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Result: Please enter valid numbers.");
        } catch (ArithmeticException ex) {
            resultLabel.setText("Result: " + ex.getMessage());
        }
    }

    private void handleUnaryOperation(String operation) {
        try {
            double num = Double.parseDouble(inputField1.getText());

            double result = 0;
            String equation = "";

            switch (operation) {
                case "sqrt":
                    result = squareRoot(num);
                    equation = "sqrt(" + num + ")";
                    break;
                case "fact":
                    result = factorial((int) num);
                    equation = num + "!";
                    break;
                default:
                    resultLabel.setText("Result: Unsupported operation");
                    return;
            }

            updateMemory(equation, result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Result: Please enter a valid number.");
        } catch (ArithmeticException ex) {
            resultLabel.setText("Result: " + ex.getMessage());
        }
    }

    private void handleBackButton(ActionEvent e) {
        goBackInMemory();
    }

    private void clearFields() {
        inputField1.setText("");
        inputField2.setText("");
        currentEquationLabel.setText("Current: ");
        resultLabel.setText("Result: ");
    }

    // -----------------------------
    // Student Methods to Implement
    // -----------------------------

    private double add(double a, double b) {
        // TODO
        return 0;
    }

    private double subtract(double a, double b) {
        // TODO
        return 0;
    }

    private double multiply(double a, double b) {
        // TODO
        return 0;
    }

    private double divide(double a, double b) {
        return a / b;
    }

    private double power(double a, double b) {
        double result = 0;
        int exponent = (int) b;

<<<<<<< HEAD
        if (exponent == 0)
            return 1;
=======
        if(a == 0)return 0;

        if(exponent == 0)return 1;
>>>>>>> 29ad90d (Negative powers)

        if(exponent < 0){
            exponent = -exponent;

            for (int i = 1; i <= exponent; i++) {
                result = a * a;
            }

            return 1/result;
        }

        for (int i = 1; i <= exponent; i++) {
            result = a * a;
        }
        return result;
    }

    private double modulus(double a, double b) {
        return a % b;
    }

    private double average(double a, double b) {
        return (a + b) / 2;

    }

    private double squareRoot(double a) {
        return Math.sqrt(a);
    }

    private long factorial(int n) {
        // TODO
        return 0;
    }

    // Memory/history method
    private void updateMemory(String equation, double result) {
        String fullEntry = equation + " = " + result;

        if (historyIndex < equationHistory.size() - 1) {
            equationHistory = new ArrayList<>(equationHistory.subList(0, historyIndex + 1));
        }

        equationHistory.add(fullEntry);
        historyIndex = equationHistory.size() - 1;

        refreshHistoryDisplay();
    }

    private void goBackInMemory() {
        if (equationHistory.isEmpty()) {
            resultLabel.setText("Result: No history available.");
            return;
        }

        if (historyIndex > 0) {
            historyIndex--;
            refreshHistoryDisplay();
        } else {
            resultLabel.setText("Result: Already at oldest saved equation.");
        }
    }

    private void refreshHistoryDisplay() {
        if (historyIndex >= 0 && historyIndex < equationHistory.size()) {
            currentEquationLabel.setText("Current: " + equationHistory.get(historyIndex));

            if (historyIndex > 0) {
                previousEquationLabel.setText("Previous: " + equationHistory.get(historyIndex - 1));
            } else {
                previousEquationLabel.setText("Previous: ");
            }

            String currentEntry = equationHistory.get(historyIndex);
            String[] parts = currentEntry.split(" = ");
            if (parts.length == 2) {
                resultLabel.setText("Result: " + parts[1]);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorAppTemplate app = new CalculatorAppTemplate();
            app.setVisible(true);
        });
    }
}

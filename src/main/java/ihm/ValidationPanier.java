package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.Font;


public class ValidationPanier extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nameField;
    private JTextField addressField;
    private JTextField phoneField;
    private JTextField emailField;
    private JComboBox<String> paymentComboBox;
    private JTextArea orderSummaryArea;
    private List<Fromage> fromages;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ValidationPanier frame = new ValidationPanier(getSampleOrderedFromages());
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public ValidationPanier(List<Fromage> orderedFromages) {
        this.fromages = orderedFromages;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 710);
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        // Customer Information Panel
        JPanel customerInfoPanel = new JPanel();
        customerInfoPanel.setLayout(new GridLayout(6, 2));
        
        // Add title
        JLabel title = new JLabel("Coordonnées", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 24)); 
        customerInfoPanel.add(title);
        customerInfoPanel.add(new JLabel(""));

        customerInfoPanel.add(new JLabel("Nom:"));
        nameField = new JTextField();
        customerInfoPanel.add(nameField);

        customerInfoPanel.add(new JLabel("Adresse:"));
        addressField = new JTextField();
        customerInfoPanel.add(addressField);

        customerInfoPanel.add(new JLabel("Téléphone:"));
        phoneField = new JTextField();
        customerInfoPanel.add(phoneField);

        customerInfoPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        customerInfoPanel.add(emailField);

        customerInfoPanel.add(new JLabel("Mode de paiement:"));
        paymentComboBox = new JComboBox<>(new String[]{"Carte de crédit", "PayPal", "Virement bancaire"});
        customerInfoPanel.add(paymentComboBox);

        contentPane.add(customerInfoPanel, BorderLayout.NORTH);

        // Order Summary Panel
        JPanel orderSummaryPanel = new JPanel(new BorderLayout());
        contentPane.add(orderSummaryPanel, BorderLayout.CENTER);

        orderSummaryArea = new JTextArea();
        orderSummaryArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(orderSummaryArea);
        orderSummaryPanel.add(scrollPane);

        // Bottom Panel with Buttons
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        contentPane.add(bottomPanel, BorderLayout.SOUTH);

        JButton validateButton = new JButton("Valider la commande");
        bottomPanel.add(validateButton);

        JButton cancelButton = new JButton("Annuler");
        bottomPanel.add(cancelButton);
        
        // Action Listeners
        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateInvoice();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        displayOrderSummary();
    }

    private void displayOrderSummary() {
        StringBuilder summary = new StringBuilder();
        double total = 0;

        for (Fromage fromage : fromages) {
            summary.append(fromage.getName()).append(" - ").append(fromage.getPrice()).append("\n");
            total += parsePrice(fromage.getPrice());
        }

        summary.append("\nTotal: ").append(String.format("%.2f €", total));
        orderSummaryArea.setText(summary.toString());
    }

    private double parsePrice(String price) {
        return Double.parseDouble(price.replace("€", "").trim());
    }

    private void generateInvoice() {
        StringBuilder invoice = new StringBuilder();
        invoice.append("FACTURE\n\n");

        invoice.append("Nom: ").append(nameField.getText()).append("\n");
        invoice.append("Adresse: ").append(addressField.getText()).append("\n");
        invoice.append("Téléphone: ").append(phoneField.getText()).append("\n");
        invoice.append("Email: ").append(emailField.getText()).append("\n");
        invoice.append("Mode de paiement: ").append(paymentComboBox.getSelectedItem().toString()).append("\n\n");

        invoice.append("Détails de la commande:\n");
        invoice.append(orderSummaryArea.getText());

        JOptionPane.showMessageDialog(this, invoice.toString(), "Facture", JOptionPane.INFORMATION_MESSAGE);
    }

    // Sample data for testing
    private static List<Fromage> getSampleOrderedFromages() {
        List<Fromage> sampleFromages = new ArrayList<>();
        sampleFromages.add(new Fromage("Roquefort", "7.20 €", "C:\\Users\\isamr\\Downloads\\png.png"));
        sampleFromages.add(new Fromage("Camembert", "5.00 €", "C:\\Users\\isamr\\Downloads\\png.png"));
        return sampleFromages;
    }

    // Duplicate the Fromage class here
    public static class Fromage {
        private String name;
        private String price;
        private String imagePath;

        public Fromage(String name, String price, String imagePath) {
            this.name = name;
            this.price = price;
            this.imagePath = imagePath;
        }

        public String getName() {
            return name;
        }

        public String getPrice() {
            return price;
        }

        public String getImagePath() {
            return imagePath;
        }
    }
}


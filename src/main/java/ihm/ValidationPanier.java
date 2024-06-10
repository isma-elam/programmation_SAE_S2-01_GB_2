package ihm;

import modele.ArticleSelectionne;
import modele.Fromage;
import modele.Panier;

import java.awt.BorderLayout;
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
    private Panier panier;

    public ValidationPanier(Panier panier) {
        this.panier = panier;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        //affiche tout les fromages puis le total
        for (ArticleSelectionne article : panier.getArticles()) {
            summary.append(article.getFromage().getDesignation()).append(" (").append(article.getArticle().getCle()).append(")").append(" - ")
                    .append("Quantité: ").append(article.getQuantite()).append(" - ")
                    .append("Prix unitaire: ").append(String.format("%.2f €", article.getArticle().getPrixTTC())).append(" - ")
                    .append("\n");
        }
        summary.append("Total fromage: ").append(String.format("%.2f €", panier.prixTotal())).append("\n");
        summary.append("Livraison:").append(String.format("%.2f €", panier.fraisPort())).append("\n");
        summary.append("Total: ").append(String.format("%.2f €", panier.total()));
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
}


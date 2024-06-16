package ihm;

import modele.ArticleSelectionne;
import modele.Facture;
import modele.Panier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ValidationPanier extends JFrame {

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
        contentPane.setBackground(new Color(255, 204, 153)); // Couleur orangée claire
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // Customer Information Panel
        JPanel customerInfoPanel = new JPanel();
        customerInfoPanel.setBackground(new Color(255, 204, 153)); // Couleur orangée claire
        customerInfoPanel.setLayout(new GridLayout(6, 2));
        customerInfoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Espacement

        // Add title
        JLabel title = new JLabel("Coordonnées", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 24));
        title.setForeground(new Color(204, 102, 0)); // Couleur orangée plus foncée
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
        orderSummaryPanel.setBackground(new Color(255, 255, 255)); // Fond blanc pour le contraste
        contentPane.add(orderSummaryPanel, BorderLayout.CENTER);

        orderSummaryArea = new JTextArea();
        orderSummaryArea.setEditable(false);
        orderSummaryArea.setFont(new Font("Arial", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(orderSummaryArea);
        orderSummaryPanel.add(scrollPane);

        // Bottom Panel with Buttons
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBackground(new Color(255, 204, 153)); // Couleur orangée claire
        contentPane.add(bottomPanel, BorderLayout.SOUTH);

        JButton validateButton = new JButton("Valider la commande");
        validateButton.setBackground(new Color(204, 102, 0)); // Couleur orangée plus foncée pour le bouton
        validateButton.setForeground(Color.WHITE); // Texte en blanc pour contraste
        bottomPanel.add(validateButton);

        JButton cancelButton = new JButton("Annuler");
        cancelButton.setBackground(new Color(204, 102, 0)); // Couleur orangée plus foncée pour le bouton
        cancelButton.setForeground(Color.WHITE); // Texte en blanc pour contraste
        bottomPanel.add(cancelButton);

        // Action Listeners
        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Facture facture = new Facture(nameField.getText(),
                        "",
                        addressField.getText(),
                        "",
                        "" ,
                        "" ,
                        phoneField.getText(),
                        emailField.getText(),
                        panier.fraisPort(),
                        paymentComboBox.getSelectedItem().toString(),
                        panier.getTransporteur().toString(),
                        panier);
                FactureUI factureUI = new FactureUI(facture);
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
        // Affiche tous les fromages puis le total
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
}

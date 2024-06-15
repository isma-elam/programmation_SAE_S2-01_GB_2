package ihm;

import modele.ArticleSelectionne;
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

    private void generateInvoice() {
        StringBuilder invoice = new StringBuilder();
        invoice.append("<html><head><title>FACTURE</title>");
        invoice.append("<style>");
        invoice.append("body { font-family: Arial, sans-serif; background-color: #fff; color: #333; margin: 20px; }");
        invoice.append("h1, h2 { text-align: center; color: #ff8c00; }");
        invoice.append("table { width: 100%; border-collapse: collapse; margin-bottom: 20px; }");
        invoice.append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }");
        invoice.append("th { background-color: #f2f2f2; }");
        invoice.append("ul { list-style-type: none; padding: 0; }");
        invoice.append("</style>");
        invoice.append("</head><body>");

        invoice.append("<h1>FACTURE</h1>");

        invoice.append("<h2>Coordonnées</h2>");
        invoice.append("<p><strong>Nom:</strong> ").append(nameField.getText()).append("</p>");
        invoice.append("<p><strong>Adresse:</strong> ").append(addressField.getText()).append("</p>");
        invoice.append("<p><strong>Téléphone:</strong> ").append(phoneField.getText()).append("</p>");
        invoice.append("<p><strong>Email:</strong> ").append(emailField.getText()).append("</p>");
        invoice.append("<p><strong>Mode de paiement:</strong> ").append(paymentComboBox.getSelectedItem().toString()).append("</p>");

        invoice.append("<h2>Détails de la commande</h2>");
        invoice.append("<table>");
        invoice.append("<tr><th>Fromage</th><th>Quantité</th><th>Prix unitaire</th></tr>");
        for (ArticleSelectionne article : panier.getArticles()) {
            invoice.append("<tr>");
            invoice.append("<td>").append(article.getFromage().getDesignation()).append(" (").append(article.getArticle().getCle()).append(")").append("</td>");
            invoice.append("<td>").append(article.getQuantite()).append("</td>");
            invoice.append("<td>").append(String.format("%.2f €", article.getArticle().getPrixTTC())).append("</td>");
            invoice.append("</tr>");
        }
        invoice.append("<tr><td colspan='2'><strong>Total fromage:</strong></td><td>").append(String.format("%.2f €", panier.prixTotal())).append("</td></tr>");
        invoice.append("<tr><td colspan='2'><strong>Livraison:</strong></td><td>").append(String.format("%.2f €", panier.fraisPort())).append("</td></tr>");
        invoice.append("<tr><td colspan='2'><strong>Total:</strong></td><td>").append(String.format("%.2f €", panier.total())).append("</td></tr>");
        invoice.append("</table>");

        invoice.append("</body></html>");

        generateHtmlInvoiceWindow(invoice.toString());
    }

    private void generateHtmlInvoiceWindow(String invoiceContent) {
        JFrame htmlFrame = new JFrame("Facture HTML");
        htmlFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        htmlFrame.setSize(600, 500);
        htmlFrame.setLocationRelativeTo(null);

        JEditorPane jEditorPane = new JEditorPane();
        jEditorPane.setContentType("text/html");
        jEditorPane.setText(invoiceContent);
        jEditorPane.setEditable(false);

        JScrollPane jScrollPane = new JScrollPane(jEditorPane);
        htmlFrame.getContentPane().add(jScrollPane, BorderLayout.CENTER);

        // Ajout du bouton de téléchargement
        JButton downloadButton = new JButton("Télécharger Facture");
        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                downloadInvoiceAsFile(invoiceContent);
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(downloadButton);
        htmlFrame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        htmlFrame.setVisible(true);
    }

    private void downloadInvoiceAsFile(String invoiceContent) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choisir l'emplacement pour télécharger la facture");
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try (PrintWriter writer = new PrintWriter(fileToSave + ".html")) {
                writer.println(invoiceContent);
                JOptionPane.showMessageDialog(this, "Facture téléchargée avec succès !");
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Erreur lors du téléchargement de la facture : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

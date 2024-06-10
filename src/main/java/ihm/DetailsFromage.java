package ihm;

import modele.Fromage;

import javax.swing.*;
import java.awt.*;

public class DetailsFromage extends JFrame {

    private JPanel contentPane;
    private JLabel nomLabel;
    private JLabel origineLabel;
    private JLabel typeLabel;

    private JLabel prixLabel;
    private JTextArea descriptionArea;
    private JComboBox<Integer> quantiteBox;
    private JButton ajouterPanierButton;
    private Fromage fromage;

    public DetailsFromage(Fromage fromage) {
        this.fromage = fromage;
        setTitle("Détails du Fromage");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Centrer la fenêtre
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        JPanel mainPanel = new JPanel(new BorderLayout());
        contentPane.add(mainPanel, BorderLayout.NORTH);

        // Panel for Image
        JPanel imagePanel = new JPanel();
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon("C:\\Users\\isamr\\Desktop\\S201\\png (1).png")); // Provide the path to your image here
        imagePanel.add(imageLabel);
        mainPanel.add(imagePanel, BorderLayout.WEST);

        // Details Panel
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridLayout(5, 2, 10, 10)); // Augmenter à 5 lignes pour inclure la quantité
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel nomTitleLabel = new JLabel("Nom:");
        nomTitleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        detailsPanel.add(nomTitleLabel);

        nomLabel = new JLabel(fromage.getDesignation());
        nomLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        detailsPanel.add(nomLabel);

        JLabel origineTitleLabel = new JLabel("Origine:");
        origineTitleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        detailsPanel.add(origineTitleLabel);

        origineLabel = new JLabel(fromage.getDescription());
        origineLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        detailsPanel.add(origineLabel);

        JLabel typeTitleLabel = new JLabel("Type:");
        typeTitleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        detailsPanel.add(typeTitleLabel);

        typeLabel = new JLabel(fromage.getTypeFromage().toString());
        typeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        detailsPanel.add(typeLabel);

        JLabel prixTitleLabel = new JLabel("Prix:");
        prixTitleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        detailsPanel.add(prixTitleLabel);

        prixLabel = new JLabel(String.format("%.2f €", fromage.getLowestPriceArticle().getPrixTTC()));
        prixLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        detailsPanel.add(prixLabel);

        // Ajouter le libellé et la boîte de sélection pour la quantité
        JLabel quantiteTitleLabel = new JLabel("Quantité:");
        quantiteTitleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        detailsPanel.add(quantiteTitleLabel);

        quantiteBox = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        quantiteBox.setFont(new Font("Arial", Font.PLAIN, 14));
        detailsPanel.add(quantiteBox);

        mainPanel.add(detailsPanel, BorderLayout.CENTER);

        JPanel descriptionPanel = new JPanel(new BorderLayout());
        descriptionPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel descriptionTitleLabel = new JLabel("Description:");
        descriptionTitleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        descriptionPanel.add(descriptionTitleLabel, BorderLayout.NORTH);

        descriptionArea = new JTextArea(fromage.getDescription());
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 14));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(descriptionArea);
        descriptionPanel.add(scrollPane, BorderLayout.CENTER);

        contentPane.add(descriptionPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        ajouterPanierButton = new JButton("Ajouter au Panier");
        ajouterPanierButton.setFont(new Font("Arial", Font.PLAIN, 14));
        buttonPanel.add(ajouterPanierButton);

        contentPane.add(buttonPanel, BorderLayout.SOUTH);
    }
}

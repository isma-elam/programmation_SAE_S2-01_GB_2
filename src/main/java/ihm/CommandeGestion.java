package ihm;

import modele.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CommandeGestion extends JFrame {

    private JPanel contentPane;
    private JTable panierTable;
    private JButton recalculerButton;
    private JComboBox<String> transporteurBox;
    private JLabel fraisPortLabel;
    private JLabel sousTotalLabel;
    private JLabel totalLabel;
    private JButton viderPanierButton;
    private JButton validerPanierButton;
    private JButton continuerAchatsButton;
    private final Panier panier;

    public CommandeGestion(Panier panier) {
        this.panier = panier;
        setTitle("Gestion du Panier");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null); // Centrer la fenêtre
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBackground(new Color(255, 229, 204)); // Light orange background
        setContentPane(contentPane);

        // Panel pour le panier
        JPanel panierPanel = new JPanel(new BorderLayout());
        panierPanel.setBackground(new Color(255, 204, 153)); // Lighter orange background
        JLabel panierLabel = new JLabel("Votre Panier", SwingConstants.CENTER);
        panierLabel.setFont(new Font("Arial", Font.BOLD, 26));
        panierPanel.add(panierLabel, BorderLayout.NORTH);

        // Création du modèle de table et de la table
        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"Produit", "Quantité", "Prix unitaire", "Prix total"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Rendre les cellules non éditables
            }
        };
        panierTable = new JTable(model);
        panierTable.setFont(new Font("Arial", Font.PLAIN, 18));
        panierTable.setRowHeight(25); // Hauteur des lignes
        customizeTableColumns(); // Personnaliser l'alignement et l'espacement des colonnes
        JScrollPane scrollPane = new JScrollPane(panierTable);
        panierPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(new Color(255, 204, 153)); // Lighter orange background
        viderPanierButton = new JButton("Vider le Panier");
        viderPanierButton.setFont(new Font("Arial", Font.PLAIN, 18));
        viderPanierButton.setBackground(new Color(255, 153, 51)); // Orange background
        viderPanierButton.setForeground(Color.WHITE); // White text
        buttonPanel.add(viderPanierButton);
        validerPanierButton = new JButton("Valider le Panier");
        validerPanierButton.setFont(new Font("Arial", Font.PLAIN, 18));
        validerPanierButton.setBackground(new Color(255, 153, 51)); // Orange background
        validerPanierButton.setForeground(Color.WHITE); // White text
        buttonPanel.add(validerPanierButton);
        continuerAchatsButton = new JButton("Continuer les Achats");
        continuerAchatsButton.setFont(new Font("Arial", Font.PLAIN, 18));
        continuerAchatsButton.setBackground(new Color(255, 153, 51)); // Orange background
        continuerAchatsButton.setForeground(Color.WHITE); // White text
        buttonPanel.add(continuerAchatsButton);
        recalculerButton = new JButton("Recalculer");
        recalculerButton.setFont(new Font("Arial", Font.PLAIN, 18));
        recalculerButton.setBackground(new Color(255, 153, 51)); // Orange background
        recalculerButton.setForeground(Color.WHITE); // White text
        buttonPanel.add(recalculerButton);

        panierPanel.add(buttonPanel, BorderLayout.SOUTH);

        contentPane.add(panierPanel, BorderLayout.CENTER);

        // Panel pour les détails du panier
        JPanel detailsPanel = new JPanel(new BorderLayout());
        detailsPanel.setBackground(new Color(255, 229, 204)); // Light orange background
        JPanel leftDetailsPanel = new JPanel(new GridLayout(2, 1));
        leftDetailsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        leftDetailsPanel.setBackground(new Color(255, 229, 204)); // Light orange background

        sousTotalLabel = new JLabel("Sous-Total et Expédition : ");
        sousTotalLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        sousTotalLabel.setForeground(new Color(102, 51, 0)); // Dark brown text
        leftDetailsPanel.add(sousTotalLabel);
        totalLabel = new JLabel("TOTAL: ");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 20));
        totalLabel.setForeground(new Color(74, 129, 102));
        leftDetailsPanel.add(totalLabel);

        detailsPanel.add(leftDetailsPanel, BorderLayout.WEST);

        JPanel rightDetailsPanel = new JPanel(new GridLayout(3, 1));
        rightDetailsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        rightDetailsPanel.setBackground(new Color(255, 229, 204)); // Light orange background

        Transporteurs transporteurs = new Transporteurs();

        transporteurBox = new JComboBox<>(new String[]{transporteurs.getTransporteur(0).toString(),
                transporteurs.getTransporteur(1).toString(),
                transporteurs.getTransporteur(2).toString()
        });

        transporteurBox.setFont(new Font("Arial", Font.PLAIN, 18));
        rightDetailsPanel.add(new JLabel("Transporteur: "));
        rightDetailsPanel.add(transporteurBox);
        fraisPortLabel = new JLabel("Frais de port offert à partir de 120 €");
        fraisPortLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        fraisPortLabel.setForeground(new Color(102, 51, 0)); // Dark brown text
        rightDetailsPanel.add(fraisPortLabel);

        detailsPanel.add(rightDetailsPanel, BorderLayout.EAST);

        contentPane.add(detailsPanel, BorderLayout.SOUTH);

        //ActionListeners
        viderPanierButton.addActionListener(e -> {
            panier.vider();
            updatePanierArea();
        });

        continuerAchatsButton.addActionListener(e -> dispose());

        validerPanierButton.addActionListener(e -> {
            //open a new window with the order summary
            ValidationPanier vp = new ValidationPanier(panier);
            vp.setVisible(true);
        });

        recalculerButton.addActionListener(e -> UpdateAll());

        transporteurBox.addActionListener(e -> {
            panier.setTransporteur(transporteurs.getTransporteur(transporteurBox.getSelectedIndex()));
            UpdateAll();
        });

        panier.setTransporteur(transporteurs.getTransporteur(0));
        UpdateAll();
    }

    private void customizeTableColumns() {
        // Centrer le contenu des colonnes du tableau
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        panierTable.setDefaultRenderer(Object.class, centerRenderer);

        // Ajuster l'espacement des colonnes (facultatif)
        panierTable.getColumnModel().getColumn(0).setPreferredWidth(250); // Produit
        panierTable.getColumnModel().getColumn(1).setPreferredWidth(100); // Quantité
        panierTable.getColumnModel().getColumn(2).setPreferredWidth(100); // Prix unitaire
        panierTable.getColumnModel().getColumn(3).setPreferredWidth(120); // Prix total
    }

    public void UpdateAll() {
        updatePanierArea();
        updateFraisDePort(panier.getTransporteur());
    }

    public void updatePanierArea() {
        //add to panierTable : "Produit", "Quantité", "Prix unitaire", "Prix total"
        DefaultTableModel model = (DefaultTableModel) panierTable.getModel();
        model.setRowCount(0);
        for (int i = 0; i < panier.getArticles().size(); i++) {
            ArticleSelectionne articleSelectionne = panier.getArticle(i);
            Article article = articleSelectionne.getArticle();
            StringBuilder sb = new StringBuilder();
            if (!article.getCle().isEmpty()) {
                sb.append(article.getFromage().getDesignation()).append(" (").append(article.getCle()).append(")");
            } else {
                sb.append(article.getFromage().getDesignation());
            }
            model.addRow(new Object[]{
                    sb.toString(),
                    articleSelectionne.getQuantite(),
                    article.getPrixTTC(),
                    article.getPrixTTC() * articleSelectionne.getQuantite()
            });
        }
        //round the total price to 2 decimal places
        double prixTotal = Math.round(panier.prixTotal()*100.0)/100.0;
        double total = Math.round(panier.total()*100.0)/100.0;
        sousTotalLabel.setText("Sous-Total : " + prixTotal + " €");
        totalLabel.setText("TOTAL: " + total + " €");
    }

    public void updateFraisDePort(Transporteur transporteur) {
        panier.setTransporteur(transporteur);
        if (panier.prixTotal() > 120) {
            fraisPortLabel.setText("Frais de port offert");
        } else {
            fraisPortLabel.setText("Frais de port: " + transporteur.getFraisPort(panier.prixTotal()) + " €");
        }
    }
}
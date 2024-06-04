package ihm;

import javax.swing.*;

import java.awt.*;

public class CommandeGestion extends JFrame {

    private JPanel contentPane;
    private JTextArea panierArea;
    private JButton recalculerButton;
    private JComboBox<String> transporteurBox;
    private JLabel fraisPortLabel;
    private JLabel sousTotalLabel;
    private JLabel totalLabel;
    private JButton viderPanierButton;
    private JButton validerPanierButton;
    private JButton continuerAchatsButton;

    public CommandeGestion() {
        setTitle("Gestion du Panier");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null); // Centrer la fenêtre
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        // Panel pour le panier
        JPanel panierPanel = new JPanel(new BorderLayout());
        JLabel panierLabel = new JLabel("Votre Panier", SwingConstants.CENTER);
        panierLabel.setFont(new Font("Arial", Font.BOLD, 26));
        panierPanel.add(panierLabel, BorderLayout.NORTH);

        panierArea = new JTextArea();
        panierArea.setFont(new Font("Arial", Font.PLAIN, 18));
        panierArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(panierArea);
        panierPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        viderPanierButton = new JButton("Vider le Panier");
        viderPanierButton.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonPanel.add(viderPanierButton);
        validerPanierButton = new JButton("Valider le Panier");
        validerPanierButton.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonPanel.add(validerPanierButton);
        continuerAchatsButton = new JButton("Continuer les Achats");
        continuerAchatsButton.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonPanel.add(continuerAchatsButton);
        recalculerButton = new JButton("Recalculer");
        recalculerButton.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonPanel.add(recalculerButton);

        panierPanel.add(buttonPanel, BorderLayout.SOUTH);

        contentPane.add(panierPanel, BorderLayout.CENTER);

        // Panel pour les détails du panier
        JPanel detailsPanel = new JPanel(new BorderLayout());
        JPanel leftDetailsPanel = new JPanel(new GridLayout(2, 1));
        leftDetailsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        sousTotalLabel = new JLabel("Sous-Total et Expédition : ");
        sousTotalLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        leftDetailsPanel.add(sousTotalLabel);
        totalLabel = new JLabel("TOTAL: ");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 20));
        totalLabel.setForeground(Color.GREEN);
        leftDetailsPanel.add(totalLabel);

        detailsPanel.add(leftDetailsPanel, BorderLayout.WEST);

        JPanel rightDetailsPanel = new JPanel(new GridLayout(3, 1));
        rightDetailsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        transporteurBox = new JComboBox<>(new String[]{"Transporteur A", "Transporteur B", "Transporteur C"});
        transporteurBox.setFont(new Font("Arial", Font.PLAIN, 18));
        rightDetailsPanel.add(new JLabel("Transporteur: "));
        rightDetailsPanel.add(transporteurBox);
        fraisPortLabel = new JLabel("Frais de port offert à partir de 120 €");
        fraisPortLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        rightDetailsPanel.add(fraisPortLabel);

        detailsPanel.add(rightDetailsPanel, BorderLayout.EAST);

        contentPane.add(detailsPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CommandeGestion::new);
    }
}
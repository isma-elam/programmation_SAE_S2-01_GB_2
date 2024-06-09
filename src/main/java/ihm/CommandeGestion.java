package ihm;

import modele.Panier;
import modele.Transporteur;
import modele.Transporteurs;

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
    private Panier panier;

    public CommandeGestion(Panier panier) {
        this.panier = panier;
        setTitle("Gestion du Panier");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null); // Centrer la fenêtre
        setVisible(true);

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
        //when the button is clicked, the panierArea is cleared
        viderPanierButton.addActionListener(e -> {
            panier.vider();
            panierArea.setText("");
        });

        validerPanierButton = new JButton("Valider le Panier");
        validerPanierButton.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonPanel.add(validerPanierButton);
        //when the button is clicked, a new window is opened
        validerPanierButton.addActionListener(e -> {
            //open a new window with the order summary
            ValidationPanier vp = new ValidationPanier(panier);
            vp.setVisible(true);
        });

        continuerAchatsButton = new JButton("Continuer les Achats");
        continuerAchatsButton.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonPanel.add(continuerAchatsButton);
        //when the button is clicked, the current window is closed
        continuerAchatsButton.addActionListener(e -> {
            dispose();
        });

        recalculerButton = new JButton("Recalculer");
        recalculerButton.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonPanel.add(recalculerButton);
        //when the button is clicked, the total price is recalculated
        recalculerButton.addActionListener(e -> {
            UpdateAll();
        });

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
        rightDetailsPanel.add(fraisPortLabel);

        //when the user selects a transporteur, the fraisPortLabel is updated
        transporteurBox.addActionListener(e -> {
            UpdateAll();
        });

        detailsPanel.add(rightDetailsPanel, BorderLayout.EAST);

        contentPane.add(detailsPanel, BorderLayout.SOUTH);
        panier.setTransporteur(transporteurs.getTransporteur(0));
        UpdateAll();
    }

    public void UpdateAll() {
        updatePanierArea();
        updateFraisDePort(new Transporteurs().getTransporteur(transporteurBox.getSelectedIndex()));
    }

    public void updatePanierArea() {
        panierArea.setText(panier.toString());
        sousTotalLabel.setText("Sous-Total : " + panier.prixTotal() + " €");
        totalLabel.setText("TOTAL: " + panier.total() + " €");
    }

    public void updateFraisDePort( Transporteur transporteur) {
        panier.setTransporteur(transporteur);
        if (panier.prixTotal() > 120) {
            fraisPortLabel.setText("Frais de port offert");
        } else {
            fraisPortLabel.setText("Frais de port: " + transporteur.getFraisPort(panier.prixTotal()) + " €");
        }
    }
}
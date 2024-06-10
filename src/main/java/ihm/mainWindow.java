package ihm;

import modele.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class mainWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField searchField;
    private JPanel cheeseListPanel;
    private Fromages fromages;
    private JComboBox<String> milkTypeComboBox;
    Panier panier;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    mainWindow frame = new mainWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public mainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 710);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // Top panel with logo, search field, and cart button
        JPanel topPanel = new JPanel();
        contentPane.add(topPanel, BorderLayout.NORTH);
        topPanel.setLayout(new BorderLayout(0, 0));

        // Logo panel
        JPanel logoPanel = new JPanel();
        topPanel.add(logoPanel, BorderLayout.WEST);
        JLabel logoLabel = new JLabel(new ImageIcon("src\\main\\resources\\images\\logo\\logo.png")); // Replace with actual image path
        logoPanel.add(logoLabel);

        // Search panel
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(200, 25));
        searchPanel.add(searchField);
        topPanel.add(searchPanel, BorderLayout.CENTER);
        //when the user types in the search field, filter the list of cheeses
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterCheeses();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterCheeses();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterCheeses();
            }
        });

        // ComboBox for milk type
        String[] milkTypes = {"Tous les fromages", "Vache", "Chèvre", "Brebis"};
        milkTypeComboBox = new JComboBox<>(milkTypes);
        milkTypeComboBox.setPreferredSize(new Dimension(150, 25));
        searchPanel.add(milkTypeComboBox);

        topPanel.add(searchPanel, BorderLayout.CENTER);

        //When the user selects a milk type, filter the list of cheeses
        milkTypeComboBox.addActionListener(e -> {
            filterCheeses();
        });

        // Cart button
        JButton cartButton = new JButton("Panier");
        topPanel.add(cartButton, BorderLayout.EAST);
        //when the user clicks the "Panier" button, show the cart
        cartButton.addActionListener(e -> {
            CommandeGestion commandeGestion = new CommandeGestion(panier);
            commandeGestion.setVisible(true);
        });

        // Panel for the list of cheeses
        cheeseListPanel = new JPanel();
        cheeseListPanel.setLayout(new GridLayout(0, 1));
        JScrollPane scrollPane = new JScrollPane(cheeseListPanel);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Bottom panel with Quit button
        JPanel bottomPanel = new JPanel();
        contentPane.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.setLayout(new BorderLayout());

        JButton quitButton = new JButton("Quitter");
        quitButton.setPreferredSize(new Dimension(90, 30));
        bottomPanel.add(quitButton, BorderLayout.EAST);

        // Load cheeses
        fromages = GenerationFromages.generationBaseFromages();

        updateCheeseList(fromages.getFromages());

        panier = new Panier();
    }

    private void filterCheeses() {
        TypeLait typeLait = null;
        List<Fromage> filteredFromages = fromages.getFromages();
        switch (milkTypeComboBox.getSelectedItem().toString()) {
            case "Vache":
                typeLait = TypeLait.VACHE;
                break;
            case "Chèvre":
                typeLait = TypeLait.CHEVRE;
                break;
            case "Brebis":
                typeLait = TypeLait.BREBIS;
                break;
            case "Tous les fromages":
                break;
        }

        if (typeLait != null) {
            filteredFromages = this.fromages.filter(
                    FiltresEnum.TYPE_LAIT,
                    typeLait

            );
        }

        filteredFromages = Fromages.Recherche(
                searchField.getText().toLowerCase(),
                filteredFromages
        );

        updateCheeseList(filteredFromages);
    }

    private void updateCheeseList(List<Fromage> filteredFromages) {
        cheeseListPanel.removeAll();

        // Add filtered cheeses
        for (Fromage fromage : filteredFromages) {
            cheeseListPanel.add(createCheesePanel(fromage));
        }

        cheeseListPanel.revalidate();
        cheeseListPanel.repaint();
    }

    private JPanel createCheesePanel(Fromage fromage) {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel lblImage = new JLabel(new ImageIcon(fromage.getNomImagePath40()));
        panel.add(lblImage, BorderLayout.WEST);

        JPanel infoPanel = new JPanel(new GridLayout(2, 1));
        infoPanel.setPreferredSize(new Dimension(200, 50));
        JLabel lblName = new JLabel(fromage.getDesignation());

        JLabel lblPrice = new JLabel(fromage.getPrixs());

        infoPanel.add(lblName);
        infoPanel.add(lblPrice);
        panel.add(infoPanel, BorderLayout.CENTER);

        //when the user clicks the "Ajouter au panier" button, add the cheese to the cart

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(255, 229, 204)); // Very light orange background

        JButton addButton = new JButton("Ajouter au panier");
        addButton.setPreferredSize(new Dimension(150, 50));
        addButton.setBackground(new Color(255, 153, 51)); // Orange background
        addButton.setForeground(Color.WHITE); // White text

        buttonPanel.add(addButton);

        addButton.addActionListener(e -> {
            panier.addArticle(fromage.getLowestPriceArticle(),1);
        });

        JButton moreInfoButton = new JButton("...");
        moreInfoButton.setPreferredSize(new Dimension(30, 50));
        moreInfoButton.setBackground(new Color(255, 153, 51)); // Orange background
        moreInfoButton.setForeground(Color.WHITE); // White text
        buttonPanel.add(moreInfoButton);

        moreInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                DetailsFromage detailsFromage = new DetailsFromage(fromage);
                detailsFromage.setVisible(true);
            }
        });

        panel.add(buttonPanel, BorderLayout.EAST);

        return panel;
    }
}


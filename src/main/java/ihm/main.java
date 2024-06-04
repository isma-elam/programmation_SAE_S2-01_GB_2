package ihm;

import modele.Fromage;
import modele.Fromages;
import modele.GenerationFromages;
import modele.Recherche;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class main extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField searchField;
    private JPanel cheeseListPanel;
    private Fromages fromages;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    main frame = new main();
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
    public main() {
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
        JLabel logoLabel = new JLabel(new ImageIcon("path/to/logo.png")); // Replace with actual image path
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

        // Cart button
        JButton cartButton = new JButton("Panier");
        topPanel.add(cartButton, BorderLayout.EAST);

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
    }

    private void filterCheeses() {
        String query = searchField.getText().toLowerCase();
        List<Fromage> filteredFromages = this.fromages.Recherche(query);
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

        JButton addButton = new JButton("Ajouter au panier");
        addButton.setPreferredSize(new Dimension(150, 50));
        addButton.setMaximumSize(getMaximumSize());
        panel.add(addButton, BorderLayout.EAST);

        return panel;
    }
}


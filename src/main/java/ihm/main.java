package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class main extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField searchField;
    private JPanel cheeseListPanel;
    private List<Fromage> fromages;

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

        // Cart button
        JButton cartButton = new JButton("Panier");
        topPanel.add(cartButton, BorderLayout.EAST);

        // Panel for the list of cheeses
        cheeseListPanel = new JPanel();
        cheeseListPanel.setLayout(new GridLayout(0, 1));
        JScrollPane scrollPane = new JScrollPane(cheeseListPanel);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Example cheeses
        fromages = new ArrayList<>();
        fromages.add(new Fromage("Roquefort", "7.20 €", "C:\\Users\\isamr\\Downloads\\png.png"));
        fromages.add(new Fromage("Camembert", "5.00 €", "C:\\Users\\isamr\\Downloads\\png.png"));
        fromages.add(new Fromage("Brie", "6.50 €", "C:\\Users\\isamr\\Downloads\\png.png"));
        fromages.add(new Fromage("Chèvre", "4.80 €", "C:\\Users\\isamr\\Downloads\\png.png"));
        fromages.add(new Fromage("Emmental", "3.50 €", "C:\\Users\\isamr\\Downloads\\png.png"));
        fromages.add(new Fromage("Roquefort", "7.20 €", "C:\\Users\\isamr\\Downloads\\png.png"));
        fromages.add(new Fromage("Camembert", "5.00 €", "C:\\Users\\isamr\\Downloads\\png.png"));
        fromages.add(new Fromage("Brie", "6.50 €", "C:\\Users\\isamr\\Downloads\\png.png"));
        fromages.add(new Fromage("Chèvre", "4.80 €", "C:\\Users\\isamr\\Downloads\\png.png"));
        fromages.add(new Fromage("Emmental", "3.50 €", "C:\\Users\\isamr\\Downloads\\png.png"));
        fromages.add(new Fromage("Roquefort", "7.20 €", "C:\\Users\\isamr\\Downloads\\png.png"));
        fromages.add(new Fromage("Camembert", "5.00 €", "C:\\Users\\isamr\\Downloads\\png.png"));
        fromages.add(new Fromage("Brie", "6.50 €", "C:\\Users\\isamr\\Downloads\\png.png"));
        fromages.add(new Fromage("Chèvre", "4.80 €", "C:\\Users\\isamr\\Downloads\\png.png"));
        fromages.add(new Fromage("Emmental", "3.50 €", "C:\\Users\\isamr\\Downloads\\png.png"));
        fromages.add(new Fromage("Roquefort", "7.20 €", "C:\\Users\\isamr\\Downloads\\png.png"));
        fromages.add(new Fromage("Camembert", "5.00 €", "C:\\Users\\isamr\\Downloads\\png.png"));
        fromages.add(new Fromage("Brie", "6.50 €", "C:\\Users\\isamr\\Downloads\\png.png"));
        fromages.add(new Fromage("Chèvre", "4.80 €", "C:\\Users\\isamr\\Downloads\\png.png"));
        fromages.add(new Fromage("Emmental", "3.50 €", "C:\\Users\\isamr\\Downloads\\png.png"));

        // Add cheese panels
        updateCheeseList(fromages);

        // Bottom panel with Quit button
        JPanel bottomPanel = new JPanel();
        contentPane.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.setLayout(new BorderLayout());

        JButton quitButton = new JButton("Quitter");
        quitButton.setPreferredSize(new Dimension(90, 30));
        bottomPanel.add(quitButton, BorderLayout.EAST);

        // Search action
        /*searchField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText().toLowerCase();
                List<Fromage> filteredFromages = fromages.stream()
                        .filter(f -> f.getName().toLowerCase().contains(searchText))
                        .collect(Collectors.toList());
                updateCheeseList(filteredFromages);
            }
        });*/
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

        JLabel lblImage = new JLabel(new ImageIcon(fromage.getImagePath())); // Replace with actual image path
        panel.add(lblImage, BorderLayout.WEST);

        JPanel infoPanel = new JPanel(new GridLayout(2, 1));
        infoPanel.setPreferredSize(new Dimension(200, 50));
        JLabel lblName = new JLabel(fromage.getName());
        JLabel lblPrice = new JLabel(fromage.getPrice());
        infoPanel.add(lblName);
        infoPanel.add(lblPrice);
        panel.add(infoPanel, BorderLayout.CENTER);

        JButton addButton = new JButton("Ajouter au panier");
        addButton.setPreferredSize(new Dimension(150, 50));
        addButton.setMaximumSize(getMaximumSize());
        panel.add(addButton, BorderLayout.EAST);

        return panel;
    }

    class Fromage {
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


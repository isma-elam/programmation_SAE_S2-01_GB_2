package ihm;

import modele.Panier;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.io.IOException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

public class Facture {
	private static JTextField txtMerciDeVotre;
    private String Nom;
    private String adresse;
    private String telephone;
    private String mail;
    private String payment;
    private Panier panier;
    private URL Url;

   public Facture(String Nom, String adresse, String telephone, String mail, String payment, Panier panier) {
        this.Nom = Nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.mail = mail;
        this.payment = payment;
        this.panier = panier;
        createWindow();
   }

   private void createWindow() {
      JFrame frame = new JFrame("Swing Tester");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      createUI(frame);
      frame.setSize(560, 450);      
      frame.setLocationRelativeTo(null);  
      
      JPanel panel = new JPanel();
      frame.getContentPane().add(panel, BorderLayout.NORTH);
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
      
      JLabel lblNewLabel = new JLabel("Votre Facture");
      lblNewLabel.setBorder(new EmptyBorder(15, 0, 15, 0));
      lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
      lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
      panel.add(lblNewLabel);
      
      txtMerciDeVotre = new JTextField();
      txtMerciDeVotre.setFont(new Font("Tahoma", Font.PLAIN, 14));
      txtMerciDeVotre.setText("Merci de votre visite.");
      txtMerciDeVotre.setEditable(false);
      panel.add(txtMerciDeVotre);
      txtMerciDeVotre.setColumns(10);
      frame.setVisible(true);
   }

   private void createUI(final JFrame frame){
      JPanel panel = new JPanel();
      LayoutManager layout = new FlowLayout();  
      panel.setLayout(layout);
       JEditorPane jEditorPane = new JEditorPane();
       jEditorPane.setEditable(false);
       try {
           URL url = Facture.class.getResource("/Html/Facture.html");
           jEditorPane.setPage(url);
       } catch (IOException e) {
           jEditorPane.setContentType("text/html");
           jEditorPane.setText("<html>Erreur lors du chargement de la page.</html>");
       }

      JScrollPane jScrollPane = new JScrollPane(jEditorPane);
      jScrollPane.setPreferredSize(new Dimension(540,400));      

      panel.add(jScrollPane);
      frame.getContentPane().add(panel, BorderLayout.CENTER);    
   }  
} 
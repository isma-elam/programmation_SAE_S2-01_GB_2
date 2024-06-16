package ihm;

import modele.Facture;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.swing.*;
import java.awt.Component;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

public class FactureUI extends JFrame {

    private Facture facture;
    private JTextField txtMerciDeVotre;

   public FactureUI(Facture facture) {
        this.facture = facture;

        String html = facture.generateHTML();

       JFrame htmlFrame = new JFrame("Facture HTML");
       htmlFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       htmlFrame.setSize(600, 500);
       htmlFrame.setLocationRelativeTo(null);

       JEditorPane jEditorPane = new JEditorPane();
       jEditorPane.setContentType("text/html");
       jEditorPane.setText(html);
       jEditorPane.setEditable(false);

       JScrollPane jScrollPane = new JScrollPane(jEditorPane);
       htmlFrame.getContentPane().add(jScrollPane, BorderLayout.CENTER);

       // Ajout du bouton de téléchargement
       JButton downloadButton = new JButton("Télécharger Facture");
       downloadButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               downloadInvoiceAsFile(html);
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
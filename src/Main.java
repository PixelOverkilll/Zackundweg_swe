import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Main Methode
public class Main {

    public static void main(String[] args) {
        // Hier wird das Fenster erstellt und die Größe, der Titel und das Schließen des Fensters definiert.
        JFrame fenster = new JFrame("Zack und weg - Geldautomat");
        fenster.setVisible(true);
        fenster.setSize(1080, 720);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /// Hiermit werden neue Knöpfe erstellt
        JButton Knopf_Einzahlung = new JButton("Einzahlung");
        JButton Knopf_Auszahlung = new JButton("Auszahlung");
        JButton Knopf_Kontostand = new JButton("Kontostand");

        Knopf_Einzahlung.setPreferredSize(new Dimension(120,80)); // <- Größe
        Knopf_Einzahlung.setBackground(Color.white); // <- Farbe
        Knopf_Einzahlung.setForeground(Color.black); // <- Schriftfarbe
        
        Knopf_Auszahlung.setPreferredSize(new Dimension(120,80));
        Knopf_Auszahlung.setBackground(Color.white);
        Knopf_Auszahlung.setForeground(Color.black);
        
        Knopf_Kontostand.setPreferredSize(new Dimension(120,80));
        Knopf_Kontostand.setBackground(Color.white);
        Knopf_Kontostand.setForeground(Color.black);


        /// in einem Panel kannst du mehrere Knöpfe speichern oder auch texte und die dann abrufen.
        JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER)); // <- Layout für das Panel
        panel.add(Knopf_Einzahlung);
        panel.add(Knopf_Auszahlung);
        panel.add(Knopf_Kontostand);
        fenster.add(panel);
        
        
        JTextField textField = new JTextField(20);
        textField.setBounds(50, 20, 300, 30);
        panel.add(textField);
        
        
        
        JTextField textField2 = new JTextField(40);
        textField2.setBounds(50, 20, 500, 30);
        panel.add(textField2);
        textField2.setEditable(false);
    


        // Eigene Fenster Farbe
        Color Background = new Color(59, 51, 51); // Neue Farbe festlegen
        panel.setBackground(Background);
       
        // Eigenes Fenster Image
        ImageIcon icon = new ImageIcon("BankIcon.png");

        // Größe des Icons anpassen
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);

        fenster.setIconImage(icon.getImage());
        
        // ========================= Auszahlung =========================
		int[] kontostand = {0}; // Kontostand initialisieren

        // Aufrufen von Berechnung der Auszahlung
        // Hier wird die Auszahlung berechnet

        // Bei Knopf "Auszahlung" = Input für den Betrag
         Knopf_Auszahlung.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				try {
					int betrag = Integer.parseInt(textField.getText());
					if (betrag <= 0) {
						JOptionPane.showMessageDialog(panel, "Bitte geben Sie einen positiven Betrag ein!");
						return;
					}
					kontostand[0] -= betrag; // Hier wird der Betrag vom Kontostand abgezogen
					textField2.setText("Sie haben " + betrag + " € abgehoben.");
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(panel, "Bitte eine gültige Zahl eingeben!");
				}
			}
		});

        // ========================= Einzahlung =========================

        // Bei Knopf "Einzahlung" = Input für den Betrag
        Knopf_Einzahlung.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				try {
					int betrag = Integer.parseInt(textField.getText());
					if (betrag <= 0) {
						JOptionPane.showMessageDialog(panel, "Bitte geben Sie einen positiven Betrag ein!");
						return;
					}
					kontostand[0] += betrag; // Hier wird der Betrag zum Kontostand hinzugefügt
					textField2.setText("Sie haben " + betrag + " € eingezahlt.");
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(panel, "Bitte eine gültige Zahl eingeben!");
				}
			}
		});

        // ========================= Kontostand =========================

        // Bei Knopf "Kontostand" = Input für den Betrag
        Knopf_Kontostand.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               textField2.setText("Aktueller Kontostand: " + kontostand[0] + " €");
            }
        });

        // ==============================================================
    }

}
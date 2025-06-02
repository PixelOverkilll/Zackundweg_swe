import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// Main Methode
public class Main {

	public static void main(String[] args) {
    	// Hier wird das Fenster erstellt
    	// und die Größe, der Titel und das Schließen des Fensters definiert.
    	JFrame fenster = new JFrame("Zack und weg - Geldautomat");
    	fenster.setVisible(true);
    	fenster.setSize(1080, 720);
    	fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	/// Info für Marlon mit dem code machst du ein Knopf.
    	JButton Knopf_Einzahlung = new JButton("Einzahlung");
    	JButton Knopf_Auszahlung = new JButton("Auszahlung");
    	JButton Knopf_Kontostand = new JButton("Kontostand");
 
    	Knopf_Einzahlung.setPreferredSize(new Dimension(120,80)); // <- Hier kannst du die Größe des Knopfes anpassen
    	Knopf_Einzahlung.setBackground(Color.white); // <- Hier kannst du die Farbe des Knopfes anpassen
    	Knopf_Einzahlung.setForeground(Color.black); // <- Hier kannst du die Schriftfarbe des Knopfes anpassen
   	 
    	Knopf_Auszahlung.setPreferredSize(new Dimension(120,80));
    	Knopf_Auszahlung.setBackground(Color.white);
    	Knopf_Auszahlung.setForeground(Color.black);
   	 
    	Knopf_Kontostand.setPreferredSize(new Dimension(120,80));
    	Knopf_Kontostand.setBackground(Color.white);
    	Knopf_Kontostand.setForeground(Color.black);


    	/// in einem Panel kannst du mehrere Knöpfe speichern oder auch texte und die dann abrufen.
    	JPanel panel = new JPanel();
    	panel.add(Knopf_Einzahlung);
    	panel.add(Knopf_Auszahlung);
    	panel.add(Knopf_Kontostand);
    	fenster.add(panel);


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

    	// Aufrufen von Berechnung der Auszahlung
    	// Hier wird die Auszahlung berechnet
    	int AuszahlBetrag = 240; // Example amount
    	int[] result = Auszahlung.berechne(AuszahlBetrag);

    	// Bei Knopf "Auszahlung" = Input für den Betrag
    	Knopf_Auszahlung.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
            	// Hier wird die Methode ausgeführt, wenn der Knopf gedrückt wird
            	JOptionPane.showMessageDialog(null, "Auszahlung Knopf wurde gedrückt!");
            	// Du kannst hier deine andere Logik implementieren
        	}
    	});

    	// Ausgabe der Auszahlung
    	System.out.println("Auszahlungsplan für " + AuszahlBetrag + " Euro:");
    	for (int i = 0; i < result.length; i++) {
        	if (result[i] > 0) {
            	System.out.println(result[i] + " x " + Auszahlung.SCHEINWERTE[i] + " Euro");
        	}
    	}

    	// ==============================================================

		// ========================= Einzahlung =========================

    	// Bei Knopf "Einzahlung" = Input für den Betrag
    	Knopf_Einzahlung.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
            	// Hier wird die Methode ausgeführt, wenn der Knopf gedrückt wird
            	JOptionPane.showMessageDialog(null, "Einzahlung Knopf wurde gedrückt!");
            	// Du kannst hier deine andere Logik implementieren
        	}
    	});

    	// ==============================================================
	}

}

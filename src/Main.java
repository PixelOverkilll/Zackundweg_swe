// Import von Libraries
import java.awt.*;
import java.util.Map;
import javax.swing.*;

// Main Methode
public class Main {

    public static void main(String[] args) {
        // Hier wird das Fenster erstellt
        // und die Größe, der Titel und das Schließen des Fensters definiert.
        JFrame fenster = new JFrame("Zack und weg - Geldautomat");
        fenster.setVisible(true);
        fenster.setSize(900, 800);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /// Info für Marlon mit dem code machst du ein Knopf.
        JButton Knopf = new JButton("Einzahlung");
        JButton Knopf2 = new JButton("Auszahlung");
 
        Knopf.setPreferredSize(new Dimension(201,99)); // <- Hier kannst du die Größe des Knopfes anpassen
        Knopf.setBackground(Color.MAGENTA); // <- Hier kannst du die Farbe des Knopfes anpassen
        Knopf.setForeground(Color.black); // <- Hier kannst du die Schriftfarbe des Knopfes anpassen




        /// in einem Panel kannst du mehrere Knöpfe speichern oder auch texte und die dann abrufen.
        JPanel panel = new JPanel();
        panel.add(Knopf, BorderLayout.CENTER); // <- Hier wird der Knopf in der Mitte des Panels platziert
        panel.add(Knopf2, BorderLayout.CENTER); // <- Hier wird der Knopf in der Mitte des Panels platziert
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
        
        // Aufrufen von Berechnung der Auszahlung
        // Hier wird die Auszahlung berechnet
        int betrag = 240; // Example amount
        Map<Integer, Integer> result = Auszahlung.berechne(betrag);

        System.out.println(result);

    }

}
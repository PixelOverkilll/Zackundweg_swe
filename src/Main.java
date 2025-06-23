import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Main Methode
public class Main {

    public static void zeigeStartGif() {
        JWindow splash = new JWindow();
        ImageIcon icon = ResourceLoader.loadIcon("start.gif");
        if (icon != null) {
            // GIF skalieren
            Image image = icon.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
            ImageIcon scaledIcon = new ImageIcon(image);
            JLabel gifLabel = new JLabel(scaledIcon);
            splash.getContentPane().add(gifLabel);
            splash.pack();
            // Fenster zentrieren
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (screenSize.width - splash.getWidth()) / 2;
            int y = (screenSize.height - splash.getHeight()) / 2;
            splash.setLocation(x, y);
            splash.setVisible(true);

            // GIF für 3 Sekunden anzeigen
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            splash.setVisible(false);
            splash.dispose();
        }
    }

    public static void main(String[] args) {
        // Start-GIF anzeigen
        zeigeStartGif();

        // Hier wird das Fenster erstellt und die Größe, der Titel und das Schließen des Fensters definiert.
        JFrame fenster = new JFrame("Zack und weg - Geldautomat");
        fenster.setSize(800, 600);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Hauptpanel mit BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Eigene Fenster Farbe
        Color backgroundColor = new Color(59, 51, 51); // Neue Farbe festlegen
        mainPanel.setBackground(backgroundColor);
        
        // Logo Panel (oben)
        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        logoPanel.setBackground(backgroundColor);
        
        // Logo laden und anzeigen
        ImageIcon bankLogo = ResourceLoader.loadIcon("Bank2.png");
        if (bankLogo != null) {
            Image scaledImage = bankLogo.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            bankLogo = new ImageIcon(scaledImage);
        }
        JLabel logoLabel = new JLabel(bankLogo);
        logoPanel.add(logoLabel);
        
        // Ausgabe Panel (oben) - für Kontostand und Aktionsanzeige
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.setBackground(backgroundColor);
        outputPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        
        // Anzeige für Kontostand und Aktionen
        JTextField displayField = new JTextField();
        displayField.setEditable(false);
        displayField.setFont(new Font("Arial", Font.BOLD, 16));
        displayField.setHorizontalAlignment(JTextField.CENTER);
        displayField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.DARK_GRAY, 2),
            BorderFactory.createEmptyBorder(8, 8, 8, 8)
        ));
        outputPanel.add(displayField, BorderLayout.CENTER);
        
        // Eingabe Panel (mitte) mit GridBagLayout für präzise Zentrierung
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBackground(backgroundColor);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        
        // GridBagConstraints für präzise Positionierung
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.weightx = 1.0;
        
        // Label für Betrag
        JLabel inputLabel = new JLabel("Betrag in €");
        inputLabel.setForeground(Color.WHITE);
        inputLabel.setFont(new Font("Arial", Font.BOLD, 24));
        inputLabel.setHorizontalAlignment(JLabel.CENTER);
        
        // Eingabefeld
        JTextField inputField = new JTextField(10);
        inputField.setFont(new Font("Arial", Font.PLAIN, 36));
        inputField.setPreferredSize(new Dimension(300, 60));
        inputField.setHorizontalAlignment(JTextField.CENTER);
        
        // Label hinzufügen (erste Zeile)
        gbc.gridy = 0;
        inputPanel.add(inputLabel, gbc);
        
        // Eingabefeld hinzufügen (zweite Zeile)
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 5, 0); // Mehr Abstand nach oben
        inputPanel.add(inputField, gbc);
        
        // Button Panel (unten) mit GridLayout für gleichmäßige Streckung
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 15, 0));
        buttonPanel.setBackground(backgroundColor);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        buttonPanel.setPreferredSize(new Dimension(0, 80)); // Mindesthöhe für das Button-Panel
        
        /// Hiermit werden neue Knöpfe erstellt
        JButton Knopf_Einzahlung = new JButton("Einzahlung");
        JButton Knopf_Auszahlung = new JButton("Auszahlung");
        JButton Knopf_Kontostand = new JButton("Kontostand");

        // Styling für alle Buttons
        Font buttonFont = new Font("Arial", Font.BOLD, 16); // Größere Schrift für bessere Sichtbarkeit
        // Keine feste Größe für die Buttons, damit sie sich stretchen können
        
        // Einzahlung Button styling
        Knopf_Einzahlung.setFont(buttonFont);
        Knopf_Einzahlung.setBackground(new Color(76, 175, 80));
        Knopf_Einzahlung.setForeground(Color.WHITE);
        Knopf_Einzahlung.setFocusPainted(false);
        Knopf_Einzahlung.setMinimumSize(new Dimension(100, 50)); // Mindestgröße
        Knopf_Einzahlung.setPreferredSize(new Dimension(120, 60)); // Bevorzugte Größe
        
        // Auszahlung Button styling
        Knopf_Auszahlung.setFont(buttonFont);
        Knopf_Auszahlung.setBackground(new Color(255, 152, 0));
        Knopf_Auszahlung.setForeground(Color.WHITE);
        Knopf_Auszahlung.setFocusPainted(false);
        Knopf_Auszahlung.setMinimumSize(new Dimension(100, 50)); // Mindestgröße
        Knopf_Auszahlung.setPreferredSize(new Dimension(120, 60)); // Bevorzugte Größe
        
        // Kontostand Button styling
        Knopf_Kontostand.setFont(buttonFont);
        Knopf_Kontostand.setBackground(new Color(33, 150, 243));
        Knopf_Kontostand.setForeground(Color.WHITE);
        Knopf_Kontostand.setFocusPainted(false);
        Knopf_Kontostand.setMinimumSize(new Dimension(100, 50)); // Mindestgröße
        Knopf_Kontostand.setPreferredSize(new Dimension(120, 60)); // Bevorzugte Größe
        
        // Buttons zum Panel hinzufügen (werden automatisch gestreckt durch GridLayout)
        buttonPanel.add(Knopf_Einzahlung);
        buttonPanel.add(Knopf_Auszahlung);
        buttonPanel.add(Knopf_Kontostand);
        
        // Eigenes Fenster Image
        ImageIcon icon2 = ResourceLoader.loadIcon("BankIcon.png");
        if (icon2 != null) {
            // Größe des Icons anpassen (für das Fenster-Icon)
            Image image2 = icon2.getImage();
            Image scaledIcon = image2.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
            icon2 = new ImageIcon(scaledIcon);
            fenster.setIconImage(icon2.getImage());
        }
        
        // Panels zusammenfügen
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.setBackground(backgroundColor);
        centerPanel.add(outputPanel, BorderLayout.NORTH);
        centerPanel.add(inputPanel, BorderLayout.CENTER);
        
        // Hauptpanel zusammensetzen
        mainPanel.add(logoPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Hauptpanel zum Fenster hinzufügen
        fenster.add(mainPanel);
        
        // Fenster zentrieren und anzeigen
        fenster.setLocationRelativeTo(null);
        fenster.setVisible(true);
        
        // ========================= Kontostand =========================
        int[] kontostand = {0}; // Kontostand initialisieren

        // Bei Knopf "Auszahlung" = Input für den Betrag
        Knopf_Auszahlung.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int betrag = Integer.parseInt(inputField.getText());

                    if (betrag > kontostand[0]) {
                        JOptionPane.showMessageDialog(fenster, "Nicht genügend Guthaben!");
                        return;
                    }

                    int[] result = Auszahlung.berechne(betrag);
                    if (result.length == 0) {
                        JOptionPane.showMessageDialog(fenster, "Ungültiger Betrag! Du kannst nur Beträge ab 5€ abheben");
                        return;
                    }

                    kontostand[0] -= betrag; // Betrag vom Kontostand abziehen
                    displayField.setText("Sie haben " + betrag + " € abgehoben.");
                    inputField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(fenster, "Bitte eine gültige Zahl eingeben!");
                }
            }
        });

        // ========================= Einzahlung =========================

        // Bei Knopf "Einzahlung" = Input für den Betrag
        Knopf_Einzahlung.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int betrag = Integer.parseInt(inputField.getText());

                    int[] result = Einzahlung.berechne(betrag);
                    if (result.length == 0) {
                        JOptionPane.showMessageDialog(fenster, "Ungültiger Betrag! Du musst mindestens 5€ einzahlen");
                        return;
                    }

                    kontostand[0] += betrag; // Betrag zum Kontostand hinzufügen
                    displayField.setText("Sie haben " + betrag + " € eingezahlt.");
                    inputField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(fenster, "Bitte eine gültige Zahl eingeben!");
                }
            }
        });

        // ========================= Kontostand =========================

        // Bei Knopf "Kontostand" = Input für den Betrag
        Knopf_Kontostand.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayField.setText("Aktueller Kontostand: " + kontostand[0] + " €");
            }
        });

        // Initial welcome message
        displayField.setText("Willkommen! Bitte wählen Sie eine Aktion.");
    }
}

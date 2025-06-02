public class Auszahlung {

    // Arrays für die Scheinwerte und ihre Beschreibungen
    public static final int[] SCHEINWERTE = {200, 100, 50, 20, 10, 5};
    public static final String[] SCHEINBESCHREIBUNGEN = {
        "200 Euro Schein(e)",
        "100 Euro Schein(e)",
        "50 Euro Schein(e)",
        "20 Euro Schein(e)",
        "10 Euro Schein(e)",
        "5 Euro Schein(e)"
    };

    private static boolean istBetragGueltig(int betrag) {
        if (betrag < 0) {
            System.err.println("Fehler: Negative Beträge sind nicht erlaubt!");
            return false;
        }
        
        if (betrag < 5) {
            System.err.println("Fehler: Der Mindestbetrag für eine Auszahlung beträgt 5 Euro!");
            return false;
        }
        
        if (betrag % 5 != 0) {
            System.err.println("Fehler: Der Betrag " + betrag + " ist nicht durch 5 teilbar. Kein Restbetrag möglich!");
            return false;
        }
        
        return true;
    }

    public static int[] berechneAuszahlung(int betrag) {
        // Validierung des Betrags
        if (!istBetragGueltig(betrag)) {
            return new int[0]; // Leeres Array im Fehlerfall
        }
        
        int[] auszahlungsPlan = new int[SCHEINWERTE.length];
        int restBetrag = betrag;

        // Berechnung der Scheinanzahl für jeden Scheinwert
        for (int i = 0; i < SCHEINWERTE.length; i++) {
            int schein = SCHEINWERTE[i];
            
            // Anzahl der Scheine dieses Werts berechnen
            int anzahlScheine = restBetrag / schein;
            auszahlungsPlan[i] = anzahlScheine;
            
            // Restbetrag aktualisieren
            restBetrag -= anzahlScheine * schein;
            
            // Abbruch, wenn kein Restbetrag mehr vorhanden
            if (restBetrag == 0) {
                break;
            }
        }

        // Prüfen, ob der gesamte Betrag aufgeteilt wurde
        if (restBetrag != 0) {
            System.err.println("Fehler: Der Betrag konnte nicht vollständig aufgeteilt werden. Rest: " + restBetrag);
            return new int[0]; // Leeres Array im Fehlerfall
        }

        return auszahlungsPlan;
    }

    /**
     * Alias für berechneAuszahlung setzen / Umbennen der Methode
     */
    public static int[] berechne(int betrag) {
        return berechneAuszahlung(betrag);
    }
}
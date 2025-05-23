import java.util.LinkedHashMap;
import java.util.Map;

public class Auszahlung {

    public static final Map<Integer, String> SCHEINWERTE = new LinkedHashMap<>();
    static {
        SCHEINWERTE.put(200, "200 Euro Schein(e)");
        SCHEINWERTE.put(100, "100 Euro Schein(e)");
        SCHEINWERTE.put(50, "50 Euro Schein(e)");
        SCHEINWERTE.put(20, "20 Euro Schein(e)");
        SCHEINWERTE.put(10, "10 Euro Schein(e)");
        SCHEINWERTE.put(5, "5 Euro Schein(e)");
    }

    public static Map<Integer, Integer> berechneAuszahlung(int betrag) {
        Map<Integer, Integer> auszahlungsPlan = new LinkedHashMap<>(); // Behält die Reihenfolge der Scheine bei
        int restBetrag = betrag;

        // Überprüfen, ob der Betrag ein Vielfaches von 5 ist
        if (betrag % 5 != 0) {
            System.err.println("Fehler: Der Betrag " + betrag + " ist nicht durch 5 teilbar. Kein Restbetrag möglich!");
            return new LinkedHashMap<>(); // Leere Map im Fehlerfall
        }
        
        // Mindestbetrag von 5 Euro
        if (betrag < 5) {
            System.err.println("Fehler: Der Mindestbetrag für eine Auszahlung beträgt 5 Euro!");
            return new LinkedHashMap<>(); // Leere Map im Fehlerfall
        }

        // Es wird geprüft, ob der Betrag negativ ist
        if (betrag < 0) {
            System.err.println("Fehler: Negative Beträge sind nicht erlaubt!");
            return new LinkedHashMap<>(); // Leere Map im Fehlerfall
        }

        // Sortiert / Aufteilung die Scheinwerte von groß nach klein
        for (int schein : SCHEINWERTE.keySet()) {
            if (restBetrag == 0) {
                break; // Gesamter Betrag wurde aufgeteilt
            }
            if (restBetrag >= schein) {
                int anzahlScheine = restBetrag / schein;
                auszahlungsPlan.put(schein, anzahlScheine);
                restBetrag %= schein; // Aktualisiere den Restbetrag
            } else {
                auszahlungsPlan.put(schein, 0); // Kein Schein dieses Wertes benötigt
            }
        }

        // Sollte nicht passieren, wenn der Betrag ein Vielfaches von 5 ist
        // und 5 als kleinster Schein verfügbar ist.
        if (restBetrag != 0) {
            System.err.println("Fehler: Der Betrag konnte nicht vollständig aufgeteilt werden. Rest: " + restBetrag);
            return new LinkedHashMap<>(); // Leere Map im Fehlerfall
        }

        return auszahlungsPlan;
    }

    public static Map<Integer, Integer> berechne(int betrag) {
        return berechneAuszahlung(betrag);
    }
}
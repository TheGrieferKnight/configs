import java.util.ArrayList;
import java.util.List;

public class Selectionsort {
    private List<Integer> originalListe;

    // Konstruktor: Initialisiert die Klasse mit einer Liste unsortierter Zahlen
    public Selectionsort(List<Integer> unsortierteZahlen) {
        // Wir erstellen eine Kopie, um die übergebene Liste bearbeiten zu können
        this.originalListe = new ArrayList<>(unsortierteZahlen);
    }

    public void sortieren() {
        // Erzeuge eine Hilfsliste
        List<Integer> hilfsliste = new ArrayList<>();

        // solange die Originalliste nicht leer ist
        while (!originalListe.isEmpty()) {
            // Initialisiere eine Hilfsvariable mit dem ersten Element
            int hilfsvariable = originalListe.get(0);

            /*
             * Im Struktogramm wird ein Zeiger verwendet. In Java nutzen wir 
             * eine Schleife, die ab dem zweiten Element (Index 1) vergleicht.
             */
            for (int i = 1; i < originalListe.size(); i++) {
                int aktuellesElement = originalListe.get(i);

                // Wenn aktuelles Element kleiner als Hilfsvariable
                if (aktuellesElement < hilfsvariable) {
                    // WAHR: Hilfsvariable = aktuelles Element
                    hilfsvariable = aktuellesElement;
                }
                // FALSCH: Nichts tun (-)
            }

            /*
             * Lösche das Element mit dem Wert der Hilfsvariablen.
             * Wichtig: Integer.valueOf stellt sicher, dass das Objekt gelöscht 
             * wird und nicht der Index.
             */
            originalListe.remove(Integer.valueOf(hilfsvariable));

            // Hänge ein Element mit dem Wert der Hilfsvariablen an die Hilfsliste an
            hilfsliste.add(hilfsvariable);
        }

        // weise der Originalliste die Hilfsliste zu
        this.originalListe = hilfsliste;
    }

    public List<Integer> getListe() {
        return originalListe;
    }

    // Beispiel zur Ausführung
    public static void main(String[] args) {
        List<Integer> daten = new ArrayList<>(List.of(5, 2, 8, 1, 9));
        Selectionsort sortierer = new Selectionsort(daten);

        System.out.println("Unsortiert: " + sortierer.getListe());
        sortierer.sortieren();
        System.out.println("Sortiert:   " + sortierer.getListe());
    }
}

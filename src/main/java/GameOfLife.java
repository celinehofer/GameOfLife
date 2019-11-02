import java.util.Random;

public class GameOfLife {

    // Global definierte Konstanten für die beiden Dimensionen
    private final static int DIMx = 12;
    private final static int DIMy = 12;

    // Liefert eine zufällig initialisierte Welt
    private boolean[][] initWelt() {

        boolean[][] welt = new boolean[DIMx][DIMy];
        Random random = new Random();

        //füllt nach zufallsprinzip den array ab
        for (int x = 1; x < welt.length - 1; x++) {
            for (int y = 1; y < welt[x].length - 1; y++) {
                welt[x][y] = random.nextBoolean();
            }
        }
        return welt;
    }

    // Gibt die aktuelle Welt aus
    private void zeigeWelt(boolean[][] welt) {
        for (int y = 0; y < welt.length; y++) {
            for (int x = 0; x < welt[y].length; x++) {
                System.out.print(welt[y][x] ? " X" : "   ");
            }
            System.out.println();
        }
    }

    private boolean[][] cloneWelt(boolean[][] welt) {
        if (welt == null)
            return null;
        boolean[][] result = new boolean[welt.length][];
        for (int r = 0; r < welt.length; r++) {
            result[r] = welt[r].clone();
        }
        return result;
    }

    // Wendet die 4 Regeln an und gibt die Folgegeneration wieder zurück
    private boolean[][] wendeRegelnAn(boolean[][] welt) {
        boolean[][] neueWelt = cloneWelt(welt);
        for (int x = 1; x < welt.length - 1; x++) {
            for (int y = 1; y < welt[y].length - 1; y++) {
                int anzahlNachbarn = this.anzahlNachbarn(welt, x, y);
                neueWelt[x][y] = (welt[x][y] && anzahlNachbarn == 2) || anzahlNachbarn == 3;
            }
        }

        return neueWelt;
    }

    // Liefert Anzahl Nachbarn einer Zelle
    private int anzahlNachbarn(boolean[][] welt, int x, int y) {
        int returnValue = 0;
        for (int i = x - 1; i <= x + 1; ++i)
            for (int j = y - 1; j <= y + 1; ++j)
                if (welt[i][j])
                    returnValue += 1;
        // einen Nachbarn zuviel mitgezählt?
        if (welt[x][y])
            returnValue -= 1;
        return returnValue;
    }

    public static void main(String[] args) {

        GameOfLife game = new GameOfLife();

        // Welt initialisieren
        boolean[][] welt = game.initWelt();

        System.out.println("Startkonstellation");
        game.zeigeWelt(welt);

        for (int i = 1; i <= 100; i++) {
            welt = game.wendeRegelnAn(welt);
            System.out.println("Generation " + i);
            game.zeigeWelt(welt);
        }
    }
}
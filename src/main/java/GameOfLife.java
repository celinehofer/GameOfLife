import java.util.Random;

public class GameOfLife {

    // Global definierte Konstanten für die beiden Dimensionen
    private final static int DIMx = 12;
    private final static int DIMy = 12;

    // Liefert eine zufällig initialisierte Welt
    private boolean[][] initWelt() {
        Random random = new Random();
        boolean[][] array = new boolean[DIMx][DIMy];
        for (int x = 1; x < DIMx - 1; x++ ){
            for(int y = 1; y < DIMy - 1; y++){
                array[x][y] = random.nextBoolean();
            }
        }
        return array;
    }

    // Gibt die aktuelle Welt aus
    private void zeigeWelt(boolean[][] welt) {
        System.out.println(welt);
        // TODO

    }

    // Wendet die 4 Regeln an und gibt die Folgegeneration wieder zurück
    private boolean[][] wendeRegelnAn(boolean[][] welt) {

        // TODO
    return new boolean[1][1];
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

        for (int i = 1; i <= 1; i++) {
            //welt = game.wendeRegelnAn(welt);
            System.out.println("Generation " + i);
            game.zeigeWelt(welt);
        }
    }
}
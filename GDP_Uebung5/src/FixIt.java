public class FixIt {
    private static int j;
    private static int h;

    //Globale Variablen sind hier nicht zwingend notwendig
    //Schleifenvariablen sollte man immer einzeln setzen... und NICHT global...
    public static int a(int k) {
        h = 0;
        for (int y = k; y > 0; y--) //dekrementieren erscheint mir hier sinnvoller...
            h += y;
        return h; // falscher return, es wurde einfach nur die eingabe wieder zurückgegeben
    }

    public static int m(int k) {
        j = 1; // 0 * (was auch immer) = 0, die 1 verändert allerdings in diesem fall nichts ....
        for (int i = 1; i <= k; ++i)
            j *= a(i);
        return j;
    }
}
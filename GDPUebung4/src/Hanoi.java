public class Hanoi {
    public static void bewege(int n, char start, char hilfe, char ziel){
        if (n == 1) {
            System.out.println("Scheibe 1 von " + start + " nach " + hilfe);
            System.out.println("Scheibe 1 von " + hilfe + " nach " + ziel);
        }
        else {
            bewege(n-1,start,hilfe,ziel);
            System.out.println("Scheibe " + n + " von " + start + " nach " + hilfe);
            bewege(n-1,ziel,hilfe,start);
            System.out.println("Scheibe " + n + " von " + hilfe + " nach " + ziel);
            bewege(n-1,start,hilfe,ziel);

        }
    }
    public static void main(String argv[]) {
        int n;
        System.out.print("Anzahl der Scheiben: ");
        //n = Keyboard.readInt();
        n=4;
        if (n > 0) {
            System.out.println("Scheibenbewegungen:");
            bewege(n, 'A', 'B', 'C');
        } else {
            System.out.println("Zahl nicht positiv");
        }
    }
}
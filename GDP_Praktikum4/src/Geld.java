class Geld {
    public static boolean Cache_an_aus = false;
    public static long CACHE[][] = new long[2001][8];
    public static void main(String[] s) {
        int sum = intUmwandeln(s);
        System.out.print(euro(sum));
        System.out.print(" kann auf ");
        System.out.print(pay(sum));
        System.out.println(" verschiedene Arten passend bezahlt werden");

    }
    public static int intUmwandeln(String[] s){
        int t = 0;
        if(s[0].equals("-c")){
            Cache_an_aus = true;
            t++;
        }
        if (s.length > 2){
            System.out.println("Bitte nicht mehr als zwei Parameter eingeben");
            System.exit(-1);
        }
        if (s.length == 0){
            System.out.println("Bitte einen Parameter eingeben.");
            System.exit(-1);
        }
        int sum = 0;
        try {
            sum = Integer.parseInt(s[t]);
        }
        catch (Throwable e) {
            System.out.println("Bitte nur eine positive ganze Zahl als Parameter eingeben");
            System.exit(-1);
        }
        if(sum > 2000){
            System.out.println("Bitte keinen Betrag größer als 2000 Cent eingeben");
            System.exit(-1);
        }
        return sum;
    }

    public static int[] Werte = {1, 2, 5, 10, 20, 50, 100, 200};

    public static long pay (int m, int n){
        if(n==0 || m==1)
            return 1;
        if(m < 0)
            return 0;
        if(Cache_an_aus) {
            if(CACHE[m][n] != 0) {
                return CACHE[m][n];
            }
            else{
                CACHE[m][n] = pay(m - Werte[n], n) + pay(m, n-1);
                return CACHE[m][n];
            }
        }
        return pay(m-Werte[n], n) + pay(m, n-1);
    }

    public static long pay (int m) {
        return pay(m, 7);

        }

    public static String million() {
        int zaehler = 0;
        while(pay(zaehler) < 1000000) {
            zaehler++;
        }
        return euro(zaehler);
    }

    public static String euro(int cent) {
        if (cent % 100 < 10){
            return cent / 100 + ",0" + cent % 100 + " Euro";
        }
        else{
            return cent / 100 + "," + cent % 100 + " Euro";
        }
    }
}

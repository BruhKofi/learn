import java.io.*;
class Sudoku {
    public enum Variante { normal, mitDiagonalen }
    private Variante v;
    // was sonst noch noetig ist ...
    public static char[] charliste = {'1','2','3','4','5','6','7','8','9'};
    public static char Eingabe[][] = new char[9][9];
    public Sudoku(Variante v) {
        this.v = v;
    }
    public void read(){
        String[] Zeile = new String[9];
        for (int i = 0; i < 9; i++) {
            Zeile[i] = Keyboard.readString();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Eingabe[i][j] = Zeile[i].charAt(j);
            }
        }

        int z = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    if (Eingabe[i][j] != charliste[k]) {
                        z++;
                    }
                }
                if (z == 9) {
                    Eingabe[i][j] = ' ';
                }
                z = 0;
            }
        }

    }
    public void write(){
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) {
                System.out.println("+-------+-------+-------+");
            }
            System.out.println(
                    "| " + Eingabe[i][0] + " " + Eingabe[i][1] + " " + Eingabe[i][2] + " |" +
                            " " + Eingabe[i][3] + " " + Eingabe[i][4] + " " + Eingabe[i][5] + " |" +
                            " " + Eingabe[i][6] + " " + Eingabe[i][7] + " " + Eingabe[i][8] + " |");
        }
        System.out.println("+-------+-------+-------+");



    }
    public boolean check(){
        for(int i=0;i<9;i++) {
            for (int j = 0; j < 9; j++) {
                if (Eingabe[i][j] != ' ') {
                    if (test(i, j, Eingabe[i][j])){
                        return false;
                    }
                }
            }
        }
        return true;
        }
    public void solve()       {
        if(solve2(0,0)) write();
        else System.out.println("nicht loesbar :-(");
    }
    public static boolean solve2(int i,int j){
        if(j==9){
            i++;
            if(i==9){
                return true;
            }
            j=0;
        }
        if(Eingabe[i][j] != ' '){
            return solve2(i,j+1);
        }
        else {
            for (int a = 0; a < 9; a++) {
                if (test(i, j, charliste[a]) == false) {
                    Eingabe[i][j] = charliste[a];
                    if (solve2(i, j + 1)) return true;
                }
            }
            Eingabe[i][j] = ' ';
            return false;
        }
    }
    public static boolean test(int i,int j,char a){
        if (Horizontal(i,j,a)) return true;
        if (Vertikal(i,j,a)) return true;
        if (Box(i,j,a)) return true;
        case v = Sudoku.Variante.mitDiagonalen //??????????????????


        return false;
    }
    public static boolean Horizontal(int i,int j, char a){
        for(int z=0;z<9;z++){
            if(Eingabe[i][j]==Eingabe[i][z]) continue;
            if(Eingabe[i][z] == a) return true;

        }
        return false;
    }
    public static boolean Vertikal(int i,int j, char a){
        for(int z=0;z<9;z++){
            if(Eingabe[i][j]==Eingabe[z][j]) continue;
            if (Eingabe[z][j]==a) return true;
        }
        return false;
    }
    public static boolean Box(int i,int j,char a ){
        int starti = (int)(i/3) * 3;
        int startj = (int)(j/3) * 3;
        for(int b=starti;b<starti+3;b++){
            for(int c=startj;c<startj+3;c++){
                if(Eingabe[i][j]==Eingabe[b][c]) continue;
                if (Eingabe[b][c]== a) return true;
            }
        }
        return false;
    }
}
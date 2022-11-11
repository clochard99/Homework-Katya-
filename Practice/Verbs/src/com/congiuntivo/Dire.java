package com.congiuntivo;

public class Dire {
    static String[][] arrays4 = new String[6][4];

    public static void main(String[] args) {
        System.out.println("Let's look at the verb \"to say\" in Italian.\nYou can see from the left side to the right side of this 2d array Presente, Passato, Imperfetto, Trapassato.");
        arrays4[0][0] = "dica    ";
        arrays4[1][0] = "dica    ";
        arrays4[2][0] = "dica    ";
        arrays4[3][0] = "diciamo ";
        arrays4[4][0] = "diciate ";
        arrays4[5][0] = "dicano  ";
        arrays4[0][1] = "abbia detto   ";
        arrays4[1][1] = "abbia detto   ";
        arrays4[2][1] = "abbia detto   ";
        arrays4[3][1] = "abbiamo detto ";
        arrays4[4][1] = "abbiate detto ";
        arrays4[5][1] = "abbiano detto ";
        arrays4[0][2] = "dicessi   ";
        arrays4[1][2] = "dicessi   ";
        arrays4[2][2] = "dicesse   ";
        arrays4[3][2] = "dicessimo ";
        arrays4[4][2] = "diceste   ";
        arrays4[5][2] = "dicessero ";
        arrays4[0][3] = "avessi detto  ";
        arrays4[1][3] = "avessi detto  ";
        arrays4[2][3] = "avesse detto  ";
        arrays4[3][3] = "avessimo detto";
        arrays4[4][3] = "aveste detto  ";
        arrays4[5][3] = "avessero detto";
        for (int i = 0; i < arrays4.length; i++) {
            for (int j = 0; j < arrays4[i].length; j++);
        }
        for (String[] a : arrays4) { for (String i : a) { System.out.print(i + "\t"); } System.out.println("\n"); }
    }

}

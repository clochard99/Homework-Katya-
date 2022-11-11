package com.congiuntivo;

public class Essere {
    static String[][] arrays1 = new String[6][4];
    public static void main(String[] args) {
        System.out.println("Let's look at the verb \"to be\" in Italian.\nYou can see from the left side to the right side of this 2d array Presente, Passato, Imperfetto, Trapassato.");
        arrays1[0][0] = "sia  ";
        arrays1[1][0] = "sia  ";
        arrays1[2][0] = "sia  ";
        arrays1[3][0] = "siamo";
        arrays1[4][0] = "siate";
        arrays1[5][0] = "siano";
        arrays1[0][1] = "sia stato   ";
        arrays1[1][1] = "sia stato   ";
        arrays1[2][1] = "sia stato   ";
        arrays1[3][1] = "siamo stati ";
        arrays1[4][1] = "siate stati ";
        arrays1[5][1] = "siano stati ";
        arrays1[0][2] = "fossi   ";
        arrays1[1][2] = "fossi   ";
        arrays1[2][2] = "fosse   ";
        arrays1[3][2] = "fossimo ";
        arrays1[4][2] = "foste   ";
        arrays1[5][2] = "fossero ";
        arrays1[0][3] = "fossi stato  ";
        arrays1[1][3] = "fossi stato  ";
        arrays1[2][3] = "fosse stato  ";
        arrays1[3][3] = "fossimo stati";
        arrays1[4][3] = "foste stati  ";
        arrays1[5][3] = "fossero stati";
        for (int i = 0; i < arrays1.length; i++) {
             for (int j = 0; j < arrays1[i].length; j++);
        }
        for (String[] a : arrays1) { for (String i : a) { System.out.print(i + "\t"); } System.out.println("\n"); }
    }
}

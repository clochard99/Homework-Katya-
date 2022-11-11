package com.congiuntivo;

public class Andare {
    static String[][] arrays2 = new String[6][4];

    public static void main(String[] args) {
        System.out.println("Let's look at the verb \"to fit on\" in Italian.\nYou can see from the left side to the right side of this 2d array Presente, Passato, Imperfetto, Trapassato.");
        arrays2[0][0] = "vada    ";
        arrays2[1][0] = "vada    ";
        arrays2[2][0] = "vada    ";
        arrays2[3][0] = "andiamo ";
        arrays2[4][0] = "andiate ";
        arrays2[5][0] = "vadono  ";
        arrays2[0][1] = "sia andato   ";
        arrays2[1][1] = "sia andato   ";
        arrays2[2][1] = "sia andato   ";
        arrays2[3][1] = "siamo andati ";
        arrays2[4][1] = "siate andati ";
        arrays2[5][1] = "siano andati ";
        arrays2[0][2] = "andassi   ";
        arrays2[1][2] = "andassi   ";
        arrays2[2][2] = "andasse   ";
        arrays2[3][2] = "andassimo ";
        arrays2[4][2] = "andaste   ";
        arrays2[5][2] = "andassero ";
        arrays2[0][3] = "fossi andato  ";
        arrays2[1][3] = "fossi andato  ";
        arrays2[2][3] = "fosse andato  ";
        arrays2[3][3] = "fossimo andati";
        arrays2[4][3] = "foste andati  ";
        arrays2[5][3] = "fossero andati";
        for (int i = 0; i < arrays2.length; i++) {
            for (int j = 0; j < arrays2[i].length; j++);
        }
        for (String[] a : arrays2) { for (String i : a) { System.out.print(i + "\t"); } System.out.println("\n"); }
    }

}

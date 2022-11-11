package com.congiuntivo;

public class Avere {
    static String[][] arrays = new String[6][4];

    public static void main(String[] args) {
        System.out.println("Let's look at the verb \"to have\" in Italian.\nYou can see from the left side to the right side of this 2d array Presente, Passato, Imperfetto, Trapassato.");
        arrays[0][0] = "abbia   ";
        arrays[1][0] = "abbia   ";
        arrays[2][0] = "abbia   ";
        arrays[3][0] = "abbiamo ";
        arrays[4][0] = "abbiate ";
        arrays[5][0] = "abbiano ";
        arrays[0][1] = "abbia stato   ";
        arrays[1][1] = "abbia stato   ";
        arrays[2][1] = "abbia stato   ";
        arrays[3][1] = "abbiamo stati ";
        arrays[4][1] = "abbiate stati ";
        arrays[5][1] = "abbiano stati ";
        arrays[0][2] = "avessi   ";
        arrays[1][2] = "avessi   ";
        arrays[2][2] = "avesse   ";
        arrays[3][2] = "avessimo ";
        arrays[4][2] = "aveste   ";
        arrays[5][2] = "avessero ";
        arrays[0][3] = "avessi stato  ";
        arrays[1][3] = "avessi stato  ";
        arrays[2][3] = "avesse stato  ";
        arrays[3][3] = "avessimo stati";
        arrays[4][3] = "aveste stati  ";
        arrays[5][3] = "avessero stati";
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++);
        }
        for (String[] a : arrays) { for (String i : a) { System.out.print(i + "\t"); } System.out.println("\n"); }
    }

}

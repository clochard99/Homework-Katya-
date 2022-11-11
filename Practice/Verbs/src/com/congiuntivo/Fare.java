package com.congiuntivo;

public class Fare {
    static String[][] arrays3 = new String[6][4];

    public static void main(String[] args) {
        System.out.println("Let's look at the verb \"to do\" in Italian.\nYou can see from the left side to the right side of this 2d array Presente, Passato, Imperfetto, Trapassato.");
        arrays3[0][0] = "faccia   ";
        arrays3[1][0] = "faccia   ";
        arrays3[2][0] = "faccia   ";
        arrays3[3][0] = "facciamo ";
        arrays3[4][0] = "facciate ";
        arrays3[5][0] = "facciano ";
        arrays3[0][1] = "abbia fatto   ";
        arrays3[1][1] = "abbia fatto   ";
        arrays3[2][1] = "abbia fatto   ";
        arrays3[3][1] = "abbiamo fatto ";
        arrays3[4][1] = "abbiate fatto ";
        arrays3[5][1] = "abbiano fatto ";
        arrays3[0][2] = "facessi   ";
        arrays3[1][2] = "facessi   ";
        arrays3[2][2] = "facesse   ";
        arrays3[3][2] = "facessimo ";
        arrays3[4][2] = "faceste   ";
        arrays3[5][2] = "facessero ";
        arrays3[0][3] = "avessi fatto  ";
        arrays3[1][3] = "avessi fatto  ";
        arrays3[2][3] = "avesse fatto  ";
        arrays3[3][3] = "avessimo fatto";
        arrays3[4][3] = "aveste fatto  ";
        arrays3[5][3] = "avessero fatto";
        for (int i = 0; i < arrays3.length; i++) {
            for (int j = 0; j < arrays3[i].length; j++);
        }
        for (String[] a : arrays3) { for (String i : a) { System.out.print(i + "\t"); } System.out.println("\n"); }
    }
}

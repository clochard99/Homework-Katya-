import java.util.Scanner;
public class Doc {
    public static int getFrequencyCount(String term, String doc) {
        term = term.toLowerCase(); // step 1
        doc = doc.toLowerCase(); // step 1

        int frequencyCount = 0; // step 2

        int index = doc.indexOf(term); // step 3

        while (index >= 0) { // step 4
            frequencyCount++; // step 5
            doc = doc.substring(index + term.length()); // step 6
            index = doc.indexOf(term); // step 7
        }

        return frequencyCount;
    }

    public static double termFrequency(String term, String doc) {
        int frequencyCount = getFrequencyCount(term, doc); // step 1
        int totalTermCount = doc.split(" ").length; // step 2
        System.out.println("Finding term frequency for " + term);
        System.out.println(frequencyCount);
        System.out.println(totalTermCount);

        return (double) frequencyCount/totalTermCount; // step 3
    }

    public static void main(String[] args) {
        System.out.println("Hello, enter your word");
        Scanner sc = new Scanner (System.in);
        String term = sc.nextLine();
        String doc = "Serbian language is the standardized variety of the Serbo-Croatian language mainly used by Serbs. It is the official and national language of Serbia, one of the three official languages of Bosnia and Herzegovina and co-official in Montenegro and Kosovo.It is a recognized minority language in Croatia, North Macedonia, Romania, Hungary, Slovakia, and the Czech Republic.";
        System.out.println(termFrequency(term , doc));
    }

}

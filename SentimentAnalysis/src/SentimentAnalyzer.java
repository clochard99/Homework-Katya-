import java.util.Arrays;

public class SentimentAnalyzer {
    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords, String[] negOpinionWords) {
        review = review.toLowerCase();
        int[] featureOpinions = new int[featureSet.length]; // output
        for(int i = 0; i < featureSet.length; i++) {
            String feature = "";
            for(int j = 0; j < featureSet[i].length; j++) {
                if(review.indexOf(featureSet[i][j]) != -1) {
                    feature = featureSet[i][j];
                    break;
                }
            }
            if(feature.equals("")) {
                featureOpinions[i] = 0;
            } else {
                featureOpinions[i] = getOpinionOnFeature(review, feature, posOpinionWords, negOpinionWords);
            }
        }
        return featureOpinions;
    }

    private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
        return opinion;
        // your code

    }

    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords,
                                                   String[] negOpinionWords) {
        String[] sentences = review.split("\\!");
        int opinion = 0;
        String op = "";

        if(review.indexOf(".") != -1) {
            sentences = review.split("\\.");
        }
        for(int i = 1; i < sentences.length; i++) {
            String temp = sentences[i];
            sentences[i] = temp.substring(1);
        }

        for(int i = 0; i < sentences.length; i++) {
            int index = sentences[i].indexOf(feature);
            if(index != -1) {
                op = sentences[i].substring(0,index-1);
                break;
            }
        }
        for(String str: posOpinionWords) {
            if(op.indexOf(str) != -1) {
                opinion = 1;
            }
        }
        if(opinion == 0) {
            for(String str: negOpinionWords) {
                if(op.indexOf(str) != -1) {
                    opinion = -1;
                }
            }
        }
        return opinion;
    }

    public static void main(String[] args) {
        String review = "Haven't been here in years. Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";

        //String review = "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude. The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.";


        String[][] featureSet = {
                { "ambiance", "ambience", "atmosphere", "decor" },
                { "dessert", "ice cream", "desert" },
                { "food" },
                { "soup" },
                { "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };
        String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome",
                "delicious" };
        String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };

        int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
        System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
    }
}
public class APIResponseParser2 {

    /**
     * Parses the input text and returns a Book instance containing
     * the parsed data.
     * @param response text to be parsed
     * @return Book instance containing parsed data
     */
    public static Book parse(String response) {
        Book book = new Book();
        String endRule = "<";

        //String startRule = "<title>"; // first example
        //String startRule = "<name>"; // second example
        String startRule = "<image_url>"; // third example
        String title = parse(response, startRule, endRule);
        //book.setTitle(title); // 1
        //book.setAuthor(title); //2
        book.setImageUrl(title); //3
        //System.out.println(book.getTitle()); //1
        //System.out.println(book.getAuthor()); //2
        System.out.println(book.getImageUrl()); //3


        // Your code
        return book;
    }

    // write overloaded parse method with the 3 parameters response, startRule, endRule
    public static String parse(String response, String startRule, String endRule) {
        if (response.contains(startRule)) {

            int startIndex = response.indexOf(startRule) + startRule.length();
            int endIndex = response.indexOf(endRule, startIndex);
            return response.substring(startIndex,endIndex);

        }
            return null;
    }

    public static void main(String[] args) {
        String response = "<work>" +
                "<id type=\"integer\">2361393</id>" +
                "<books_count type=\"integer\">813</books_count>" +
                "<ratings_count type=\"integer\">1,16,315</ratings_count>" +
                "<text_reviews_count type=\"integer\">3439</text_reviews_count>" +
                "<original_publication_year type=\"integer\">1854</original_publication_year>" +
                "<original_publication_month type=\"integer\" nil=\"true\"/>" +
                "<original_publication_day type=\"integer\" nil=\"true\"/>" +
                "<average_rating>3.79</average_rating>" +
                "<best_book type=\"Book\">" +
                "<id type=\"integer\">16902</id>" +
                "<title>Walden</title>" +
                "<author>" +
                "<id type=\"integer\">10264</id>" +
                "<name>Henry David Thoreau</name>" +
                "</author>" +
                "<image_url>" +
                "http://images.gr-assets.com/books/1465675526m/16902.jpg" +
                "</image_url>" +
                "<small_image_url>" +
                "http://images.gr-assets.com/books/1465675526s/16902.jpg" +
                "</small_image_url>" +
                "</best_book>" +
                "</work>";

        APIResponseParser2.parse(response);
    }
}
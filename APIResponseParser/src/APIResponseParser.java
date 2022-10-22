import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.util.List;

public class APIResponseParser {
    public static void main (String[] args) throws IOException, JDOMException {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document doc = saxBuilder.build("C:\\Test1\\Homework-Katya-\\data.xml");
        System.out.println(doc.getRootElement().getName());
        System.out.println(doc.getContentSize());

        List <Content> listElements = doc.getRootElement().getContent();
        System.out.println(listElements.stream().toList());
    }

}

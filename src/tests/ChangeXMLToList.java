package tests;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ChangeXMLToList {
 
public static void main(String arg[]) throws Exception{
    String xmlRecords = 
            "<root>"
            + "<Tag>Tung</Tag>"
            + "<Tag>Binh</Tag>"
            + "<Tag>Lan</Tag>"
            + "<Tag>Tuan</Tag>"
            + "</root>";
    
    DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    InputSource is = new InputSource();
    is.setCharacterStream(new StringReader(xmlRecords));

    Document doc = db.parse(is);
    NodeList nodes = doc.getElementsByTagName("Tag");
    System.out.println(nodes.getLength());
    List<String> valueList = new ArrayList<String>();
    for (int i = 0; i < nodes.getLength(); i++) {
      Element element = (Element) nodes.item(i);
      String name = element.getTextContent();
      System.out.println("Name: " + name);
      valueList.add(name);
    }
  }
}


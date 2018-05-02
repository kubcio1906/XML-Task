package main.java.m;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;



    public class XMLExample {
        public static void xmlTest(){
            try {
                File fXmlFile = new File("src/main/java/m/exemple.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fXmlFile);
                //optional, but recommended
                //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
                doc.getDocumentElement().normalize();
                NodeList nList = doc.getElementsByTagName("car");

                Node car1 = nList.item(1);
                System.out.println(car1);
                Element eElement = (Element) car1;
                System.out.println(eElement.getElementsByTagName("brand").item(0).getTextContent());
              //  Element engine1 = (Element) ((Element) car1).getElementsByTagName("engine");
              //  String capacity = engine1.getElementsByTagName("capacity").item(0).getTextContent();
               // System.out.println(engine1);
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
        }
    }



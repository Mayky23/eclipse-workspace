package Libros_xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class libros {

	public static void main(String[] args) throws SAXException, ParserConfigurationException, XPathExpressionException, IOException {
	    try {
	        // Ruta del archivo XML que deseas analizar
	        File rutaxml = new File(System.getProperty("user.dir") + "\\src\\Libros_xml\\book.xml");

	        // Configura el parser XML
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

	        // Parsea el archivo XML (ruta)
	        Document doc = dBuilder.parse(rutaxml);
	        doc.getDocumentElement().normalize();

	        //  el XPath
	        XPath xPath = XPathFactory.newInstance().newXPath();

	        // Define la expresión XPath para seleccionar nodos de libros en la biblioteca
	        String expression = "/library/book";

	        // Evalúa la expresión XPath en el documento XML y obtiene un NodeList
	        NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

	        // Itera a través de los nodos de libros
	        for (int i = 0; i < nodeList.getLength(); i++) {
	            Node nNode = nodeList.item(i);

	            // Imprime el nombre de la etiqueta base
	            System.out.println("\n Etiqueta base: " + nNode.getNodeName());

	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	                // Comprueba si el nodo es un elemento XML (etiqueta)
	                Element eElement = (Element) nNode; // Convierte el nodo en un elemento
	                // Accede a las etiquetas hijas para obtener información del libro
	            

	                // Imprime información del libro
	                System.out.println("- Libro " + (i + 1) + " :"); // sumamos al contador
	                System.out.println("- Título : " + eElement.getElementsByTagName("title").item(0).getTextContent()); //buscar por etiqueta
	                System.out.println("- Autor : " + eElement.getElementsByTagName("author").item(0).getTextContent());
	                System.out.println("- Año : " + eElement.getElementsByTagName("year").item(0).getTextContent());
	                System.out.println("- Género : " + eElement.getElementsByTagName("genre").item(0).getTextContent());
	                System.out.println("-----------------------------------------------------");
	            }
	        }
	    } catch (ParserConfigurationException e) {
	        e.printStackTrace();
	    }
	}


}

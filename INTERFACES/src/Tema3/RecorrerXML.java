package Tema3;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecorrerXML extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private NodeList departamentoList; // Declarar NodeList como un campo de clase

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RecorrerXML frame = new RecorrerXML();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public RecorrerXML() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600); // Ajustar el ancho de la ventana principal
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        setContentPane(contentPane);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        try {
            // Cargar el archivo XML
            File xmlFile = new File("C:\\Users\\AlumnoT\\eclipse-workspace\\INTERFACES\\src\\Tema3\\Tabla.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Obtener la lista de nodos del departamento
            departamentoList = doc.getElementsByTagName("departamento"); // Inicializar la NodeList

            // Recorrer la lista de departamentos
            for (int i = 0; i < departamentoList.getLength(); i++) {
                Node departamentoNode = departamentoList.item(i);
                if (departamentoNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element departamentoElement = (Element) departamentoNode;
                    String departamentoNombre = departamentoElement.getElementsByTagName("nombre").item(0).getTextContent();
                    String departamentoDescripcion = departamentoElement.getElementsByTagName("descripcion").item(0).getTextContent();

                    // Crear un panel para cada departamento
                    JPanel panel = new JPanel();
                    panel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 20, 20, 20), // Ajustar los márgenes
                            new TitledBorder(departamentoNombre)));

                    // Crear un área de texto para mostrar la descripción y los empleados
                    JTextArea textArea = new JTextArea(5, 30); // Ajustar el número de columnas en el JTextArea
                    textArea.setText("Descripción: " + departamentoDescripcion + "\n\nEmpleados:\n");

                    // Obtener la lista de nodos de empleados
                    NodeList empleadoList = departamentoElement.getElementsByTagName("empleado");

                    // Recorrer la lista de empleados
                    for (int j = 0; j < empleadoList.getLength(); j++) {
                        Node empleadoNode = empleadoList.item(j);
                        if (empleadoNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element empleadoElement = (Element) empleadoNode;
                            String empleadoNombre = empleadoElement.getElementsByTagName("nombre").item(0).getTextContent();
                            String empleadoDni = empleadoElement.getElementsByTagName("dni").item(0).getTextContent();
                            textArea.append("- Nombre: " + empleadoNombre + ", DNI: " + empleadoDni + "\n");
                        }
                    }
                    // Agregar un panel de desplazamiento para la visualización adecuada
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    panel.add(scrollPane);

                    // Crear un botón de información para mostrar la descripción del departamento
                    JButton informacionButton = new JButton("Info " + departamentoNombre); // Ajustar el texto del botón
                    informacionButton.setPreferredSize(new Dimension(120, informacionButton.getPreferredSize().height)); // Ajustar el tamaño del botón
                    informacionButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            JOptionPane.showMessageDialog(null, departamentoDescripcion, "Descripción del Departamento",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    });
                    panel.add(informacionButton);

                    // Agregar el panel del departamento al panel principal
                    contentPane.add(panel);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



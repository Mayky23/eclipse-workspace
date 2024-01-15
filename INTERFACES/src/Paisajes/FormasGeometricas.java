package Paisajes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class FormasGeometricas extends JFrame implements ActionListener {

    private JComboBox<String> formasComboBox; 
    private JPanel drawingArea; 


    public FormasGeometricas() {
        setTitle("Dibujo de Formas Geométricas"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Establecer la operación de cierre
        setLayout(new BorderLayout()); 

        // Definir las formas disponibles en el JComboBox
        String[] formas = {"--", "Triángulo", "Círculo", "Cuadrado", "Rombo", "Elipse", "Rectángulo"};

        formasComboBox = new JComboBox<>(formas); // Inicializar el JComboBox con las formas
        formasComboBox.setRenderer(new DefaultListCellRenderer() { // Personalizar el renderizado del JComboBox
        	
        	
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (index == 0) { // Hacer que la opción seleccionada aparezca en negrita
                    Font font = c.getFont();
                    Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
                    attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
                    c.setFont(font.deriveFont(attributes));
                } else {
                    c.setFont(new Font("Arial", Font.PLAIN, 12)); // Establecer la fuente regular para otras opciones
                }
                return c;
            }
        });
        formasComboBox.addActionListener(this); // Agregar un ActionListener al JComboBox

        drawingArea = new JPanel() { // Inicializar el JPanel para el área de dibujo

			private static final long serialVersionUID = -5611129349672076473L;

			@Override
         // Método para dibujar en el área de dibujo
            protected void paintComponent(Graphics g) { 
                super.paintComponent(g);
                // Dibujamos las formas seleccionadas
                String selectedForma = (String) formasComboBox.getSelectedItem();
                if (selectedForma != null && !selectedForma.equals("--")) { // Verificar si no se ha seleccionado la opción predeterminada
                    switch (selectedForma) { // Dibujar la forma seleccionada
                        case "Triángulo":
                            dibujarTriangulo(g);
                            break;
                        case "Círculo":
                            dibujarCirculo(g);
                            break;
                        case "Cuadrado":
                            dibujarCuadrado(g);
                            break;
                        case "Rombo":
                            dibujarRombo(g);
                            break;
                        case "Elipse":
                            dibujarElipse(g);
                            break;
                        case "Rectángulo":
                            dibujarRectangulo(g);
                            break;
                        default:
                            break;
                    }
                }
            }
        };

        add(formasComboBox, BorderLayout.PAGE_START); // Agregar el JComboBox en la parte superior de la ventana
        add(drawingArea, BorderLayout.CENTER); 
        setSize(300, 300); 
        setVisible(true); // Hacer visible la ventana
    }

    // Métodos para dibujar formas geométricas específicas

    private void dibujarTriangulo(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillPolygon(new int[]{150, 75, 225}, new int[]{150, 225, 225}, 3);
    }

    private void dibujarCirculo(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(75, 75, 150, 150);
    }

    private void dibujarCuadrado(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(75, 75, 150, 150);
    }

    private void dibujarRombo(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillPolygon(new int[]{150, 75, 150, 225}, new int[]{75, 150, 225, 150}, 4);
    }

    private void dibujarElipse(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillOval(75, 75, 200, 150);
    }

    private void dibujarRectangulo(Graphics g) {
        g.setColor(Color.PINK);
        g.fillRect(75, 75, 200, 150);
    }

    // Acción al seleccionar una opción en el JComboBox
    @Override
    public void actionPerformed(ActionEvent e) {
        drawingArea.repaint(); // Volver a pintar el área de dibujo
    }

    
    public static void main(String[] args) {
        new FormasGeometricas(); 
    }
}

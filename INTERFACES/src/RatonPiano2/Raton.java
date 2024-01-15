package RatonPiano2; 

import java.awt.Color; 
import java.awt.EventQueue; 
import java.awt.Graphics; 
import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.border.EmptyBorder; 
import javax.swing.JLabel; 
import javax.swing.JComboBox; 
import javax.swing.DefaultComboBoxModel; 
import javax.swing.JSpinner; 
import javax.swing.SpinnerNumberModel; 
import java.awt.event.ItemListener; 
import java.awt.event.ItemEvent; 
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent; 
import javax.swing.JProgressBar; 
import java.awt.Font;

public class Raton extends JFrame {

    // Atributos de la clase
    private static final long serialVersionUID = 4245468765612304746L;
    private JPanel contentPane;
    private JComboBox<Object> combo1;
    private JSpinner spinner1;

    // Constructor de la clase Raton
    public Raton() {
        setTitle("CONFIGURA TU RATÓN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setBounds(100, 100, 457, 329); 
        contentPane = new JPanel(); 
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.LIGHT_GRAY);
        setContentPane(contentPane); 
        contentPane.setLayout(null);
        
        // Crear y configurar  los componentes de la interfaz gráfica.
        JLabel label1 = new JLabel("Mouse Speed");
        label1.setBounds(63, 31, 78, 16);
        contentPane.add(label1);

        JLabel label2 = new JLabel("Main mouse click");
        label2.setBounds(274, 31, 117, 16);
        contentPane.add(label2);

        combo1 = new JComboBox<Object>();
        combo1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                repaint(); // Vuelve a pintar cuando cambia el estado del JComboBox.
            }
        });
        combo1.setModel(new DefaultComboBoxModel<Object>(new String[] { "Left", "Right" }));
        combo1.setBounds(249, 61, 142, 27);
        contentPane.add(combo1);

        JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setToolTipText("hola");
        progressBar.setForeground(new Color(0, 128, 0));
        progressBar.setBackground(new Color(169, 169, 169));
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 15));
        progressBar.setBounds(22, 121, 162, 35);
        contentPane.add(progressBar);

        spinner1 = new JSpinner();
        spinner1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
            	
                // Cambia el color de la barra de progreso en función del valor seleccionado en el JSpinner.
                int valorSeleccionado = (int) spinner1.getValue();
                if (valorSeleccionado == 0) {
                    progressBar.setValue(0);
                } else if (valorSeleccionado == 25) {
                    progressBar.setValue(25);
                    progressBar.setForeground(new Color(178, 34, 34));
                } else if (valorSeleccionado == 50) {
                    progressBar.setValue(50);
                    progressBar.setForeground(new Color(255, 140, 0));
                } else if (valorSeleccionado == 75) {
                    progressBar.setValue(75);
                    progressBar.setForeground(new Color(218, 165, 32));
                } else if (valorSeleccionado == 100) {
                    progressBar.setValue(100);
                    progressBar.setForeground(new Color(0, 128, 0));
                }
            }
        });
        spinner1.setModel(new SpinnerNumberModel(0, 0, 100, 25));
        spinner1.setBounds(38, 61, 123, 26);
        contentPane.add(spinner1);

    }

    // Método paint que sobrescribe el método paint de la clase padre
    public void paint(Graphics g) {
        super.paint(g); // Llama al método paint de la clase padre para realizar la pintura por defecto
        g.setColor(Color.BLACK);
        g.drawRect(274, 148, 121, 61); // Dibuja un rectángulo

        // Cambia el color y la posición del dibujo en función segun el valor del JComboBox.
        if (combo1.getSelectedItem().toString().equals("Left")) {
            g.setColor(Color.BLACK);
            g.fillRect(275, 149, 60, 60);
            g.setColor(Color.red);
            g.fillOval(275, 149, 59, 59);
        } else {
            g.setColor(Color.BLACK);
            g.fillRect(335, 149, 60, 60);
            g.setColor(Color.GREEN);
            g.fillOval(335, 149, 60, 60);
        }
    }
    
 // Método main 
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Raton frame = new Raton(); // Crea una nueva instancia de la clase Raton.
                    frame.setVisible(true); // Hace que la ventana sea visible.
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

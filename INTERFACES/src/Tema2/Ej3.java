package Tema2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Ej3 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtBase;
    private JTextField txtAltura;
    private JLabel lblResultado;

    private double resultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ej3 frame = new Ej3();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Ej3() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblBase = new JLabel("Base:");
        lblBase.setBounds(30, 30, 50, 20);
        contentPane.add(lblBase);

        txtBase = new JTextField();
        txtBase.setBounds(90, 30, 100, 20);
        contentPane.add(txtBase);
        txtBase.setColumns(10);

        JLabel lblAltura = new JLabel("Altura:");
        lblAltura.setBounds(30, 60, 50, 20);
        contentPane.add(lblAltura);

        txtAltura = new JTextField();
        txtAltura.setBounds(90, 60, 100, 20);
        contentPane.add(txtAltura);
        txtAltura.setColumns(10);

        lblResultado = new JLabel("Resultado: ");
        lblResultado.setBounds(217, 30, 250, 20);
        contentPane.add(lblResultado);

        JButton btnCalcularTriangulo = new JButton("Triángulo");
        btnCalcularTriangulo.setBounds(169, 192, 123, 58);
        contentPane.add(btnCalcularTriangulo);

        JButton btnCalcularRectangulo = new JButton("Rectángulo");
        btnCalcularRectangulo.setBounds(30, 192, 123, 58);
        contentPane.add(btnCalcularRectangulo);

        btnCalcularTriangulo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularAreaTriangulo();
            }
        });

        btnCalcularRectangulo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularAreaRectangulo();
            }
        });
    }

    private void calcularAreaTriangulo() {
        try {
        	 // Obtiene el valor de la base ingresada por el usuario y lo convierte a un número decimal.
            double base = Double.parseDouble(txtBase.getText());
            double altura = Double.parseDouble(txtAltura.getText());
            resultado = (base * altura) / 2;
            lblResultado.setText("Área del Triángulo: " + resultado + "\n");
         // resultado.append( "Área del Triángulo: " + resultado + "\n"); no lo detecta 
        } catch (NumberFormatException e) {
            lblResultado.setText("Ingrese números válidos en Base y Altura.");
            
        }
    }

    private void calcularAreaRectangulo() {
        try {
        	 // Obtiene el valor de la base ingresada por el usuario y lo convierte a un número decimal.
            double base = Double.parseDouble(txtBase.getText());
            double altura = Double.parseDouble(txtAltura.getText());
            resultado = base * altura;
            lblResultado.setText("Área del Rectángulo: " + resultado + "\n");
         // resultado.append( "Área del Rectángulo: " + resultado + "\n"); no lo detecta 
        } catch (NumberFormatException ex) {
            lblResultado.setText("Ingrese números válidos en Base y Altura.");
        }
    }
}


package ConvertirDivisas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ConvertirDivisas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCantidad;
    private JComboBox<String> cmbMonedaOrigen;
    private JComboBox<String> cmbMonedaDestino;
    private JLabel lblResultado;

    private double tasaEuroDolar = 1.18;
    private double tasaEuroYen = 130.5;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ConvertirDivisas frame = new ConvertirDivisas();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ConvertirDivisas() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 390, 305);
        contentPane = new JPanel();
        contentPane.setBackground(Color.MAGENTA);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPregunta = new JLabel("¿A qué país viajas?");
        lblPregunta.setFont(new Font("Arial", Font.BOLD, 14));
        lblPregunta.setBounds(38, 10, 200, 20);
        contentPane.add(lblPregunta);

        JButton btnMarruecos = new JButton("Marruecos");
        btnMarruecos.setFont(new Font("Arial", Font.BOLD, 12));
        btnMarruecos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirConversor("Marruecos");
            }
        });
        btnMarruecos.setBounds(38, 40, 120, 23);
        contentPane.add(btnMarruecos);

        JButton btnChina = new JButton("China");
        btnChina.setFont(new Font("Arial", Font.BOLD, 12));
        btnChina.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirConversor("China");
            }
        });
        btnChina.setBounds(38, 70, 120, 23);
        contentPane.add(btnChina);

        JButton btnEEUU = new JButton("EEUU");
        btnEEUU.setFont(new Font("Arial", Font.BOLD, 12));
        btnEEUU.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirConversor("EEUU");
            }
        });
        btnEEUU.setBounds(38, 100, 120, 23);
        contentPane.add(btnEEUU);
    }

    private void abrirConversor(String pais) {
        ConversorDivisas conversor = new ConversorDivisas();
        conversor.setVisible(true);
    }
}

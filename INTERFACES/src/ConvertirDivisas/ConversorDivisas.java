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

public class ConversorDivisas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCantidad;
    private JComboBox<String> cmbMonedaDestino;
    private JLabel lblResultado;

    private double tasaEuroDolar = 1.18;
    private double tasaEuroYen = 130.5;
    private double tasaEuroDirham = 10.90; // Tasa de cambio de Euro a Dirham

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ConversorDivisas frame = new ConversorDivisas();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ConversorDivisas() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 390, 305);
        contentPane = new JPanel();
        contentPane.setBackground(Color.MAGENTA);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPregunta = new JLabel("Elige la moneda que desea convertir a Euros");
        lblPregunta.setFont(new Font("Arial", Font.BOLD, 14));
        lblPregunta.setBounds(38, 10, 326, 20);
        contentPane.add(lblPregunta);

        cmbMonedaDestino = new JComboBox<String>(new String[] { "--", "Dólares", "Yenes", "Dirhams" });
        cmbMonedaDestino.setFont(new Font("Arial", Font.BOLD, 12));
        cmbMonedaDestino.setBounds(38, 40, 120, 23);
        contentPane.add(cmbMonedaDestino);

        JLabel lblCantidad = new JLabel("Cantidad en Euros:");
        lblCantidad.setFont(new Font("Arial", Font.BOLD, 12));
        lblCantidad.setBounds(38, 80, 120, 20);
        contentPane.add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(172, 80, 100, 20);
        contentPane.add(txtCantidad);
        txtCantidad.setColumns(10);

        JButton btnConvertir = new JButton("Convertir");
        btnConvertir.setBackground(new Color(147, 112, 219));
        btnConvertir.setFont(new Font("Arial", Font.BOLD, 12));
        btnConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertirDivisa();
            }
        });
        btnConvertir.setBounds(38, 120, 100, 23);
        contentPane.add(btnConvertir);

        lblResultado = new JLabel("");
        lblResultado.setFont(new Font("Arial", Font.BOLD, 12));
        lblResultado.setBounds(38, 160, 326, 20);
        contentPane.add(lblResultado);
        
        JLabel lblContactarConLa = new JLabel("Contactar con la casa de moneda");
        lblContactarConLa.setFont(new Font("Arial", Font.BOLD, 12));
        lblContactarConLa.setBounds(38, 182, 234, 20);
        contentPane.add(lblContactarConLa);
        
        JButton btnLlamar = new JButton("LLAMAR");
        btnLlamar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnLlamar.setFont(new Font("Arial", Font.BOLD, 12));
        btnLlamar.setBackground(new Color(147, 112, 219));
        btnLlamar.setBounds(38, 213, 100, 23);
        contentPane.add(btnLlamar);
    }

    private void convertirDivisa() {
        double cantidad = Double.parseDouble(txtCantidad.getText());
        double resultado = 0.0;

        switch (cmbMonedaDestino.getSelectedIndex()) {
            case 0: // Euros
                resultado = cantidad;
                break;
            case 1: // Dólares
                resultado = cantidad * tasaEuroDolar;
                break;
            case 2: // Yenes
                resultado = cantidad * tasaEuroYen;
                break;
            case 3: // Dirhams
                resultado = cantidad * tasaEuroDirham;
                break;
        }

        lblResultado.setText("Resultado: " + resultado + " " + cmbMonedaDestino.getSelectedItem());
    }
}

package ConvertirDivisas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;

public class ConvertirDivisas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCantidad;
    private JComboBox<String> cmbMonedaOrigen;
    private JComboBox<String> cmbMonedaDestino;
    private JLabel lblResultado;

    private double tasaEuroDolar = 1.18; // Tasa de cambio Euro a Dólar
    private double tasaEuroYen = 130.5; // Tasa de cambio Euro a Yen

    /**
     * Launch the application.
     */
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

    /**
     * Create the frame.
     */
    public ConvertirDivisas() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 390, 305);
        contentPane = new JPanel();
        contentPane.setBackground(Color.MAGENTA);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        cmbMonedaOrigen = new JComboBox<String>(new String[] { "Euros", "Dólares", "Yenes" });
        cmbMonedaOrigen.setFont(new Font("Arial", Font.BOLD, 12));
        cmbMonedaOrigen.setBounds(38, 36, 120, 20);
        contentPane.add(cmbMonedaOrigen);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(38, 77, 120, 20);
        contentPane.add(txtCantidad);
        txtCantidad.setColumns(10);

        cmbMonedaDestino = new JComboBox<String>(new String[] { "Euros", "Dólares", "Yenes" });
        cmbMonedaDestino.setFont(new Font("Arial", Font.BOLD, 12));
        cmbMonedaDestino.setBounds(38, 123, 120, 20);
        contentPane.add(cmbMonedaDestino);

        JButton btnConvertir = new JButton("Convertir");
        btnConvertir.setBackground(new Color(147, 112, 219));
        btnConvertir.setFont(new Font("Arial", Font.BOLD, 12));
        btnConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertirDivisa();
            }
        });
        btnConvertir.setBounds(38, 169, 120, 23);
        contentPane.add(btnConvertir);

        lblResultado = new JLabel("Resultado:");
        lblResultado.setFont(new Font("Arial Black", Font.BOLD, 12));
        lblResultado.setBounds(38, 213, 326, 42);
        contentPane.add(lblResultado);
    }

    private void convertirDivisa() {

            int cantidad = Integer.parseInt(txtCantidad.getText());

            // Convertir de la moneda de origen a euros
            int cantidadEnEuros = (int) convertirAEuros(cantidad, cmbMonedaOrigen.getSelectedIndex());

            // Convertir de euros a la moneda de destino
            int resultado = (int) convertirDesdeEuros(cantidadEnEuros, cmbMonedaDestino.getSelectedIndex());

            lblResultado.setText("Resultado: " + resultado);
      
    }


    private double convertirAEuros(double cantidad, int indiceMonedaOrigen) {
        switch (indiceMonedaOrigen) {
            case 0: // Euros
                return cantidad;
            case 1: // Dólares
                return cantidad / tasaEuroDolar;
            case 2: // Yenes
                return cantidad / tasaEuroYen;
            default:
                return 0;
        }
    }

    private double convertirDesdeEuros(double cantidadEnEuros, int indiceMonedaDestino) {
        switch (indiceMonedaDestino) {
            case 0: // Euros
                return cantidadEnEuros;
            case 1: // Dólares
                return cantidadEnEuros * tasaEuroDolar;
            case 2: // Yenes
                return cantidadEnEuros * tasaEuroYen;
            default:
                return 0;
        }
    }
}

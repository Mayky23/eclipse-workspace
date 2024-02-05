package ServerPeliculas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ClienteLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfHostname, tfPuerto;
    private JButton btnConectar;

    public ClienteLogin() {
        setTitle("Cliente - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridLayout(4, 2));

        tfHostname = new JTextField();
        btnConectar = new JButton("Conectar");
        btnConectar.setBackground(Color.GREEN);
        btnConectar.setFont(new Font("Arial Black", Font.BOLD, 14));

        JLabel label_1 = new JLabel("Hostname:");
        label_1.setFont(new Font("Arial Black", Font.BOLD, 14));
        getContentPane().add(label_1);
        getContentPane().add(tfHostname);
        JLabel label = new JLabel("Puerto:");
        label.setFont(new Font("Arial Black", Font.BOLD, 14));
        getContentPane().add(label);
        tfPuerto = new JTextField();
        getContentPane().add(tfPuerto);
        getContentPane().add(new JLabel("")); // Espacio en blanco para ajustar el diseño
        getContentPane().add(btnConectar);

        btnConectar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conectar();
            }
        });

        pack();
        setSize(400, 200); // Tamaño predeterminado de la ventana
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void conectar() {
        String hostname = tfHostname.getText();
        int puerto = Integer.parseInt(tfPuerto.getText());
        try {
            Socket cliente = new Socket(hostname, puerto);
            System.out.println("Conexión exitosa.");
            dispose(); // Cerrar la ventana de login
            new ClienteDatosPeli(cliente);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar al servidor.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new ClienteLogin();
    }
}

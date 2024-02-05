package ServerPeliculas;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ClienteDatosPeli extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfNombre, tfAnio, tfDuracion, tfNota;
    private JButton btnEnviar;
    private ObjectOutputStream salida;
    private Socket cliente;
    
    String nombre_pelicula; 
    int año_pelicula, duracion_minutos, nota;

    public ClienteDatosPeli(Socket cliente) {
        this.cliente = cliente;

        setTitle("Cliente - Datos Película");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridLayout(5, 2));

        tfNombre = new JTextField();
        tfAnio = new JTextField();
        tfDuracion = new JTextField();
        tfNota = new JTextField();
        btnEnviar = new JButton("Enviar");
        btnEnviar.setBackground(Color.GREEN);
        btnEnviar.setFont(new Font("Arial Black", Font.BOLD, 14));

        JLabel label = new JLabel("Nombre de la película:");
        label.setFont(new Font("Arial Black", Font.BOLD, 14));
        getContentPane().add(label);
        getContentPane().add(tfNombre);
        JLabel label_1 = new JLabel("Año de lanzamiento:");
        label_1.setFont(new Font("Arial Black", Font.BOLD, 14));
        getContentPane().add(label_1);
        getContentPane().add(tfAnio);
        JLabel label_2 = new JLabel("Duración en minutos:");
        label_2.setFont(new Font("Arial Black", Font.BOLD, 14));
        getContentPane().add(label_2);
        getContentPane().add(tfDuracion);
        JLabel label_3 = new JLabel("Nota (1 al 10):");
        label_3.setFont(new Font("Arial Black", Font.BOLD, 14));
        getContentPane().add(label_3);
        getContentPane().add(tfNota);
        getContentPane().add(btnEnviar);

        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                enviarPelicula();
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void enviarPelicula() {
    	  Pelicula pelicula = new Pelicula();
    	  nombre_pelicula = tfNombre.getText();
    	  pelicula.setNombre(nombre_pelicula);
        try {
            salida = new ObjectOutputStream(cliente.getOutputStream());
            try {
            	año_pelicula = Integer.parseInt(tfAnio.getText());
            	duracion_minutos = Integer.parseInt(tfDuracion.getText());
            	nota = Integer.parseInt(tfNota.getText());
            	
            	if (año_pelicula > 0 && duracion_minutos >=20 && (nota > 0 || nota < 10) ) {
            		pelicula.setAnio(año_pelicula);
            		pelicula.setDuracion(duracion_minutos);
            		pelicula.setNota(nota);
            		salida.writeObject(pelicula);
            	} else {
            	pelicula.setNombre("La pelicula insertada no existe, te joés, perrón.");
            	}
            	
            
                System.out.println("Pelicula enviada: " + pelicula);
                JOptionPane.showMessageDialog(this, "Película enviada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
            } catch (NumberFormatException nfe) {
            	JOptionPane.showMessageDialog(this,  "Por favor, inserte valores válidos para el año de lanzamiento,"
            			+ "duración y la nota", "Datos inválidos" , JOptionPane.INFORMATION_MESSAGE);
            }
         
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al enviar la película.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        tfNombre.setText("");
        tfAnio.setText("");
        tfDuracion.setText("");
        tfNota.setText("");
    }
}

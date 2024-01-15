package Tema2_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Ej3 extends JFrame {

    private static final long serialVersionUID = 1L;

    public Ej3() {
        setTitle("VENTA DE ENTRADAS");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        
        JPanel panel_base = new JPanel();
        panel_base.setBounds(0, 0, 784, 561);
        getContentPane().add(panel_base);
        panel_base.setLayout(null);
        
        JPanel panel_escenario = new JPanel();
        panel_escenario.setBackground(new Color(222, 184, 135));
        panel_escenario.setBounds(0, 399, 784, 162);
        panel_base.add(panel_escenario);
        panel_escenario.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("ESCENARIO");
        lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblNewLabel.setBounds(331, 93, 169, 28);
        panel_escenario.add(lblNewLabel);
        
        JPanel panel_grada = new JPanel();
        panel_grada.setBounds(0, 0, 784, 320);
        panel_base.add(panel_grada);
        panel_grada.setLayout(new GridLayout(5, 3, 6, 6));
        
        JButton btn_asiento_13 = new JButton("13");
        btn_asiento_13.setFont(new Font("Arial Black", Font.PLAIN, 20));
        panel_grada.add(btn_asiento_13);
        
        JButton btn_asiento_14 = new JButton("14");
        btn_asiento_14.setFont(new Font("Arial Black", Font.PLAIN, 20));
        panel_grada.add(btn_asiento_14);
        
        JButton btn_asiento_15 = new JButton("15");
        btn_asiento_15.setFont(new Font("Arial Black", Font.PLAIN, 20));
        panel_grada.add(btn_asiento_15);
        
        JButton btn_asiento_10 = new JButton("10");
        btn_asiento_10.setFont(new Font("Arial Black", Font.PLAIN, 20));
        panel_grada.add(btn_asiento_10);
        
        JButton btn_asiento_11 = new JButton("11");
        btn_asiento_11.setFont(new Font("Arial Black", Font.PLAIN, 20));
        btn_asiento_11.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        panel_grada.add(btn_asiento_11);
        
        JButton btn_asiento_12 = new JButton("12");
        btn_asiento_12.setFont(new Font("Arial Black", Font.PLAIN, 20));
        panel_grada.add(btn_asiento_12);
        
        JButton btn_asiento_7 = new JButton("7");
        btn_asiento_7.setFont(new Font("Arial Black", Font.PLAIN, 20));
        panel_grada.add(btn_asiento_7);
        
        JButton btn_asiento_8 = new JButton("8");
        btn_asiento_8.setFont(new Font("Arial Black", Font.PLAIN, 20));
        panel_grada.add(btn_asiento_8);
        
        JButton btn_asiento_9 = new JButton("9");
        btn_asiento_9.setFont(new Font("Arial Black", Font.PLAIN, 20));
        panel_grada.add(btn_asiento_9);
        
        JButton btn_asiento_4 = new JButton("4");
        btn_asiento_4.setFont(new Font("Arial Black", Font.PLAIN, 20));
        panel_grada.add(btn_asiento_4);
        
        JButton btn_asiento_5 = new JButton("5");
        btn_asiento_5.setFont(new Font("Arial Black", Font.PLAIN, 20));
        panel_grada.add(btn_asiento_5);
        
        JButton btn_asiento_6 = new JButton("6");
        btn_asiento_6.setFont(new Font("Arial Black", Font.PLAIN, 20));
        panel_grada.add(btn_asiento_6);
        
        JButton btn_asiento_1 = new JButton("1");
        btn_asiento_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btn_asiento_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
        panel_grada.add(btn_asiento_1);
        
        JButton btn_asiento_2 = new JButton("2");
        btn_asiento_2.setFont(new Font("Arial Black", Font.PLAIN, 20));
        panel_grada.add(btn_asiento_2);
        
        JButton btn_asiento_3 = new JButton("3");
        btn_asiento_3.setFont(new Font("Arial Black", Font.PLAIN, 20));
        panel_grada.add(btn_asiento_3);
        
        JPanel panel_vip = new JPanel();
        panel_vip.setBounds(-2, 320, 785, 81);
        panel_base.add(panel_vip);
        panel_vip.setLayout(null);
        
        JButton btn_vip = new JButton("VIP");
        btn_vip.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		grada_vip vips = new grada_vip();
        		vips.setVisible(true);
        	
        		
        	}
        });
        btn_vip.setFont(new Font("Arial Black", Font.PLAIN, 25));
        btn_vip.setBackground(new Color(255, 255, 0));
        btn_vip.setBounds(2, 5, 782, 67);
        panel_vip.add(btn_vip);
        
        
        
     // Creación de un array que almacena los botones de asiento
        JButton[] botones = new JButton[] {
            btn_asiento_1, btn_asiento_2, btn_asiento_3,
            btn_asiento_4, btn_asiento_5, btn_asiento_6,
            btn_asiento_7, btn_asiento_8, btn_asiento_9,
            btn_asiento_10, btn_asiento_11, btn_asiento_12,
            btn_asiento_13, btn_asiento_14, btn_asiento_15
        };

        // Creación de un generador de números aleatorios
        Random random = new Random();

        // Recorrido de los botones para configurar sus propiedades
        for (JButton boton : botones) {
            // Establece la fuente del botón
            boton.setFont(new Font("Arial Black", Font.PLAIN, 20));

            // Establece aleatoriamente el color de fondo (rojo o verde)
            Color colorFondo = random.nextBoolean() ? Color.GREEN : Color.RED;
            boton.setBackground(colorFondo);

            // Agrega un ActionListener para manejar los clics en el botón
            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (boton.getBackground() == Color.GREEN) {
                        // Si el asiento es verde, se reserva (cambia a naranja)
                        boton.setBackground(Color.ORANGE);
                        JOptionPane.showMessageDialog(null, "El asiento número " + boton.getText() + " se ha reservado correctamente.");
                    } else {
                        // Si el asiento es rojo, ya está reservado
                        JOptionPane.showMessageDialog(null, "Este asiento ya está reservado.");
                    }
                }
            });

            // Agrega el botón al panel de grada
            panel_grada.add(boton);
        }

      }
    

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Ej3 frame = new Ej3();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

package Tema2_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class grada_vip extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();

    public static void main(String[] args) {
        try {
            grada_vip dialog = new grada_vip();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public grada_vip() {
    	
    	initComponets();
    	
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JPanel panel_base = new JPanel();
        panel_base.setBounds(0, 0, 434, 228);
        contentPanel.add(panel_base);
        panel_base.setLayout(null);

        JButton vip_1 = new JButton("1");
        vip_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        vip_1.setFont(new Font("Arial Black", Font.PLAIN, 25));
        vip_1.setBounds(10, 11, 135, 206);
        panel_base.add(vip_1);

        JButton vip_2 = new JButton("2");
        vip_2.setFont(new Font("Arial Black", Font.PLAIN, 25));
        vip_2.setBounds(155, 11, 121, 206);
        panel_base.add(vip_2);

        JButton vip_3 = new JButton("3");
        vip_3.setFont(new Font("Arial Black", Font.PLAIN, 25));
        vip_3.setBounds(289, 11, 135, 206);
        panel_base.add(vip_3);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);

        // Creación de un array que almacena los botones de asiento
        JButton[] botones = new JButton[] {
            // Lista de botones para los asientos VIP
            vip_1, vip_2, vip_3
        };

        // Creación de un generador de números aleatorios
        Random random = new Random();

        // Recorrido de los botones para configurar sus propiedades
        for (JButton boton : botones) {
            // Establece la fuente del botón
            boton.setFont(new Font("Arial Black", Font.PLAIN, 25));

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
        }
    }

	private void initComponets() {
		// TODO Auto-generated method stub
		
	}
}


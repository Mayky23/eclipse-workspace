package Tema2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ej1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej1 frame = new Ej1();
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
	public Ej1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btMostrar = new JButton("MOSTRAR");
		
		btMostrar.setForeground(new Color(0, 0, 255));
		btMostrar.setBackground(Color.LIGHT_GRAY);
		btMostrar.setBounds(176, 168, 107, 41);
		contentPane.add(btMostrar);
		
		JTextArea texto = new JTextArea();
		texto.setBackground(Color.LIGHT_GRAY);
		texto.setForeground(Color.BLACK);
		texto.setBounds(40, 11, 362, 146);
		contentPane.add(texto);
		
		btMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				texto.setText("Boton Pulsado \n" + texto.getText());
			}
		});
	}
}

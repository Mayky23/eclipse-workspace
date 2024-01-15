package Tema1;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("unused")
public class INTERFACES extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					INTERFACES frame = new INTERFACES();
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
	public INTERFACES() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 452, 258);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btbFinalizar = new JButton("Cerrar sesión");
		btbFinalizar.setForeground(Color.RED);
		btbFinalizar.setBounds(250, 200, 150, 30);
		panel.add(btbFinalizar);
		btbFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    dispose(); 
				
			}
		});
		btbFinalizar.setFont(new Font("Arial Black", Font.PLAIN, 9));
		btbFinalizar.setBackground(new Color(255, 0, 0));
	}

}

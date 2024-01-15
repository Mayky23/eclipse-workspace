package Tema1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ej2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej2 frame = new Ej2();
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
	public Ej2() {
		setTitle("hola frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JButton bt1 = new JButton("1");
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("1");

			}
		});
		bt1.setForeground(Color.RED);
		bt1.setFont(new Font("Arial Black", Font.PLAIN, 9));
		bt1.setBackground(Color.RED);
		bt1.setBounds(10, 11, 126, 239);
		panel.add(bt1);
		
		JButton bt2 = new JButton("2");
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("2");
			}
		});
		bt2.setForeground(Color.MAGENTA);
		bt2.setFont(new Font("Arial Black", Font.PLAIN, 9));
		bt2.setBackground(Color.MAGENTA);
		bt2.setBounds(146, 11, 141, 239);
		panel.add(bt2);
		
		JButton bt3 = new JButton("3");
		bt3.setForeground(Color.GREEN);
		bt3.setFont(new Font("Arial Black", Font.PLAIN, 9));
		bt3.setBackground(new Color(128, 255, 0));
		bt3.setBounds(298, 11, 126, 239);
		panel.add(bt3);
		
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("3");
			}
		});
	}
}

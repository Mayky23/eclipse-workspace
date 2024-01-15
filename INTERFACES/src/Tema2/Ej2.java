package Tema2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Ej2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombreAlumno;
	private JTextField nombreAsignatura;
	private JButton btnSuspender;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        nombreAlumno = new JTextField();
        nombreAlumno.setBounds(146, 31, 86, 20);
        contentPane.add(nombreAlumno);
        nombreAlumno.setColumns(10);

        nombreAsignatura = new JTextField();
        nombreAsignatura.setBounds(146, 74, 86, 20);
        nombreAsignatura.setColumns(10);
        contentPane.add(nombreAsignatura);

        JTextArea texto = new JTextArea();
        texto.setBounds(242, 11, 182, 243);
        contentPane.add(texto);

        JButton btnAprobar = new JButton("APROBAR");
        btnAprobar.setForeground(Color.WHITE);
        btnAprobar.setBackground(Color.BLUE);
        btnAprobar.setBounds(10, 149, 94, 72);
        contentPane.add(btnAprobar);

        btnSuspender = new JButton("SUSPENDER");
        btnSuspender.setBackground(Color.RED);
        btnSuspender.setForeground(Color.WHITE);
        btnSuspender.setBounds(128, 149, 104, 72);
        contentPane.add(btnSuspender);
        
        JTextPane txtNombreAlumnoa = new JTextPane();
        txtNombreAlumnoa.setText("Nombre alumno/a:");
        txtNombreAlumnoa.setBounds(10, 31, 126, 20);
        contentPane.add(txtNombreAlumnoa);
        
        JTextPane txtAsignatura = new JTextPane();
        txtAsignatura.setText("Nombre asignatura:");
        txtAsignatura.setBounds(10, 74, 126, 20);
        contentPane.add(txtAsignatura);

        btnAprobar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String alumno = nombreAlumno.getText();
                String asignatura = nombreAsignatura.getText();
                String resultado = alumno + " ha aprobado la asignatura " + asignatura + "\n";
                texto.setText(resultado);
                // resultado.append( alumno + " ha aprobado la asignatura " + asignatura + "\n"); no lo detecta 
            }; 
        });

        btnSuspender.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String alumno = nombreAlumno.getText();
                String asignatura = nombreAsignatura.getText();
                String resultado = alumno + " ha suspendido la asignatura " + asignatura + "\n";
                texto.setText(resultado);
             // resultado.append( alumno + " ha suspendido la asignatura " + asignatura + "\n"); no lo detecta 
            }
        });
    }
}

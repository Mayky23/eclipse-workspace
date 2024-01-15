package Calendario2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

public class LogInCalendario extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPasswordField passwordField_contraseña;
    private JTextField textField_user;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LogInCalendario frame = new LogInCalendario();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LogInCalendario() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 223, 286);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel_base = new JPanel();
        panel_base.setBackground(Color.LIGHT_GRAY);
        panel_base.setBounds(0, 0, 207, 247);
        contentPane.add(panel_base);
        panel_base.setLayout(null);

        JLabel Label_user = new JLabel("Usuario:");
        Label_user.setBounds(10, 66, 81, 21);
        Label_user.setFont(new Font("Arial Black", Font.PLAIN, 14));
        panel_base.add(Label_user);

        textField_user = new JTextField();
        textField_user.setBounds(79, 66, 112, 20);
        textField_user.setColumns(10);
        panel_base.add(textField_user);

        JLabel Label_contraseña = new JLabel("Contraseña:");
        Label_contraseña.setBounds(10, 92, 91, 21);
        Label_contraseña.setFont(new Font("Arial Black", Font.PLAIN, 14));
        panel_base.add(Label_contraseña);

        passwordField_contraseña = new JPasswordField();
        passwordField_contraseña.setBounds(100, 92, 91, 20);
        panel_base.add(passwordField_contraseña);

        JButton btn_inicio = new JButton("INICIO");
        btn_inicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user, pwd;
                user = textField_user.getText();
                pwd = String.copyValueOf(passwordField_contraseña.getPassword());
                if (user.equals("admin") && pwd.equals("1234")) {
                    JOptionPane.showMessageDialog(null, "Usuario y contraseña correctos... accediendo");
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario o contraseña es incorrecto");
                }
            }
        });
        btn_inicio.setBounds(10, 166, 181, 31);
        btn_inicio.setBackground(new Color(0, 255, 0));
        btn_inicio.setFont(new Font("Arial Black", Font.PLAIN, 15));
        panel_base.add(btn_inicio);

        JButton btn_salir = new JButton("SALIR");
        btn_salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Cierra la aplicación al hacer clic en "SALIR"
            }
        });
        btn_salir.setBounds(10, 211, 181, 31);
        btn_salir.setBackground(Color.RED);
        btn_salir.setFont(new Font("Arial Black", Font.PLAIN, 15));
        panel_base.add(btn_salir);
        
        JButton btn_fecha = new JButton("FECHA");
        btn_fecha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    File file = new File(getClass().getClassLoader().getResource("CALENDARIO.jar").getFile());
                    if (file.exists()) {
                        Runtime.getRuntime().exec("java -jar " + file.getAbsolutePath());
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btn_fecha.setFont(new Font("Arial Black", Font.PLAIN, 15));
        btn_fecha.setBackground(Color.ORANGE);
        btn_fecha.setBounds(10, 124, 181, 31);
        panel_base.add(btn_fecha);
    }
}



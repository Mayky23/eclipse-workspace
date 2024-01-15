package JavaHelp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.net.URL;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 4245468765612304746L;
	private JPanel contentPane;
	private JComboBox<Object> combo1;
	private JSpinner spinner1;
	
	private JMenuItem itemAyuda;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
		JButton mostrarVentanaBtn = new JButton("Mostrar Ventana Secundaria");
        mostrarVentanaBtn.setFont(new Font("Arial Black", Font.BOLD, 20));
        mostrarVentanaBtn.setBackground(new Color(0, 128, 255));
        mostrarVentanaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarNuevaVentanaSecundaria();
            }
        });
        contentPane.setLayout(new BorderLayout(0, 0));

        contentPane.add(mostrarVentanaBtn);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, -4, 441, 22);
		contentPane.add(menuBar, BorderLayout.NORTH);

		JMenu GuiaItem = new JMenu("Ayuda");
		menuBar.add(GuiaItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		itemAyuda = new JMenuItem("Guía"); // Inicializar itemAyuda como una variable de instancia
		GuiaItem.add(itemAyuda);
		
		

		
		
		
		showHelp();
		
	}

	 
	
    
    private void showHelp() {
        // Cargar el archivo de configuración de JavaHelp
        try {
            File fichero = new File("C:\\Users\\AlumnoT\\eclipse-workspace\\JavaHelp\\help\\help_set.hs");
            java.net.URL hsURL = fichero.toURI().toURL();
            HelpSet helpSet = new HelpSet(getClass().getClassLoader(), hsURL);
            HelpBroker helpBroker = helpSet.createHelpBroker();

            // Mostrar la ayuda
            helpBroker.enableHelpOnButton(itemAyuda, "aplicacion", helpSet);
            helpBroker.enableHelpKey(contentPane, "main", helpSet);

        } catch (Exception e) {
            e.printStackTrace();
        }}

 

    private void mostrarNuevaVentanaSecundaria() {
        // Crear y mostrar una nueva instancia de VentanaSecundaria como ventana emergente
        JOptionPane.showMessageDialog(this, new VentanaSecundaria(), "Ventana Secundaria", JOptionPane.PLAIN_MESSAGE);
    }
}
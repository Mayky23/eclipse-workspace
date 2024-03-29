package RatonPiano2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfugue.player.Player;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class PianoGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = -3140891473828099958L;
	
	private Player player;
    private JButton buttonDo, buttonRe, buttonMi, buttonFa, buttonSol, buttonLa, buttonSi;
    private JPanel panel_imagen; 
    private JLabel tapaPiano;

    public PianoGUI() {
        player = new Player(); // Inicialización del reproductor
        
        // Generar botones
        buttonDo = new JButton("Do"); 
        buttonRe = new JButton("Re"); 
        buttonMi = new JButton("Mi");
        buttonFa = new JButton("Fa"); 
        buttonSol = new JButton("Sol"); 
        buttonLa = new JButton("La"); 
        buttonSi = new JButton("Si"); 

        // Añadir  ActionListener a los botones 
        buttonDo.addActionListener(this); 
        buttonRe.addActionListener(this); 
        buttonMi.addActionListener(this);
        buttonFa.addActionListener(this); 
        buttonSol.addActionListener(this); 
        buttonLa.addActionListener(this); 
        buttonSi.addActionListener(this); 
        getContentPane().setLayout(new GridLayout(2, 1, 0, 0)); 

        panel_imagen = new JPanel();
        getContentPane().add(panel_imagen); 
        panel_imagen.setLayout(new GridLayout(1, 1, 0, 0));

        tapaPiano = new JLabel("");
        tapaPiano.setIcon(new ImageIcon("C:\\Users\\AlumnoT\\eclipse-workspace\\INTERFACES\\src\\RatonPiano2\\tapapiano.jpg")); // Establecer la imagen del piano
        tapaPiano.setHorizontalAlignment(SwingConstants.CENTER); 
        panel_imagen.add(tapaPiano); 

        JPanel panel = new JPanel(); 
        panel.setLayout(new GridLayout(0, 7, 0, 0)); 
        
        // Agregar botones al panel
        panel.add(buttonDo);
        panel.add(buttonRe); 
        panel.add(buttonMi);
        panel.add(buttonFa);
        panel.add(buttonSol); 
        panel.add(buttonLa);
        panel.add(buttonSi); 

        getContentPane().add(panel);
        this.setSize(386, 248);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setTitle("Piano"); 
        this.setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	
        // Acciones correspondientes a cada botón
        if (e.getSource() == buttonDo) {
            player.play("C");   
        } else if (e.getSource() == buttonRe) {
            player.play("D"); 
        } else if (e.getSource() == buttonMi) {
            player.play("E"); 
        } else if (e.getSource() == buttonFa) {
            player.play("F"); 
        } else if (e.getSource() == buttonSol) {
            player.play("G"); 
        } else if (e.getSource() == buttonLa) {
            player.play("A");
        } else if (e.getSource() == buttonSi) {
            player.play("B");
        }
    }

    public static void main(String[] args) {
        new PianoGUI(); // Crear una instancia del piano
    }
}
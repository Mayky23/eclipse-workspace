package JavaHelp;

import javax.swing.*;
import java.awt.*;

public class VentanaSecundaria extends JPanel {

    private static final long serialVersionUID = 1L;

    public VentanaSecundaria() {
        setLayout(new BorderLayout());

        JLabel etiquetaDescripcion = new JLabel("Descripción: ");
        add(etiquetaDescripcion, BorderLayout.NORTH);

        JTextField txtBienvenido = new JTextField("Bienvenido a la ventana de ayuda");
        add(txtBienvenido, BorderLayout.CENTER);
    }
}

package Calendario2;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.time.LocalDate;
import java.util.Calendar;

public class ComponenteCalendario extends JPanel {

    // Variables de instancia
    private static final long serialVersionUID = -3157082013187339222L;
    private JLabel etiquetaMes;
    private JButton botonAnterior; // Botón para retroceder un mes
    private JButton botonSiguiente; // Botón para avanzar un mes
    private JPanel panelDias;
    private JButton[][] botonesDias; // Array de botones para los días del mes
    private int mesActual;
    private int añoActual;
    private JSeparator separator; // Separador entre los botones anterior y siguiente
    private JPanel panelPrincipal;
    private JButton botonAtras; // Botón para regresar al calendario principal

    // Strings meses y días de la semana
    
    private String[] months = {"", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    private String[] days = {"Lun", "Mar", "Mie", "Jue", "Vie", "Sab", "Dom"};


    public ComponenteCalendario() {
    	
        // Inicialización del mes y año actual
        LocalDate today = LocalDate.now();
        this.mesActual = today.getMonthValue() - 1;
        this.añoActual = today.getYear();

        // Configuración del diseño del panel
        setLayout(new BorderLayout());

        // Configuración de la etiqueta de mes
        etiquetaMes = new JLabel(months[mesActual] + " " + añoActual, JLabel.CENTER);
        etiquetaMes.setFont(new Font("Arial", Font.BOLD, 24));
        etiquetaMes.setForeground(new Color(50, 50, 50));

        // Configuración del panel de días del mes y año
        JPanel panelDiasMesAnio = new JPanel(new BorderLayout());
        panelDiasMesAnio.add(etiquetaMes, BorderLayout.CENTER);

        // Configuración del panel de días de la semana
        JPanel panelDiasSemana = new JPanel(new GridLayout(1, 7));
        panelDiasSemana.setBackground(Color.WHITE);
        for (String dia : days) {
            JLabel labelDia = new JLabel(dia, JLabel.CENTER);
            labelDia.setFont(new Font("Arial", Font.PLAIN, 18));
            panelDiasSemana.add(labelDia);
        }
        panelDiasMesAnio.add(panelDiasSemana, BorderLayout.SOUTH);
        add(panelDiasMesAnio, BorderLayout.NORTH);

        // Configuración de los botones anterior y siguiente
        JPanel panelBotones = new JPanel(new GridLayout(1, 3));
        panelBotones.setBackground(Color.WHITE);
        botonAnterior = new JButton("Mes Anterior");
        botonAnterior.setBackground(new Color(100, 149, 237));
        botonAnterior.setForeground(Color.BLACK);
        botonAnterior.setPreferredSize(new Dimension(150, 50));
        botonAnterior.setFont(new Font("Arial", Font.PLAIN, 18));
        botonSiguiente = new JButton("Mes Siguiente");
        botonSiguiente.setBackground(new Color(100, 149, 237));
        botonSiguiente.setForeground(Color.BLACK);
        botonSiguiente.setPreferredSize(new Dimension(150, 50));
        botonSiguiente.setFont(new Font("Arial", Font.PLAIN, 18));

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        botonAnterior.setBorder(border);
        botonSiguiente.setBorder(border);

        panelBotones.add(botonAnterior);
        separator = new JSeparator();
        separator.setForeground(new Color(255, 255, 255));
        panelBotones.add(separator);
        panelBotones.add(botonSiguiente);
        add(panelBotones, BorderLayout.SOUTH);
        
     // Configuración del panel de los días del mes
        panelDias = new JPanel(new GridLayout(0, 7)); // 0 filas y 7 columnas
        panelDias.setBackground(Color.WHITE); 
        botonesDias = new JButton[6][7]; // Array botones de 6 filas y 7 columnas
        for (int i = 0; i < 6; i++) { // recorrer las filas
            for (int j = 0; j < 7; j++) { // recorrer las columnas
                botonesDias[i][j] = new JButton(""); // Inicialización de cada botón con una cadena vacía
                panelDias.add(botonesDias[i][j]); // Agregar cada botón al panel de días
            }
        }
        add(panelDias, BorderLayout.CENTER); 


        // Acción para el botón anterior
        botonAnterior.addActionListener(e -> {
            mesActual = (mesActual - 1);
            actualizarCalendario();
        });

        // Acción para el botón siguiente
        botonSiguiente.addActionListener(e -> {
            mesActual = (mesActual + 1);
            actualizarCalendario();
        });

        
        actualizarCalendario();
    }

    // Método para actualizar el calendario
    private void actualizarCalendario() {
        // Manejo de los casos en que el mes sea menor que 0 o mayor que 11
        if (mesActual < 1) {
            mesActual = 12;
            añoActual--;
        } else if (mesActual > 12) {
            mesActual = 1;
            añoActual++;
        }

        // Actualización de la etiqueta de mes
        etiquetaMes.setText(months[mesActual] + " " + añoActual);

        // Configuración del calendario
        Calendar cal = Calendar.getInstance();
        cal.set(añoActual, mesActual, 1);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int primerDia = cal.get(Calendar.DAY_OF_WEEK);
        int numeroDias = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

     // Limpiar panel de días
        panelDias.removeAll();
        // panel de días con una cuadrícula de 0 filas y 7 columnas
        panelDias.setLayout(new GridLayout(0, 7));

        int dia = 1; // Inicialización del día en 1
        for (int i = 0; i < 6; i++) { //  recorrer las filas
        	
            for (int j = 0; j < 7; j++) { // recorrer las columnas
            	
                if (i == 0 && j < primerDia - 1) { // Condición para los días anteriores al primer día del mes
                    JButton botonVacio = new JButton(""); //  botón vacío
                    botonVacio.setEnabled(false); // Deshabilitar botón vacío
                    botonVacio.setBackground(Color.WHITE); 
                    panelDias.add(botonVacio); // Agregar el botón vacío al panel de días
                    
                } else if (dia <= numeroDias) { // Condición para los días dentro del mes
                    final int finalDia = dia;
                    JButton botonDia = new JButton(String.valueOf(dia)); // Creación botón con número de día
                    botonDia.addActionListener(e -> mostrarPanelHoras(finalDia)); // acción al botón del dia para mostrar el panel de horas
                    botonDia.setRolloverEnabled(false); // Deshabilitar accion mouse
                    panelDias.add(botonDia); // Agregar el botón al panel de días
                    dia++; // Incrementar el día
                    
                } else { // días fuera del rango de días del mes
                    JButton botonVacio = new JButton(""); // Creación de un botón vacío
                    botonVacio.setEnabled(false); // Deshabilitar botón vacío
                    botonVacio.setBackground(Color.WHITE); 
                    panelDias.add(botonVacio); // Agregar el botón vacío al panel de días
                }
            }
        }

        revalidate(); // Validar el diseño del panel
        repaint(); // Volver a pintar el panel

    }

 // Método para mostrar el panel de horas
    private void mostrarPanelHoras(int dia) {
        panelDias.setVisible(false); // Ocultar el panel de días

        JPanel panelHoras = new JPanel(new GridLayout(8, 3)); // panel con una disposición de 8 filas y 3 columnas
        JButton[][] botonesHoras = new JButton[8][3]; // Array de botones de 8 filas y 3 columnas

        for (int i = 0; i < 8; i++) { // recorrer las filas
        	
            for (int j = 0; j < 3; j++) { //recorrer las columnas
            	
                int hora = (i * 3) + j; // Cálculo de la hora en base a la fila y la columna
                
                if (hora < 24) { // Verificar si la hora es menor que 24
                    botonesHoras[i][j] = new JButton(String.format("%02d:00 - %02d:00", hora, (hora + 1) % 24)); // botón con el rango horario 
                    panelHoras.add(botonesHoras[i][j]); // Agregar el botón al panel de horas
                    botonesHoras[i][j].setRolloverEnabled(false); // Deshabilitar el efecto de resaltado al pasar el mouse sobre el botón

                    // Agregar ActionListener para cambiar el color al hacer clic
                    botonesHoras[i][j].addActionListener(event -> {
                        JButton source = (JButton) event.getSource();
                        source.setBackground(Color.ORANGE); 
                    });
                }
            }
        }

        JTextArea campoRecordatorio = new JTextArea(10, 20); // área de texto recordatorio
        campoRecordatorio.setFont(new Font("Arial", Font.PLAIN, 16)); 
        JScrollPane scrollPane = new JScrollPane(campoRecordatorio); // panel dcon desplazamiento
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // desplazamiento vertical
        campoRecordatorio.setText(""); // texto por defecto vacío

        JButton botonEstablecerRecordatorio = new JButton("Establecer Recordatorio"); // botón para establecer el recordatorio
        botonEstablecerRecordatorio.setVisible(true); // Hacer visible el botón de establecer recordatorio

        botonEstablecerRecordatorio.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Recordatorio guardado", "Mensaje", JOptionPane.INFORMATION_MESSAGE); // Mostrar un mensaje de diálogo al establecer el recordatorio
        });

        botonAtras = new JButton("Atrás"); // botón retroceder
        botonAtras.setEnabled(true); // Habilitar el botón de retroceso


        JPanel panelRecordatorio = new JPanel(new BorderLayout()); // panel con texto de recordatorio
        panelRecordatorio.add(scrollPane, BorderLayout.CENTER); 
        JLabel labelRecordatorio = new JLabel("Escribe aquí el recordatorio...", SwingConstants.CENTER); 
        labelRecordatorio.setFont(new Font("Arial", Font.BOLD, 16));
        panelRecordatorio.add(labelRecordatorio, BorderLayout.NORTH); 
        panelRecordatorio.add(botonEstablecerRecordatorio, BorderLayout.SOUTH);

        panelPrincipal = new JPanel(new BorderLayout()); // crear panel principal 
        panelPrincipal.add(panelHoras, BorderLayout.CENTER);
        panelPrincipal.add(panelRecordatorio, BorderLayout.SOUTH); 

        botonAnterior.setVisible(false); // Ocultar el botón anterior
        botonSiguiente.setVisible(false); // Ocultar el botón siguiente
        botonAtras.addActionListener(e -> volverAlCalendario()); // Agregar acción botón atras para volver al calendario principal
        add(botonAtras, BorderLayout.SOUTH); 
        add(panelPrincipal, BorderLayout.CENTER);

        revalidate(); // Validar el diseño del panel
        repaint(); // Volver a pintar el panel
    }


 // Método para regresar al calendario principal
    private void volverAlCalendario() {
        remove(panelPrincipal); // Eliminar el panel principal
        panelDias.setVisible(true); // Hacer visible el panel de días

        botonAnterior.setVisible(true); // Hacer visible el botón anterior
        botonSiguiente.setVisible(true); // Hacer visible el botón siguiente

        remove(botonAtras); // Eliminar el botón de retroceso

        revalidate(); // Validar el diseño del panel
        repaint(); // Volver a pintar el panel
    }

  
    // Método main para la ejecución del programa
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calendario");
        frame.setSize(800, 636);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ComponenteCalendario calendar = new ComponenteCalendario();
        frame.getContentPane().add(calendar);

        frame.setVisible(true);
    }
}



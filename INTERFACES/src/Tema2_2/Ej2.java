package Tema2_2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.JSeparator;

public class Ej2 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel Panel_base;

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

    public Ej2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 457, 485);
        Panel_base = new JPanel();
        setContentPane(Panel_base);
        Panel_base.setLayout(new BoxLayout(Panel_base, BoxLayout.Y_AXIS));
        
        JSeparator separator = new JSeparator();
        Panel_base.add(separator);
        
        JPanel panel_base_pantalla = new JPanel();
        Panel_base.add(panel_base_pantalla);
                panel_base_pantalla.setLayout(new BorderLayout(0, 0));
                
                JPanel panel_oeste = new JPanel();
                FlowLayout fl_panel_oeste = (FlowLayout) panel_oeste.getLayout();
                fl_panel_oeste.setHgap(20);
                panel_base_pantalla.add(panel_oeste, BorderLayout.WEST);
                
                JPanel panel_norte = new JPanel();
                FlowLayout fl_panel_norte = (FlowLayout) panel_norte.getLayout();
                fl_panel_norte.setVgap(25);
                panel_base_pantalla.add(panel_norte, BorderLayout.NORTH);
                
                JPanel panel_este = new JPanel();
                FlowLayout fl_panel_este = (FlowLayout) panel_este.getLayout();
                fl_panel_este.setHgap(20);
                panel_base_pantalla.add(panel_este, BorderLayout.EAST);
                
                JScrollPane scrollPane = new JScrollPane();
                panel_base_pantalla.add(scrollPane, BorderLayout.CENTER);
                
                JTextArea textArea = new JTextArea();
                scrollPane.setViewportView(textArea);
                
                JPanel panel_sur = new JPanel();
                FlowLayout fl_panel_sur = (FlowLayout) panel_sur.getLayout();
                fl_panel_sur.setVgap(25);
                panel_base_pantalla.add(panel_sur, BorderLayout.SOUTH);
                
                JPanel panel_Botones = new JPanel();
                Panel_base.add(panel_Botones);
                panel_Botones.setLayout(new GridLayout(0, 4, 0, 0));
                
                JPanel panel = new JPanel();
                panel_Botones.add(panel);
                panel.setLayout(new GridLayout(4, 5, 0, 0));
                
                JButton btn_Cls = new JButton("CLS");
                btn_Cls.setFont(new Font("Arial Black", Font.PLAIN, 14));
                panel_Botones.add(btn_Cls);
                
                JButton btn_Back = new JButton("BACK");
                btn_Back.setFont(new Font("Arial Black", Font.PLAIN, 14));
                panel_Botones.add(btn_Back);
                
                JButton btn_Close = new JButton("CLOSE");
                btn_Close.setFont(new Font("Arial Black", Font.PLAIN, 14));
                panel_Botones.add(btn_Close);
                
                JButton btn_7 = new JButton("7");
                btn_7.setFont(new Font("Arial Black", Font.PLAIN, 14));
                panel_Botones.add(btn_7);
                
                JButton btn_8 = new JButton("8");
                btn_8.setFont(new Font("Arial Black", Font.PLAIN, 14));
                panel_Botones.add(btn_8);
                
                JButton btn_9 = new JButton("9");
                btn_9.setFont(new Font("Arial Black", Font.PLAIN, 14));
                panel_Botones.add(btn_9);
                
                JButton btn_dividir = new JButton("/");
                btn_dividir.setFont(new Font("Arial Black", Font.PLAIN, 14));
                panel_Botones.add(btn_dividir);
                
                JButton btn_4 = new JButton("4");
                btn_4.setFont(new Font("Arial Black", Font.PLAIN, 14));
                panel_Botones.add(btn_4);
                
                JButton btn_5 = new JButton("5");
                btn_5.setFont(new Font("Arial Black", Font.PLAIN, 14));
                panel_Botones.add(btn_5);
                
                JButton btn_6 = new JButton("6");
                btn_6.setFont(new Font("Arial Black", Font.PLAIN, 14));
                panel_Botones.add(btn_6);
                
                JButton btn_porcentaje = new JButton("%");
                btn_porcentaje.setFont(new Font("Arial Black", Font.PLAIN, 14));
                panel_Botones.add(btn_porcentaje);
                
                JButton btn_1 = new JButton("1");
                btn_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
                panel_Botones.add(btn_1);
                
                JButton btn_2 = new JButton("2");
                btn_2.setFont(new Font("Arial Black", Font.PLAIN, 14));
                panel_Botones.add(btn_2);
                
                JButton btn_3 = new JButton("3");
                btn_3.setFont(new Font("Arial Black", Font.PLAIN, 14));
                panel_Botones.add(btn_3);
                
                JButton btn_resta = new JButton("-");
                btn_resta.setFont(new Font("Arial Black", Font.PLAIN, 14));
                panel_Botones.add(btn_resta);
                
                JButton btn_0 = new JButton("0");
                btn_0.setFont(new Font("Arial Black", Font.PLAIN, 14));
                panel_Botones.add(btn_0);
                
                JButton btn_punto = new JButton(".");
                btn_punto.setFont(new Font("Arial Black", Font.PLAIN, 14));
                panel_Botones.add(btn_punto);
                
                JButton btn_igual = new JButton("=");
                btn_igual.setFont(new Font("Arial Black", Font.PLAIN, 14));
                panel_Botones.add(btn_igual);
                
                JButton btn_sumar = new JButton("+");
                btn_sumar.setFont(new Font("Arial Black", Font.PLAIN, 14));
                panel_Botones.add(btn_sumar);
    }
}


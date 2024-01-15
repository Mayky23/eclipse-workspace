package Paisajes;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Paisaje extends JPanel {

	private static final long serialVersionUID = -7855086242560259453L;


	public Paisaje() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar el cielo
        dibujarCielo(g);

        // Dibujar el sol
        dibujarSol(g, 100, 50, 80);

        // Dibujar las montañas
        dibujarMontanas(g);

        // Dibujar el campo
        dibujarCampo(g);

        // Dibujar árboles
        dibujarPino(g, 115, 220, 60, 120);
        dibujarPino(g, 215, 220, 40, 100);
        dibujarPino(g, 315, 220, 70, 140);
        dibujarPino(g, 415, 220, 50, 110);
        dibujarPino(g, 515, 220, 30, 90);

        // Dibujar un río
        dibujarRio(g);

        // Dibujar nubes
        dibujarNubes(g);

     // Dibujar la casa simple a la derecha
        dibujarCasa(g, 600, 220, 100, 80);

    }

    private void dibujarCielo(Graphics g) {
        g.setColor(new Color(135, 206, 250));
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    private void dibujarSol(Graphics g, int x, int y, int tamano) {
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, tamano, tamano);
    }

    private void dibujarMontanas(Graphics g) {
        g.setColor(new Color(139, 69, 19));
        g.fillPolygon(new int[]{50, 250, 150}, new int[]{250, 250, 100}, 3);
        g.fillPolygon(new int[]{200, 400, 300}, new int[]{250, 250, 150}, 3);
    }

    private void dibujarCampo(Graphics g) {
        g.setColor(new Color(50, 205, 50));
        g.fillRect(0, 250, getWidth(), getHeight());
    }

    private void dibujarPino(Graphics g, int x, int y, int ancho, int altura) {
        // Dibujar tronco de árbol marrón
        g.setColor(new Color(139, 69, 19));
        g.fillRect(x + ancho / 3, y + altura / 2, ancho / 5, altura / 2);

        // Dibujar capas de la copa del árbol
        int niveles = 5; // Número de niveles en la copa del árbol
        int nivelAltura = altura / niveles; // Altura de cada nivel

        for (int i = niveles - 1; i >= 0; i--) {
            int nivelAncho = ancho - i * (ancho / niveles); // Ancho de cada nivel
            int nivelX = x - 5 + (ancho - nivelAncho) / 2; // Ajusta la posición horizontal de la copa 5 izquierda
            int nivelY = y + (niveles - 1 - i) * (altura / 10); // Ajusta la posición vertical de la copa

            g.setColor(new Color(34, 139, 34));
            g.fillOval(nivelX, nivelY, nivelAncho, nivelAltura);
        }
    }

    private void dibujarRio(Graphics g) {
        g.setColor(new Color(0, 0, 139));
        g.fillRect(0, 330, getWidth(), 50);
    }

    private void dibujarNubes(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(50, 70, 60, 30);
        g.fillOval(70, 60, 80, 40);
    }

    private void dibujarCasa(Graphics g, int x, int y, int ancho, int altura) {
        // Dibujar base cuadrada blanca
        g.setColor(Color.WHITE);
        g.fillRect(x, y, ancho, altura);

        // Dibujar tejado rojo
        g.setColor(Color.RED);
        int[] tejadoX = {x, x + ancho / 2, x + ancho};
        int[] tejadoY = {y, y - altura / 2, y};
        g.fillPolygon(tejadoX, tejadoY, 3);
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Paisaje");
        Paisaje escena = new Paisaje();
        frame.getContentPane().add(escena);
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

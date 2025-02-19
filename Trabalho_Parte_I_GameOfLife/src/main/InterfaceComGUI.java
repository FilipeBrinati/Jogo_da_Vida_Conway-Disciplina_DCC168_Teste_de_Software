package main;

import javax.swing.*;
import java.awt.*;

public class InterfaceComGUI extends JPanel {

	private static final long serialVersionUID = -298185225002398275L;
	private static final int CELL_SIZE = 20;
    private Tabuleiro tabuleiro;

    public InterfaceComGUI(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int[][] espaco = tabuleiro.getEspaco();

        for (int i = 0; i < tabuleiro.getTamanho(); i++) {
            for (int j = 0; j < tabuleiro.getTamanho(); j++) {
                if (espaco[i][j] == 1) {
                    g.setColor(Color.BLACK); // Célula viva
                } else {
                    g.setColor(Color.WHITE); // Célula morta
                }
                g.fillRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                g.setColor(Color.GRAY); // Grade
                g.drawRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }

    public void atualizarTabuleiro(Tabuleiro novoTabuleiro) {
        this.tabuleiro = novoTabuleiro;
        repaint();
    }

    public void mostrarJanela(Tabuleiro tabuleiro, int tamanho) {
        JFrame frame = new JFrame("Jogo da Vida - Conway");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(tamanho * CELL_SIZE + 16, tamanho * CELL_SIZE + 39);
        frame.add(this);
        frame.setVisible(true);

        // Inicializa o estado do tabuleiro
        atualizarTabuleiro(tabuleiro);
    }
}

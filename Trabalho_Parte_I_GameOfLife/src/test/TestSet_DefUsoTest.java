package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Analise;
import main.Tabuleiro;

class TestSet_DefUsoTest {

	private Tabuleiro tabuleiroInicial;
    private Analise analise;

    @BeforeEach
    void setUp() {
        tabuleiroInicial = new Tabuleiro(6); // Tabuleiro 6x6
        analise = new Analise(tabuleiroInicial);
    }

    @Test
    void CT1_testCelulaMorrePorSolidao() {
        tabuleiroInicial.setEspaco(new int[][] {
            {0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
        });

        Tabuleiro resultado = analise.executar(tabuleiroInicial);
        assertEquals(0, resultado.getEspacoEspecifico(1, 1), "Célula deve morrer por solidão.");
    }

    @Test
    void CT2_testCelulaPermaneceViva() {
        tabuleiroInicial.setEspaco(new int[][] {
            {0, 1, 0, 0, 0, 0},
            {0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
        });

        Tabuleiro resultado = analise.executar(tabuleiroInicial);
        assertEquals(1, resultado.getEspacoEspecifico(1, 1), "Célula deve permanecer viva.");
    }

    @Test
    void CT3_testCelulaRevive() {
        tabuleiroInicial.setEspaco(new int[][] {
            {0, 1, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
        });

        Tabuleiro resultado = analise.executar(tabuleiroInicial);
        assertEquals(1, resultado.getEspacoEspecifico(1, 1), "Célula deve reviver.");
    }

    @Test
    void CT4_testCelulaMorrePorSuperlotacao() {
        tabuleiroInicial.setEspaco(new int[][] {
            {1, 1, 1, 0, 0, 0},
            {1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
        });

        Tabuleiro resultado = analise.executar(tabuleiroInicial);
        assertEquals(0, resultado.getEspacoEspecifico(1, 1), "Célula deve morrer por superlotação.");
    }

    @Test
    void CT5_testCalculoNovoXNovoY_1Vizinho() {
        tabuleiroInicial.setEspaco(new int[][] {
            {0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
        });

        Tabuleiro resultado = analise.executar(tabuleiroInicial);
        assertEquals(0, resultado.getEspacoEspecifico(1, 1), "Cálculo de novoX e novoY deve funcionar para 1 vizinho vivo.");
    }

    @Test
    void CT6_testCalculoNovoXNovoY_2Vizinhos() {
        tabuleiroInicial.setEspaco(new int[][] {
            {0, 1, 0, 0, 0, 0},
            {0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
        });

        Tabuleiro resultado = analise.executar(tabuleiroInicial);
        assertEquals(1, resultado.getEspacoEspecifico(1, 1), "Cálculo de novoX e novoY deve funcionar para 2 vizinhos vivos.");
    }

    @Test
    void CT7_testCalculoNovoXNovoY_3Vizinhos() {
        tabuleiroInicial.setEspaco(new int[][] {
            {0, 1, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
        });

        Tabuleiro resultado = analise.executar(tabuleiroInicial);
        assertEquals(1, resultado.getEspacoEspecifico(1, 1), "Cálculo de novoX e novoY deve funcionar para 3 vizinhos vivos.");
    }

    @Test
    void CT8_testCalculoNovoXNovoY_4Vizinhos() {
        tabuleiroInicial.setEspaco(new int[][] {
            {1, 1, 1, 0, 0, 0},
            {1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
        });

        Tabuleiro resultado = analise.executar(tabuleiroInicial);
        assertEquals(0, resultado.getEspacoEspecifico(1, 1), "Cálculo de novoX e novoY deve funcionar para 4 vizinhos vivos.");
    }

}


package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Analise;
import main.Tabuleiro;

public class TestSet_DefUsoTest {

	private Tabuleiro tabuleiroInicial;
    private Analise analise;

    @Before
    public void setUp() {
        tabuleiroInicial = new Tabuleiro(6); // Tabuleiro 6x6
        analise = new Analise(tabuleiroInicial);
    }

    @Test
    public void CT1_testCelulaMorrePorSolidao() {
        tabuleiroInicial.setEspaco(new int[][] {
            {0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
        });

        Tabuleiro resultado = analise.executar(tabuleiroInicial);
        assertEquals(0, resultado.getEspacoEspecifico(1, 1));
    }

    @Test
    public void CT2_testCelulaPermaneceViva() {
        tabuleiroInicial.setEspaco(new int[][] {
            {0, 1, 0, 0, 0, 0},
            {0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
        });

        Tabuleiro resultado = analise.executar(tabuleiroInicial);
        assertEquals(1, resultado.getEspacoEspecifico(1, 1));
    }

    @Test
    public void CT3_testCelulaRevive() {
        tabuleiroInicial.setEspaco(new int[][] {
            {0, 1, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
        });

        Tabuleiro resultado = analise.executar(tabuleiroInicial);
        assertEquals(1, resultado.getEspacoEspecifico(1, 1));
    }

    @Test
    public void CT4_testCelulaMorrePorSuperlotacao() {
        tabuleiroInicial.setEspaco(new int[][] {
            {1, 1, 1, 0, 0, 0},
            {1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
        });

        Tabuleiro resultado = analise.executar(tabuleiroInicial);
        assertEquals(0, resultado.getEspacoEspecifico(1, 1));
    }

    @Test
    public void CT5_testCalculoNovoXNovoY_1Vizinho() {
        tabuleiroInicial.setEspaco(new int[][] {
            {0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
        });

        Tabuleiro resultado = analise.executar(tabuleiroInicial);
        assertEquals(0, resultado.getEspacoEspecifico(1, 1));
    }

    @Test
    public void CT6_testCalculoNovoXNovoY_2Vizinhos() {
        tabuleiroInicial.setEspaco(new int[][] {
            {0, 1, 0, 0, 0, 0},
            {0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
        });

        Tabuleiro resultado = analise.executar(tabuleiroInicial);
        assertEquals(1, resultado.getEspacoEspecifico(1, 1));
    }

    @Test
    public void CT7_testCalculoNovoXNovoY_3Vizinhos() {
        tabuleiroInicial.setEspaco(new int[][] {
            {0, 1, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
        });

        Tabuleiro resultado = analise.executar(tabuleiroInicial);
        assertEquals(1, resultado.getEspacoEspecifico(1, 1));
    }

    @Test
    public void CT8_testCalculoNovoXNovoY_4Vizinhos() {
        tabuleiroInicial.setEspaco(new int[][] {
            {1, 1, 1, 0, 0, 0},
            {1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
        });

        Tabuleiro resultado = analise.executar(tabuleiroInicial);
        assertEquals(0, resultado.getEspacoEspecifico(1, 1));
    }

}


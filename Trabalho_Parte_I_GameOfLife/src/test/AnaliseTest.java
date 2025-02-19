package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Analise;
import main.Tabuleiro;

class AnaliseTest {

    private Tabuleiro tabuleiroInicial;
    private Tabuleiro tabuleiroEsperado;
    private Analise analise;

    @BeforeEach
    void setUp() {
        tabuleiroInicial = new Tabuleiro(6);
        tabuleiroEsperado = new Tabuleiro(6);
        analise = new Analise(tabuleiroInicial);
    }

    @AfterEach
    void tearDown() {
        tabuleiroInicial = null;
        tabuleiroEsperado = null;
        analise = null;
    }

    @Test
    void CT2_testCMWithThreeNeighbors() {
        tabuleiroInicial.setEspaco(new int[][] {
            {0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}
        });
        tabuleiroEsperado.setEspaco(new int[][] {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}
        });
        tabuleiroInicial = analise.executar(tabuleiroInicial);
        assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroEsperado.getEspaco());
    }

    @Test
    void CT3_testCVDiesUnderFlow() {
        tabuleiroInicial.setEspaco(new int[][] {
            {1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}
        });
        tabuleiroEsperado.setEspaco(new int[][] {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}
        });
        tabuleiroInicial = analise.executar(tabuleiroInicial);
        assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroEsperado.getEspaco());
    }

    @Test
    void CT4_testCVSurvivesWithTwoOrThreeNeighbors() {
        tabuleiroInicial.setEspaco(new int[][] {
            {0, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 0}
        });
        tabuleiroEsperado.setEspaco(new int[][] {
            {0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 1, 0},
            {0, 0, 0, 0, 0, 0}
        });
        tabuleiroInicial = analise.executar(tabuleiroInicial);
        assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroEsperado.getEspaco());
    }

    @Test
    void CT5_testCVDiesOverFlow() {
        tabuleiroInicial.setEspaco(new int[][] {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 0},
            {0, 0, 0, 1, 1, 0},
            {0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}
        });
        tabuleiroEsperado.setEspaco(new int[][] {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}
        });
        tabuleiroInicial = analise.executar(tabuleiroInicial);
        assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroEsperado.getEspaco());
    }
}

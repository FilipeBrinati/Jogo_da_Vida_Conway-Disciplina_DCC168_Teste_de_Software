package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Analise;
import main.Tabuleiro;

class TestSet_EstrTest {

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
    void CTN3_testCelulaMorrePorSolidão() {
        tabuleiroInicial.setEspaco(new int[][] {
            {0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
        });
        tabuleiroEsperado.setEspaco(new int[][] {
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
		});
        tabuleiroInicial = analise.executar(tabuleiroInicial);
        assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroEsperado.getEspaco());
    }
    

    @Test
    void CTN4_testCelulaPermaneceViva() {
        tabuleiroInicial.setEspaco(new int[][] {
            {0, 1, 0, 0, 0, 0},
            {0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
        });
        tabuleiroEsperado.setEspaco(new int[][] {
			{0, 1, 1, 0, 0, 0},
			{0, 1, 1, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
		});
        tabuleiroInicial = analise.executar(tabuleiroInicial);
        assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroEsperado.getEspaco());
    }
    

    @Test
    void CTN5_testCelulaRevive() {
        tabuleiroInicial.setEspaco(new int[][] {
            {0, 1, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
        });
        tabuleiroEsperado.setEspaco(new int[][] {
			{0, 0, 0, 0, 0, 0},
			{0, 1, 1, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
		});
        tabuleiroInicial = analise.executar(tabuleiroInicial);
        assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroEsperado.getEspaco());
    }


    @Test
    void CTN6_testCelulaPermaneceMorta() {
        tabuleiroInicial.setEspaco(new int[][] {
            {0, 1, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
        });
        tabuleiroEsperado.setEspaco(new int[][] {
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
		});
        tabuleiroInicial = analise.executar(tabuleiroInicial);
        assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroEsperado.getEspaco());
    }
    
    @Test
    void CTD2_testCelulaMorrePorSuperpopulacao() {
        tabuleiroInicial.setEspaco(new int[][] {
            {1, 1, 1, 0, 0, 0},
            {1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
        });
        tabuleiroEsperado.setEspaco(new int[][] {
			{1, 0, 1, 0, 0, 0},
			{1, 0, 1, 0, 0, 0},
			{0, 1, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
		});
        tabuleiroInicial = analise.executar(tabuleiroInicial);
        assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroEsperado.getEspaco());
    }

}

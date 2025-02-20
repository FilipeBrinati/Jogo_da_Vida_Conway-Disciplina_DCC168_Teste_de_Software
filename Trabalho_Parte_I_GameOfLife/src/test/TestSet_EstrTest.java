package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.Analise;
import main.Tabuleiro;

public class TestSet_EstrTest {

    private Tabuleiro tabuleiroInicial;
    private Tabuleiro tabuleiroEsperado;
    private Analise analise;

    @Before
    public void setUp() {
        tabuleiroInicial = new Tabuleiro(6);
        tabuleiroEsperado = new Tabuleiro(6);
        analise = new Analise(tabuleiroInicial);
    }
    @After
    public void tearDown() {
    	tabuleiroInicial = null;
        tabuleiroEsperado = null;
        analise = null;
    }

    @Test
    public void CT1_testCelulaMorrePorSolidão() {
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
    public void CT2_testCelulaPermaneceViva() {
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
    public void CT3_testCelulaRevive() {
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
    public void CT4_testCelulaPermaneceMorta() {
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
    public void CT5_testCelulaMorrePorSuperpopulacao() {
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

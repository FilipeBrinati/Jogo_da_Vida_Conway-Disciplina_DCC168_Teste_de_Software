package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.Analise;
import main.Tabuleiro;

public class TestSet_FuncTest {
	/*
	 * Essa classe deve ter todos os testes para poderem ser rodados
	 * apenas uma vez. A separação dos outros arquivos foi realizado
	 * em vista do que estava sendo testado e diferentes metodos
	 * utilizados para gerar um teste(grafo causa efeito, tabuleiro e 
	 * celula individual).*/

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
    public void CT1_testEmptyBoard(){
		tabuleiroInicial.setEspaco(new int[][] {
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
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
        for (int i = 0; i < 10; i++) {
            tabuleiroInicial = analise.executar(tabuleiroInicial);
        }
        assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroEsperado.getEspaco());
	}
    @Test
    public void CT2_testCMWithThreeNeighbors() {
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
    public void CT3_testCVDiesUnderFlow() {
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
    public void CT4_testCVSurvivesWithTwoOrThreeNeighbors() {
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
    public void CT5_testCVDiesOverFlow() {
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
    @Test 
    public void CT6_testStillLifesBlock(){
		tabuleiroInicial.setEspaco(new int[][] {
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 1, 1, 0, 0},
			{0, 0, 1, 1, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
		});
		tabuleiroEsperado.setEspaco(new int[][] {
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 1, 1, 0, 0},
			{0, 0, 1, 1, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
		});
        for (int i = 0; i < 10; i++) {
            tabuleiroInicial = analise.executar(tabuleiroInicial);
        }
        assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroEsperado.getEspaco());
	}
	@Test
	public void CT7_testStillLifesBeehive() {
	    tabuleiroInicial.setEspaco(new int[][] {
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 1, 0, 0},
	        {0, 0, 1, 0, 1, 0},
	        {0, 0, 0, 1, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	    });
	    tabuleiroEsperado.setEspaco(new int[][] {
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 1, 0, 0},
	        {0, 0, 1, 0, 1, 0},
	        {0, 0, 0, 1, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	    });
	    for (int i = 0; i < 10; i++) {
	        tabuleiroInicial = analise.executar(tabuleiroInicial);
	    }
	    assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroEsperado.getEspaco());
	}
	@Test
	public void CT8_testStillLifesLoaf() {
	    tabuleiroInicial.setEspaco(new int[][] {
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 1, 1, 0, 0},
	        {0, 1, 0, 0, 1, 0},
	        {0, 0, 1, 0, 1, 0},
	        {0, 0, 0, 1, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	    });
	    tabuleiroEsperado.setEspaco(new int[][] {
	    	{0, 0, 0, 0, 0, 0},
	        {0, 0, 1, 1, 0, 0},
	        {0, 1, 0, 0, 1, 0},
	        {0, 0, 1, 0, 1, 0},
	        {0, 0, 0, 1, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	    });
	    for (int i = 0; i < 10; i++) {
	        tabuleiroInicial = analise.executar(tabuleiroInicial);
	    }
	    assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroEsperado.getEspaco());
	}
	@Test
	public void CT9_testStillLifesBoat() {
	    tabuleiroInicial.setEspaco(new int[][] {
	        {0, 0, 0, 0, 0, 0},
	        {0, 1, 1, 0, 0, 0},
	        {0, 1, 0, 1, 0, 0},
	        {0, 0, 1, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	    });
	    tabuleiroEsperado.setEspaco(new int[][] {
	        {0, 0, 0, 0, 0, 0},
	        {0, 1, 1, 0, 0, 0},
	        {0, 1, 0, 1, 0, 0},
	        {0, 0, 1, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	    });
	    for (int i = 0; i < 10; i++) {
	        tabuleiroInicial = analise.executar(tabuleiroInicial);
	        tabuleiroInicial.printEspaco();
	    }
	    assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroEsperado.getEspaco());
	}
	@Test
	public void CT10_testStillLifesTub() {
	    tabuleiroInicial.setEspaco(new int[][] {
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 1, 0, 0, 0},
	        {0, 1, 0, 1, 0, 0},
	        {0, 0, 1, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	    });
	    tabuleiroEsperado.setEspaco(new int[][] {
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 1, 0, 0, 0},
	        {0, 1, 0, 1, 0, 0},
	        {0, 0, 1, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	    });
	    for (int i = 0; i < 10; i++) {
	        tabuleiroInicial = analise.executar(tabuleiroInicial);
	    }
	    assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroEsperado.getEspaco());
	}
	@Test
	public void CT11_testOscillatorsBlinker() {
	    tabuleiroInicial.setEspaco(new int[][] {
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	        {0, 1, 1, 1, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0}
	    });
	    Tabuleiro tabuleiroStarter = new Tabuleiro(6);
	    tabuleiroStarter.setEspaco(tabuleiroInicial.getEspaco());
	    tabuleiroEsperado.setEspaco(new int[][] {
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 1, 0, 0, 0},
	        {0, 0, 1, 0, 0, 0},
	        {0, 0, 1, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0}
	    });
	    tabuleiroInicial = analise.executar(tabuleiroInicial);
	    assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroEsperado.getEspaco());
	    tabuleiroInicial = analise.executar(tabuleiroInicial);
	    assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroStarter.getEspaco());
	}
	@Test
	public void CT12_testOscillatorsToad() {
	    tabuleiroInicial.setEspaco(new int[][] {
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 1, 0, 0, 0},
	        {0, 1, 0, 0, 1, 0},
	        {0, 1, 0, 0, 1, 0},
	        {0, 0, 0, 1, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	    });
	    Tabuleiro tabuleiroStarter = new Tabuleiro(6);
	    tabuleiroStarter.setEspaco(tabuleiroInicial.getEspaco());
	    tabuleiroEsperado.setEspaco(new int[][] {
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	        {0, 1, 1, 1, 0, 0},
	        {0, 0, 1, 1, 1, 0},
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	    });
	    tabuleiroInicial = analise.executar(tabuleiroInicial);
	    assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroEsperado.getEspaco());
	    tabuleiroInicial = analise.executar(tabuleiroInicial);
	    assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroStarter.getEspaco());
	}
	@Test
	public void CT13_testOscillatorsBeacon() {
	    tabuleiroInicial.setEspaco(new int[][] {
	        {1, 1, 0, 0, 0, 0},
	        {1, 1, 0, 0, 0, 0},
	        {0, 0, 1, 1, 0, 0},
	        {0, 0, 1, 1, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0}
	    });
	    Tabuleiro tabuleiroStarter = new Tabuleiro(6);
	    tabuleiroStarter.setEspaco(tabuleiroInicial.getEspaco());
	    tabuleiroEsperado.setEspaco(new int[][] {
	    	{1, 1, 0, 0, 0, 0},
	        {1, 0, 0, 0, 0, 0},
	        {0, 0, 0, 1, 0, 0},
	        {0, 0, 1, 1, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0}
	    });
	    tabuleiroInicial = analise.executar(tabuleiroInicial);
	    assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroEsperado.getEspaco());
	    tabuleiroInicial = analise.executar(tabuleiroInicial);
	    assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroStarter.getEspaco());
	}
	@Test
	public void CT14_testSpaceShipGlider() {
	    tabuleiroInicial.setEspaco(new int[][] {
	        {0, 0, 1, 0, 0, 0},
	        {1, 0, 1, 0, 0, 0},
	        {0, 1, 1, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0}
	    });
	    tabuleiroEsperado.setEspaco(new int[][] {
	    	{0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 1, 0, 0},
	        {0, 1, 0, 1, 0, 0},
	        {0, 0, 1, 1, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0}
	    });
	    Tabuleiro tabuleiroMiddleOne = new Tabuleiro(6);
	    tabuleiroMiddleOne.setEspaco(new int[][] {
	    	{0, 1, 0, 0, 0, 0},
	        {0, 0, 1, 1, 0, 0},
	        {0, 1, 1, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0}
	    });
	    Tabuleiro tabuleiroMiddleTwo = new Tabuleiro(6);
	    tabuleiroMiddleTwo.setEspaco(new int[][] {
	    	{0, 0, 1, 0, 0, 0},
	        {0, 0, 0, 1, 0, 0},
	        {0, 1, 1, 1, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0}
	    });
	    Tabuleiro tabuleiroMiddleThree = new Tabuleiro(6);
	    tabuleiroMiddleThree.setEspaco(new int[][] {
	    	{0, 0, 0, 0, 0, 0},
	        {0, 1, 0, 1, 0, 0},
	        {0, 0, 1, 1, 0, 0},
	        {0, 0, 1, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0}
	    });
	    tabuleiroInicial = analise.executar(tabuleiroInicial);
	    assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroMiddleOne.getEspaco());
	    tabuleiroInicial = analise.executar(tabuleiroInicial);
	    assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroMiddleTwo.getEspaco());
	    tabuleiroInicial = analise.executar(tabuleiroInicial);
	    assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroMiddleThree.getEspaco());
	    tabuleiroInicial = analise.executar(tabuleiroInicial);
	    assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroEsperado.getEspaco());
	}
	@Test
	public void CT15_testSpaceShipLWSS() {
	    tabuleiroInicial.setEspaco(new int[][] {
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	        {0, 1, 1, 1, 1, 0},
	        {1, 0, 0, 0, 1, 0},
	        {0, 0, 0, 0, 1, 0},
	        {1, 0, 0, 1, 0, 0}
	    });
	    Tabuleiro tabuleiroMiddleOne = new Tabuleiro(6);
	    tabuleiroMiddleOne.setEspaco(new int[][] {
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 1, 1, 0, 0},
	        {0, 1, 1, 1, 1, 0},
	        {0, 1, 1, 0, 1, 1},
	        {0, 0, 0, 1, 1, 0},
	        {0, 0, 0, 0, 0, 0}
	    });
	    Tabuleiro tabuleiroMiddleTwo = new Tabuleiro(6);
	    tabuleiroMiddleTwo.setEspaco(new int[][] {
	        {0, 0, 0, 0, 0, 0},
	        {0, 1, 0, 0, 1, 0},
	        {0, 0, 0, 0, 0, 1},
	        {0, 1, 0, 0, 0, 1},
	        {0, 0, 1, 1, 1, 1},
	        {0, 0, 0, 0, 0, 0}
	    });
	    Tabuleiro tabuleiroMiddleThree = new Tabuleiro(6);
	    tabuleiroMiddleThree.setEspaco(new int[][] {
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 1, 1},
	        {0, 0, 1, 1, 0, 1},
	        {0, 0, 1, 1, 1, 1},
	        {0, 0, 0, 1, 1, 0}
	    });
	    tabuleiroEsperado.setEspaco(new int[][] {
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 1, 1, 1},
	        {0, 0, 1, 0, 0, 0},
	        {0, 0, 0, 0, 0, 1},
	        {0, 0, 1, 0, 0, 1}
	    });
	    tabuleiroInicial = analise.executar(tabuleiroInicial);
	    assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroMiddleOne.getEspaco());
	    tabuleiroInicial = analise.executar(tabuleiroInicial);
	    assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroMiddleTwo.getEspaco());
	    tabuleiroInicial = analise.executar(tabuleiroInicial);
	    assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroMiddleThree.getEspaco());
	    tabuleiroInicial = analise.executar(tabuleiroInicial);
	    assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroEsperado.getEspaco());
	}
	 @Test
	 public void CeE1() {
		    tabuleiroInicial.setEspaco(new int[][] {
		        {0, 0, 0, 0, 0, 0},
		        {0, 0, 0, 0, 0, 0},
		        {0, 0, 1, 0, 0, 0},
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
	    public void CeE2() {
		    tabuleiroInicial.setEspaco(new int[][] {
		        {0, 0, 0, 0, 0, 0},
		        {0, 0, 0, 1, 0, 0},
		        {0, 0, 1, 0, 0, 0},
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
	    public void CeE3() {
		    tabuleiroInicial.setEspaco(new int[][] {
		        {0, 0, 0, 0, 0, 0},
		        {0, 1, 0, 1, 0, 0},
		        {0, 0, 1, 0, 0, 0},
		        {0, 1, 0, 1, 0, 0},
		        {0, 0, 0, 0, 0, 0},
		        {0, 0, 0, 0, 0, 0},
		    });
		    tabuleiroEsperado.setEspaco(new int[][] {
		        {0, 0, 0, 0, 0, 0},
		        {0, 0, 1, 0, 0, 0},
		        {0, 1, 0, 1, 0, 0},
		        {0, 0, 1, 0, 0, 0},
		        {0, 0, 0, 0, 0, 0},
		        {0, 0, 0, 0, 0, 0},
		    });
		    tabuleiroInicial = analise.executar(tabuleiroInicial);
		    assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroEsperado.getEspaco());
		}
	    @Test
	    public void CeE4() {
		    tabuleiroInicial.setEspaco(new int[][] {
		        {0, 0, 0, 0, 0, 0},
		        {0, 1, 0, 1, 0, 0},
		        {0, 0, 1, 0, 0, 0},
		        {0, 0, 0, 1, 0, 0},
		        {0, 0, 0, 0, 0, 0},
		        {0, 0, 0, 0, 0, 0},
		    });
		    tabuleiroEsperado.setEspaco(new int[][] {
		        {0, 0, 0, 0, 0, 0},
		        {0, 0, 1, 0, 0, 0},
		        {0, 0, 1, 1, 0, 0},
		        {0, 0, 0, 0, 0, 0},
		        {0, 0, 0, 0, 0, 0},
		        {0, 0, 0, 0, 0, 0},
		    });
		    tabuleiroInicial = analise.executar(tabuleiroInicial);
		    assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroEsperado.getEspaco());
		}
	    @Test
	    public void CeE5() {
		    tabuleiroInicial.setEspaco(new int[][] {
		        {0, 0, 0, 0, 0, 0},
		        {0, 1, 0, 0, 0, 0},
		        {0, 0, 1, 0, 0, 0},
		        {0, 0, 0, 1, 0, 0},
		        {0, 0, 0, 0, 0, 0},
		        {0, 0, 0, 0, 0, 0},
		    });
		    tabuleiroEsperado.setEspaco(new int[][] {
		        {0, 0, 0, 0, 0, 0},
		        {0, 0, 0, 0, 0, 0},
		        {0, 0, 1, 0, 0, 0},
		        {0, 0, 0, 0, 0, 0},
		        {0, 0, 0, 0, 0, 0},
		        {0, 0, 0, 0, 0, 0},
		    });
		    tabuleiroInicial = analise.executar(tabuleiroInicial);
		    assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroEsperado.getEspaco());
		}
	    @Test
	    public void CeE6() {
		    tabuleiroInicial.setEspaco(new int[][] {
		        {0, 0, 0, 0, 0, 0},
		        {0, 1, 0, 1, 0, 0},
		        {0, 0, 0, 0, 0, 0},
		        {0, 0, 0, 1, 0, 0},
		        {0, 0, 0, 0, 0, 0},
		        {0, 0, 0, 0, 0, 0},
		    });
		    tabuleiroEsperado.setEspaco(new int[][] {
		        {0, 0, 0, 0, 0, 0},
		        {0, 0, 0, 0, 0, 0},
		        {0, 0, 1, 0, 0, 0},
		        {0, 0, 0, 0, 0, 0},
		        {0, 0, 0, 0, 0, 0},
		        {0, 0, 0, 0, 0, 0},
		    });
		    tabuleiroInicial = analise.executar(tabuleiroInicial);
		    assertArrayEquals(tabuleiroInicial.getEspaco(), tabuleiroEsperado.getEspaco());
		}
	    @Test
	    public void CeE7() {
		    tabuleiroInicial.setEspaco(new int[][] {
		        {0, 0, 0, 0, 0, 0},
		        {0, 0, 0, 0, 0, 0},
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
	    public void CeE8() {
		    tabuleiroInicial.setEspaco(new int[][] {
		        {0, 0, 0, 0, 0, 0},
		        {0, 0, 0, 1, 0, 0},
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
	    public void CeE9() {
		    tabuleiroInicial.setEspaco(new int[][] {
		        {0, 0, 0, 0, 0, 0},
		        {0, 0, 0, 1, 0, 0},
		        {0, 0, 0, 0, 0, 0},
		        {0, 0, 0, 1, 0, 0},
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
	    public void CeE10() {
		    tabuleiroInicial.setEspaco(new int[][] {
		        {0, 0, 0, 0, 0, 0},
		        {0, 1, 0, 1, 0, 0},
		        {0, 0, 0, 0, 0, 0},
		        {0, 1, 0, 1, 0, 0},
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

    
    
}

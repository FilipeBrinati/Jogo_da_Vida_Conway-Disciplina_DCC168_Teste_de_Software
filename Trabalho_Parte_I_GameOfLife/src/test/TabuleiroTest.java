package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Analise;
import main.Tabuleiro;

class TabuleiroTest {
	
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
	void CT1_testEmptyBoard(){
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
	void CT6_testStillLifesBlock(){
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
	void CT7_testStillLifesBeehive() {
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
	void CT8_testStillLifesLoaf() {
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
	void CT9_testStillLifesBoat() {
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
	void CT10_testStillLifesTub() {
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
	void CT11_testOscillatorsBlinker() {
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
	void CT12_testOscillatorsToad() {
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
	void CT13_testOscillatorsBeacon() {
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
	void CT14_testSpaceShipGlider() {
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
	void CT15_testSpaceShipLWSS() {
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



}

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Analise;
import main.Tabuleiro;

class CasoEfeitoTest {
	
	/*
	 * Avaliando a alteração no espaço [2][2]
	 * */

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
    void CeE1() {
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
    void CeE2() {
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
    void CeE3() {
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
    void CeE4() {
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
    void CeE5() {
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
    void CeE6() {
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
    void CeE7() {
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
    void CeE8() {
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
    void CeE9() {
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
    void CeE10() {
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

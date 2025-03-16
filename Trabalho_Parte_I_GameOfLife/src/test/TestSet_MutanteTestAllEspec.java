package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Analise;
import main.Tabuleiro;

class TestSet_MutanteTestAllEspec {

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
	void tearDown() throws Exception {
		tabuleiroInicial = null;
		tabuleiroEsperado = null;
		analise = null;
	}
	
	//Testes desenvolvidos na etapa Funcional
	
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
    
    //Testes Mutantes
	
	@Test
	void CT16_TestGetNovoTab() {
	    Tabuleiro novoTab = analise.getNovoTab();
	    assertNotNull(novoTab);
	}
	
	@Test
	void CT17_TestSetEspaco() {
	    analise.setNovoTab(tabuleiroInicial);
	    assertEquals(tabuleiroInicial, analise.getNovoTab());
	}

	@Test
	void CT18_TestSetEspaco() {
	    int[][] espaco = new int[6][6];
	    tabuleiroInicial.setEspaco(espaco);
	    assertArrayEquals(espaco, tabuleiroInicial.getEspaco());
	}	
	
	@Test
	public void CT19_testConstrutorCriaTabuleiroComTamanhoCorreto() {
	    Tabuleiro antigoTab = new Tabuleiro(6); 
	    Analise analise = new Analise(antigoTab);
	    assertEquals(6, analise.getNovoTab().getTamanho()); 
	}
}

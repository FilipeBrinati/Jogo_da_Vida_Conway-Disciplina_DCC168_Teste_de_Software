package main;

public class Analise {

	private Tabuleiro novoTab;
	
	public Analise(Tabuleiro antigoTab) {
		novoTab = new Tabuleiro(antigoTab.getTamanho());
	}

	public Tabuleiro getNovoTab() {
		return novoTab;
	}

	public void setNovoTab(Tabuleiro novoTab) {
		this.novoTab = novoTab;
	}
	
	/*
	 * A funcao executar deve:
	 * - Receber um Tabuleiro
	 * - Usar o antigo tabuleiro para criar um novo a partir das regras definidas
	 * - Retornar o novo tabuleiro gerado*/
	public Tabuleiro executar(Tabuleiro antigoTab) {
		int auxTamanho = antigoTab.getTamanho();
		Tabuleiro auxTab = new Tabuleiro(auxTamanho);
		int[][] auxEspaco = new int[auxTamanho][auxTamanho];
		for(int i = 0; i < antigoTab.getTamanho(); i++) {
			for(int j = 0; j < antigoTab.getTamanho(); j++) {
				auxEspaco[i][j] = identificar(antigoTab,i,j);
			}
		}
		auxTab.setEspaco(auxEspaco);
		return auxTab;
	}

	/*Aplica as regras que define se um espaco morre ou não:
	 * - Qualquer célula viva com menos de dois vizinhos vivos morre de solidão.
	 * - Qualquer célula viva com mais de três vizinhos vivos morre de superpopulação.
	 * - Qualquer célula morta com exatamente três vizinhos vivos se torna uma célula viva.
	 * - Qualquer célula com dois vizinhos vivos continua no mesmo estado para a próxima geração. */
	private int identificar(Tabuleiro antigoTab, int i, int j) {
		int auxTamanho = antigoTab.getTamanho();
        int[][] direcoes = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},          {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        int vizinhosVivos = 0;
        int estadoAtual = antigoTab.getEspacoEspecifico(i, j);

        for (int[] direcao : direcoes) {
            int novoX = i + direcao[0];
            int novoY = j + direcao[1];

            if (novoX >= 0 && novoX < auxTamanho && novoY >= 0 && novoY < auxTamanho) {
                vizinhosVivos += antigoTab.getEspacoEspecifico(novoX, novoY);
            }
        }

        if (estadoAtual == 1) {
            if (vizinhosVivos < 2 || vizinhosVivos > 3) {
                return 0;
            }
            return 1; 
        } else { 
            if (vizinhosVivos == 3) {
                return 1;
            }
            return 0;
        }
	}
}

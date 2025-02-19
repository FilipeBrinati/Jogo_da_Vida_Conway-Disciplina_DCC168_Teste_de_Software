package main;


public class Tabuleiro {
	
	private int[][] espaco;
	private int tamanho;
	

	public Tabuleiro(int tamanho) {
		this.tamanho = tamanho;
		espaco = new int[tamanho][tamanho];
		generateEmptyEspaco();
	}
	
	/*Cria um tabuleiro com todos os espacos igual a 0*/
	private void generateEmptyEspaco() {
		for(int i=0; i<this.tamanho;i++) {
			for(int j=0;j<this.tamanho;j++) {
				this.espaco[i][j] = 0;
			}
		}
	}

	/*Cria um tabuleiro com valores de 0 e 1 de forma aleatória*/
	public void generateRandomEspaco() {
		for(int i=0; i<this.tamanho;i++) {
			for(int j=0;j<this.tamanho;j++) {
				this.espaco[i][j] = Math.random() < 0.5 ? 0 : 1;
			}
		}
	}
	
	/*Imprime os espacos na tabela*/
	public void printEspaco() {
		for(int i=0; i<this.tamanho;i++) {
			System.out.println("");
			for(int j=0;j<this.tamanho;j++) {
				System.out.print(" | " + this.espaco[i][j]);
			}
			System.out.print(" |");
		}
		System.out.println("");
	}
	
	public int[][] getEspaco() {
		return espaco;
	}
	public void setEspaco(int[][] espaco) {
		this.espaco = espaco;
	}
	public int getEspacoEspecifico(int x, int y) {
		return espaco[x][y];
	}
	public int getTamanho() {return tamanho;}
	public static void main (String [] args) {
		Tabuleiro t = new Tabuleiro(6);
		t.printEspaco();
		t.generateRandomEspaco();
		t.printEspaco();
	}

	
	

}

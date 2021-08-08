package puzzle_8;

import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class No {

//	private int[] x = { 2, 0, 0, 0, 1, 1, 1, 2, 2 };
//	private int[] y = { 2, 0, 1, 2, 0, 1, 2, 0, 1 };

	private int matrizObj[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, -1 } };
	public int[][] state = new int[3][3];

	private No noUp;
	private No noDown;
	private No noRight;
	private No noLeft;
	private No noDad;
	private String posicao;

	public int h = 0;
	public int f = 0;

	private int profun;

	public No(int stateInit[][]) {

		for (int i = 0; i < stateInit.length; i++) {
			for (int j = 0; j < stateInit.length; j++) {
				this.state[i][j] = stateInit[i][j];
			}
		}

		this.noUp = null;
		this.noDown = null;
		this.noRight = null;
		this.noLeft = null;

//		this.g = 0;
//		this.noDad = null;
	}

	public No getNoDad() {
		return noDad;
	}

	public void setNoDad(No noDad) {
		this.noDad = noDad;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public No getNoUp() {
		return noUp;
	}

	public No getNoDown() {
		return noDown;
	}

	public No getNoRight() {
		return noRight;
	}

	public No getNoLeft() {
		return noLeft;
	}

	public int getProfun() {
		return profun;
	}

	public void setProfun(int profun) {
		this.profun = profun;
	}

	// Verifica se é o estado pesquisado
	public boolean isState() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (this.matrizObj[i][j] != this.state[i][j]) {
					return false;
				}
			}
		}

		return true;
	}

	// Mover para cima
	public No moveUp() {

		int[][] stateUp = new int[3][3];
		int l = 0, c = 0;

		// Copia o vetor e verifico se vai existir
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				stateUp[i][j] = this.state[i][j];

				if (this.state[i][j] == -1) {
					if (i == 0) {
						return null;
					}
					l = i;
					c = j;
				}

			}
		}

		if (this.state[l][c] == -1) {

			if (l > 0) {
				int valor = stateUp[l - 1][c];
				stateUp[l - 1][c] = -1;
				stateUp[l][c] = valor;
			}
		}

		No filho = new No(stateUp);
		filho.setPosicao("UP");
		filho.setNoDad(this);
		filho.setProfun(this.getProfun() + 1);
//		this.setNoDad(filho);
		return filho;
	}

	// Mover para direita
	public No moveRight() {

		int[][] stateUp = new int[3][3];
		int l = 0, c = 0;

		// Copia o vetor e verifico se vai existir
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				stateUp[i][j] = this.state[i][j];

				if (this.state[i][j] == -1) {
					if (j == 2) {
						return null;
					}

					l = i;
					c = j;
				}

			}
		}

		if (this.state[l][c] == -1) {
			if (c < 2) {
				int valor = stateUp[l][c + 1];
				stateUp[l][c + 1] = -1;
				stateUp[l][c] = valor;
			}
		}

		No filho = new No(stateUp);
		filho.setPosicao("Right");
		filho.setNoDad(this);
		filho.setProfun(this.getProfun() + 1);
//		this.setNoDad(filho);
		return filho;
	}

	// Mover para Baixo
	public No moveDown() {

		int[][] stateUp = new int[3][3];
		int l = 0, c = 0;

		// Copia o vetor e verifico se vai existir
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				stateUp[i][j] = this.state[i][j];

				if (this.state[i][j] == -1) {
					if (i == 2) {
						return null;
					}

					l = i;
					c = j;
				}

			}
		}

		if (this.state[l][c] == -1) {
			if (l < 2) {
				int valor = stateUp[l + 1][c];
				stateUp[l + 1][c] = -1;
				stateUp[l][c] = valor;
			}
		}

		No filho = new No(stateUp);
		filho.setPosicao("Down");
//		this.setNoDad(filho);
		filho.setNoDad(this);
		filho.setProfun(this.getProfun() + 1);
		return filho;
	}

	// Move para esquerda
	public No moveLeft() {

		int[][] stateUp = new int[3][3];
		int l = 0, c = 0;

		// Copia o vetor e verifico se vai existir
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				stateUp[i][j] = this.state[i][j];

				if (this.state[i][j] == -1) {
					if (j == 0) {
						return null;
					}

					l = i;
					c = j;
				}

			}
		}

		if (this.state[l][c] == -1) {
			if (c > 0) {
				int valor = stateUp[l][c - 1];
				stateUp[l][c - 1] = -1;
				stateUp[l][c] = valor;
			}
		}

		No filho = new No(stateUp);
		filho.setPosicao("Left");
//		this.setNoDad(filho);
		filho.setNoDad(this);
		filho.setProfun(this.getProfun() + 1);
		return filho;
	}

	public ArrayList gerarFilhos() {

		ArrayList<No> filhos = new ArrayList<No>();
		filhos.add(this.moveUp());
		filhos.add(this.moveRight());
		filhos.add(this.moveDown());
		filhos.add(this.moveLeft());

		return filhos;
	}

	public String transformVisit() {
		String aux = "";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				aux += Integer.toString(this.state[i][j]);
			}
		}

		return aux;
	}

	public No menor(ArrayList<No> list) {
		// Menor custo F

		No aux = list.get(0);

		for (No element : list) {
			if (element.f < aux.f) {
				aux = element;
			}
		}

		return aux;
	}

	public ArrayList sortFila(ArrayList<No> list) {
		// Menor custo F

		ArrayList<No> novaFila = new ArrayList<No>();
		No aux;

		for (int i = 0; i < list.size(); i++) {
			aux = menor(list);
			novaFila.add(aux);
			list.remove(aux);

		}

		return novaFila;
	}

	private int calcManattan(int x1, int y1, int x2, int y2) {
		return (Math.abs(x2 - x1) + Math.abs(y2 - y1));
	}

	private int[] searchPosition(int[][] valor, int procurar) {

		int position[] = new int[2];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (this.state[i][j] == procurar) {
					position[0] = i;
					position[1] = j;
//					System.out.println("------------------------");
//					System.out.println(procurar);
//					System.out.println(this.state[i][j]);
//					System.out.println("------------------------");
					return position;
				}
			}
		}

		return position;

	}

	public int manhattanDistance() {
		// H(X)
		String currentState = this.transformVisit();
		String goalSate = "12345678-1";

//		System.out.println(currentState);

		int difference = 0;
		for (int i = 0; i < currentState.length(); i += 1)
			for (int j = 0; j < goalSate.length(); j += 1)
				if (currentState.charAt(i) == goalSate.charAt(j))
					difference = difference + ((Math.abs(i % 3 - j % 3)) + Math.abs(i / 3 + j / 3));

		return difference;
	}

	public int manhattanDistance2() {
		// H(X)

		int valor = 0, deveria = 0, te;
		int position[] = new int[2];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				if (this.state[i][j] == this.matrizObj[i][j]) {
					valor += 0;
				} else {
					deveria = this.matrizObj[i][j];

					if (deveria != -1) {
						position = searchPosition(this.state, deveria);
						te = calcManattan(i, j, position[0], position[1]);
						valor = valor + te;

//						System.out.println("------------------------");
//						System.out.println(position[0]);
//						System.out.println(position[1]);
//						System.out.println(i);
//						System.out.println(j);
//						System.out.println(this.state[2][1]);
//						System.out.println(deveria);
//						System.out.println(te);
//						System.out.println("------------------------");
					}

				}

			}
		}

//		System.out.println(valor);
		return valor;
	}

	public int f() {
		// soma g+h
		return this.profun + this.h;
	}

}

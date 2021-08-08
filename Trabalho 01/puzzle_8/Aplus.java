package puzzle_8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Aplus {

	// F(X) = H(X) + G(X) -> G(X) Profudidade do Nó.

	private int max_search_depth = 0;
	private int max_frontier_size = 0;

	private ArrayList<No> filaNoOpen = new ArrayList<No>();
	private ArrayList<No> filaNoClose = new ArrayList<No>();
	public Set<String> statesVisit = new HashSet<String>();

	public Aplus() {
		// Construtor
	}

	public int getMax_search_depth() {
		return max_search_depth;
	}

	public int getMax_frontier_size() {
		return max_frontier_size;
	}

	public void buscar(No state) {

		No aux;
		ArrayList<No> filhos;

		state.setProfun(0);
		state.f = 0;

		filaNoOpen.add(state);

		while (true) {

			aux = filaNoOpen.remove(0);
			filaNoClose.add(aux);

			if (aux.isState()) {
//				System.out.println("---------------------");
				result(filaNoClose);
//				System.out.println("---------------------");
				return;
			}

			filhos = aux.gerarFilhos();

			for (No element : filhos) {

				if (element != null) {

					// Calculo do Heuristica
					element.h = element.manhattanDistance2();

					element.f += element.f();

					// Add na fila
					filaNoOpen.add(element);

					if (element.getProfun() > this.max_search_depth) {
						this.max_search_depth += 1;
					}

				}
			}

			this.max_frontier_size += filaNoOpen.size();

			// Cria uma nova fila ordenada
			filaNoOpen = aux.sortFila(filaNoOpen);

		}

	}

	public void result(ArrayList<No> listN) {

		for (No n : listN) {

			System.out.println("----------------------------------");
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(n.state[i][j] + " ");
				}
				System.out.println("");
			}
			System.out.println(n.getPosicao());
			System.out.println("----------------------------------");
			
//			System.out.println(n.getProfun());

		}
	}
}

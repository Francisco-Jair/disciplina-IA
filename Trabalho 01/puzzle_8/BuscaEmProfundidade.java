package puzzle_8;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.ArrayList;

public class BuscaEmProfundidade {

	// Nós colocar em arquivo

	private int max_search_depth = 0; // profundidade máxima atingida
	private long max_frontier_size = 0; // Memoria

	public Stack<No> pilhaNos;
	public Set<String> statesVisit = new HashSet<String>();

	public BuscaEmProfundidade() {
		this.pilhaNos = new Stack<No>();
	}

	public int getMax_search_depth() {
		return max_search_depth;
	}

	public long getMax_frontier_size() {
		return max_frontier_size;
	}

	public void buscar(No state) {

		No aux = null;
		ArrayList<No> filhos;

		state.setProfun(0);
		pilhaNos.push(state);

		while (!pilhaNos.empty()) {
			aux = pilhaNos.pop();
			statesVisit.add(aux.transformVisit());

			if (aux.isState()) {
//				System.out.println("-----------");
//				System.out.println(aux.getProfun()); // Profudidade da solução
//				System.out.println("-----------");
				this.backtracking(aux);
				return;
			}

			filhos = aux.gerarFilhos();

			for (No f : filhos) {
				if (f != null && !statesVisit.contains(f.transformVisit())) {
					pilhaNos.push(f);
					statesVisit.add(f.transformVisit());

					if (f.getProfun() > this.max_search_depth) {
						this.max_search_depth += 1;
					}
				}
			}

			this.max_frontier_size += pilhaNos.size();
		}

	}

	public void backtracking(No initResult) {

		No aux = initResult;

		while (aux != null) {

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(aux.state[i][j] + " ");
				}
				System.out.println("");
			}

			System.out.println(aux.getPosicao());
//			System.out.println(aux.getProfun());

//			System.out.println("AQUI");
			aux = aux.getNoDad();

		}
	}
}

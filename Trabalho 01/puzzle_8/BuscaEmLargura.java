package puzzle_8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BuscaEmLargura {

	private int max_search_depth = 0; // profundidade máxima atingida
	private long max_frontier_size = 0; // Memoria

	private Queue<No> filaNo = new LinkedList<No>();
	public Set<String> statesVisit = new HashSet<String>();

	public BuscaEmLargura() {

	}

	public long getMax_frontier_size() {
		return max_frontier_size;
	}

	public int getMax_search_depth() {
		return max_search_depth;
	}

	public void buscar(No state) {

		No aux = null;
		ArrayList<No> filhos;

		state.setProfun(0);
		filaNo.add(state);

		while (filaNo.isEmpty() != true) {

			aux = filaNo.remove();
			statesVisit.add(aux.transformVisit());

			if (aux.isState()) {
//				System.out.println("----------------------");
//				System.out.println(aux.getProfun());
//				System.out.println("----------------------");
				backtracking(aux);
				return;
			}

			// Gera Filhos
			filhos = aux.gerarFilhos();

			for (No f : filhos) {
				if (f != null && !statesVisit.contains(f.transformVisit())) {
					filaNo.add(f);
					statesVisit.add(f.transformVisit());

					if (f.getProfun() > this.max_search_depth) {
						this.max_search_depth += 1;
					}
				}
			}

			this.max_frontier_size += filaNo.size();

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

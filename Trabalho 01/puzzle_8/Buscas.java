package puzzle_8;

public class Buscas {

	public static void main(String[] args) {

//		int matrizObj[][] = new int[][] { { 1, 2, 3 }, { 4, -1, 6 }, { 7, 5, 8 } }; // 1
		int matrizObj[][] = new int[][] { { 1, 2, 3 }, { 4, -1, 5 }, { 7, 8, 6 } }; // 2
//		int matrizObj[][] = new int[][] { { 1, 3, 6 }, { 4, 2, 8 }, { 7, 5, -1 } }; // 3

		// No inicial
		No noIni = new No(matrizObj);
		noIni.setNoDad(null);
		noIni.setPosicao("Inicial");

		// Busca em Profudidade

		BuscaEmProfundidade dfs = new BuscaEmProfundidade();
		dfs.buscar(noIni);
		System.out.println(dfs.getMax_search_depth());
		System.out.println(dfs.getMax_frontier_size());

		// Busca em Largura
//		BuscaEmLargura bfs = new BuscaEmLargura();
//		bfs.buscar(noIni);
//		System.out.println(bfs.getMax_search_depth());
//		System.out.println(bfs.getMax_frontier_size());

		// A*
//		Aplus astar = new Aplus();
//		astar.buscar(noIni);
//		System.out.println(astar.getMax_search_depth());
//		System.out.println(astar.getMax_frontier_size());

		// Busca Gulosa
//		BuscaGulosa bg = new BuscaGulosa();
//		bg.buscar(noIni);
//		System.out.println(bg.getMax_search_depth());
//		System.out.println(bg.getMax_frontier_size());
	}

}

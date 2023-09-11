import espacoDeEstados.*;
import estrategiasDeBusca.heuristica.*;
import estrategiasDeBusca.cega.*;

public class Main {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		//char[] cfgIni = {' ','2','3','1','4','6','7','5','8'};
		char[] cfgIni = {'2','4','3','7','1','6','5',' ','8'};
		//char[] cfgIni = {'2','3',' ','7','4','1','5','8','6'};
		//char[] cfgIni = {'7','2','3','4',' ','1','5','8','6'}; // OutOfMemory
		@SuppressWarnings("unused")
		char[] cfgEnd = {'1', '2', '3', '4', '5', '6', '7', ' ', '8'};

		Puzzle8 puzzleInicial = new Puzzle8();
		puzzleInicial.setEstado(cfgIni);
		puzzleInicial.setCusto(0);
		puzzleInicial.setAvaliacao( puzzleInicial.heuristica(Puzzle8.TABULEIRO_ORGANIZADO) );
			
		Puzzle8 puzzleFinal = new Puzzle8();
		puzzleFinal.setEstado( Puzzle8.TABULEIRO_ORGANIZADO );
		puzzleFinal.setCusto(0);
		puzzleFinal.setAvaliacao(0);
		
		@SuppressWarnings("unused")
		BuscaCega busca = new BuscaEmLargura();
		@SuppressWarnings("unused")
		BuscaCega buscaa = new BuscaEmProfundidade();
		@SuppressWarnings("unused")
		BuscaCega buusca = new BuscaEmProfundidadeLimitada(null, null, 5);
						
		BuscaInformada busca1 = new AStar();
		busca1.setInicio(puzzleInicial);
		busca1.setObjetivo(puzzleFinal);
		busca1.buscar();
		for(Estado e : busca1.getCaminhoSolucao()) {
			System.out.println(e);
		}

		System.exit(0);
	}

}

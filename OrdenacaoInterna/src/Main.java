import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe que modela a rotina de testes.
 */
public class Main {
    
    public static void main(String[] args) {

        /**
         *  Define a quantidade de Registros a ser utilizada nos testes.
         */
        final int quantidade = 500;

        /**
         *  Lista de Registros.
         */
        List<Registro> dadosDesordenadosSelection = new ArrayList<>();
        List<Registro> dadosDesordenadosInsertion = new ArrayList<>();
        List<Registro> dadosDesordenadosQuick = new ArrayList<>();
        List<Registro> dadosDesordenadosSort = new ArrayList<>();
        List<Registro> dadosDesordenadosShell = new ArrayList<>();

        /**
         *  Objeto responsável por realizar as ordenações.
         */
        Ordenador ordenador = new Ordenador();

        /**
         *  Variáveis usadas para o cálculo de tempo.
         */
        long tempoInicial;
        long tempoFinal;

        /**
         *  Preenche a lista com dados.
         */
        Registro reg;
        for(int index = 0; index < quantidade; index++){
            reg = new Registro();
            dadosDesordenadosSelection.add(index, reg);
            dadosDesordenadosInsertion.add(index,(Registro) reg.clone());
            dadosDesordenadosQuick.add(index, (Registro) reg.clone());
            dadosDesordenadosSort.add(index, (Registro) reg.clone());
            dadosDesordenadosShell.add(index, (Registro) reg.clone());
        }

        /**
         *  Mede o tempo de execução da ordenação por selection sort.
         */
        System.out.println("Ordenando os dados com Selection Sort...");
        tempoInicial = System.currentTimeMillis();
        ordenador.selectionSort(dadosDesordenadosSelection); 
        tempoFinal = System.currentTimeMillis();  
        System.out.println("Tempo gasto: " + (tempoFinal - tempoInicial) + "ms");

        /**
         *  Mede o tempo de execução da ordenação por insertion sort.
         */
        System.out.println("Ordenando os dados com Insertion Sort...");
        tempoInicial = System.currentTimeMillis();    
        ordenador.insertionSort(dadosDesordenadosInsertion);  
        tempoFinal = System.currentTimeMillis();  
        System.out.println("Tempo gasto: " + (tempoFinal - tempoInicial) + "ms");

        /**
         *  Mede o tempo de execução da ordenação por quicksort.
         */
        System.out.println("Ordenando os dados com Quicksort...");
        tempoInicial = System.currentTimeMillis();    
        ordenador.quickSort(dadosDesordenadosQuick); 
        tempoFinal = System.currentTimeMillis();  
        System.out.println("Tempo gasto: " + (tempoFinal - tempoInicial) + "ms");

        /**
         *  Mede o tempo de execução da ordenação por quicksort oferecido pela linguagem.
         */
        System.out.println("Ordenando os dados com Quicksort da linguagem...");
        tempoInicial = System.currentTimeMillis();    
        Collections.sort(dadosDesordenadosSort);
        tempoFinal = System.currentTimeMillis();  
        System.out.println("Tempo gasto: " + (tempoFinal - tempoInicial) + "ms");


        /**
         *  Mede o tempo de execução da ordenação por shell sort.
         */
        System.out.println("Ordenando os dados com Shell Sort...");
        tempoInicial = System.currentTimeMillis();    
        ordenador.shellSort(dadosDesordenadosShell);  
        tempoFinal = System.currentTimeMillis();  
        System.out.println("Tempo gasto: " + (tempoFinal - tempoInicial) + "ms");

    }

}
	
import java.util.List;

/**
 * Classe que abriga os métodos de ordenação empregados nos testes. 
 */
public class Ordenador {
    
    /**
     * Método que ordena utilizando o algoritmo insertion sort.
     * @param dadosDesordenados Lista a ser ordenada.
     */
    public void insertionSort(List<Registro> dadosDesordenados){
        int i, j;
        Registro swap;
        for (i = 0; i < dadosDesordenados.size(); i++) {
            swap = dadosDesordenados.get(i);
            for (j = (i - 1); j >= 0 && (dadosDesordenados.get(j).compareTo(swap) > 0); j--) {
                    dadosDesordenados.set(j+1, dadosDesordenados.get(j));
                    dadosDesordenados.set(j, swap);
            }
        }
    }

    /**
     * Método que ordena utilizando o algoritmo selection sort.
     * @param dadosDesordenados Lista a ser ordenada.
     */
    public void selectionSort(List<Registro> dadosDesordenados){
        int i, j, min;
        int aux;
        Registro swap;
        for (i = 0; i < (dadosDesordenados.size() - 1); i++) {
            min = i;
            for (j = (i + 1); j < dadosDesordenados.size(); j++) {
                aux = dadosDesordenados.get(j).compareTo(dadosDesordenados.get(min));
                if (aux < 0) {
                    min = j;
                }
            }
            if (i != min) {
                swap = dadosDesordenados.get(i);
                dadosDesordenados.set(i, dadosDesordenados.get(min));
                dadosDesordenados.set(min, swap);
            }
        }
    }


    /**
     * Método que utiliza o algoritmo quicksort para ordenação, ocultando detalhes relacionados a recursividade.
     * @param dadosDesordenados Lista a ser ordenada.
     */
    public void quickSort(List<Registro> dadosDesordenados){
        quicksort(dadosDesordenados, 0, dadosDesordenados.size()-1);
    }

    /**
     * Método recursivo de ordenação por quicksort.
     * @param dadosDesordenados Lista a ser ordenada.
     * @param low Inicio da lista.
     * @param high Fim da lista.
     */
    private void quicksort(List<Registro> dadosDesordenados, int inicio, int fim){
        if (inicio < fim){
            int posicaoPivo = separar(dadosDesordenados, inicio, fim);
            Ordenador.this.quicksort(dadosDesordenados, inicio, posicaoPivo - 1);
            Ordenador.this.quicksort(dadosDesordenados, posicaoPivo + 1, fim);
        }
    }

    /**
     * Método auxiliar para divisão da lista.
     * @param dadosDesordenados Lista a ser separada.
     * @param inicio Posição de inicio da lista.
     * @param fim Poisição de fim da lista.
     * @return Posição do pivo. 
     */
    private int separar(List<Registro> dadosDesordenados, int inicio, int fim) {
        Registro pivo = dadosDesordenados.get(inicio);
        int i = inicio + 1, f = fim;
        while (i <= f){
            if (!(dadosDesordenados.get(i).compareTo(pivo)> 0))
                i++;
            else if (pivo.compareTo(dadosDesordenados.get(f)) < 0)
                f--;
            else {
                swap(dadosDesordenados, i, f);
                i++;
                f--;
            }
        }
        dadosDesordenados.set(inicio,dadosDesordenados.get(f));
        dadosDesordenados.set(f, pivo);
        return f;
    }

    /**
     * Método que ordena utilizando o algoritmo shell sort.
     * @param dadosDesordenados Lista a ser ordenada.
     */
    public void shellSort(List<Registro> dadosDesordenados){
        int tamanho = dadosDesordenados.size();
        int h = 1;

        while (h < tamanho/3) 
            h = 3*h + 1; 

        while (h >= 1) {
            for (int i = h; i < tamanho; i++) {
                for (int j = i; j >= h && less(dadosDesordenados.get(j), dadosDesordenados.get(j-h)); j -= h) {
                    swap(dadosDesordenados, j, j-h);
                }
            }
            h /= 3;
        }
    }

    /**
     * Método auxiliar que realiza a troca de registros.
     * @param lista Lista contendo os registros.
     * @param x Posição do elemento a participar da troca.
     * @param y Posição do elemento a participar da troca.
     */
    private void swap (List<Registro> lista, int x, int y) {
        Registro temp = lista.get(x);
        lista.set(x,lista.get(y));
        lista.set(y, temp);
    }

    /**
     * Método auxiliar que transforma o resultado da comparação entre dois elementos em um booleano.
     * @param v Elemento sendo comparado.
     * @param w Elemento sendo comparado.
     * @return true caso v seja menor que w.
     */
    private boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }
        
}

import java.util.Locale;

public class Algoritmos {
    public static int[] bubbleSort(int[] vetor){
        int n = vetor.length;
//      criamos um vetor auxiliar para não modificar o vetor original
        int[] aux = new int[n];
        for (int i = 0; i < n; i++) {
            aux[i] = vetor[i];
        }
        long inicio = System.nanoTime();
        int temp;
        int trocas = 0;
        int iteracoes = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n-i); j++) {
                iteracoes++;
                if(aux[j-1] > aux[j]){
                    trocas++;
                    temp = aux[j-1];
                    aux[j-1] = aux[j];
                    aux[j] = temp;
                }
            }
        }
        long fim = System.nanoTime();
        float tempo = (float) (fim - inicio) / 1000000000;
        System.out.printf(Locale.UK, "Bubble Sort,%d,%.6f,%d,%d\n", n, tempo, trocas, iteracoes);
        return aux;
    }

    public static int[] selectionSort(int[] vetor){
        int n = vetor.length;
        int[] aux = new int[n];
        for (int i = 0; i < n; i++) {
            aux[i] = vetor[i];
        }
        long inicio = System.nanoTime();
        int trocas = 0;
        int iteracoes = 0;

        for (int i = 0; i < n-1; i++) {
            int indiceMenor = i;
            for (int j = i+1; j < n; j++) {
                iteracoes++;
                if(aux[j] < aux[indiceMenor]){
                    indiceMenor = j;
                }
            }
            int temp = aux[indiceMenor];
            aux[indiceMenor] = aux[i];
            aux[i] = temp;
            trocas++;
        }

        long fim = System.nanoTime();
        float tempo = (float) (fim - inicio) / 1000000000;
        System.out.printf(Locale.UK, "Selection Sort,%d,%.6f,%d,%d\n", n, tempo, trocas, iteracoes);
        return aux;
    }

    public static int[] shellSort(int[] vetor){
        int n = vetor.length;
        int[] aux = new int[n];
        for (int i = 0; i < n; i++) {
            aux[i] = vetor[i];
        }
        long inicio = System.nanoTime();
        int trocas = 0;
        int iteracoes = 0;

        int intervalo = 1;
        while (intervalo < n) {
            intervalo = intervalo * 3 + 1;
        }

        while (intervalo > 1) {
            intervalo /= 3;
            for (int i = intervalo; i < n; i++) {
                int valor = aux[i];
                int j = i;
                iteracoes++;
                while (j >= intervalo && aux[j - intervalo] > valor) {
                    trocas++;
                    aux[j] = aux[j - intervalo];
                    j -= intervalo;
                }
                aux[j] = valor;
            }
        }

        long fim = System.nanoTime();
        float tempo = (float) (fim - inicio) / 1000000000;
        System.out.printf(Locale.UK, "Shell Sort,%d,%.6f,%d,%d\n", n, tempo, trocas, iteracoes);
        return aux;
    }

    public static int[] mergeSort(int[] vetor) {
        int n = vetor.length;
        int[] aux = new int[n];
        for (int i = 0; i < n; i++) {
            aux[i] = vetor[i];
        }
        long inicio = System.nanoTime();
        int[] contagens = mergeSortRecursivo(aux, 0, n - 1);
        int trocas = contagens[0];
        int iteracoes = contagens[1];
        long fim = System.nanoTime();
        float tempo = (float) (fim - inicio) / 1000000000;
        System.out.printf(Locale.UK, "Merge Sort,%d,%.6f,%d,%d\n", n, tempo, trocas, iteracoes);
        return aux;
    }

    private static int[] mergeSortRecursivo(int[] vetor, int inicio, int fim) {
        int[] contagens = new int[2]; // Array para contar trocas e iterações
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;

            int[] contagensEsquerda = mergeSortRecursivo(vetor, inicio, meio);
            int[] contagensDireita = mergeSortRecursivo(vetor, meio + 1, fim);

            int trocas = contagensEsquerda[0] + contagensDireita[0];
            int iteracoes = contagensEsquerda[1] + contagensDireita[1];

            contagens[0] = trocas;
            contagens[1] = iteracoes;

            merge(vetor, inicio, meio, fim, contagens);
        }
        return contagens;
    }

    private static void merge(int[] vetor, int inicio, int meio, int fim, int[] contagem) {
        int[] aux = new int[vetor.length];
        for (int i = inicio; i <= fim; i++) {
            aux[i] = vetor[i];
        }

        int indiceEsquerda = inicio;
        int indiceDireita = meio + 1;
        int indiceAtual = inicio;

        while (indiceEsquerda <= meio && indiceDireita <= fim) {
            contagem[1]++;
            if (aux[indiceEsquerda] <= aux[indiceDireita]) {
                vetor[indiceAtual] = aux[indiceEsquerda];
                indiceEsquerda++;
            } else {
                vetor[indiceAtual] = aux[indiceDireita];
                indiceDireita++;
                contagem[0]++;
            }
            indiceAtual++;
        }

        while (indiceEsquerda <= meio) {
            vetor[indiceAtual] = aux[indiceEsquerda];
            indiceAtual++;
            indiceEsquerda++;
        }
    }


}

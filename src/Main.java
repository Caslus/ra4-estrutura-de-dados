import java.util.Random;

public class Main {
    static Random random = new Random(40028922);

    public static int[] randomVetor(int tamanho){
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] vetor50 = randomVetor(50);
        int[] vetor500 = randomVetor(500);
        int[] vetor1000 = randomVetor(1000);
        int[] vetor5000 = randomVetor(5000);
        int[] vetor10000 = randomVetor(10000);
        int[][] vetores = {vetor50, vetor500, vetor1000, vetor5000, vetor10000};

        for (int[] vetor: vetores) {
            for (int i = 0; i < 5; i++) {
                Algoritmos.bubbleSort(vetor);
            }
            for (int i = 0; i < 5; i++) {
                Algoritmos.selectionSort(vetor);
            }
            for (int i = 0; i < 5; i++) {
                Algoritmos.shellSort(vetor);
            }
            for (int i = 0; i < 5; i++) {
                Algoritmos.mergeSort(vetor);
            }
        }
    }
}
package org.example.Algoritmos;

public class BubbleSort {
    public static void ordenar(int[] vetor) {

        int contador = 0;
        long tempoInicio = System.currentTimeMillis();

        for (int i = 0; i < vetor.length; i++) {
            boolean trocou = true;

            for (int j = 0; j < (vetor.length - 1); j++) {
                // se o elemento atual for maior que o próximo, troca os dois de lugar
                if (vetor[j] > vetor[j + 1]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                    trocou = false;
                    contador++;
                }
            }

            // se nenhuma troca ocorreu na passagem, o vetor já está ordenado
            if (trocou) {
                break;
            }
        }

        System.out.println("\nProcessos do Bubble: " + contador);
        System.out.println("Tempo do Bubble: " + (System.currentTimeMillis() - tempoInicio) + "ms");
        // System.out.println("Vetor Organizado (Bubble): " + Arrays.toString(vetor));
    }
}
package org.example.Algoritmos;

public class SelectionSort {
    public static void ordenar(int[] vetor) {

        int contador = 0;
        long tempoInicio = System.currentTimeMillis();

        for (int j = 0; j < (vetor.length - 1); j++) {
            // assume que o menor elemento da parte não ordenada está na posição j
            int menor = j;

            for (int i = j + 1; i < vetor.length; i++) {
                // procura o índice do menor elemento no restante do vetor
                if (vetor[i] < vetor[menor]) {
                    menor = i;
                    contador++;
                }
            }

            // coloca o menor elemento encontrado na posição j (sua posição correta)
            int aux = vetor[j];
            vetor[j] = vetor[menor];
            vetor[menor] = aux;
        }

        System.out.println("\nProcessos do Selection: " + contador);
        System.out.println("Tempo do Selection: " + (System.currentTimeMillis() - tempoInicio) + "ms");
        // System.out.println("Vetor Organizado (Selection): " + Arrays.toString(vetor));
    }
}

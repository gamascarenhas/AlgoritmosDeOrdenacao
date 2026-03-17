package org.example;

import java.util.Arrays;

public class InsertionSort {
    public static void ordenar(int[] vetor) {

        int contador = 0;
        long tempoInicio = System.currentTimeMillis();

        for (int i = 1; i < vetor.length; i++) {
            int aux = vetor[i];
            int j;

            for (j = i - 1; j >=0 && aux < vetor[j]; j--) {
                vetor[j + 1] = vetor[j];
                contador ++;
            }
            vetor[j + 1] = aux;
        }

        System.out.println("\nProcessos do Insertion: " + contador);
        System.out.println("Tempo do Insertion: " + (System.currentTimeMillis() - tempoInicio) + "ms");
        // System.out.println("Vetor Organizado (Insertion): " + Arrays.toString(vetor));
    }
}
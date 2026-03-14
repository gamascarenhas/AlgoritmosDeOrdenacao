package org.example;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    public static void ordenar(int[] vetor) {

        int contador = 0;
        long tempoInicio = System.currentTimeMillis();

        for (int j = 0; j < (vetor.length - 1); j++) {
            int menor = j;

            for (int i = j + 1; i < vetor.length; i++) {

                if (vetor[i] < vetor[menor]) {
                    menor = i;
                    contador++;
                }
            }

            int aux = vetor[j];
            vetor[j] = vetor[menor];
            vetor[menor] = aux;

        }


        System.out.println("\nProcessos do Selection: " + contador);
        System.out.println("Tempo do Selection: " + (System.currentTimeMillis() - tempoInicio) + "ms");
        // System.out.println("Vetor Organizado (Selection): " + Arrays.toString(vetor));
    }
}

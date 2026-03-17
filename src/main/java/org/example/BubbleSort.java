package org.example;

import java.util.Arrays;

public class BubbleSort {
    public static void ordenar(int[] vetor) {

        int contador = 0;
        long tempoInicio = System.currentTimeMillis();

        for (int i = 0; i < vetor.length; i++) {
            boolean trocou = true;

            for (int j = 0; j < (vetor.length - 1); j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                    trocou = false;
                    contador++;
                }
            }
            if (trocou) {
                break;
            }
        }

        System.out.println("\nProcessos do Bubble: " + contador);
        System.out.println("Tempo do Bubble: " + (System.currentTimeMillis() - tempoInicio) + "ms");
        // System.out.println("Vetor Organizado (Bubble): " + Arrays.toString(vetor));
    }
}
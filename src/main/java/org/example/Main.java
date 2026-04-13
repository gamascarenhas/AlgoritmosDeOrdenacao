package org.example;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] vetor = new int[4000];
        Random random = new Random();

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = i;
        }

        for (int i = 0; i < vetor.length; i++) {
            int j = random.nextInt(vetor.length);
            int aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
        }

        // System.out.println("Vetor Inicial: " + Arrays.toString(vetor));

        int[] vetorParaInsertion = vetor.clone();
        int[] vetorParaSelection = vetor.clone();
        int[] vetorParaBubble = vetor.clone();
        int[] vetorParaShell = vetor.clone();

        InsertionSort.ordenar(vetorParaInsertion);
        SelectionSort.ordenar(vetorParaSelection);
        BubbleSort.ordenar(vetorParaBubble);
        ShellSort.ordenar(vetorParaShell);

    }
}

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

        int[] vetorParaBubble    = vetor.clone();
        int[] vetorParaSelection = vetor.clone();
        int[] vetorParaInsertion = vetor.clone();
        int[] vetorParaShell     = vetor.clone();
        int[] vetorParaHeap      = vetor.clone();
        int[] vetorParaMerge     = vetor.clone();
        int[] vetorParaQuick     = vetor.clone();

        BubbleSort.ordenar(vetorParaBubble);
        SelectionSort.ordenar(vetorParaSelection);
        InsertionSort.ordenar(vetorParaInsertion);
        ShellSort.ordenar(vetorParaShell);
        HeapSort.ordenar(vetorParaHeap);
        MergeSort.ordenar(vetorParaMerge);
        QuickSort.ordenar(vetorParaQuick);

    }
}

package org.example.Algoritmos;

public class TimSort {

    // tamanho mínimo de cada "run" (bloco ordenado pelo insertion sort)
    private static final int RUN = 32;

    public static void ordenar(int[] vetor) {

        int n = vetor.length;
        int contador = 0;
        long tempoInicio = System.currentTimeMillis();

        // fase 1: ordena cada bloco de tamanho RUN com insertion sort
        for (int i = 0; i < n; i += RUN) {
            int fim = Math.min(i + RUN - 1, n - 1);
            contador = insertionSortParcial(vetor, i, fim, contador);
        }

        // fase 2: intercala os blocos ordenados, dobrando o tamanho a cada rodada
        for (int tamanho = RUN; tamanho < n; tamanho *= 2) {
            for (int inicio = 0; inicio < n; inicio += 2 * tamanho) {
                // calcula o meio e o fim do par de blocos a intercalar
                int meio = Math.min(inicio + tamanho - 1, n - 1);
                int fim  = Math.min(inicio + 2 * tamanho - 1, n - 1);

                // só intercala se o segundo bloco existir
                if (meio < fim) {
                    contador = intercalar(vetor, inicio, meio, fim, contador);
                }
            }
        }

        System.out.println("\nProcessos do Tim: " + contador);
        System.out.println("Tempo do Tim: " + (System.currentTimeMillis() - tempoInicio) + "ms");
        // System.out.println("Vetor Organizado (Tim): " + Arrays.toString(vetor));
    }

    private static int insertionSortParcial(int[] vetor, int inicio, int fim, int contador) {

        for (int i = inicio + 1; i <= fim; i++) {
            // guarda o elemento atual para inseri-lo na posição correta dentro do bloco
            int aux = vetor[i];
            int j = i - 1;

            // desloca para a direita os elementos maiores que aux dentro do bloco
            while (j >= inicio && vetor[j] > aux) {
                vetor[j + 1] = vetor[j];
                j--;
                contador++;
            }

            // insere aux na posição correta encontrada
            vetor[j + 1] = aux;
        }

        return contador;
    }

    private static int intercalar(int[] vetor, int inicio, int meio, int fim, int contador) {

        // calcula os tamanhos das duas metades
        int tamanhoEsquerda = meio - inicio + 1;
        int tamanhoDireita  = fim - meio;

        // cria vetores auxiliares temporários para cada metade
        int[] esquerda = new int[tamanhoEsquerda];
        int[] direita  = new int[tamanhoDireita];

        // copia os dados para os vetores auxiliares
        for (int i = 0; i < tamanhoEsquerda; i++) {
            esquerda[i] = vetor[inicio + i];
        }
        for (int j = 0; j < tamanhoDireita; j++) {
            direita[j] = vetor[meio + 1 + j];
        }

        // intercala os dois vetores auxiliares de volta ao vetor original em ordem
        int i = 0, j = 0, k = inicio;

        while (i < tamanhoEsquerda && j < tamanhoDireita) {
            if (esquerda[i] <= direita[j]) {
                vetor[k] = esquerda[i];
                i++;
            } else {
                vetor[k] = direita[j];
                j++;
            }
            k++;
            contador++;
        }

        // copia os elementos restantes da metade esquerda, se houver
        while (i < tamanhoEsquerda) {
            vetor[k] = esquerda[i];
            i++;
            k++;
        }

        // copia os elementos restantes da metade direita, se houver
        while (j < tamanhoDireita) {
            vetor[k] = direita[j];
            j++;
            k++;
        }

        return contador;
    }
}
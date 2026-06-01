package org.example.Algoritmos;

public class MergeSort {
    public static void ordenar(int[] vetor) {

        int contador = 0;
        long tempoInicio = System.currentTimeMillis();

        // inicia a recursão cobrindo o vetor inteiro
        contador = ordenarRecursivo(vetor, 0, vetor.length - 1, contador);

        System.out.println("\nProcessos do Merge: " + contador);
        System.out.println("Tempo do Merge: " + (System.currentTimeMillis() - tempoInicio) + "ms");
        // System.out.println("Vetor Organizado (Merge): " + Arrays.toString(vetor));
    }

    private static int ordenarRecursivo(int[] vetor, int inicio, int fim, int contador) {

        if (inicio < fim) {
            // calcula o índice do meio para dividir o vetor em duas metades
            int meio = (inicio + fim) / 2;

            // divide e ordena recursivamente a metade esquerda
            contador = ordenarRecursivo(vetor, inicio, meio, contador);

            // divide e ordena recursivamente a metade direita
            contador = ordenarRecursivo(vetor, meio + 1, fim, contador);

            // intercala as duas metades já ordenadas
            contador = intercalar(vetor, inicio, meio, fim, contador);
        }

        return contador;
    }

    private static int intercalar(int[] vetor, int inicio, int meio, int fim, int contador) {

        // calcula os tamanhos das duas metades
        int tamanhoEsquerda = meio - inicio + 1;
        int tamanhoDireita = fim - meio;

        // cria vetores auxiliares temporários para cada metade
        int[] esquerda = new int[tamanhoEsquerda];
        int[] direita = new int[tamanhoDireita];

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
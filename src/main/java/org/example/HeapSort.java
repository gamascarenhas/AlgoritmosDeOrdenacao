package org.example;

public class HeapSort {
    public static void ordenar(int[] vetor) {

        int n = vetor.length;
        int contador = 0;
        long tempoInicio = System.currentTimeMillis();

        // fase 1: constrói o max-heap a partir do vetor desordenado
        // começa pelo último nó interno e aplica heapify de baixo para cima
        for (int i = n / 2 - 1; i >= 0; i--) {
            contador = heapify(vetor, n, i, contador);
        }

        // fase 2: extrai os elementos do heap um a um, do maior para o menor
        for (int i = n - 1; i > 0; i--) {
            // move a raiz atual (maior elemento) para o final do vetor
            int aux = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = aux;
            contador++;

            // restaura a propriedade de max-heap no heap reduzido (sem o último elemento)
            contador = heapify(vetor, i, 0, contador);
        }

        System.out.println("\nProcessos do Heap: " + contador);
        System.out.println("Tempo do Heap: " + (System.currentTimeMillis() - tempoInicio) + "ms");
        // System.out.println("Vetor Organizado (Heap): " + Arrays.toString(vetor));
    }

    private static int heapify(int[] vetor, int tamanho, int i, int contador) {

        // assume que o nó atual (i) é o maior entre ele e seus filhos
        int maior = i;

        // calcula os índices dos filhos esquerdo e direito na representação em array
        int esquerdo = 2 * i + 1;
        int direito  = 2 * i + 2;

        // verifica se o filho esquerdo existe e é maior que o nó atual
        if (esquerdo < tamanho && vetor[esquerdo] > vetor[maior]) {
            maior = esquerdo;
        }

        // verifica se o filho direito existe e é maior que o maior encontrado até agora
        if (direito < tamanho && vetor[direito] > vetor[maior]) {
            maior = direito;
        }

        // se o maior não é o nó atual, troca e propaga a correção para baixo
        if (maior != i) {
            int aux = vetor[i];
            vetor[i] = vetor[maior];
            vetor[maior] = aux;
            contador++;

            // aplica heapify recursivamente na subárvore afetada pela troca
            contador = heapify(vetor, tamanho, maior, contador);
        }

        return contador;
    }
}
package org.example.Algoritmos;

public class QuickSort {
    public static void ordenar(int[] vetor) {

        int contador = 0;
        long tempoInicio = System.currentTimeMillis();

        // inicia a recursão cobrindo o vetor inteiro
        contador = ordenarRecursivo(vetor, 0, vetor.length - 1, contador);

        System.out.println("\nProcessos do Quick: " + contador);
        System.out.println("Tempo do Quick: " + (System.currentTimeMillis() - tempoInicio) + "ms");
        // System.out.println("Vetor Organizado (Quick): " + Arrays.toString(vetor));
    }

    private static int ordenarRecursivo(int[] vetor, int inicio, int fim, int contador) {

        if (inicio < fim) {
            // particiona o vetor e obtém a posição final do pivô
            int[] resultado = particionar(vetor, inicio, fim, contador);
            int indicePivo = resultado[0];
            contador = resultado[1];

            // ordena recursivamente a metade esquerda (elementos menores que o pivô)
            contador = ordenarRecursivo(vetor, inicio, indicePivo - 1, contador);

            // ordena recursivamente a metade direita (elementos maiores que o pivô)
            contador = ordenarRecursivo(vetor, indicePivo + 1, fim, contador);
        }

        return contador;
    }

    private static int[] particionar(int[] vetor, int inicio, int fim, int contador) {

        // escolhe o último elemento como pivô
        int pivo = vetor[fim];

        // i aponta para a posição onde o próximo elemento menor que o pivô será inserido
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            // se o elemento atual for menor ou igual ao pivô, ele pertence ao lado esquerdo
            if (vetor[j] <= pivo) {
                i++;

                // troca vetor[i] com vetor[j] para mover o elemento menor para a esquerda
                int aux = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = aux;
                contador++;
            }
        }

        // posiciona o pivô entre as duas metades: i+1 é sua posição definitiva
        int aux = vetor[i + 1];
        vetor[i + 1] = vetor[fim];
        vetor[fim] = aux;

        // retorna a posição final do pivô junto ao contador atualizado
        return new int[]{i + 1, contador};
    }
}
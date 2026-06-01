package org.example.Algoritmos;

import java.util.Arrays;

public class RadixSort {
    public static void ordenar(int[] vetor) {

        int contador = 0;
        long tempoInicio = System.currentTimeMillis();

        // encontra o valor máximo para saber quantos dígitos precisam ser processados
        int maximo = Arrays.stream(vetor).max().getAsInt();

        // processa o vetor dígito a dígito, do menos significativo ao mais significativo
        for (int exp = 1; maximo / exp > 0; exp *= 10) {
            contador = countingSortPorDigito(vetor, exp, contador);
        }

        System.out.println("\nProcessos do Radix: " + contador);
        System.out.println("Tempo do Radix: " + (System.currentTimeMillis() - tempoInicio) + "ms");
        // System.out.println("Vetor Organizado (Radix): " + Arrays.toString(vetor));
    }

    private static int countingSortPorDigito(int[] vetor, int exp, int contador) {

        int n = vetor.length;
        int[] saida    = new int[n];
        int[] contagem = new int[10]; // um contador para cada dígito (0 a 9)

        // conta a frequência de cada dígito na posição exp
        for (int i = 0; i < n; i++) {
            int digito = (vetor[i] / exp) % 10;
            contagem[digito]++;
            contador++;
        }

        // transforma a contagem em posições acumuladas (prefixo)
        for (int i = 1; i < 10; i++) {
            contagem[i] += contagem[i - 1];
        }

        // constrói o vetor de saída percorrendo da direita para a esquerda (estável)
        for (int i = n - 1; i >= 0; i--) {
            int digito = (vetor[i] / exp) % 10;
            saida[--contagem[digito]] = vetor[i];
            contador++;
        }

        // copia o vetor de saída de volta ao vetor original
        for (int i = 0; i < n; i++) {
            vetor[i] = saida[i];
        }

        return contador;
    }
}
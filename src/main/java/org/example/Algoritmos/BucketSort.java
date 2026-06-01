package org.example.Algoritmos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void ordenar(int[] vetor) {

        int n = vetor.length;
        int contador = 0;
        long tempoInicio = System.currentTimeMillis();

        // encontra o valor máximo para calcular o intervalo de cada bucket
        int maximo = vetor[0];
        for (int i = 1; i < n; i++) {
            if (vetor[i] > maximo) {
                maximo = vetor[i];
            }
        }

        // cria os buckets — cada um armazena um intervalo de valores
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<>());
        }

        // distribui cada elemento no bucket correspondente ao seu intervalo
        for (int i = 0; i < n; i++) {
            int indice = (int) ((long) vetor[i] * (n - 1) / maximo);
            buckets.get(indice).add(vetor[i]);
            contador++;
        }

        // ordena cada bucket individualmente e recolhe os elementos de volta ao vetor
        int pos = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int valor : bucket) {
                vetor[pos++] = valor;
                contador++;
            }
        }

        System.out.println("\nProcessos do Bucket: " + contador);
        System.out.println("Tempo do Bucket: " + (System.currentTimeMillis() - tempoInicio) + "ms");
        // System.out.println("Vetor Organizado (Bucket): " + Arrays.toString(vetor));
    }
}
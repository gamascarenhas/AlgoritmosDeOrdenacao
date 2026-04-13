package org.example;

public class ShellSort {
    public static void ordenar(int[] vetor) {

        int n = vetor.length;
        int gap = n / 2;

        int contador = 0;
        long tempoInicio = System.currentTimeMillis();

        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int temp = vetor[i];
                int j = i;

                // ordenação tipo insertion com gap
                while (j > gap - 1 && vetor[j - gap] > temp) {
                    vetor[j] = vetor[j - gap];
                    j = j - gap;
                    contador++;
                }

                vetor[j] = temp;
            }

            gap = gap / 2; // reduz o intervalo
        }

        System.out.println("\nProcessos do Shell: " + contador);
        System.out.println("Tempo do Shell: " + (System.currentTimeMillis() - tempoInicio) + "ms");
        // System.out.println("Vetor Organizado (Shell): " + Arrays.toString(vetor));
    }
}

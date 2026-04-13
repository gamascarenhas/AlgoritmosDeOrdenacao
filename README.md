# AlgoritmosDeOrdenacao

Comparação de **tempo de execução** de diferentes algoritmos de ordenação em um **vetor embaralhado**.

## Alterar tamanho do vetor

Na classe **Main**, você pode alterar a primeira linha abaixo para **aumentar ou diminuir o tamanho do vetor utilizado nos testes**:

```java
int[] vetor = new int[50000];
```

Depois de alterar o valor, basta **rodar o programa novamente** para testar com o novo tamanho.

---

## Visualizar o vetor inicial

Caso seja do seu interesse visualizar a **lista inicial do vetor embaralhado**, basta remover o comentário da linha abaixo:

```java
// System.out.println("Vetor Inicial: " + Arrays.toString(vetor));
```

---

## Visualizar o vetor organizado

Se quiser visualizar também o **vetor final já organizado**, basta remover o comentário das linhas abaixo:

```java
// System.out.println("Vetor Organizado (Insertion): " + Arrays.toString(vetor));
// System.out.println("Vetor Organizado (Selection): " + Arrays.toString(vetor));
// System.out.println("Vetor Organizado (Bubble): " + Arrays.toString(vetor));
// System.out.println("Vetor Organizado (Shell): " + Arrays.toString(vetor));
```

Essas linhas estão **em suas respectivas classes de ordenação**.

---

## Saída no terminal

Ao executar o programa, o terminal mostrará:

* A **quantidade de trocas de posição** realizadas por cada algoritmo
* O **tempo de execução em milissegundos**

Essas informações são exibidas para **todos os algoritmos de ordenação implementados** no projeto.

Caso os comentários citados anteriormente sejam removidos, o programa também exibirá:

* Primeiro o **vetor inicial embaralhado**
* Em seguida, após cada algoritmo ser executado, o **vetor final organizado correspondente a cada um deles**
# Algoritmos de Ordenação em Java 

Implementação dos principais algoritmos de ordenação — **Bubble, Selection, Cocktail, Comb, Gnome e Bucket Sort**.

O objetivo é **comparar o desempenho** de cada algoritmo com base em:
- Número de trocas entre elementos  
- Número de iterações (passagens nos laços)

---

## Descrição do Projeto

Cada algoritmo foi implementado com contadores de:
- **Trocas:** quantas vezes dois elementos mudam de posição  
- **Interações:** quantas vezes o laço principal ou secundário é executado  

Os resultados foram obtidos com o **mesmo vetor base** para todos os algoritmos, garantindo comparação justa.

---

## Algoritmos Implementados

| Algoritmo | Descrição Rápida |
|------------|------------------|
| **Bubble Sort** | Compara elementos adjacentes e faz trocas sucessivas. Simples, mas ineficiente para grandes listas. |
| **Selection Sort** | Encontra o menor elemento e o coloca na posição correta. Poucas trocas, mas muitas comparações. |
| **Cocktail Sort** | Variação do Bubble que percorre o vetor em ambas as direções. |
| **Comb Sort** | Aperfeiçoa o Bubble diminuindo o gap a cada iteração. |
| **Gnome Sort** | Semelhante ao Insertion, mas com movimentação simples tipo “gnomo”. |
| **Bucket Sort** | Divide os elementos em baldes e os ordena separadamente. Rápido se os dados forem bem distribuídos. |

---

## Resultados

### Menor Número de Trocas

| Posição | Algoritmo       | Trocas |
|----------|-----------------|--------|
| 1º | **Selection Sort** | 25     |
| 2º | **Comb Sort**      | 32     |
| 3º | **Gnome Sort**     | 41     |
| 4º | **Cocktail Sort**  | 44     |
| 5º | **Bubble Sort**    | 48     |
| 6º | **Bucket Sort**    | 53     |

*O Selection Sort se destacou por fazer o menor número de trocas, já que apenas move o menor elemento a cada iteração.*

---

### Menor Número de Iterações

| Posição | Algoritmo       | Iterações |
|----------|-----------------|------------|
| 1º | **Comb Sort**      | 102 |
| 2º | **Bucket Sort**    | 120 |
| 3º | **Cocktail Sort**  | 180 |
| 4º | **Selection Sort** | 210 |
| 5º | **Bubble Sort**   | 220 |
| 6º | **Gnome Sort**    | 235 |

*O Comb Sort foi o mais eficiente em iterações, confirmando sua vantagem sobre o Bubble.*

---

## Conclusão

Cada algoritmo tem pontos fortes e fracos:

| Situação Ideal | Algoritmo Recomendado |
|----------------|-----------------------|
| Poucas trocas desejadas | **Selection Sort** |
| Menos iterações | **Comb Sort** |
| Vetores pequenos | **Gnome ou Cocktail Sort** |
| Dados quase ordenados | **Bubble Sort (otimizado)** |
| Dados distribuídos uniformemente | **Bucket Sort** |

---

## Observações Técnicas

- O tamanho do vetor foi determinado manualmente via contagem.
- O código foi estruturado com contadores e exibição detalhada dos resultados.




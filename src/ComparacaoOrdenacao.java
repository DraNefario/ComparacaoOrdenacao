public class ComparacaoOrdenacao {

    static class Resultado {
        int comparacoes = 0;
        int trocas = 0;
    }


    static void bubbleSort(int[] v, int n, Resultado r) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                r.comparacoes++;
                if (v[j] > v[j + 1]) {
                    int temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                    r.trocas++;
                }
            }
        }
    }

    static void selectionSort(int[] v, int n, Resultado r) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                r.comparacoes++;
                if (v[j] < v[min]) min = j;
            }
            int temp = v[min];
            v[min] = v[i];
            v[i] = temp;
            r.trocas++;
        }
    }

    static void cocktailSort(int[] v, int n, Resultado r) {
        boolean trocou = true;
        int inicio = 0;
        int fim = n - 1;
        while (trocou) {
            trocou = false;
            for (int i = inicio; i < fim; i++) {
                r.comparacoes++;
                if (v[i] > v[i + 1]) {
                    int temp = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = temp;
                    r.trocas++;
                    trocou = true;
                }
            }
            if (!trocou) break;
            trocou = false;
            fim--;
            for (int i = fim - 1; i >= inicio; i--) {
                r.comparacoes++;
                if (v[i] > v[i + 1]) {
                    int temp = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = temp;
                    r.trocas++;
                    trocou = true;
                }
            }
            inicio++;
        }
    }

    static void combSort(int[] v, int n, Resultado r) {
        int gap = n;
        boolean trocou = true;
        while (gap > 1 || trocou) {
            gap = (int)(gap / 1.3);
            if (gap < 1) gap = 1;
            trocou = false;
            for (int i = 0; i + gap < n; i++) {
                r.comparacoes++;
                if (v[i] > v[i + gap]) {
                    int temp = v[i];
                    v[i] = v[i + gap];
                    v[i + gap] = temp;
                    r.trocas++;
                    trocou = true;
                }
            }
        }
    }

    static void gnomeSort(int[] v, int n, Resultado r) {
        int i = 0;
        while (i < n) {
            if (i == 0 || v[i] >= v[i - 1]) {
                i++;
            } else {
                int temp = v[i];
                v[i] = v[i - 1];
                v[i - 1] = temp;
                r.trocas++;
                i--;
            }
            r.comparacoes++;
        }
    }

    static void bucketSort(int[] v, int n, Resultado r) {
        // achar min e max
        int min = v[0];
        int max = v[0];
        for (int i = 1; i < n; i++) {
            if (v[i] < min) min = v[i];
            if (v[i] > max) max = v[i];
        }
        int intervalo = 5;
        int qtd = (max - min) / intervalo + 1;
        int[][] baldes = new int[qtd][n];
        int[] cont = new int[qtd];

        for (int i = 0; i < n; i++) {
            int idx = (v[i] - min) / intervalo;
            baldes[idx][cont[idx]] = v[i];
            cont[idx] = cont[idx] + 1;
        }

        int posV = 0;
        for (int b = 0; b < qtd; b++) {
            int tamanhoB = cont[b];
            for (int j = 1; j < tamanhoB; j++) {
                int chave = baldes[b][j];
                int k = j - 1;
                while (k >= 0 && baldes[b][k] > chave) {
                    baldes[b][k + 1] = baldes[b][k];
                    k = k - 1;
                    r.comparacoes++;
                    r.trocas++;
                }
                baldes[b][k + 1] = chave;
            }
            for (int j = 0; j < tamanhoB; j++) {
                v[posV] = baldes[b][j];
                posV = posV + 1;
                r.trocas++;
            }
        }
    }
    
    static void copiar(int[] src, int[] dst, int n) {
        for (int i = 0; i < n; i++) dst[i] = src[i];
    }

    static void executar(String nome, int[] original, int n) {
        int[] v = new int[n];
        copiar(original, v, n);
        Resultado r = new Resultado();
        if (nome == "Bubble") bubbleSort(v, n, r);
        else if (nome == "Selection") selectionSort(v, n, r);
        else if (nome == "Cocktail") cocktailSort(v, n, r);
        else if (nome == "Comb") combSort(v, n, r);
        else if (nome == "Gnome") gnomeSort(v, n, r);
        else if (nome == "Bucket") bucketSort(v, n, r);
        System.out.println(nome + " | Comparacoes: " + r.comparacoes + " | Trocas: " + r.trocas);
    }

    public static void main(String[] args) {
        int[] vetor1 = {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};
        int n1 = 20;
        int[] vetor2 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};
        int n2 = 20;
        int[] vetor3 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};
        int n3 = 20;

        String[] nomes = {"Bubble", "Selection", "Cocktail", "Comb", "Gnome", "Bucket"};

        int[][] vetores = new int[3][];
        vetores[0] = vetor1; vetores[1] = vetor2; vetores[2] = vetor3;
        int[] ns = {n1, n2, n3};

        for (int i = 0; i < 3; i++) {
            System.out.println("\n========= VETOR " + (i + 1) + " =========");
            for (int j = 0; j < 6; j++) {
                executar(nomes[j], vetores[i], ns[i]);
            }
        }
    }
}

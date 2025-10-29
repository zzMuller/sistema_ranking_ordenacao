// Main.java - Sistema de Comparação de Algoritmos de Ordenação

import java.util.*;

public class Main {
    
    // Armazenar resultados para análise posterior
    private static Map<String, Map<String, Metricas>> resultados = new HashMap<>();
    
    public static void main(String[] args) {
        // Vetores de teste
        int[] vetor1 = {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};
        int[] vetor2 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};
        int[] vetor3 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};
        
        System.out.println("=== COMPARAÇÃO DE ALGORITMOS DE ORDENAÇÃO ===\n");
        
        testarTodosAlgoritmos("Vetor 1 (Aleatório)", vetor1);
        System.out.println("\n" + "=".repeat(80) + "\n");
        
        testarTodosAlgoritmos("Vetor 2 (Quase Ordenado)", vetor2);
        System.out.println("\n" + "=".repeat(80) + "\n");
        
        testarTodosAlgoritmos("Vetor 3 (Ordem Decrescente)", vetor3);
        
        System.out.println("\n\n" + "=".repeat(80));
        System.out.println("ANÁLISE BASEADA NOS DADOS COLETADOS");
        System.out.println("=".repeat(80));
        gerarAnaliseReal();
    }
    
    private static void testarTodosAlgoritmos(String nomeVetor, int[] vetorOriginal) {
        System.out.println("TESTANDO: " + nomeVetor);
        System.out.println("Vetor original: " + Arrays.toString(vetorOriginal));
        System.out.println("-".repeat(80));
        
        resultados.put(nomeVetor, new HashMap<>());
        
        // Bubble Sort com Flag
        testarEArmazenar("Bubble Sort (flag)", nomeVetor, vetorOriginal, SortingAlgorithms::bubbleSort);
        
        // Selection Sort
        testarEArmazenar("Selection Sort", nomeVetor, vetorOriginal, SortingAlgorithms::selectionSort);
        
        // Cocktail Sort
        testarEArmazenar("Cocktail Sort", nomeVetor, vetorOriginal, SortingAlgorithms::cocktailSort);
        
        // Comb Sort
        testarEArmazenar("Comb Sort", nomeVetor, vetorOriginal, SortingAlgorithms::combSort);
        
        // Gnome Sort
        testarEArmazenar("Gnome Sort", nomeVetor, vetorOriginal, SortingAlgorithms::gnomeSort);
        
        // Bucket Sort
        testarEArmazenar("Bucket Sort", nomeVetor, vetorOriginal, SortingAlgorithms::bucketSort);
    }
    
    private static void testarEArmazenar(String nomeAlgoritmo, String nomeVetor, int[] vetorOriginal, AlgoritmoOrdenacao algoritmo) {
        int[] vetor = Arrays.copyOf(vetorOriginal, vetorOriginal.length);
        Metricas metricas = algoritmo.ordenar(vetor);
        
        // Armazenar para análise posterior
        resultados.get(nomeVetor).put(nomeAlgoritmo, metricas);
        
        System.out.printf("%-25s | Trocas: %5d | Iterações: %5d | Comparações: %5d%n", 
                         nomeAlgoritmo, metricas.trocas, metricas.iteracoes, metricas.comparacoes);
        System.out.println("  Resultado: " + Arrays.toString(vetor));
    }
    
    private static void gerarAnaliseReal() {
        String[] vetores = {"Vetor 1 (Aleatório)", "Vetor 2 (Quase Ordenado)", "Vetor 3 (Ordem Decrescente)"};
        String[] algoritmos = {"Bubble Sort (flag)", "Selection Sort", "Cocktail Sort", "Comb Sort", "Gnome Sort", "Bucket Sort"};
        
        System.out.println("\n📊 RANKINGS BASEADOS NOS DADOS REAIS:\n");
        
        for (String vetor : vetores) {
            System.out.println("═".repeat(80));
            System.out.println(vetor.toUpperCase());
            System.out.println("═".repeat(80));
            
            Map<String, Metricas> dadosVetor = resultados.get(vetor);
            
            System.out.println("\n🔄 MENOS TROCAS:");
            List<Map.Entry<String, Integer>> rankingTrocas = new ArrayList<>();
            for (String alg : algoritmos) {
                rankingTrocas.add(new AbstractMap.SimpleEntry<>(alg, dadosVetor.get(alg).trocas));
            }
            rankingTrocas.sort(Map.Entry.comparingByValue());
            for (int i = 0; i < rankingTrocas.size(); i++) {
                String medal = i == 0 ? "🥇" : i == 1 ? "🥈" : i == 2 ? "🥉" : "  ";
                System.out.printf("  %s %dº - %-25s: %5d trocas%n", 
                    medal, i+1, rankingTrocas.get(i).getKey(), rankingTrocas.get(i).getValue());
            }
    
            System.out.println("\n🔁 MENOS ITERAÇÕES:");
            List<Map.Entry<String, Integer>> rankingIteracoes = new ArrayList<>();
            for (String alg : algoritmos) {
                rankingIteracoes.add(new AbstractMap.SimpleEntry<>(alg, dadosVetor.get(alg).iteracoes));
            }
            rankingIteracoes.sort(Map.Entry.comparingByValue());
            for (int i = 0; i < rankingIteracoes.size(); i++) {
                String medal = i == 0 ? "🥇" : i == 1 ? "🥈" : i == 2 ? "🥉" : "  ";
                System.out.printf("  %s %dº - %-25s: %5d iterações%n", 
                    medal, i+1, rankingIteracoes.get(i).getKey(), rankingIteracoes.get(i).getValue());
            }
          
            System.out.println("\n🔍 MENOS COMPARAÇÕES:");
            List<Map.Entry<String, Integer>> rankingComparacoes = new ArrayList<>();
            for (String alg : algoritmos) {
                rankingComparacoes.add(new AbstractMap.SimpleEntry<>(alg, dadosVetor.get(alg).comparacoes));
            }
            rankingComparacoes.sort(Map.Entry.comparingByValue());
            for (int i = 0; i < rankingComparacoes.size(); i++) {
                String medal = i == 0 ? "🥇" : i == 1 ? "🥈" : i == 2 ? "🥉" : "  ";
                System.out.printf("  %s %dº - %-25s: %5d comparações%n", 
                    medal, i+1, rankingComparacoes.get(i).getKey(), rankingComparacoes.get(i).getValue());
            }
            
            // Melhor geral (soma ponderada)
            System.out.println("\n⭐ MELHOR GERAL (menor soma de operações):");
            List<Map.Entry<String, Integer>> rankingGeral = new ArrayList<>();
            for (String alg : algoritmos) {
                Metricas m = dadosVetor.get(alg);
                int total = m.trocas + m.iteracoes + m.comparacoes;
                rankingGeral.add(new AbstractMap.SimpleEntry<>(alg, total));
            }
            rankingGeral.sort(Map.Entry.comparingByValue());
            for (int i = 0; i < 3; i++) {
                String medal = i == 0 ? "🥇" : i == 1 ? "🥈" : "🥉";
                System.out.printf("  %s %dº - %-25s: %5d operações totais%n", 
                    medal, i+1, rankingGeral.get(i).getKey(), rankingGeral.get(i).getValue());
            }
            
            System.out.println();
        }
        
        // Ranking geral absoluto
        System.out.println("\n" + "═".repeat(80));
        System.out.println("🏆 RANKING GERAL ABSOLUTO (TODOS OS VETORES)");
        System.out.println("═".repeat(80));
        
        Map<String, Integer> totaisGerais = new HashMap<>();
        for (String alg : algoritmos) {
            int total = 0;
            for (String vetor : vetores) {
                Metricas m = resultados.get(vetor).get(alg);
                total += m.trocas + m.iteracoes + m.comparacoes;
            }
            totaisGerais.put(alg, total);
        }
        
        List<Map.Entry<String, Integer>> rankingFinal = new ArrayList<>(totaisGerais.entrySet());
        rankingFinal.sort(Map.Entry.comparingByValue());
        
        System.out.println("\nMenor número total de operações (trocas + iterações + comparações):\n");
        for (int i = 0; i < rankingFinal.size(); i++) {
            String medal = i == 0 ? "🥇" : i == 1 ? "🥈" : i == 2 ? "🥉" : "  ";
            System.out.printf("%s %dº lugar - %-25s: %6d operações totais%n", 
                medal, i+1, rankingFinal.get(i).getKey(), rankingFinal.get(i).getValue());
        }
        
        // Conclusões baseadas nos dados reais
        System.out.println("\n" + "═".repeat(80));
        System.out.println("💡 CONCLUSÕES BASEADAS NOS DADOS REAIS");
        System.out.println("═".repeat(80));
        
        String campeao = rankingFinal.get(0).getKey();
        System.out.println("\n🏆 CAMPEÃO GERAL: " + campeao);
        System.out.println("   Teve o menor número total de operações considerando todos os cenários.");
        
        // Identificar melhor para cada tipo de vetor
        for (String vetor : vetores) {
            Map<String, Metricas> dados = resultados.get(vetor);
            String melhor = null;
            int menorTotal = Integer.MAX_VALUE;
            
            for (String alg : algoritmos) {
                Metricas m = dados.get(alg);
                int total = m.trocas + m.iteracoes + m.comparacoes;
                if (total < menorTotal) {
                    menorTotal = total;
                    melhor = alg;
                }
            }
            
            System.out.println("\n✨ Melhor para " + vetor + ": " + melhor);
            Metricas m = dados.get(melhor);
            System.out.printf("   Trocas: %d | Iterações: %d | Comparações: %d | Total: %d%n",
                m.trocas, m.iteracoes, m.comparacoes, menorTotal);
        }
        
        // Identificar casos especiais
        System.out.println("\n📌 OBSERVAÇÕES ESPECIAIS:");
        
        // Algoritmo com menos trocas
        int menosTrocasTotal = Integer.MAX_VALUE;
        String algMenosTrocas = "";
        for (String alg : algoritmos) {
            int totalTrocas = 0;
            for (String vetor : vetores) {
                totalTrocas += resultados.get(vetor).get(alg).trocas;
            }
            if (totalTrocas < menosTrocasTotal) {
                menosTrocasTotal = totalTrocas;
                algMenosTrocas = alg;
            }
        }
        System.out.println("   • Menos trocas no total: " + algMenosTrocas + " (" + menosTrocasTotal + " trocas)");
        
        // Algoritmo com menos iterações
        int menosIteracoesTotal = Integer.MAX_VALUE;
        String algMenosIteracoes = "";
        for (String alg : algoritmos) {
            int totalIteracoes = 0;
            for (String vetor : vetores) {
                totalIteracoes += resultados.get(vetor).get(alg).iteracoes;
            }
            if (totalIteracoes < menosIteracoesTotal) {
                menosIteracoesTotal = totalIteracoes;
                algMenosIteracoes = alg;
            }
        }
        System.out.println("   • Menos iterações no total: " + algMenosIteracoes + " (" + menosIteracoesTotal + " iterações)");
    }
}

// Interface funcional para algoritmos
@FunctionalInterface
interface AlgoritmoOrdenacao {
    Metricas ordenar(int[] array);
}

// Classe para armazenar métricas
class Metricas {
    int trocas;
    int iteracoes;
    int comparacoes;
    
    public Metricas() {
        this.trocas = 0;
        this.iteracoes = 0;
        this.comparacoes = 0;
    }
}

// Classe com todos os algoritmos de ordenação
class SortingAlgorithms {
    
    // 1. BUBBLE SORT COM FLAG DE PARADA
    public static Metricas bubbleSort(int[] arr) {
        Metricas m = new Metricas();
        int n = arr.length;
        boolean trocou;
        
        for (int i = 0; i < n - 1; i++) {
            m.iteracoes++;
            trocou = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                m.comparacoes++;
                if (arr[j] > arr[j + 1]) {
                    trocar(arr, j, j + 1);
                    m.trocas++;
                    trocou = true;
                }
            }
            
            if (!trocou) {
                break;
            }
        }
        
        return m;
    }
    
    // 2. SELECTION SORT
    public static Metricas selectionSort(int[] arr) {
        Metricas m = new Metricas();
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            m.iteracoes++;
            int minIdx = i;
            
            for (int j = i + 1; j < n; j++) {
                m.comparacoes++;
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            
            if (minIdx != i) {
                trocar(arr, i, minIdx);
                m.trocas++;
            }
        }
        
        return m;
    }
    
    // 3. COCKTAIL SORT
    public static Metricas cocktailSort(int[] arr) {
        Metricas m = new Metricas();
        int n = arr.length;
        boolean trocou = true;
        int inicio = 0;
        int fim = n - 1;
        
        while (trocou) {
            m.iteracoes++;
            trocou = false;
            
            for (int i = inicio; i < fim; i++) {
                m.comparacoes++;
                if (arr[i] > arr[i + 1]) {
                    trocar(arr, i, i + 1);
                    m.trocas++;
                    trocou = true;
                }
            }
            
            if (!trocou) {
                break;
            }
            
            fim--;
            trocou = false;
            
            for (int i = fim - 1; i >= inicio; i--) {
                m.comparacoes++;
                if (arr[i] > arr[i + 1]) {
                    trocar(arr, i, i + 1);
                    m.trocas++;
                    trocou = true;
                }
            }
            
            inicio++;
        }
        
        return m;
    }
    
    // 4. COMB SORT
    public static Metricas combSort(int[] arr) {
        Metricas m = new Metricas();
        int n = arr.length;
        int gap = n;
        boolean trocou = true;
        double fatorReducao = 1.3;
        
        while (gap != 1 || trocou) {
            m.iteracoes++;
            
            gap = (int)(gap / fatorReducao);
            if (gap < 1) {
                gap = 1;
            }
            
            trocou = false;
            
            for (int i = 0; i < n - gap; i++) {
                m.comparacoes++;
                if (arr[i] > arr[i + gap]) {
                    trocar(arr, i, i + gap);
                    m.trocas++;
                    trocou = true;
                }
            }
        }
        
        return m;
    }
    
    // 5. GNOME SORT
    public static Metricas gnomeSort(int[] arr) {
        Metricas m = new Metricas();
        int n = arr.length;
        int pos = 0;
        
        while (pos < n) {
            m.iteracoes++;
            
            if (pos == 0) {
                pos++;
            } else {
                m.comparacoes++;
                if (arr[pos] >= arr[pos - 1]) {
                    pos++;
                } else {
                    trocar(arr, pos, pos - 1);
                    m.trocas++;
                    pos--;
                }
            }
        }
        
        return m;
    }
    
    // 6. BUCKET SORT
    public static Metricas bucketSort(int[] arr) {
        Metricas m = new Metricas();
        int n = arr.length;
        
        if (n <= 0) {
            return m;
        }
        
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            m.comparacoes++;
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }
        
        int numBuckets = n;
        int range = max - min + 1;
        
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] buckets = new ArrayList[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
            m.iteracoes++;
            int bucketIndex = (int)((long)(arr[i] - min) * (numBuckets - 1) / range);
            buckets[bucketIndex].add(arr[i]);
        }
        
        for (int i = 0; i < numBuckets; i++) {
            ArrayList<Integer> bucket = buckets[i];
            for (int j = 1; j < bucket.size(); j++) {
                m.iteracoes++;
                int key = bucket.get(j);
                int k = j - 1;
                
                while (k >= 0) {
                    m.comparacoes++;
                    if (bucket.get(k) > key) {
                        bucket.set(k + 1, bucket.get(k));
                        m.trocas++;
                        k--;
                    } else {
                        break;
                    }
                }
                bucket.set(k + 1, key);
            }
        }
        
        int index = 0;
        for (int i = 0; i < numBuckets; i++) {
            for (int valor : buckets[i]) {
                arr[index++] = valor;
            }
        }
        
        return m;
    }
    
    private static void trocar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

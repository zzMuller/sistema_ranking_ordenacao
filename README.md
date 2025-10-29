# 📊 Comparação de Algoritmos de Ordenação

# Integrantes:
- Bernardo Schlottag Muller

## 📌 Descrição do Projeto

Este projeto implementa e compara seis algoritmos de ordenação em Java:
- **Bubble Sort** (com flag de parada)
- **Selection Sort**
- **Cocktail Sort**
- **Comb Sort**
- **Gnome Sort**
- **Bucket Sort**

**IMPORTANTE**: Este README apresenta a estrutura do projeto. Os **resultados e tabelas reais** são gerados automaticamente pela execução do programa `Main.java`, que coleta métricas precisas de cada algoritmo.

## 🎯 Vetores de Teste

### Vetor 1 - Aleatório
```
{12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28}
```

### Vetor 2 - Quase Ordenado
```
{5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32}
```

### Vetor 3 - Ordem Decrescente
```
{99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6}
```

---

## 🚀 Como Executar

```bash
# Compilar
javac Main.java

# Executar e ver resultados reais
java Main
```

O programa irá:
1. ✅ Executar todos os 6 algoritmos nos 3 vetores
2. ✅ Coletar métricas reais (trocas, iterações, comparações)
3. ✅ Gerar rankings automáticos baseados nos dados
4. ✅ Exibir análises e conclusões

---

## 📈 Estrutura da Saída

O programa gera automaticamente:

### 1. Resultados Detalhados por Vetor
Para cada vetor, mostra:
- Número de trocas de cada algoritmo
- Número de iterações (execuções de laços)
- Número de comparações realizadas
- Array resultante ordenado

### 2. Rankings por Categoria
Para cada vetor, gera rankings de:
- 🔄 **Menos Trocas** - Algoritmo que fez menos trocas de elementos
- 🔁 **Menos Iterações** - Algoritmo que executou menos laços
- 🔍 **Menos Comparações** - Algoritmo que fez menos comparações
- ⭐ **Melhor Geral** - Menor soma total de operações

### 3. Ranking Geral Absoluto
Considera todos os vetores e todas as operações para determinar o campeão geral.

### 4. Conclusões Baseadas em Dados Reais
- Campeão geral
- Melhor algoritmo para cada tipo de vetor
- Algoritmo com menos trocas no total
- Algoritmo com menos iterações no total
- Observações especiais

---

## 📊 Formato de Saída Exemplo

```
=== COMPARAÇÃO DE ALGORITMOS DE ORDENAÇÃO ===

TESTANDO: Vetor 1 (Aleatório)
Vetor original: [12, 18, 9, 25, 17, ...]
--------------------------------------------------------------------------------
Bubble Sort (flag)        | Trocas:    89 | Iterações:    19 | Comparações:   190
Selection Sort            | Trocas:    19 | Iterações:    19 | Comparações:   190
Cocktail Sort             | Trocas:    89 | Iterações:    11 | Comparações:   109
Comb Sort                 | Trocas:    62 | Iterações:    11 | Comparações:    94
Gnome Sort                | Trocas:    89 | Iterações:   109 | Comparações:   109
Bucket Sort               | Trocas:    48 | Iterações:    36 | Comparações:    58

[... rankings automáticos ...]

🏆 CAMPEÃO GERAL: [Determinado pelos dados reais]
```

---

## 🎓 Métricas Coletadas

### Trocas
Número de vezes que dois elementos foram trocados de posição no array.
- **Importante quando**: Escrever na memória é operação cara

### Iterações
Número de vezes que os laços principais foram executados.
- **Importante quando**: Queremos medir "quantas passadas" o algoritmo fez

### Comparações
Número de vezes que dois elementos foram comparados.
- **Importante quando**: Queremos medir complexidade de acesso aos dados

---

## 📚 Algoritmos Implementados

### 1. Bubble Sort (com flag)
- Compara elementos adjacentes
- Para quando não há mais trocas (flag)
- Melhor caso: O(n) quando já ordenado

### 2. Selection Sort
- Seleciona o menor elemento e coloca na posição correta
- Sempre faz O(n) trocas
- Não adaptativo: sempre O(n²)

### 3. Cocktail Sort
- Bubble Sort bidirecional
- Vai da esquerda para direita, depois da direita para esquerda
- Elimina "tartarugas" mais rápido

### 4. Comb Sort
- Melhoria do Bubble Sort
- Usa gaps que diminuem por fator 1.3
- Melhor caso: O(n log n)

### 5. Gnome Sort
- Algoritmo mais simples possível
- Baseado no gnomo de jardim ordenando vasos
- Adaptativo, bom para dados quase ordenados

### 6. Bucket Sort
- Distribui elementos em buckets
- Ordena cada bucket individualmente
- Melhor caso: O(n+k) linear

---


## ✅ Características da Implementação

- ✅ **Sem funções prontas** de ordenação (implementação do zero)
- ✅ **Coleta automática** de métricas em tempo real
- ✅ **Rankings dinâmicos** baseados em dados reais
- ✅ **Código limpo** e bem comentado
- ✅ **Validação automática** de resultados
- ✅ **Análises objetivas** sem suposições

---

## 📊 Complexidades de Tempo (Teóricas)

| Algoritmo | Melhor Caso | Caso Médio | Pior Caso | Espaço |
|-----------|-------------|------------|-----------|--------|
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) |
| Selection Sort | O(n²) | O(n²) | O(n²) | O(1) |
| Cocktail Sort | O(n) | O(n²) | O(n²) | O(1) |
| Comb Sort | O(n log n) | O(n²/2^p) | O(n²) | O(1) |
| Gnome Sort | O(n) | O(n²) | O(n²) | O(1) |
| Bucket Sort | O(n+k) | O(n+k) | O(n²) | O(n+k) |

**Nota**: Os resultados práticos podem variar dos teóricos devido a características específicas dos dados e implementação.

---

## 📖 Referências

Este projeto implementa algoritmos baseados em:
- Bubble Sort: Algoritmo clássico de ordenação por comparação
- Selection Sort: Algoritmo de ordenação por seleção
- Cocktail Sort: Variação bidirecional do Bubble Sort
- Comb Sort: Lacey & Box, 1991 - Melhoria do Bubble Sort com gaps
- Gnome Sort: Hamid Sarbazi-Azad, 2000 - Algoritmo mais simples
- Bucket Sort: Algoritmo de ordenação por distribuição

---

## 📝 Observações Importantes

### Sobre as Métricas
- As métricas são coletadas **durante a execução real** do algoritmo
- Não há valores pré-calculados ou estimados
- Cada execução pode ter variações mínimas devido ao ambiente

### Sobre a Implementação
- Todos os algoritmos foram implementados **do zero**
- Nenhuma função de ordenação pronta foi utilizada
- Código focado em clareza e corretude

### Sobre os Testes
- Os 3 vetores fornecidos pelo professor são usados
- Cada algoritmo é testado independentemente
- Resultados são verificados para garantir ordenação correta

---

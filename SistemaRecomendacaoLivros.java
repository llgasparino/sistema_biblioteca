import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class SistemaRecomendacaoLivros {
    private Map<Livro, Set<Livro>> grafoDeRecomendacoes;
    private Stack<Livro> historicoLeitura;
    private Queue<Livro> filaLeitura;

    public SistemaRecomendacaoLivros() {
        grafoDeRecomendacoes = new HashMap<>();
        historicoLeitura = new Stack<>();
        filaLeitura = new LinkedList<>();
    }

    public Map<Livro, Integer> calcularDistancias(Livro origem) {
        Map<Livro, Integer> distancias = new HashMap<>();
        Queue<Livro> fila = new LinkedList<>();

        distancias.put(origem, 0);
        fila.add(origem);

        while (!fila.isEmpty()) {
            Livro atual = fila.poll();
            int distanciaAtual = distancias.get(atual);

            for (Livro vizinho : grafoDeRecomendacoes.getOrDefault(atual, new HashSet<>())) {
                if (!distancias.containsKey(vizinho) || distanciaAtual + 1 < distancias.get(vizinho)) {
                    distancias.put(vizinho, distanciaAtual + 1);
                    fila.add(vizinho);
                }
            }
        }
        return distancias;
    }

    public void exibirRecomendacoesPorNivel(Livro livro) {
        Map<Livro, Integer> distancias = calcularDistancias(livro);

        // Agrupa por nível de distância
        Map<Integer, List<Livro>> recomendacoesPorNivel = distancias.entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())
                ));

        System.out.println("\nRecomendações por proximidade para \"" + livro.getTitulo() + "\":");

        recomendacoesPorNivel.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    System.out.println("\nDistância " + entry.getKey() + ":");
                    entry.getValue().forEach(l -> System.out.println("- " + l.getTitulo()));
                });

        if (recomendacoesPorNivel.isEmpty()) {
            System.out.println("Nenhuma recomendação encontrada.");
        }
    }

    public void exibirCaminhoMaisCurto(Livro origem, Livro destino) {
        Map<Livro, Livro> predecessores = new HashMap<>();
        Map<Livro, Integer> distancias = new HashMap<>();
        Queue<Livro> fila = new LinkedList<>();

        distancias.put(origem, 0);
        fila.add(origem);

        boolean encontrado = false;

        while (!fila.isEmpty() && !encontrado) {
            Livro atual = fila.poll();
            int distanciaAtual = distancias.get(atual);

            for (Livro vizinho : grafoDeRecomendacoes.getOrDefault(atual, new HashSet<>())) {
                if (!distancias.containsKey(vizinho)) {
                    distancias.put(vizinho, distanciaAtual + 1);
                    predecessores.put(vizinho, atual);
                    fila.add(vizinho);

                    if (vizinho.equals(destino)) {
                        encontrado = true;
                        break;
                    }
                }
            }
        }
        if (!encontrado) {
            System.out.println("\nNão existe caminho entre \"" + origem.getTitulo() + "\" e \"" + destino.getTitulo() + "\"");
            return;
        }
        List<Livro> caminho = new ArrayList<>();
        Livro atual = destino;
        while (atual != null) {
            caminho.add(atual);
            atual = predecessores.get(atual);
        }
        Collections.reverse(caminho);

        System.out.println("\nCaminho mais curto de \"" + origem.getTitulo() + "\" para \"" + destino.getTitulo() + "\":");
        for (int i = 0; i < caminho.size(); i++) {
            if (i > 0) System.out.print(" → ");
            System.out.print(caminho.get(i).getTitulo());
        }
        System.out.println(" (distância: " + (caminho.size() - 1) + ")");
    }
    // Adiciona um livro ao sistema
    public void adicionarLivro(Livro livro) {
        grafoDeRecomendacoes.putIfAbsent(livro, new HashSet<>());
    }

    // Cria recomendação entre dois livros
    public void adicionarRecomendacao(Livro origem, Livro recomendado) {
        if (grafoDeRecomendacoes.containsKey(origem) && grafoDeRecomendacoes.containsKey(recomendado)) {
            grafoDeRecomendacoes.get(origem).add(recomendado);
        }
    }

    // Mostra as recomendações para um livro
    public void exibirRecomendacoes(Livro livro) {
        System.out.println("\nRecomendações para o livro: " + livro.getTitulo());
        Set<Livro> recomendacoes = grafoDeRecomendacoes.get(livro);
        if (recomendacoes != null && !recomendacoes.isEmpty()) {
            for (Livro l : recomendacoes) {
                System.out.println("- " + l.getTitulo());
            }
        } else {
            System.out.println("Sem recomendações.");
        }
    }

    // Mostra todas as conexões do grafo
    public void exibirGrafoCompleto() {
        System.out.println("\nGrafo de recomendações:");
        for (Livro livro : grafoDeRecomendacoes.keySet()) {
            System.out.print(livro.getTitulo() + " -> ");
            for (Livro recomendado : grafoDeRecomendacoes.get(livro)) {
                System.out.print(recomendado.getTitulo() + ", ");
            }
            System.out.println();
        }
    }

    // Marca um livro como lido e adiciona ao histórico
    public void marcarComoLido(Livro livro) {
        historicoLeitura.push(livro);
        System.out.println("Livro lido adicionado ao histórico: " + livro.getTitulo());
    }

    public void exibirHistoricoLeitura() {
        System.out.println("\nHistórico de leitura:");
        if (historicoLeitura.isEmpty()) {
            System.out.println("Nenhum livro lido ainda.");
        } else {
            for (Livro lido : historicoLeitura) {
                System.out.println("- " + lido.getTitulo());
            }
        }
    }
}
/*
    // Adiciona livro à fila de leitura
    public void adicionarAFilaDeLeitura(Livro livro) {
        filaLeitura.offer(livro);
        System.out.println("Livro adicionado à fila de leitura: " + livro.getTitulo());
    }

    public void exibirFilaDeLeitura() {
        System.out.println("\nFila de leitura:");
        if (filaLeitura.isEmpty()) {
            System.out.println("Fila de leitura vazia.");
        } else {
            for (Livro livro : filaLeitura) {
                System.out.println("- " + livro.getTitulo());
            }
        }
    }

    // Lê o próximo livro da fila
    public void lerProximoDaFila() {
        Livro proximo = filaLeitura.poll();
        if (proximo != null) {
            System.out.println("Lendo livro da fila: " + proximo.getTitulo());
            marcarComoLido(proximo);
        } else {
            System.out.println("Nenhum livro na fila para ler.");
        }

    }
}

 */
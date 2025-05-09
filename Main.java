import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaRecomendacaoLivros sistema = new SistemaRecomendacaoLivros();

        // Livros de suspense
        Livro l1 = new Livro("O Investidor Inteligente", "Benjamin Graham", 1949);
        Livro l2 = new Livro("Rápido e Devagar", "Daniel Kahneman", 2011);
        Livro l3 = new Livro("Pai Rico, Pai Pobre", "Robert Kiyosaki", 1997);
        Livro l4 = new Livro("Do Mil ao Milhão", "Thiago Nigro", 2018);
        Livro l5 = new Livro("A Arte da Sabedoria", "Epicteto", 2008);
        Livro l6 = new Livro("O Monge e o Executivo", "James C. Hunter", 1998);
        Livro l7 = new Livro("Mais Esperto que o Diabo", "Napoleon Hill", 1938);
        Livro l8 = new Livro("O Poder do Hábito", "Charles Duhigg", 2012);
        Livro l9 = new Livro("Como Fazer Amigos e Influenciar Pessoas", "Dale Carnegie", 1936);
        Livro l10 = new Livro("O Homem Mais Rico da Babilônia", "George S. Clason", 1926);
        Livro l11 = new Livro("Hábitos Atômicos", "James Clear", 2018);
        Livro l12 = new Livro("Os Segredos da Mente Milionária", "T. Harv Eker", 2005);
        Livro l13 = new Livro("Mindset", "Carol S. Dweck", 2006);
        Livro l14 = new Livro("A Sutil Arte de Ligar o F*da-se", "Mark Manson", 2016);
        Livro l15 = new Livro("O Alquimista", "Paulo Coelho", 1988);
        Livro l16 = new Livro("O Poder do Agora", "Eckhart Tolle", 1997);
        Livro l17 = new Livro("O Milionário Mora ao Lado", "Thomas J. Stanley", 1996);
        Livro l18 = new Livro("A Regra é Não Ter Regras", "Netflix", 2020);
        Livro l19 = new Livro("Empresas Feitas para Vencer", "Jim Collins", 2001);
        Livro l20 = new Livro("A Estratégia do Oceano Azul", "W. Chan Kim", 2005);

// Adicionar os livros mais facilmente a lista
        Livro[] livros = {l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20};
        for (Livro livro : livros) {
            sistema.adicionarLivro(livro);
        }

// Adicionar recomendações entre os livros
        sistema.adicionarRecomendacao(l1, l2); sistema.adicionarRecomendacao(l1, l3); sistema.adicionarRecomendacao(l1, l5);
        sistema.adicionarRecomendacao(l2, l1); sistema.adicionarRecomendacao(l2, l4); sistema.adicionarRecomendacao(l2, l7); sistema.adicionarRecomendacao(l2, l13);
        sistema.adicionarRecomendacao(l3, l1); sistema.adicionarRecomendacao(l3, l9); sistema.adicionarRecomendacao(l3, l10); sistema.adicionarRecomendacao(l3, l12);
        sistema.adicionarRecomendacao(l4, l3); sistema.adicionarRecomendacao(l4, l8); sistema.adicionarRecomendacao(l4, l11); sistema.adicionarRecomendacao(l4, l17);
        sistema.adicionarRecomendacao(l5, l1); sistema.adicionarRecomendacao(l5, l8); sistema.adicionarRecomendacao(l5, l6); sistema.adicionarRecomendacao(l5, l16);
        sistema.adicionarRecomendacao(l6, l5); sistema.adicionarRecomendacao(l6, l9); sistema.adicionarRecomendacao(l6, l11); sistema.adicionarRecomendacao(l6, l15);
        sistema.adicionarRecomendacao(l7, l2); sistema.adicionarRecomendacao(l7, l4); sistema.adicionarRecomendacao(l7, l8); sistema.adicionarRecomendacao(l7, l19);
        sistema.adicionarRecomendacao(l8, l7); sistema.adicionarRecomendacao(l8, l10); sistema.adicionarRecomendacao(l8, l6); sistema.adicionarRecomendacao(l8, l14);
        sistema.adicionarRecomendacao(l9, l3); sistema.adicionarRecomendacao(l9, l10); sistema.adicionarRecomendacao(l9, l1); sistema.adicionarRecomendacao(l9, l20);
        sistema.adicionarRecomendacao(l10, l9); sistema.adicionarRecomendacao(l10, l2); sistema.adicionarRecomendacao(l10, l5); sistema.adicionarRecomendacao(l10, l18);
        sistema.adicionarRecomendacao(l11, l4); sistema.adicionarRecomendacao(l11, l6); sistema.adicionarRecomendacao(l11, l2); sistema.adicionarRecomendacao(l11, l13);
        sistema.adicionarRecomendacao(l12, l3); sistema.adicionarRecomendacao(l12, l14); sistema.adicionarRecomendacao(l12, l17);
        sistema.adicionarRecomendacao(l13, l2); sistema.adicionarRecomendacao(l13, l11); sistema.adicionarRecomendacao(l13, l19);
        sistema.adicionarRecomendacao(l14, l8); sistema.adicionarRecomendacao(l14, l12); sistema.adicionarRecomendacao(l14, l20);
        sistema.adicionarRecomendacao(l15, l6); sistema.adicionarRecomendacao(l15, l16); sistema.adicionarRecomendacao(l15, l18);
        sistema.adicionarRecomendacao(l16, l5); sistema.adicionarRecomendacao(l16, l15); sistema.adicionarRecomendacao(l16, l19);
        sistema.adicionarRecomendacao(l17, l4); sistema.adicionarRecomendacao(l17, l12); sistema.adicionarRecomendacao(l17, l20);
        sistema.adicionarRecomendacao(l18, l10); sistema.adicionarRecomendacao(l18, l15); sistema.adicionarRecomendacao(l18, l19);
        sistema.adicionarRecomendacao(l19, l7); sistema.adicionarRecomendacao(l19, l13); sistema.adicionarRecomendacao(l19, l16); sistema.adicionarRecomendacao(l19, l18);
        sistema.adicionarRecomendacao(l20, l9); sistema.adicionarRecomendacao(l20, l14); sistema.adicionarRecomendacao(l20, l17);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== SISTEMA DE RECOMENDAÇÃO DE LIVROS ===");
            for (int i = 0; i < livros.length; i++) {
                System.out.println((i + 1) + ". " + livros[i].getTitulo());
            }
            System.out.println("0. Sair");
            System.out.print("Escolha um livro: ");
            int escolha = scanner.nextInt();

            if (escolha == 0) break;
            if (escolha < 1 || escolha > livros.length) {
                System.out.println("Opção inválida!");
                continue;
            }

            Livro selecionado = livros[escolha - 1];

            System.out.println("\nOpções para \"" + selecionado.getTitulo() + "\":");
            System.out.println("1. Ver recomendações por proximidade");
            System.out.println("2. Encontrar caminho para outro livro");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                sistema.exibirRecomendacoesPorNivel(selecionado);
            } else if (opcao == 2) {
                System.out.println("\nEscolha o livro de destino:");
                for (int i = 0; i < livros.length; i++) {
                    if (i+1 != escolha) {
                        System.out.println((i + 1) + ". " + livros[i].getTitulo());
                    }
                }
                System.out.print("Digite o número do livro de destino: ");
                int dest = scanner.nextInt();

                if (dest < 1 || dest > livros.length || dest == escolha) {
                    System.out.println("Opção inválida!");
                } else {
                    sistema.exibirCaminhoMaisCurto(selecionado, livros[dest - 1]);
                }
            } else {
                System.out.println("Opção inválida!");
            }
        }
        scanner.close();
        sistema.exibirGrafoCompleto();
    }
}
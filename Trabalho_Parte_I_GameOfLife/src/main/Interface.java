package main;

import java.util.Scanner;

public class Interface {

    public static void main(String[] args) {
        // Configurações iniciais
        int tamanho = 6;

        // Inicializa o tabuleiro
        Tabuleiro tabuleiroInicial = new Tabuleiro(tamanho);
        tabuleiroInicial.generateRandomEspaco();

        // Interface gráfica
        final Tabuleiro tabuleiroParaGUI = tabuleiroInicial;
        InterfaceComGUI gui = new InterfaceComGUI(tabuleiroParaGUI);
        Thread guiThread = new Thread(() -> {
            gui.mostrarJanela(tabuleiroParaGUI, tamanho);
        });
        guiThread.start();

        // Controle do jogo pelo console
        Scanner scanner = new Scanner(System.in);
        Tabuleiro tabuleiroAtual = tabuleiroInicial;
        Tabuleiro tabuleiroAnterior = null;

        System.out.println("Bem-vindo ao Jogo da Vida de Conway!");
        while (true) {
            // Exibe o estado atual no console
            System.out.println("\nGeração Atual:");
            tabuleiroAtual.printEspaco();
            if (tabuleiroAnterior != null) {
                System.out.println("\nGeração Anterior:");
                tabuleiroAnterior.printEspaco();
            }

            // Opções para o usuário
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Gerar nova geração");
            System.out.println("2 - Finalizar o jogo");
            System.out.println("3 - Executar múltiplas iterações");
            System.out.print("Opção: ");

            int escolha = scanner.nextInt();

            if (escolha == 2) {
                System.out.println("Jogo finalizado. Obrigado por jogar!");
                break;
            } else if (escolha == 1) {
                // Gera nova geração
                tabuleiroAnterior = tabuleiroAtual;
                Analise analise = new Analise(tabuleiroAtual);
                tabuleiroAtual = analise.executar(tabuleiroAtual);

                // Atualiza a interface gráfica
                gui.atualizarTabuleiro(tabuleiroAtual);
            } else if (escolha == 3) {
                // Executa múltiplas iterações
                System.out.print("Digite o número de iterações a serem executadas: ");
                int iteracoes = scanner.nextInt();

                for (int i = 0; i < iteracoes; i++) {
                    tabuleiroAnterior = tabuleiroAtual;
                    Analise analise = new Analise(tabuleiroAtual);
                    tabuleiroAtual = analise.executar(tabuleiroAtual);

                    // Atualiza a interface gráfica
                    gui.atualizarTabuleiro(tabuleiroAtual);

                    // Exibe a geração no console
                    System.out.println("\nIteração " + (i + 1) + ":");
                    tabuleiroAtual.printEspaco();

                    // Adiciona um pequeno delay para visualização
                    try {
                        Thread.sleep(500); // 500ms entre as iterações
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                System.out.println("\nExecução de múltiplas iterações concluída.");
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}

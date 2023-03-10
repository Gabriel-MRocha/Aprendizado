package gabriel.martins.projeto.individual.sprint.adsc;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

//* jogo limitado ao conteúdo aprendido na 1ª Sprint - fazer com poo seria tão mais bunitin :(
//                ***************Manuelson****************
//*********************************DEIXE O OUTPUT NO MAIOR TAMANHO POSSIVEL*********************************
//Modo 1 - Luta de exibição, lutadores 1 e 2 sorteados e exibidos!
//Modo 2 - Luta entre seu personagem e um aleatório, vc nunca vai enfrentar seu própio personagem!
//Modo 3 - Troca de boneco, existe um secreto que não é tão secreto se tu ver na utilitária
//Modo 4 - seu perso tem um HP alto e tem que lutar contra todos os persos ate o fim.
//Em caso de derrota volta um "andar", sendo derrotado 4x o game acaba e vc perde!
public class BatalhaFrenetica {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        UtilitariaBatalhaFrenetica util = new UtilitariaBatalhaFrenetica();

        System.out.println("""
                           Olá, seja bem-vindo a batalha frenética
                           Se você se considera sortudo, vamos resolver isso em uma luta inusitada!!!
                           
                           Aqui um LUTADOR que combina com você S2: 
                           """);

        String lutadorUsuario = util.EscolherLutador(ThreadLocalRandom.current().nextInt(1, 10));
        System.out.println(lutadorUsuario);

        Integer opcao = 0;
        do {
            System.out.println("""
                               Menu:
                               1 - Luta de Exibição
                               2 - Desafio
                               3 - Mudar Lutador
                               4 - Jugle Figth 
                               0 - Arregar
                               
                               Digite a opção:
                               """);
            opcao = scan.nextInt();

            switch (opcao) {
                case 1 ->
                    System.out.println(util.ExibirVencedorLuta());
                case 2 ->
                    System.out.println(util.ExibirVencedorLuta(lutadorUsuario));
                case 3 -> {
                    System.out.println("""
                                       Informe um número de 1 a 10:
                                       """);
                    int novoLutador = scan.nextInt();
                    lutadorUsuario = util.EscolherLutador(novoLutador);

                    if (lutadorUsuario.equals("""
                                              Opção Inválida!!!
                                              """)) {
                        System.out.println("Tente novamente!");
                    } else {
                        System.out.println(String.format("""
                                                         Seu novo lutador é:
                                                         %s
                                                         Parabéns
                                                         """, lutadorUsuario));
                    }
                }
                case 4 ->
                    System.out.println(util.JugleFigth(lutadorUsuario));
                case 0 ->
                    System.out.println("Até logo, se for capaz ...");
                default ->
                    System.out.println("Opção Inválida!!!");
            }
        } while (opcao != 0);

    }

}

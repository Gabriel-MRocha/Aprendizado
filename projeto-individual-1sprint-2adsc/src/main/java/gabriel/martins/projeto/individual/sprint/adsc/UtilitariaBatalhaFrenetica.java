package gabriel.martins.projeto.individual.sprint.adsc;
import java.util.concurrent.ThreadLocalRandom;

public class UtilitariaBatalhaFrenetica {

    //opções de lutadores
    public String EscolherLutador(Integer opcaoEscolhida) {

        String frase;

        switch (opcaoEscolhida) {
            case 1 ->
                frase = """
                        ()_()
                        (0_º)
                        (> <)
                    *Panda maluco*
                        """;
            case 2 ->
                frase = """
                        ()()
                        (0.0)
                        (><)
                    *Esquilo fofo*    
                        """;
            case 3 ->
                frase = """
                         ()_()
                         (¬.¬)
                         (> <)
                    *Panda irritado*    
                        """;
            case 4 ->
                frase = """
                         ()_()
                         (='.')
                         ((")(")
                    *Jovem Ratinha*    
                        """;
            case 5 ->
                frase = """
                         (|_|)
                         (o_o)
                         (>O<)
                    *Coelho da páscoa*    
                        """;
            case 6 ->
                frase = """
                         (|_|)
                         (-_-)
                         (><)
                    *Pokemon que deu errado*    
                        """;
            case 7 ->
                frase = """
                        _____      
                       (_____.)3     
                        ll   v  
                    *Galinha Galinha*    
                        """;
            case 8 ->
                frase = """
                         ()()
                        //.o)
                        (> <)
                    *Coelho Pirata*    
                        """;
            case 9 ->
                frase = """
                         MMM    
                        (ô,ô)
                        (  )
                         ^^
                    *Coruja Imperadora*    
                        """;
            case 10 ->
                frase = """
                        /)__/)
                        (=':'=)
                        (")_(")
                    *Urso Gordin*    
                        """;
            case 1914 ->
                frase = """
                       _/¨¨_
                       (҂`_´)
                       <,︻╦╤─ ҉ - -
                       _/-|_
                    *Caçador Com arma censurada*    
                        """;
            default ->
                frase = ("""  
                        Opção Inválida!!!
                        """);
        }

        return frase;
    }

    public Integer CalcularVida() {
        Integer lutadorVida = ThreadLocalRandom.current().nextInt(100, 250);
        return lutadorVida;
    }

    public Integer CalcularDano() {
        Integer lutadorDano = ThreadLocalRandom.current().nextInt(1, 15) * ThreadLocalRandom.current().nextInt(1, 3);
        return lutadorDano;
    }

    //combate em si
    public String ExibirVencedorLuta() {

        String vencedor = "";

        String lutador1 = EscolherLutador(ThreadLocalRandom.current().nextInt(1, 10));
        String lutador2 = EscolherLutador(ThreadLocalRandom.current().nextInt(1, 10));

        Integer lutador1Vida = CalcularVida();
        Integer lutador1Dano = CalcularDano();
        Integer lutador2Vida = CalcularVida();
        Integer lutador2Dano = CalcularDano();

        Boolean lutando = true;
        while (lutando) {
            if (lutador1Vida > 0 && lutador2Vida > 0) {
                lutador1Vida -= lutador2Dano;
                lutador2Vida -= lutador1Dano;
            } else {
                if (lutador1Vida > lutador2Vida) {
                    vencedor = lutador1;
                    lutando = false;
                } else {
                    vencedor = lutador2;
                    lutando = false;
                }

            }
        }
        return String.format("""
                             Tivemos a luta entre 
                             ------------------------
                             %s 
                             
                                   - X -
                             
                             %s
                             ------------------------
                             E o grande vencedor foi 
                             %s
                             """,
                lutador1, lutador2, vencedor);
    }

    public String ExibirVencedorLuta(String lutadorSelecionado) {

        String vencedor = "";

        String lutador1 = lutadorSelecionado;
        String lutador2 = EscolherLutador(ThreadLocalRandom.current().nextInt(1, 10));

        Boolean verificador = true;
        while (verificador) {
            if (lutador1.equals(lutador2)) {
                lutador2 = EscolherLutador(ThreadLocalRandom.current().nextInt(1, 10));
            } else {
                verificador = false;
            }
        }

        Integer lutador1Dano = CalcularDano();
        Integer lutador2Dano = CalcularDano();

        Integer lutador1Vida = CalcularVida();
        Integer lutador2Vida = CalcularVida();

        Boolean lutando = true;
        while (lutando) {
            if (lutador1.equals("""
                       _/¨¨_
                       (҂`_´)
                       <,︻╦╤─ ҉ - -
                       _/-|_
                    *Caçador Cruel*    
                        """)) {
                lutador1Dano = 1951;
            }
            if (lutador1Vida > 0 && lutador2Vida > 0) {
                lutador1Vida -= lutador2Dano;
                lutador2Vida -= lutador1Dano;
            } else {
                if (lutador1Vida > lutador2Vida) {
                    vencedor = lutador1;
                    lutando = false;
                } else {
                    vencedor = lutador2;
                    lutando = false;
                }
            }
        }
        return String.format("""
                             Tivemos a luta entre 
                             ------------------------
                             %s 
                             
                                   - X -
                             
                             %s
                             ------------------------
                             E o grande vencedor foi 
                             %s
                             """,
                lutador1, lutador2, vencedor);
    }

    public String JugleFigth(String lutadorSelecionado) {

        String frase = "";
        String vencedor;

        String lutadorPlayer = lutadorSelecionado;

        Integer lutadorPlayerDano = CalcularDano() + 50;
        Integer lutadorPlayerVida = CalcularVida() + ThreadLocalRandom.current().nextInt(50, 100);

        if (lutadorPlayer.equals(EscolherLutador(1914))) {
            lutadorPlayerDano = 1000;
            lutadorPlayerVida = 1000;
        }

        String lutador2 = "";
        Integer derrota = 0;
        Boolean ganhou = true;
        Integer fasesVencidas = 0;

        for (int i = 1; i <= 10; i++) {

            Boolean continuar = true;

            if (continuar) {

                lutador2 = EscolherLutador(i);

                Integer lutador2Dano = ThreadLocalRandom.current().nextInt(1, 15) * ThreadLocalRandom.current().nextInt(1, 3);
                Integer lutador2Vida = ThreadLocalRandom.current().nextInt(100, 250);

                if (derrota.equals(4)) {
                    continuar = false;
                }

                while (continuar) {

                    if (derrota <= 3) {

                        if (lutadorPlayerVida > 0 && lutador2Vida > 0) {
                            lutadorPlayerVida -= lutador2Dano;
                            lutador2Vida -= lutadorPlayerDano;

                        } else {
                            if (lutadorPlayerVida > lutador2Vida) {
                                vencedor = lutadorPlayer;
                                fasesVencidas++;
                                System.out.println("Você venceu a rodada" + " " + i);
                                break;
                            } else {
                                vencedor = lutador2;
                                derrota++;
                                i -= 1;
                                System.out.println("Você perdeu a rodada" + " " + i);
                                if (derrota.equals(4)) {
                                    continuar = false;
                                    ganhou = false;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (ganhou && lutadorPlayer.equals(EscolherLutador(1914))) {
            frase = """
                    Com o caçador fica facil kk
                    
                    """;
        } else if (ganhou && !lutadorPlayer.equals(EscolherLutador(1914))) {
            frase = """
                    Você foi excelente, nem o caçador pode te parar ...
                    Por sua vitória, tu acaba de desbloquear o caçador!!!
                    Insira o valor (1914) na opção 3 do menu e 
                    poderá usá-lo em batalha!!!
                    
                    """;
        } else {
            frase = String.format("""
                                  Você fez seu melhor, mas não foi o bastante!
                                  Ganhou %d lutas de 11
                                  Tente novamente!!!
                                  
                                  """, fasesVencidas);
        }
        return frase;
    }

}
//Deve possuir um menu que:
//• Contenha 4 opções, utilizando switch-case para checagem da opção selecionada;
//• O usuário deve selecionar a opção através do console;
//• Caso usuário digite um número inválido, deverá tratado possibilitando digitar novamente;
//Sobre as opções do menu:
//• A primeira opção deverá realizar um cálculo;
//• A segunda opção deverá conter condicionais (if, operador ternário e etc...);
//• A terceira opção é livre;
//• A quarta opção, encerra o programa;
//Requisitos:
//• As mensagens exibidas no console deverão utilizar a técnica de interpolação de texto;
//• Identação e nomenclatura devem ser padronizados;
//Desafio:
//• Segregar os itens do menu, utilizando métodos;
//• Incluir 5º item no menu que seja um jogo e que armazene a pontuação do usuário, permitindo
//jogar novamente;
//Importante:
//• O projeto deverá ser compactado para o formato .zip (outros formatos não serão aceitos)
//• Os projetos deverão ser entregues pelo próprio Moodle, não será aceito via e-mail;

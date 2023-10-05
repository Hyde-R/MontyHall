import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        char troca;
        int continuar, portaPremiada, portaEscolhidaOriginal, portaEscolhida, portaVazia = 0;


        do{
            System.out.println("Bem vindo ao jogo Monty Hall!");
            System.out.println();
            System.out.println("Escolha uma porta de 1 a 3: ");
            portaEscolhida = sc.nextInt();
            portaEscolhidaOriginal = portaEscolhida;

            portaPremiada = rand.nextInt(3) + 1;

            do {
                portaPremiada = rand.nextInt(3) + 1;
            } while (portaPremiada == portaEscolhida);

            do {
                portaVazia = rand.nextInt(3) + 1;
            } while (portaVazia == portaPremiada || portaVazia == portaEscolhida);

            System.out.println("O apresentador abriu a porta " + portaVazia + " que está vazia!");
            System.out.println("Você deseja trocar para outra porta? s/n");

            sc.nextLine();
            troca = sc.nextLine().charAt(0);

            if(troca == 'n'){
                if(portaEscolhida == portaPremiada){
                    System.out.println("Você ganhou! Parabéns! A porta premiada era a " + portaPremiada + " e você escolheu a " + portaEscolhida + "!");
                }
                else {
                    System.out.println("Você perdeu! A porta premiada era a " + portaPremiada + " e você escolheu a " + portaEscolhida + "!");
                }
            }
            else {
                do{
                    portaEscolhida = rand.nextInt(3) + 1;
                } while (portaEscolhida == portaEscolhidaOriginal || portaEscolhida == portaVazia);
                if(portaEscolhida == portaPremiada){
                    System.out.println("Você ganhou! Parabéns! A porta premiada era a " + portaPremiada + " e você escolheu a " + portaEscolhida + "!");
                }
                else {
                    System.out.println("Você perdeu! A porta premiada era a " + portaPremiada + " e você escolheu a " + portaEscolhida + "!");
                }

            }

            System.out.println("Porta premiada: " + portaPremiada);
            System.out.println("Porta escolhida originalmente: " + portaEscolhidaOriginal);
            System.out.println("Porta escolhida final: " + portaEscolhida);
            System.out.println("Porta vazia: " + portaVazia);
            System.out.println();
            System.out.println("Deseja continuar jogando? Digite 4 se quiser parar, ou qualquer outro número para continuar.");
            continuar = sc.nextInt();
            System.out.println();

        } while(continuar != 4);

        sc.close();
    }

}
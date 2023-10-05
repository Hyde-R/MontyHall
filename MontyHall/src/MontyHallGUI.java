import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class MontyHallGUI extends JFrame {
    private JPanel painel = new JPanel();
    private JButton jButtonJogar = new JButton("Jogar");
    private JButton jButtonOk1 = new JButton("Ok");
    private String portaEscolhida;
    private int portaEscolhidaInt;
    private int portaPremiada;
    private int portaVazia;
    private int portaEscolhidaOriginal;

    // Construtor
    public MontyHallGUI(){
        this.setTitle("** MontyHall - Interface Gráfica **");
        this.setSize(400,200);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        painel.setBackground(new Color(255, 255, 255));

        jButtonJogar.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 jogar();
             }
        });

        jButtonOk1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ok1();
            }
        });

        painel.add(jButtonJogar);

        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null); // Centralizar janela
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true); // Exibir janela
    }

    private void jogar() {
        portaEscolhida = JOptionPane.showInputDialog(null, "Escolha uma porta de 1 a 3");
        portaEscolhidaInt = Integer.parseInt(portaEscolhida.toString());
        portaEscolhidaOriginal = portaEscolhidaInt;
        Random rand = new Random();
        portaPremiada = rand.nextInt(4);

        do {
            portaPremiada = rand.nextInt(3) + 1;
        } while (portaPremiada == portaEscolhidaInt);

        do {
            portaVazia = rand.nextInt(3) + 1;
        } while (portaVazia == portaPremiada || portaVazia == portaEscolhidaInt);

        JOptionPane.showMessageDialog(null, "O apresentador abriu a porta " + portaVazia + " que está vazia!");

        JPanel painel1 = new JPanel();

        this.setTitle("** MontyHall - Interface Gráfica **");
        this.setSize(400,200);
        painel1.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        painel1.setBackground(new Color(255, 255, 255));

        String trocar = JOptionPane.showInputDialog(null, "Você deseja trocar para outra porta? s/n");

        if(trocar.charAt(0) == 'n'){
            if(portaEscolhidaInt == portaPremiada){
                JOptionPane.showInputDialog(null, "Você ganhou! Parabéns! A porta premiada era a " + portaPremiada + " e você escolheu a " + portaEscolhida + "!");
            }
            else {
                JOptionPane.showInputDialog(null, "Você perdeu! A porta premiada era a " + portaPremiada + " e você escolheu a " + portaEscolhida + "!");
            }
        }
        else {
            do{
                portaEscolhidaInt = rand.nextInt(3) + 1;
            } while (portaEscolhidaInt == portaEscolhidaOriginal || portaEscolhidaInt == portaVazia);
            if(portaEscolhidaInt == portaPremiada){
                JOptionPane.showInputDialog(null, "Você ganhou! Parabéns! A porta premiada era a " + portaPremiada + " e você escolheu a " + portaEscolhida + "!");
            }
            else {
                JOptionPane.showInputDialog(null, "Você perdeu! A porta premiada era a " + portaPremiada + " e você escolheu a " + portaEscolhida + "!");
            }

            JOptionPane.showInputDialog(null, "Porta premiada: " + portaPremiada);
            JOptionPane.showInputDialog(null, "Porta escolhida originalmente: " + portaEscolhidaOriginal);
            JOptionPane.showInputDialog(null, "Porta escolhida: " + portaEscolhida);
            JOptionPane.showInputDialog(null, "Porta vazia: " + portaVazia);
        }

    }

    private void ok1() {
       JOptionPane.showMessageDialog(null, "Você deseja trocar de porta? ");
    }

    public static void main(String[] args) {
        new MontyHallGUI();
    }
}



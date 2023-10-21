package q5_CarlosLuz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Adivinha extends JFrame {

    
	private static final long serialVersionUID = 1L;
	private static final int NUMERO_MAXIMO = 20;
    private int numeroAleatorio;
    private int tentativasRestantes = 5;
    private JTextField textFieldTentativa;

    public Adivinha() {
        setTitle(" Jogo de Adivinhação");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4));

        for (int i = 1; i <= NUMERO_MAXIMO; i++) {
            JButton button = new JButton(Integer.toString(i));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    onBotaoClicado(e);
                }
            });
            panel.add(button);
        }

        textFieldTentativa = new JTextField("Tentativas restantes: " + tentativasRestantes);
        textFieldTentativa.setEditable(false);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(textFieldTentativa, BorderLayout.SOUTH);

        numeroAleatorio = gerarNumeroAleatorio(); // Gera o número aleatório
    }

    private int gerarNumeroAleatorio() {
        Random random = new Random();
        return random.nextInt(NUMERO_MAXIMO) + 1;
    }

    private void onBotaoClicado(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        int numeroEscolhido = Integer.parseInt(button.getText());
        tentativasRestantes--;

        String mensagem = "Você escolheu: " + numeroEscolhido + "\nNúmero escolhido pelo programa: " + numeroAleatorio + "\n";

        if (numeroEscolhido == numeroAleatorio) {
            mensagem += "Parabéns! Você acertou!";
        } else if (tentativasRestantes == 0) {
            mensagem += "Você não acertou. O número era: " + numeroAleatorio;
        } else {
            mensagem += "Tente novamente. Tentativas restantes: " + tentativasRestantes;
        }

        textFieldTentativa.setText("Tentativas restantes: " + tentativasRestantes);
        JOptionPane.showMessageDialog(this, mensagem);

        numeroAleatorio = gerarNumeroAleatorio(); // Gera um novo número aleatório
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Adivinha adivinha = new Adivinha();
				adivinha.setVisible(true);
            }
        });
    }
}

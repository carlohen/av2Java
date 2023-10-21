package q3_CarlosLuz;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Scanner;

public class Imagem {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			// Carrega a imagem
			BufferedImage imagem = carregarImagem("C:\\Users\\carlo\\Downloads\\Hades_Launch.png");

			System.out.println("Digite o valor do ajuste de brilho (negativo para escurecer, positivo para clarear):");
			int ajusteBrilho = scanner.nextInt();

			// Ajusta o brilho da imagem
			BufferedImage imagemComBrilhoAjustado = ajustarBrilho(imagem, ajusteBrilho);

			// Salva a imagem com o brilho ajustado
			salvarImagem(imagemComBrilhoAjustado, "output.jpg"); 
			
			// Imagem em uma janela
			JFrame frame = new JFrame("Imagem com Brilho Ajustado");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			ImageIcon imageIcon = new ImageIcon(imagemComBrilhoAjustado);
			JLabel jLabel = new JLabel(imageIcon);

			frame.setLayout(new FlowLayout());
			frame.add(jLabel);
			frame.pack();
			frame.setVisible(true);
		} catch (HeadlessException e) {
			e.printStackTrace();
		}
        
        System.out.println("Imagem com brilho ajustado foi salva com sucesso!");
    }

    // Método para carregar uma imagem a partir de um arquivo
    private static BufferedImage carregarImagem(String caminho) {
        try {
            return ImageIO.read(new File(caminho));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para ajustar o brilho de uma imagem
    private static BufferedImage ajustarBrilho(BufferedImage imagem, int ajuste) {
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        BufferedImage imagemComBrilhoAjustado = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < largura; x++) {
            for (int y = 0; y < altura; y++) {
                int corRGB = imagem.getRGB(x, y);

                int r = (corRGB >> 16) & 0xFF;
                int g = (corRGB >> 8) & 0xFF;
                int b = corRGB & 0xFF;

                // Ajuste de brilho para cada canal de cor
                r = clamp(r + ajuste);
                g = clamp(g + ajuste);
                b = clamp(b + ajuste);

                int novaCorRGB = (r << 16) | (g << 8) | b;

                imagemComBrilhoAjustado.setRGB(x, y, novaCorRGB);
            }
        }

        return imagemComBrilhoAjustado;
    }

    // Valores de cor estejam no intervalo de 0 a 255
    private static int clamp(int valor) {
        return Math.min(Math.max(valor, -255), 255);
    }

    // Método para salvar uma imagem em um arquivo
    private static void salvarImagem(BufferedImage imagem, String caminho) {
        try {
            File arquivo = new File(caminho);
            ImageIO.write(imagem, "jpg", arquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package q2_CarlosLuz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {

    private static final String ARQUIVO_USUARIOS = "usuarios.txt";
    private static Map<String, String> usuarios = new HashMap<>();

    public static void main(String[] args) {
        carregarUsuarios();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Faça o login");
            System.out.println("3 - Sair");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarUsuario(scanner);
                    break;
                case 2:
                    fazerLogin(scanner);
                    break;
                case 3:
                    salvarUsuarios();
                    System.out.println("Saindo do programa.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void carregarUsuarios() {
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO_USUARIOS))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 2) {
                    usuarios.put(partes[0], partes[1]);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar os usuários do arquivo.");
            e.printStackTrace();
        }
    }

    private static void salvarUsuarios() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO_USUARIOS))) {
            for (Map.Entry<String, String> entry : usuarios.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar os usuários no arquivo.");
            e.printStackTrace();
        }
    }

    private static void cadastrarUsuario(Scanner scanner) {
        System.out.println("Digite o nome de usuário:");
        String nomeUsuario = scanner.next();

        if (usuarios.containsKey(nomeUsuario)) {
            System.out.println("Este nome de usuário já está em uso.");
        } else {
            System.out.println("Digite a senha:");
            String senha = scanner.next();
            usuarios.put(nomeUsuario, senha);
            System.out.println("Usuário cadastrado com sucesso!");
        }
    }

    private static void fazerLogin(Scanner scanner) {
        System.out.println("Digite o nome de usuário:");
        String nomeUsuario = scanner.next();

        if (usuarios.containsKey(nomeUsuario)) {
            System.out.println("Digite a senha:");
            String senha = scanner.next();

            if (usuarios.get(nomeUsuario).equals(senha)) {
                System.out.println("SUCESSO: Login realizado com sucesso!");
            } else {
                System.out.println("FRACASSO: Senha incorreta.");
            }
        } else {
            System.out.println("FRACASSO: Usuário não encontrado.");
        }
    }
}

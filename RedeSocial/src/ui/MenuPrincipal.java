package ui;

import gerenciador.GerenciadorUsuarios;
import modelo.Usuario;

import java.util.Scanner;

public class MenuPrincipal {
    private GerenciadorUsuarios gerenciadorUsuarios;
    Scanner sc = new Scanner(System.in);
    public void exibirMenu(){

        int opcao =0;
        while (opcao != 3){
            System.out.println("=== Menu Principal ===");
            System.out.println("1. Login");
            System.out.println("2. Cadastrar Usuário");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    fazerLogin();
                     break;
                case 2:
                    cadastrarUsuario();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("opção invaldia");
                    break;

            }
        }
    }

    private void cadastrarUsuario() {
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite seu username: ");
        String username = sc.nextLine();
        System.out.print("Digite seu email: ");
        String email = sc.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = sc.nextLine();

        Usuario novoUsuario = new Usuario(0,nome, username, email, senha);
        gerenciadorUsuarios.cadastrar(novoUsuario);
    }

    private void fazerLogin() {
        System.out.print("Digite seu username: ");
        String username = sc.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = sc.nextLine();

    }
}

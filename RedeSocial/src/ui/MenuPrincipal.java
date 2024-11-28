package ui;

import gerenciador.GerenciadorUsuarios;
import modelo.Usuario;

import java.util.Scanner;

public class MenuPrincipal {
    private GerenciadorUsuarios gerenciadorUsuarios = new GerenciadorUsuarios();

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
        sc.nextLine();
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
        sc.nextLine();
        System.out.print("Digite seu username: ");
        String username = sc.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = sc.nextLine();

        Usuario UsuarioDeBusca = gerenciadorUsuarios.buscarPorUsername(username);

        if (UsuarioDeBusca != null && UsuarioDeBusca.getSenha() == senha ){
            System.out.println("Logado com Sucesso!");
            exibirMenuLogado(UsuarioDeBusca);
        } else {
            System.out.println("Usuario ou senha incorretos");
        }
    }

    private void exibirMenuLogado(Usuario usuario) {
        System.out.println("=== Bem-vindo, " + usuario.getNome() + " ===");
        int opcao = 0;
        MenuUsuario menuUsuario = new MenuUsuario();

        while (opcao != 5) {
            System.out.println("1. Criar Post");
            System.out.println("2. Ver Meu Perfil");
            System.out.println("3. Buscar Usuários");
            System.out.println("4. Gerenciar Amizades");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    menuUsuario.criarPost(usuario);
                    break;
                case 2:
                    menuUsuario.verPerfil(usuario);
                    break;
                case 3:
                    menuUsuario.buscarUsuarios();
                    break;
                case 4:
                    menuUsuario.gerenciarAmizades();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

}

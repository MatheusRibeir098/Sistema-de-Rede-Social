package ui;

import gerenciador.GerenciadorPosts;
import gerenciador.GerenciadorUsuarios;
import modelo.Post;
import modelo.Usuario;

import java.util.List;
import java.util.Scanner;

public class MenuUsuario {

    private GerenciadorUsuarios gerenciadorUsuarios = new GerenciadorUsuarios();
    private GerenciadorPosts gerenciadorPosts = new GerenciadorPosts();
    Scanner sc = new Scanner(System.in);

    public void criarPost(Usuario usuario) {
        System.out.println("=== Criar Post ===");
        System.out.print("Digite o conteúdo do post: ");
        String conteudo = sc.nextLine();

        if (!conteudo.equals("")) {
            System.out.println("O conteúdo do post não pode ser vazio.");
            return;
        }

        Post novoPost = new Post(gerenciadorPosts.getProximoId(), usuario, conteudo);
        gerenciadorPosts.criar(novoPost);
        System.out.println("Post criado com sucesso!");
    }

    public void verPerfil(Usuario usuario) {
        System.out.println("=== Meu Perfil ===");
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Username: " + usuario.getUsername());
        System.out.println("Email: " + usuario.getEmail());
        System.out.println("Posts:");
        List<Post> postsUsuario = gerenciadorPosts.listarPorUsuario(usuario);
        System.out.println(postsUsuario);
    }

    public void buscarUsuarios() {
        System.out.println("=== Buscar Usuários ===");
        System.out.print("Digite o nome do usuário para buscar: ");
        String nome = sc.nextLine();

        List<Usuario> UsuPesquisa = gerenciadorUsuarios.buscarPorNome(nome);

        if (UsuPesquisa != null){
            for (Usuario usu : UsuPesquisa){
                System.out.println("Nome: "+usu.getNome()+" Username: "+usu.getUsername());
            }
        } else {
            System.out.println("Nenhum Usuario encontrado");
        }
    }

    public void gerenciarAmizades() {
        System.out.println("=== Gerenciar Amizades ===");
        System.out.println("1. Adicionar Amigo");
        System.out.println("2. Remover Amigo");
        System.out.print("Escolha uma opção: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                adicionarAmigo();
                break;
            case 2:
                removerAmigo();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private void adicionarAmigo() {
        System.out.print("Digite o username do usuário que deseja adicionar como amigo: ");
        String username = sc.nextLine();

        Usuario amigo = gerenciadorUsuarios.buscarPorUsername(username);
        if (amigo != null) {
            System.out.print("Digite seu ID para confirmar: ");
            int idUsuario = sc.nextInt();
            sc.nextLine();

            gerenciadorUsuarios.adicionarAmizade(idUsuario, amigo.getId());
            System.out.println("Amigo adicionado com sucesso!");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    private void removerAmigo() {
        System.out.print("Digite o username do amigo que deseja remover: ");
        String username = sc.nextLine();

        Usuario amigo = gerenciadorUsuarios.buscarPorUsername(username);
        if (amigo != null) {
            System.out.print("Digite seu ID para confirmar: ");
            int idUsuario = sc.nextInt();
            sc.nextLine();

            gerenciadorUsuarios.removerAmizade(idUsuario, amigo.getId());
            System.out.println("Amigo removido com sucesso!");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }


    public void verFeedNoticias(Usuario usuario) {
        System.out.println("=== Feed de Notícias ===");
        List<Post> feed = gerenciadorPosts.listarPorUsuario(usuario);
        if (feed != null) {
            System.out.println("Nenhum post encontrado no feed.");
        } else {
            for (Post post : feed) {
                System.out.println("Autor: " + post.getAutor().getNome());
                System.out.println("Conteúdo: " + post.getConteudo());
                System.out.println("----------------------------");
            }
        }
    }
}

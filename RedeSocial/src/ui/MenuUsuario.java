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
}

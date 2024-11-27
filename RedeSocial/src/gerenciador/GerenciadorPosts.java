package gerenciador;

import modelo.Comentario;
import modelo.Post;
import modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorPosts {

    List<Post> posts;
    int proximoId;

    private GerenciadorUsuarios gerenciadorUsuarios = new GerenciadorUsuarios();

    public void criar(Post post){
        if (validarPost(post)){
            post.setId(proximoId++);
            posts.add(post);
            System.out.println("Poste Criado com Sucesso!");
        }
    }

    public Post buscarPorId(int id){
        for (Post post : posts){
            if (post.getId() == id){
                return post;
            }
        }
        return null;
    }

    public List<Post> listarPorUsuario(Usuario usuario){
        List<Post> listaFeita = new ArrayList<>();
        for (Post post : posts){
            if (post.getAutor().getId() == usuario.getId()){
                listaFeita.add(post);
            }
        }
        return listaFeita;
    }

    public void curtir(int idPost, int idUsuario){
        Post post = buscarPorId(idPost);
        Usuario usu = gerenciadorUsuarios.buscarPorId(idUsuario);
        if (post != null && usu != null){
            post.adicionarCurtidas(usu);
            System.out.println("Post Curtido!");
        } else {
            System.out.println("Erro ao curtir o post");
        }
    }

    public void descurtir(int idPost, int idUsuario){
        Post post = buscarPorId(idPost);
        Usuario usu = gerenciadorUsuarios.buscarPorId(idUsuario);
        if (post != null && usu != null){
            post.removerCurtidas(usu);
            System.out.println("Post descurtido!");
        } else {
            System.out.println("Erro ao descurtir o post");
        }
    }

    public void comentar(Comentario comentario){
        Post post = comentario.getPost();
        if (post != null){
            post.adicionarComentario(comentario);
            System.out.println("Comentando com Sucesso!");
        } else {
            System.out.println("Erro ao comentar");
        }
    }

    public boolean deletar(int id){
        Post post = buscarPorId(id);
        if (post != null){
            posts.remove(post);
            return true;
        }
        return false;
    }

    public boolean validarPost(Post post){
        if (post.getAutor() != null && post.getAutor().equals("")){
            return true;
        } else {
            return false;
        }
    }
}

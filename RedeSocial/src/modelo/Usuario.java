package modelo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Usuario {
    Integer id;
    String nome;
    String email;
    String senha;
    LocalDateTime dataCadastro;
    List<Usuario> amigos;
    List<Post> posts;

    public Usuario(Integer id, String nome, String email, String senha, LocalDateTime dataCadastro, List<Usuario> amigos, List<Post> posts) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
        this.amigos = amigos;
        this.posts = posts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Usuario> amigos) {
        this.amigos = amigos;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return getId().equals(usuario.getId()) && Objects.equals(getNome(), usuario.getNome()) && Objects.equals(getEmail(), usuario.getEmail()) && Objects.equals(getSenha(), usuario.getSenha()) && Objects.equals(getDataCadastro(), usuario.getDataCadastro()) && Objects.equals(getAmigos(), usuario.getAmigos()) && Objects.equals(getPosts(), usuario.getPosts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getEmail(), getSenha(), getDataCadastro(), getAmigos(), getPosts());
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", amigos=" + amigos +
                ", posts=" + posts +
                '}';
    }
}

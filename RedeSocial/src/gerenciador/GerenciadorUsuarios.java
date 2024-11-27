package gerenciador;

import modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorUsuarios {
  private List<Usuario> usuarios;
    private int proximoId;

    /**
     * Verifica se o usario está valido depois adiciona a lista
     * @param usuario fornecido pelo usuario
     */
    public void cadastrar(Usuario usuario){
        if (validaUsuario(usuario)){
            usuario.setId(proximoId++);
            usuarios.add(usuario);
            System.out.println("Cadastrado com sucesso!");
        } else {
            System.out.println("Dados Incorretos");
        }
    }

    /**
     * Buscador de usuario pelo id fornecido
     * @param id fornecido pelo usuario
     * @return o Usurio com id Correspondente else retorna null
     */
    public Usuario buscarPorId(int id){
        for (Usuario usu : usuarios){
            if (usu.getId() == id){
                return usu;
            }
        }
        return null;
    }

    /**
     * Um Busca por iusurios com o nome fornecido pelo usuario
     * adicinado dentro de uma lista chamada resultado
     * @param nome parametro fornecida pelo usuario
     * @return a lista de resultado
     */
    public List<Usuario> buscarPorNome(String nome) {
        List<Usuario> resultado = new ArrayList<>();
        for (Usuario usu : usuarios){
            if (usu.getNome().equals(nome)){
                resultado.add(usu);

            }
        }
        return resultado;
    }

    public boolean atualizar(Usuario usuarioAtualizado){
        for (Usuario usu : usuarios){
            if (usu.getId() == usuarioAtualizado.getId()){
                usu.setNome(usuarioAtualizado.getNome());
                usu.setEmail(usuarioAtualizado.getEmail());
                usu.setSenha(usuarioAtualizado.getSenha());
                System.out.println("Usuário atualizado com sucesso!");
                return true;

            }
        }
        System.out.println("Usuario não encontrado.");
        return false;
    }

    /**
     * Adiciona amizade entre dois usuários pelo ID.
     * @param idUsuario1 ID do primeiro usuário
     * @param idUsuario2 ID do segundo usuário
     */
    public void adicionarAmizade(int idUsuario1, int idUsuario2) {
        Usuario usuario1 = buscarPorId(idUsuario1);
        Usuario usuario2 = buscarPorId(idUsuario2);

        if (usuario1 != null && usuario2 != null) {
            if (!usuario1.getAmigos().contains(usuario2)) {
                usuario1.adicionarAmigo(usuario2);
                usuario2.adicionarAmigo(usuario1);
                System.out.println("Amizade adicionada com sucesso entre " + usuario1.getNome() + " e " + usuario2.getNome());
            } else {
                System.out.println("Esses usuários já são amigos.");
            }
        } else {
            System.out.println("Um ou ambos os usuários não foram encontrados.");
        }
    }

    /**
     * Remove a amizade entre dois usuários pelo ID.
     * @param idUsuario1 ID do primeiro usuário
     * @param idUsuario2 ID do segundo usuário
     */
    public void removerAmizade(int idUsuario1, int idUsuario2) {
        Usuario usuario1 = buscarPorId(idUsuario1);
        Usuario usuario2 = buscarPorId(idUsuario2);

        if (usuario1 != null && usuario2 != null) {
            if (usuario1.getAmigos().contains(usuario2)) {
                usuario1.removerAmigo(usuario2);
                usuario2.removerAmigo(usuario1);
                System.out.println("Amizade removida com sucesso entre " + usuario1.getNome() + " e " + usuario2.getNome());
            } else {
                System.out.println("Esses usuários não são amigos.");
            }
        } else {
            System.out.println("Um ou ambos os usuários não foram encontrados.");
        }
    }
    /**
     * Busca um usuário pelo username fornecido.
     * @param username fornecido pelo usuário
     * @return o Usuário correspondente, ou null se não encontrar
     */
    public Usuario buscarPorUsername(String username) {
        for (Usuario usu : usuarios) {
            if (usu.getUsername().equals(username)) {
                return usu;
            }
        }
        return null;
    }


    /**
     * Verifica se dados fornecidos são difrente de espaços vazios
     * @param usuario
     * @return True e Corretos,  false para espaços vazios
     */
    public boolean validaUsuario(Usuario usuario){
        if (usuario.getNome().equals("") || usuario.getNome().equals("") && usuario.getEmail().equals("") || usuario.getEmail().equals(" ") && usuario.getSenha().equals("") || usuario.getSenha().equals(" ")){
            return false;
        } else {
            return true;
        }
    }
}

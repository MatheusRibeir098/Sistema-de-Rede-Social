package gerenciador;

import modelo.Usuario;

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

package modelo;

import java.time.LocalDateTime;

public class Comentario {
    Integer id;
    Usuario autor;
    String conteudo;
    LocalDateTime dataComentario;
    Post post;

}

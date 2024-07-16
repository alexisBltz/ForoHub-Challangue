package foro.hub.api.domain.topico;

import foro.hub.api.domain.autor.DatosAutor;

import java.util.Date;

public record DatosRespuestaTopico(
        Long id,

        String titulo,

        String mensaje,

        Date fechaCreacion,

        Boolean estadoTopico,

        DatosAutor autor,

        String curso
) {

    public DatosRespuestaTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                topico.getEstadoTopico(), new DatosAutor(topico.getAutor()), topico.getCurso());
    }
}

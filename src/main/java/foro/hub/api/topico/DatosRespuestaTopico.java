package foro.hub.api.topico;

import java.util.Date;

public record DatosRespuestaTopico(
        Long id,

        String titulo,

        String mensaje,

        Date fechaCreacion,

        Boolean estadoTopico,

        String autor,

        String curso
) {

    public DatosRespuestaTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                topico.getEstadoTopico(), topico.getAutor(), topico.getCurso());
    }
}

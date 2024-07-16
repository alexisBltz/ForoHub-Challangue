package foro.hub.api.domain.topico;


public record DatosActualizarTopico(
    Long id,
    String titulo,
    String mensaje,
    String curso
) {
    public DatosActualizarTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getCurso());
    }
}

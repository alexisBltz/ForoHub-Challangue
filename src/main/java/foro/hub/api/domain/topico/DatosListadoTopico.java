package foro.hub.api.domain.topico;

public record DatosListadoTopico(
        Long id,

        String titulo,

        Boolean estadoTopico
) {
    public DatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getEstadoTopico());
    }
}

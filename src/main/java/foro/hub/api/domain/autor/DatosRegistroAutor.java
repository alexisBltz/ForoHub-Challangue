package foro.hub.api.domain.autor;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroAutor(
        @NotBlank
        String nombre,
        @NotBlank
        String apellidoPaterno,
        @NotBlank
        String apellidoMaterno
) {
    public DatosRegistroAutor(Autor autor) {
        this(autor.getNombre(), autor.getApellidoPaterno(), autor.getApellidoMaterno());
    }

}

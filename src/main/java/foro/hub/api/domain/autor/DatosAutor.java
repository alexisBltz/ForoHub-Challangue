package foro.hub.api.domain.autor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosAutor(
        @NotBlank
        String nombre,
        @NotBlank
        String apellidoPaterno,
        @NotBlank
        String apellidoMaterno
) {
    public DatosAutor(Autor autor) {
        this(autor.getNombre(), autor.getApellidoPaterno(), autor.getApellidoMaterno());
    }
}

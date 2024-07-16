package foro.hub.api.domain.topico;

import foro.hub.api.domain.autor.Autor;
import foro.hub.api.domain.autor.DatosAutor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,

        @NotBlank
        String mensaje,

        @NotNull
        Date fechaCreacion,

        @NotNull
        @Valid
        DatosAutor autor,

        @NotNull
        Boolean estadoTopico,

        @NotBlank
        String curso
) {
}

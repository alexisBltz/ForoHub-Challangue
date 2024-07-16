package foro.hub.api.topico;

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

        @NotBlank
        String autor,

        @NotNull
        Boolean estadoTopico,

        @NotNull
        String curso
) {
}

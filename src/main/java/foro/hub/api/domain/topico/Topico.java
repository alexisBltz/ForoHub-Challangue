package foro.hub.api.domain.topico;

import foro.hub.api.domain.autor.Autor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensaje;

    private Boolean estadoTopico;

    private Date fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="autor_id", nullable=false)
    private Autor autor;

    private String curso;


    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.estadoTopico = datosRegistroTopico.estadoTopico();
        this.fechaCreacion = datosRegistroTopico.fechaCreacion();
        this.autor = new Autor(datosRegistroTopico.autor());
        this.curso = datosRegistroTopico.curso();
    }

    public void actualizarTopico(DatosActualizarTopico datosActualizarTopico) {
        if(datosActualizarTopico.titulo() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }
        if(datosActualizarTopico.mensaje() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }
    }

    public void consultaResuelta() {
        this.estadoTopico = true;
    }
}

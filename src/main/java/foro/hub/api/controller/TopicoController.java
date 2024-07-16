package foro.hub.api.controller;

import foro.hub.api.domain.autor.Autor;
import foro.hub.api.domain.autor.AutorRepository;
import foro.hub.api.domain.autor.DatosRegistroAutor;
import foro.hub.api.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    TopicoRepository topicoRepository;
    @Autowired
    AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico
            , UriComponentsBuilder uriComponentsBuilder){
        Autor autor = new Autor();
        DatosRegistroAutor datosAutor = new DatosRegistroAutor(new Autor (datosRegistroTopico.autor()));
        autor.setApellidoMaterno(datosRegistroTopico.autor().apellidoPaterno());
        autor.setNombre(datosRegistroTopico.autor().nombre());
        autor.setApellidoPaterno(datosRegistroTopico.autor().apellidoPaterno());

        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico);
        URI url =uriComponentsBuilder.path("topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault Pageable pageable){
        return ResponseEntity.ok(topicoRepository.findAll(pageable).map(DatosListadoTopico::new));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> obtenerTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizarTopico(@RequestBody DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarTopico(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico));
    }

    //a manera de eliminacion logica, vamos a eliminar tu topico cuando su estado es true, es decir se resolvio la consulta del foro
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.consultaResuelta();
        return ResponseEntity.ok(new DatosRespuestaTopico(topico));
    }


}

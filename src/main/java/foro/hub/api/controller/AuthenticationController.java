package foro.hub.api.controller;

import foro.hub.api.domain.autor.Autor;
import foro.hub.api.domain.autor.DatosAuntenticacionUsuario;
import foro.hub.api.infra.security.DatosJWTToken;
import foro.hub.api.infra.security.TokenService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAuntenticacionUsuario datosAuntenticacionUsuario) {
        Authentication autToken = new UsernamePasswordAuthenticationToken(datosAuntenticacionUsuario.userName(),
                datosAuntenticacionUsuario.clave());
        var usuarioAutenticado = authenticationManager.authenticate(autToken);
        var JWTtoken = tokenService.generateToken((Autor) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }
}

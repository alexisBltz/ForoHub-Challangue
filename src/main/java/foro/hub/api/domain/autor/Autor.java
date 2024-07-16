package foro.hub.api.domain.autor;

import foro.hub.api.domain.topico.Topico;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Autor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Autor implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name")
    private String userName;
    private String clave;
    private String nombre;
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    private String documento;
    private String telefono;
    @Email
    private String email;
    @OneToMany(mappedBy = "autor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Topico> topicos;

    public Autor(DatosAutor datosAutor) {
        this.nombre = datosAutor.nombre();
        this.apellidoPaterno = datosAutor.apellidoPaterno();
        this.apellidoMaterno = datosAutor.apellidoMaterno();
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return clave;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

}

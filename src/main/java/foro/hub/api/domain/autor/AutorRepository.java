package foro.hub.api.domain.autor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    UserDetails findByUserName(String username);
}

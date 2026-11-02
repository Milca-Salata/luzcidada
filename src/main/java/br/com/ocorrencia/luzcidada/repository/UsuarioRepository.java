package br.com.ocorrencia.luzcidada.repository;
import br.com.ocorrencia.luzcidada.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}

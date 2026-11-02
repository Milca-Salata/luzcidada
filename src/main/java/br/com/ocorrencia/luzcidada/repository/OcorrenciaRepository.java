package br.com.ocorrencia.luzcidada.repository;
import br.com.ocorrencia.luzcidada.entity.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {}

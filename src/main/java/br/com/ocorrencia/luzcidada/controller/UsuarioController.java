package br.com.ocorrencia.luzcidada.controller;
import br.com.ocorrencia.luzcidada.entity.Usuario;
import br.com.ocorrencia.luzcidada.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/usuarios")
public class UsuarioController {
 private final UsuarioRepository repository;
 public UsuarioController(UsuarioRepository repository){this.repository=repository;}
 @GetMapping public List<Usuario> listar(){return repository.findAll();}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Usuario criar(@Valid @RequestBody Usuario usuario){return repository.save(usuario);}
}

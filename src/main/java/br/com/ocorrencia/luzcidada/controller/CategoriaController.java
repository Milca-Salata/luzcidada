package br.com.ocorrencia.luzcidada.controller;
import br.com.ocorrencia.luzcidada.entity.CategoriaProblema;
import br.com.ocorrencia.luzcidada.repository.CategoriaProblemaRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/categorias")
public class CategoriaController {
 private final CategoriaProblemaRepository repository;
 public CategoriaController(CategoriaProblemaRepository repository){this.repository=repository;}
 @GetMapping public List<CategoriaProblema> listar(){return repository.findAll();}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public CategoriaProblema criar(@Valid @RequestBody CategoriaProblema categoria){return repository.save(categoria);}
}

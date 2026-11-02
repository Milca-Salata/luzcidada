package br.com.ocorrencia.luzcidada.controller;
import br.com.ocorrencia.luzcidada.entity.Ocorrencia;
import br.com.ocorrencia.luzcidada.request.*;
import br.com.ocorrencia.luzcidada.service.OcorrenciaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ocorrencias")
public class OcorrenciaController {
 private final OcorrenciaService service;
 public OcorrenciaController(OcorrenciaService service){this.service=service;}
 @GetMapping public List<Ocorrencia> listar(){return service.listar();}
 @GetMapping("/{id}") public Ocorrencia buscar(@PathVariable Long id){return service.buscar(id);}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Ocorrencia criar(@Valid @RequestBody CriarOcorrenciaRequest request){return service.criar(request);}
 @PatchMapping("/{id}/status") public Ocorrencia atualizarStatus(@PathVariable Long id,@Valid @RequestBody AtualizarStatusRequest request){return service.atualizarStatus(id,request);}
}

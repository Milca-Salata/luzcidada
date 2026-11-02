package br.com.ocorrencia.luzcidada.service;

import br.com.ocorrencia.luzcidada.entity.*;
import br.com.ocorrencia.luzcidada.repository.*;
import br.com.ocorrencia.luzcidada.request.*;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OcorrenciaService {
 private final OcorrenciaRepository ocorrencias;
 private final UsuarioRepository usuarios;
 private final CategoriaProblemaRepository categorias;
 private final HistoricoOcorrenciaRepository historicos;
 public OcorrenciaService(OcorrenciaRepository o, UsuarioRepository u, CategoriaProblemaRepository c, HistoricoOcorrenciaRepository h) {
  ocorrencias=o; usuarios=u; categorias=c; historicos=h;
 }
 public List<Ocorrencia> listar(){return ocorrencias.findAll();}
 public Ocorrencia buscar(Long id){return ocorrencias.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Ocorrência não encontrada"));}
 @Transactional public Ocorrencia criar(CriarOcorrenciaRequest req){
  Usuario morador=usuarios.findById(req.moradorId()).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"Morador não encontrado"));
  if(morador.getTipoUsuario()!=TipoUsuario.MORADOR) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Usuário informado não é morador");
  Ocorrencia o=new Ocorrencia(); o.setMorador(morador); o.setTitulo(req.titulo()); o.setDescricao(req.descricao());
  o.setEndereco(req.endereco()); o.setBairro(req.bairro()); o.setLatitude(req.latitude()); o.setLongitude(req.longitude());
  if(req.categoriaId()!=null)o.setCategoria(categorias.findById(req.categoriaId()).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"Categoria não encontrada")));
  return ocorrencias.save(o);
 }
 @Transactional public Ocorrencia atualizarStatus(Long id, AtualizarStatusRequest req){
  Ocorrencia o=buscar(id);
  Usuario usuario=usuarios.findById(req.usuarioId()).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"Usuário não encontrado"));
  StatusOcorrencia anterior=o.getStatus(); o.setStatus(req.status());
  o.setDataConclusao(req.status()==StatusOcorrencia.CONCLUIDA?LocalDateTime.now():null);
  o=ocorrencias.save(o);
  HistoricoOcorrencia h=new HistoricoOcorrencia(); h.setOcorrencia(o); h.setUsuario(usuario); h.setStatusAnterior(anterior); h.setStatusNovo(req.status()); h.setComentario(req.comentario()); historicos.save(h);
  return o;
 }
}

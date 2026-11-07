package br.com.ocorrencia.luzcidada.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity @Table(name="historico_ocorrencias")
public class HistoricoOcorrencia {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="id_ocorrencia",nullable=false) private Ocorrencia ocorrencia;
 @ManyToOne(optional=false) @JoinColumn(name="id_usuario",nullable=false) private Usuario usuario;
 @Enumerated(EnumType.STRING) private StatusOcorrencia statusAnterior;
 @Enumerated(EnumType.STRING) @Column(nullable=false) private StatusOcorrencia statusNovo;
 @Column(columnDefinition="TEXT") private String comentario;
 @Column(nullable=false,updatable=false) private LocalDateTime dataAlteracao;
 @PrePersist void prePersist(){if(dataAlteracao==null)dataAlteracao=LocalDateTime.now();}
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public Ocorrencia getOcorrencia(){return ocorrencia;} public void setOcorrencia(Ocorrencia v){ocorrencia=v;}
 public Usuario getUsuario(){return usuario;} public void setUsuario(Usuario v){usuario=v;}
 public StatusOcorrencia getStatusAnterior(){return statusAnterior;} public void setStatusAnterior(StatusOcorrencia v){statusAnterior=v;}
 public StatusOcorrencia getStatusNovo(){return statusNovo;} public void setStatusNovo(StatusOcorrencia v){statusNovo=v;}
 public String getComentario(){return comentario;} public void setComentario(String v){comentario=v;}
 public LocalDateTime getDataAlteracao(){return dataAlteracao;}
}

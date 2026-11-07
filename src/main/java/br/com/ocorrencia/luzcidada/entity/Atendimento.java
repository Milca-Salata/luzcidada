package br.com.ocorrencia.luzcidada.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity @Table(name="atendimentos")
public class Atendimento {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="id_ocorrencia",nullable=false) private Ocorrencia ocorrencia;
 @ManyToOne(optional=false) @JoinColumn(name="id_tecnico",nullable=false) private Usuario tecnico;
 @ManyToOne @JoinColumn(name="id_gestor") private Usuario gestor;
 private LocalDateTime dataAtribuicao, dataInicio, dataFim;
 @Column(columnDefinition="TEXT") private String observacoes;
 @PrePersist void prePersist(){if(dataAtribuicao==null)dataAtribuicao=LocalDateTime.now();}
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public Ocorrencia getOcorrencia(){return ocorrencia;} public void setOcorrencia(Ocorrencia v){ocorrencia=v;}
 public Usuario getTecnico(){return tecnico;} public void setTecnico(Usuario v){tecnico=v;}
 public Usuario getGestor(){return gestor;} public void setGestor(Usuario v){gestor=v;}
 public LocalDateTime getDataAtribuicao(){return dataAtribuicao;} public LocalDateTime getDataInicio(){return dataInicio;} public void setDataInicio(LocalDateTime v){dataInicio=v;}
 public LocalDateTime getDataFim(){return dataFim;} public void setDataFim(LocalDateTime v){dataFim=v;}
 public String getObservacoes(){return observacoes;} public void setObservacoes(String v){observacoes=v;}
}

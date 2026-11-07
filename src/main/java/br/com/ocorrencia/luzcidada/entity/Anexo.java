package br.com.ocorrencia.luzcidada.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity @Table(name="anexos")
public class Anexo {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="id_ocorrencia",nullable=false) private Ocorrencia ocorrencia;
 @ManyToOne(optional=false) @JoinColumn(name="id_usuario",nullable=false) private Usuario usuario;
 @Column(nullable=false) private String nomeArquivo;
 @Column(nullable=false,length=500) private String caminhoArquivo;
 @Column(length=100) private String tipoArquivo;
 @Column(nullable=false,updatable=false) private LocalDateTime dataEnvio;
 @PrePersist void prePersist(){if(dataEnvio==null)dataEnvio=LocalDateTime.now();}
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public Ocorrencia getOcorrencia(){return ocorrencia;} public void setOcorrencia(Ocorrencia v){ocorrencia=v;}
 public Usuario getUsuario(){return usuario;} public void setUsuario(Usuario v){usuario=v;}
 public String getNomeArquivo(){return nomeArquivo;} public void setNomeArquivo(String v){nomeArquivo=v;}
 public String getCaminhoArquivo(){return caminhoArquivo;} public void setCaminhoArquivo(String v){caminhoArquivo=v;}
 public String getTipoArquivo(){return tipoArquivo;} public void setTipoArquivo(String v){tipoArquivo=v;}
 public LocalDateTime getDataEnvio(){return dataEnvio;}
}

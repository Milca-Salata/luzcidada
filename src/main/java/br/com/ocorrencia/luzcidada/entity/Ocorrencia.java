package br.com.ocorrencia.luzcidada.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="ocorrencias")
public class Ocorrencia {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true,length=20) private String protocolo;
 @ManyToOne(optional=false,fetch=FetchType.EAGER) @JoinColumn(name="id_morador",nullable=false) private Usuario morador;
 @NotBlank @Column(nullable=false,length=120) private String titulo;
 @NotBlank @Column(nullable=false,columnDefinition="TEXT") private String descricao;
 @Column(length=200) private String endereco;
 @Column(length=100) private String bairro;
 @Column(precision=10,scale=7) private BigDecimal latitude;
 @Column(precision=10,scale=7) private BigDecimal longitude;
 @Enumerated(EnumType.STRING) @Column(nullable=false,length=30) private StatusOcorrencia status=StatusOcorrencia.ABERTA;
 @ManyToOne @JoinColumn(name="id_categoria") private CategoriaProblema categoria;
 @Column(nullable=false,updatable=false) private LocalDateTime dataAbertura;
 private LocalDateTime dataConclusao;
 @PrePersist void prePersist(){if(protocolo==null)protocolo="LC-"+UUID.randomUUID().toString().substring(0,8).toUpperCase(); if(dataAbertura==null)dataAbertura=LocalDateTime.now();}
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getProtocolo(){return protocolo;} public void setProtocolo(String protocolo){this.protocolo=protocolo;}
 public Usuario getMorador(){return morador;} public void setMorador(Usuario morador){this.morador=morador;}
 public String getTitulo(){return titulo;} public void setTitulo(String titulo){this.titulo=titulo;}
 public String getDescricao(){return descricao;} public void setDescricao(String descricao){this.descricao=descricao;}
 public String getEndereco(){return endereco;} public void setEndereco(String endereco){this.endereco=endereco;}
 public String getBairro(){return bairro;} public void setBairro(String bairro){this.bairro=bairro;}
 public BigDecimal getLatitude(){return latitude;} public void setLatitude(BigDecimal latitude){this.latitude=latitude;}
 public BigDecimal getLongitude(){return longitude;} public void setLongitude(BigDecimal longitude){this.longitude=longitude;}
 public StatusOcorrencia getStatus(){return status;} public void setStatus(StatusOcorrencia status){this.status=status;}
 public CategoriaProblema getCategoria(){return categoria;} public void setCategoria(CategoriaProblema categoria){this.categoria=categoria;}
 public LocalDateTime getDataAbertura(){return dataAbertura;} public LocalDateTime getDataConclusao(){return dataConclusao;} public void setDataConclusao(LocalDateTime dataConclusao){this.dataConclusao=dataConclusao;}
}
